/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuNhapHangDAO;
import DTO.PhieuNhapHangDTO;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Asus
 */
public class PhieuNhapHangBUS {
    
    private List<PhieuNhapHangDTO> pnhBUS;
    
    public PhieuNhapHangBUS() {
        pnhBUS = null;
    }
    
    public List<PhieuNhapHangDTO> getPnhBUS() {
        return pnhBUS;
    }
    
    public void list() {
        PhieuNhapHangDAO pnhDAO = new PhieuNhapHangDAO();
        pnhBUS = new ArrayList<>();
        pnhBUS = pnhDAO.findAll();
    }
    
    public void add(PhieuNhapHangDTO pnhDTO) {
        PhieuNhapHangDAO pnhDAO = new PhieuNhapHangDAO();
        if (pnhBUS == null) {
            pnhBUS = new ArrayList<>();
        }
        try {
            pnhDTO.setId_PNH(pnhDAO.save(pnhDTO));
            pnhBUS.add(pnhDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void addDTO(PhieuNhapHangDTO pnhDTO) {
        PhieuNhapHangDAO pnhDAO = new PhieuNhapHangDAO();
        pnhBUS.add(pnhDAO.findByCode(pnhDTO.getId_PNH()));
    }
    
    public void delete(int idPNH) {
        for (PhieuNhapHangDTO pnhDTO : pnhBUS) {
            if (pnhDTO.getId_PNH() == idPNH) {
                pnhBUS.remove(pnhDTO);
                PhieuNhapHangDAO pnhDAO = new PhieuNhapHangDAO();
                try {
                    pnhDAO.delete(idPNH);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }
    
    public void set(PhieuNhapHangDTO pnhDTO) {
        for (int i = 0; i < pnhBUS.size(); i++) {
            if (pnhBUS.get(i).getId_PNH() == pnhDTO.getId_PNH()) {
                pnhBUS.set(i, pnhDTO);
                PhieuNhapHangDAO pnhDAO = new PhieuNhapHangDAO();
                try {
                    pnhDAO.update(pnhDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    //phần thống kê
    public boolean checkTime(Calendar from, Calendar to, Calendar time) {
//        System.err.print(from.getTime()+" ");
//        System.err.print(to.getTime()+" ");
//        System.err.println(time.getTime());
        if (time.after(from) && time.before(to)) {
            return true;
        }
        return false;
    }
    
    public ArrayList<PhieuNhapHangDTO> ListTime(Calendar from, Calendar to) {
        ArrayList<PhieuNhapHangDTO> list = new ArrayList<>();
        for (PhieuNhapHangDTO nh : pnhBUS) {
            Timestamp date = (Timestamp) nh.getDate_add();
            Calendar time = Calendar.getInstance();
            time.setTimeInMillis(date.getTime());
            if (checkTime(from, to, time)) {
                list.add(nh);
            }
        }
        return list;
    }
    
    public ArrayList<PhieuNhapHangDTO> search(int mm, int yyyy, double max, double min, int maPNH) {
        int mm1 = 0, mm2 = 12;
        int yyy1 = 0, yyy2 = Calendar.getInstance().get(Calendar.YEAR);
        
        if (mm != -1) {
            mm1 = mm;
            mm2 = mm;
        }
        if (yyyy != 0) {
            yyy1 = yyyy;
            yyy2 = yyyy;
        }
        
        ArrayList<PhieuNhapHangDTO> search = new ArrayList<>();
        LocalDate localDate = null;
        for (PhieuNhapHangDTO pnh : pnhBUS) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(pnh.getDate_add());
            int month = calendar.get(Calendar.MONTH);
            int year = calendar.get(Calendar.YEAR);
            if (pnh.getTotal_money() >= min && pnh.getTotal_money() <= max
                    && (month >= mm1 && month <= mm2)
                    && (year >= yyy1 && year <= yyy2)) {
                if (maPNH != 0 && pnh.getId_PNH() == maPNH) {
                    search.clear();
                    search.add(pnh);
                    break;
                }
                if (maPNH != 0 && pnh.getId_PNH() != maPNH) {
                    search.clear();
                }
                search.add(pnh);
            }
        }
        return search;
    }
    
}
