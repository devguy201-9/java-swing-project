/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ThongKeDAO;
import DTO.HoaDonDTO;
import DTO.PhieuNhapHangDTO;
import DTO.ThongKeDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ThongKeBUS {
    private HoaDonBUS hdBUS = new HoaDonBUS();
    private PhieuNhapHangBUS nhBUS = new PhieuNhapHangBUS();
    public ThongKeBUS()
    {
        hdBUS.list();
        nhBUS.list();
    }
    
    public List<ThongKeDTO> getChartByTime (LocalDate startDate , LocalDate endDate){
        ThongKeDAO tkDAO = new ThongKeDAO();
        List<ThongKeDTO> tks = tkDAO.getChartByTime(startDate, endDate);
        return tks;
    }

}
