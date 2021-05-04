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

    public boolean check(String maHD) {
        for (HoaDonDTO hd : hdBUS) {
            if (String.valueOf(hd.getId()).equals(maHD)) {
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
    
    public ArrayList<HoaDonDTO> search( int mm, int yyy,double max, double min,ArrayList<String> mahd)
    {
        int mm1 = 0, mm2 = 12;
        int yyy1 = 0, yyy2 = Calendar.getInstance().get(Calendar.YEAR);
        
        if(mm != -1)
        {
            mm1 = mm;
            mm2 = mm;
        }
        if(yyy != 0)
        {
            yyy1 = yyy;
            yyy2 = yyy;
        }
        
        ArrayList<HoaDonDTO> ds = getListWidthArray(mahd);
        ArrayList<HoaDonDTO> search = new ArrayList<>();
        for(HoaDonDTO hd : ds)
        {
            Timestamp time = hd.getCreate_day();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time.getTime());;
            
            int month = calendar.get(Calendar.MONTH);
            int year = calendar.get(Calendar.YEAR);
            
            if( hd.getTotal_money()>= min && hd.getTotal_money()<= max 
                && (month >= mm1 && month <= mm2)
                && (year >= yyy1 && year <= yyy2))
            {
                search.add(hd);
            }
        }
        return search;
    }
    public ArrayList<HoaDonDTO> getListWidthArray(ArrayList<String> s)
    {
        ArrayList<HoaDonDTO> ds = new ArrayList<>();
        if(s == null) return (ArrayList<HoaDonDTO>) hdBUS;
        for(HoaDonDTO hd : hdBUS)
        {
            String mahd = String.valueOf(hd.getId());
            for(String a: s)
            {
                if(mahd.equals(a))
                {
                    ds.add(hd);
                }
            }
        }
        return ds;
    }
}
