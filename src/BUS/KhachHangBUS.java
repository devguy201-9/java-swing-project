/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class KhachHangBUS {

    private List<KhachHangDTO> khBUS;

    public KhachHangBUS() {
        khBUS = null;
    }

    public List<KhachHangDTO> getKhBUS() {
        return khBUS;
    }

    public KhachHangDTO getCustomerById(String MaKH) {
        for (KhachHangDTO kh : khBUS) {
            if (kh.getId_KH() == Integer.parseInt(MaKH)) {
                return kh;
            }
        }
        return null;
    }

    public void list() {
        KhachHangDAO hdDAO = new KhachHangDAO();
        khBUS = new ArrayList<>();
        khBUS = hdDAO.findAll();
    }

    public void add(KhachHangDTO khDTO) {
        KhachHangDAO khDAO = new KhachHangDAO();
        try {
            khDTO.setId_KH(khDAO.save(khDTO));
            khBUS.add(khDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idKhachHang = Integer.parseInt(id);
        for (KhachHangDTO khachHangDTO : khBUS) {
            if (khachHangDTO.getId_KH() == idKhachHang) {
                khBUS.remove(khachHangDTO);
                KhachHangDAO khDAO = new KhachHangDAO();
                try {
                    khDAO.delete(idKhachHang);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(KhachHangDTO khachHangDTO) {
        for (int i = 0; i < khBUS.size(); i++) {
            if (khBUS.get(i).getId_KH() == khachHangDTO.getId_KH()) {
                khBUS.set(i, khachHangDTO);
                KhachHangDAO khDAO = new KhachHangDAO();
                try {
                    khDAO.update(khachHangDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public boolean check(String makh) {
        for (KhachHangDTO kh : khBUS) {
            if (String.valueOf(kh.getId_KH()).equals(makh)) {
                return true;
            }
        }
        return false;
    }
}
