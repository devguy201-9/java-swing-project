/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class TaiKhoanBUS {
    private List<TaiKhoanDTO> tkBUS;
    
    public TaiKhoanBUS() {
        tkBUS = null;
    }

    public List<TaiKhoanDTO> getTkBUS() {
        return tkBUS;
    }
    
    public void list(){
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
        tkBUS = new ArrayList<>();
        tkBUS = taiKhoanDAO.findAll();
    }
    
    public void show(){
        for(TaiKhoanDTO taiKhoan : tkBUS) {
            System.out.println(taiKhoan.getUser_name());
        }
    }
    
    public void add(TaiKhoanDTO taiKhoan){
        tkBUS.add(taiKhoan);
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
        try {
            taiKhoanDAO.save(taiKhoan);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(int idTaiKhoan) {
        for(TaiKhoanDTO taiKhoanDTO : tkBUS){
            if(taiKhoanDTO.getId_TK() == idTaiKhoan) {
                tkBUS.remove(taiKhoanDTO);
                TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
                try {
                    taiKhoanDAO.delete(idTaiKhoan);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }
    
    public void set(TaiKhoanDTO taiKhoanDTO){
        for(int i = 0 ; i < tkBUS.size() ; i++) {
            if(tkBUS.get(i).getId_TK() == taiKhoanDTO.getId_TK()) {
                tkBUS.set(i, taiKhoanDTO);
                TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
                try {
                    taiKhoanDAO.update(taiKhoanDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }
        
}
