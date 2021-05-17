/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ThongKeDTO;
import java.sql.Timestamp;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.List;
import mapper.ThongKeMapper;



/**
 *
 * @author ACER
 */
public class ThongKeDAO extends AbstractDAO<ThongKeDTO>{
    
    public List<ThongKeDTO> getChartByTime (LocalDate startDate , LocalDate endDate){
        String sql = "SELECT cthd.name,SUM(cthd.price*cthd.amount) AS tong FROM ct_hoadon AS cthd "
                + "INNER JOIN hoadon AS hd ON cthd.id_HD = hd.id "
                + "WHERE '"+startDate.toString()+"' <= hd.create_day && hd.create_day <= '"+endDate.toString()
                + "' GROUP BY cthd.name ORDER BY tong DESC LIMIT 6";

        List<ThongKeDTO> tk = query(sql , new ThongKeMapper());
        return tk;
    }
}