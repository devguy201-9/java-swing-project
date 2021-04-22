/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class NhanVienBUS {

    private List<NhanVienDTO> nvBUS;

    public NhanVienBUS() {
        nvBUS = null;
    }

    public List<NhanVienDTO> getNvBUS() {
        return nvBUS;
    }

    public void list() {
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvBUS = new ArrayList<>();
        nvBUS = nvDAO.findAll();
    }

    public void add(NhanVienDTO nvDTO) {
        nvBUS.add(nvDTO);
        NhanVienDAO nvDAO = new NhanVienDAO();
        try {
            nvDAO.save(nvDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idNV = Integer.parseInt(id);
        for (NhanVienDTO nvDTO : nvBUS) {
            if (nvDTO.getId_NV() == idNV) {
                nvBUS.remove(nvDTO);
                NhanVienDAO nvDAO = new NhanVienDAO();
                try {
                    nvDAO.delete(idNV);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(NhanVienDTO nvDTO) {
        for (int i = 0; i < nvBUS.size(); i++) {
            if (nvBUS.get(i).getId_NV() == nvDTO.getId_NV()) {
                nvBUS.set(i, nvDTO);
                NhanVienDAO nvDAO = new NhanVienDAO();
                try {
                    nvDAO.update(nvDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }
}