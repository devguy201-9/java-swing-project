/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ct_KMDAO;
import DTO.ct_KhuyenMaiDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class ct_KhuyenMaiBUS {

    private List<ct_KhuyenMaiDTO> ct_kmBUS;

    public ct_KhuyenMaiBUS() {
        ct_kmBUS = null;
    }

    public List<ct_KhuyenMaiDTO> getCt_kmBUS() {
        return ct_kmBUS;
    }

    public void list() {
        ct_KMDAO ctKMDAO = new ct_KMDAO();
        ct_kmBUS = new ArrayList<>();
        ct_kmBUS = ctKMDAO.findAll();
    }

    public void add(ct_KhuyenMaiDTO ctkmDTO) {
        ct_kmBUS.add(ctkmDTO);
        ct_KMDAO ctKMDAO = new ct_KMDAO();
        try {
            ctKMDAO.save(ctkmDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idCTKM = Integer.parseInt(id);
        for (ct_KhuyenMaiDTO ctkmDTO : ct_kmBUS) {
            if (ctkmDTO.getId() == idCTKM) {
                ct_kmBUS.remove(ctkmDTO);
                ct_KMDAO ctKMDAO = new ct_KMDAO();
                try {
                    ctKMDAO.delete(idCTKM);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(ct_KhuyenMaiDTO ctkmDTO) {
        for (int i = 0; i < ct_kmBUS.size(); i++) {
            if (ct_kmBUS.get(i).getId() == ctkmDTO.getId()) {
                ct_kmBUS.set(i, ctkmDTO);
                ct_KMDAO ctKMDAO = new ct_KMDAO();
                try {
                    ctKMDAO.update(ctkmDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

}
