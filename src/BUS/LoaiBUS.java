/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.LoaiDAO;
import DTO.LoaiDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class LoaiBUS {

    private List<LoaiDTO> loaiBUS;

    public LoaiBUS() {
        loaiBUS = null;
    }

    public List<LoaiDTO> getLoaiBUS() {
        return loaiBUS;
    }

    public void list() {
        LoaiDAO loaiDAO = new LoaiDAO();
        loaiBUS = new ArrayList<>();
        loaiBUS = loaiDAO.findAll();
    }

    public void add(LoaiDTO loaiDTO) {
        loaiBUS.add(loaiDTO);
        LoaiDAO loaiDAO = new LoaiDAO();
        try {
            loaiDAO.save(loaiDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idLoai = Integer.parseInt(id);
        for (LoaiDTO loaiDTO : loaiBUS) {
            if (loaiDTO.getId_Loai() == idLoai) {
                loaiBUS.remove(loaiDTO);
                LoaiDAO loaiDAO = new LoaiDAO();
                try {
                    loaiDAO.delete(idLoai);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(LoaiDTO loaiDTO) {
        for (int i = 0; i < loaiBUS.size(); i++) {
            if (loaiBUS.get(i).getId_Loai() == loaiDTO.getId_Loai()) {
                loaiBUS.set(i, loaiDTO);
                LoaiDAO loaiDAO = new LoaiDAO();
                try {
                    loaiDAO.update(loaiDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public LoaiDTO searchMaLoai(int maloai) {
        for (LoaiDTO loai : loaiBUS) {
            if (loai.getId_Loai() == maloai) {
                return loai;
            }
        }
        return null;
    }
}
