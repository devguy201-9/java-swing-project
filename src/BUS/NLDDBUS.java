/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NLDDDAO;
import DTO.NguyenLieuDaDungDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class NLDDBUS {

    private List<NguyenLieuDaDungDTO> nlddBUS;

    public NLDDBUS() {
        nlddBUS = null;
    }

    public List<NguyenLieuDaDungDTO> getNlddBUS() {
        return nlddBUS;
    }

    public void list() {
        NLDDDAO nlddDAO = new NLDDDAO();
        nlddBUS = new ArrayList<>();
        nlddBUS = nlddDAO.findAll();
    }

    public void add(NguyenLieuDaDungDTO nlddDTO) {
        nlddBUS.add(nlddDTO);
        NLDDDAO nlddDAO = new NLDDDAO();
        try {
            nlddDAO.save(nlddDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idNLDD = Integer.parseInt(id);
        for (NguyenLieuDaDungDTO nlddDTO : nlddBUS) {
            if (nlddDTO.getId() == idNLDD) {
                nlddBUS.remove(nlddDTO);
                NLDDDAO nlddDAO = new NLDDDAO();
                try {
                    nlddDAO.delete(idNLDD);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(NguyenLieuDaDungDTO nlddDTO) {
        for (int i = 0; i < nlddBUS.size(); i++) {
            if (nlddBUS.get(i).getId() == nlddDTO.getId()) {
                nlddBUS.set(i, nlddDTO);
                NLDDDAO nlddDAO = new NLDDDAO();
                try {
                    nlddDAO.update(nlddDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }
}
