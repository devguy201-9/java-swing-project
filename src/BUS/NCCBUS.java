/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NCCDAO;
import DTO.NhaCungCapDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class NCCBUS {

    private List<NhaCungCapDTO> nccBUS;

    public NCCBUS() {
        nccBUS = null;
    }

    public List<NhaCungCapDTO> getNccBUS() {
        return nccBUS;
    }

    public void list() {
        NCCDAO nccDAO = new NCCDAO();
        nccBUS = new ArrayList<>();
        nccBUS = nccDAO.findAll();
    }

    public void add(NhaCungCapDTO nccDTO) {
        NCCDAO nccDAO = new NCCDAO();
        try {
            nccDTO.setId_NCC(nccDAO.save(nccDTO));
            nccBUS.add(nccDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idNCC = Integer.parseInt(id);
        for (NhaCungCapDTO nccDTO : nccBUS) {
            if (nccDTO.getId_NCC() == idNCC) {
                nccBUS.remove(nccDTO);
                NCCDAO nccDAO = new NCCDAO();
                try {
                    nccDAO.delete(idNCC);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(NhaCungCapDTO nccDTO) {
        for (int i = 0; i < nccBUS.size(); i++) {
            if (nccBUS.get(i).getId_NCC() == nccDTO.getId_NCC()) {
                nccBUS.set(i, nccDTO);
                NCCDAO nccDAO = new NCCDAO();
                try {
                    nccDAO.update(nccDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public boolean checkIdNCC(int idNCC) {
        for (NhaCungCapDTO ncc : nccBUS) {
            if (ncc.getId_NCC() == idNCC) {
                return true;
            }
        }
        return false;
    }

}
