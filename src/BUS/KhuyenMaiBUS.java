/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class KhuyenMaiBUS {

    private List<KhuyenMaiDTO> kmBUS;

    public KhuyenMaiBUS() {
        kmBUS = null;
    }

    public List<KhuyenMaiDTO> getKmBUS() {
        return kmBUS;
    }

    public void list() {
        KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
        kmBUS = new ArrayList<>();
        kmBUS = kmDAO.findAll();
    }

    public void add(KhuyenMaiDTO kmDTO) {
        kmBUS.add(kmDTO);
        KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
        try {
            kmDAO.save(kmDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idTaiKhoan = Integer.parseInt(id);
        for (KhuyenMaiDTO kmDTO : kmBUS) {
            if (kmDTO.getId_KM() == idTaiKhoan) {
                kmBUS.remove(kmDTO);
                KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
                try {
                    kmDAO.delete(idTaiKhoan);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(KhuyenMaiDTO kmDTO) {
        for (int i = 0; i < kmBUS.size(); i++) {
            if (kmBUS.get(i).getId_KM() == kmDTO.getId_KM()) {
                kmBUS.set(i, kmDTO);
                KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
                try {
                    kmDAO.update(kmDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }
}
