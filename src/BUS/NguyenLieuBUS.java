/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NguyenLieuDAO;
import DTO.NguyenLieuDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class NguyenLieuBUS {

    private List<NguyenLieuDTO> nlBUS;

    public NguyenLieuBUS() {
        nlBUS = null;
    }

    public List<NguyenLieuDTO> getNlBUS() {
        return nlBUS;
    }

    public void list() {
        NguyenLieuDAO nlDAO = new NguyenLieuDAO();
        nlBUS = new ArrayList<>();
        nlBUS = nlDAO.findAll();
    }

    public void add(NguyenLieuDTO nlDTO) {
        nlBUS.add(nlDTO);
        NguyenLieuDAO nlDAO = new NguyenLieuDAO();
        try {
            nlDAO.save(nlDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idNL = Integer.parseInt(id);
        for (NguyenLieuDTO nlDTO : nlBUS) {
            if (nlDTO.getId_NL() == idNL) {
                nlBUS.remove(nlDTO);
                NguyenLieuDAO nlDAO = new NguyenLieuDAO();
                try {
                    nlDAO.delete(idNL);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(NguyenLieuDTO nlDTO) {
        for (int i = 0; i < nlBUS.size(); i++) {
            if (nlBUS.get(i).getId_NL() == nlDTO.getId_NL()) {
                nlBUS.set(i, nlDTO);
                NguyenLieuDAO nlDAO = new NguyenLieuDAO();
                try {
                    nlDAO.update(nlDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

}
