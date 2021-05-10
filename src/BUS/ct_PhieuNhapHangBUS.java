/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ct_PNHDAO;
import DTO.ct_PhieuNhapHangDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class ct_PhieuNhapHangBUS {

    private List<ct_PhieuNhapHangDTO> ct_pnhBUS;

    public ct_PhieuNhapHangBUS() {
        ct_pnhBUS = null;
    }

    public List<ct_PhieuNhapHangDTO> getCt_pnhBUS() {
        return ct_pnhBUS;
    }

    public void list() {
        ct_PNHDAO ctpnhDAO = new ct_PNHDAO();
        ct_pnhBUS = new ArrayList<>();
        ct_pnhBUS = ctpnhDAO.findAll();
    }
    
    public void listByCode(int maPNH) {
        ct_PNHDAO ctpnhDAO = new ct_PNHDAO();
        ct_pnhBUS = new ArrayList<>();
        ct_pnhBUS = ctpnhDAO.findByCode(maPNH);
    }

    public void add(ct_PhieuNhapHangDTO ctpnhDTO) {
        if (ct_pnhBUS == null) {
            ct_pnhBUS = new ArrayList<>();
        }
        ct_pnhBUS.add(ctpnhDTO);
        ct_PNHDAO ctpnhDAO = new ct_PNHDAO();
        try {
            ctpnhDAO.save(ctpnhDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idCTPNH = Integer.parseInt(id);
        for (ct_PhieuNhapHangDTO ctpnhDTO : ct_pnhBUS) {
            if (ctpnhDTO.getId_PNH() == idCTPNH) {
                ct_pnhBUS.remove(ctpnhDTO);
                ct_PNHDAO ctpnhDAO = new ct_PNHDAO();
                try {
                    ctpnhDAO.delete(idCTPNH);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }
    
    public void deleteByCode(int idPNH,int idNL) {
        for (ct_PhieuNhapHangDTO ctpnhDTO : ct_pnhBUS) {
            if (ctpnhDTO.getId_PNH() == idPNH && ctpnhDTO.getId_NL() == idNL) {
                ct_pnhBUS.remove(ctpnhDTO);
                ct_PNHDAO ctpnhDAO = new ct_PNHDAO();
                try {
                    ctpnhDAO.deleteByCodeBillAndProduct(idPNH, idNL);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(ct_PhieuNhapHangDTO ctpnhDTO) {
        for (int i = 0; i < ct_pnhBUS.size(); i++) {
            if (ct_pnhBUS.get(i).getId_PNH() == ctpnhDTO.getId_PNH()) {
                ct_pnhBUS.set(i, ctpnhDTO);
                ct_PNHDAO ctpnhDAO = new ct_PNHDAO();
                try {
                    ctpnhDAO.update(ctpnhDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

}
