/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ct_HDDAO;
import DTO.ct_HoaDonDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class ct_HDBUS {

    private List<ct_HoaDonDTO> ct_hdBUS;

    public ct_HDBUS() {
        ct_hdBUS = null;
    }

    public List<ct_HoaDonDTO> getCt_hdBUS() {
        return ct_hdBUS;
    }

    public void list() {
        ct_HDDAO cthdDAO = new ct_HDDAO();
        ct_hdBUS = new ArrayList<>();
        ct_hdBUS = cthdDAO.findAll();
    }

    public void add(ct_HoaDonDTO cthdDTO) {
        ct_hdBUS.add(cthdDTO);
        ct_HDDAO cthdDAO = new ct_HDDAO();
        try {
            cthdDAO.save(cthdDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idCTHD = Integer.parseInt(id);
        for (ct_HoaDonDTO cthdDTO : ct_hdBUS) {
            if (cthdDTO.getId() == idCTHD) {
                ct_hdBUS.remove(cthdDTO);
                ct_HDDAO cthdDAO = new ct_HDDAO();
                try {
                    cthdDAO.delete(idCTHD);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(ct_HoaDonDTO cthdDTO) {
        for (int i = 0; i < ct_hdBUS.size(); i++) {
            if (ct_hdBUS.get(i).getId() == cthdDTO.getId()) {
                ct_hdBUS.set(i, cthdDTO);
                ct_HDDAO cthdDAO = new ct_HDDAO();
                try {
                    cthdDAO.update(cthdDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

}