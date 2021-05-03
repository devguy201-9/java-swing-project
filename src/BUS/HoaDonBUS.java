/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Asus
 */
public class HoaDonBUS {

    private List<HoaDonDTO> hdBUS;

    public HoaDonBUS() {
        hdBUS = null;
    }

    public List<HoaDonDTO> getHdBUS() {
        return hdBUS;
    }

    public void list() {
        HoaDonDAO hdDAO = new HoaDonDAO();
        hdBUS = new ArrayList<>();
        hdBUS = hdDAO.findAll();
    }

    public void add(HoaDonDTO hd) {
        hdBUS.add(hd);
        HoaDonDAO hdDAO = new HoaDonDAO();
        try {
            hdDAO.save(hd);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idHoaDon = Integer.parseInt(id);
        for (HoaDonDTO hoaDonDTO : hdBUS) {
            if (hoaDonDTO.getId() == idHoaDon) {
                hdBUS.remove(hoaDonDTO);
                HoaDonDAO hdDAO = new HoaDonDAO();
                try {
                    hdDAO.delete(idHoaDon);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(HoaDonDTO hoaDonDTO) {
        for (int i = 0; i < hdBUS.size(); i++) {
            if (hdBUS.get(i).getId() == hoaDonDTO.getId()) {
                hdBUS.set(i, hoaDonDTO);
                HoaDonDAO hdDAO = new HoaDonDAO();
                try {
                    hdDAO.update(hoaDonDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public String remindMaHD() {
        int max = 0;
        String s = "";
        for (HoaDonDTO hd : hdBUS) {
            int id = hd.getId();
            if (id > max) {
                max = id;
            }
        }
        for (int i = 0; i < 3 - String.valueOf(max + 1).length(); i++) {
            s += "0";
        }
        return s + (max + 1);
    }

    public boolean check(int maHD) {
        for (HoaDonDTO hd : hdBUS) {
            if (hd.getId() == maHD) {
                return true;
            }
        }
        return false;
    }

    //phần thống kê
    public boolean checkTime(Calendar from,Calendar to,Calendar time)
    {
//        System.err.print(from.getTime()+" ");
//        System.err.print(to.getTime()+" ");
//        System.err.println(time.getTime());
        if(time.after(from) && time.before(to))
        {
            return true;
        }
        return false;
    }
    public ArrayList<HoaDonDTO> ListTime(Calendar from,Calendar to)
    {
        ArrayList<HoaDonDTO> list = new ArrayList<>();
        for(HoaDonDTO hd : hdBUS)
        {
            Timestamp date = hd.getCreate_day();
            Calendar time = Calendar.getInstance();
            time.setTimeInMillis(date.getTime());
            if(checkTime(from, to, time))
            {
                list.add(hd);
            }
        }
        return list;
    }
    
    
}
