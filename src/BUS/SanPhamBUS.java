/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class SanPhamBUS {

    private List<SanPhamDTO> spBUS;

    public SanPhamBUS() {
        spBUS = null;
    }

    public List<SanPhamDTO> getSpBUS() {
        return spBUS;
    }

    public void list() {
        SanPhamDAO spDAO = new SanPhamDAO();
        spBUS = new ArrayList<>();
        spBUS = spDAO.findAll();
    }

    public void add(SanPhamDTO spDTO) {
        spBUS.add(spDTO);
        SanPhamDAO spDAO = new SanPhamDAO();
        try {
            spDAO.save(spDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idSP = Integer.parseInt(id);
        for (SanPhamDTO spDTO : spBUS) {
            if (spDTO.getId_SP() == idSP) {
                spBUS.remove(spDTO);
                SanPhamDAO spDAO = new SanPhamDAO();
                try {
                    spDAO.delete(idSP);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(SanPhamDTO spDTO) {
        for (int i = 0; i < spBUS.size(); i++) {
            if (spBUS.get(i).getId_SP() == spDTO.getId_SP()) {
                spBUS.set(i, spDTO);
                SanPhamDAO spDAO = new SanPhamDAO();
                try {
                    spDAO.update(spDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public boolean checkSL(int masp, int sl) {
        for (SanPhamDTO sp : spBUS) {
            if (sp.getId_SP() == masp) {
                if (sl > sp.getAmount()) {
                    JOptionPane.showMessageDialog(null, "Không đủ hàng");
                    return false;
                }
            }
        }
        return true;
    }

    public SanPhamDTO getSP(String masp) {
        for (SanPhamDTO sp : spBUS) {
            if (sp.getId_SP() == Integer.parseInt(masp)) {
                return sp;
            }
        }
        return null;
    }

    public boolean checkMasp(int masp) {
        for (SanPhamDTO sp : spBUS) {
            if (sp.getId_SP() == masp) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<SanPhamDTO> searchSP(int masp, int maloai, int max, int min) {
        ArrayList<SanPhamDTO> search = new ArrayList<>();
        masp = (masp == 0) ? masp = 0 : masp;
        maloai = maloai == 0 ? maloai = 0 : maloai;

        for (SanPhamDTO sp : spBUS) {
            if ((sp.getId_SP() == masp)
                    && (sp.getId_Loai() == maloai)
                    && sp.getPrice() >= min
                    && sp.getPrice() <= max) {
                search.add(sp);
            }
        }
        return search;
    }
}
