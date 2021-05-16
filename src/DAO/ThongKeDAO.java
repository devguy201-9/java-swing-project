/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ThongKeDTO;
import java.time.LocalDate;
import java.util.List;
import mapper.ThongKeMapper;



/**
 *
 * @author ACER
 */
public class ThongKeDAO extends AbstractDAO<ThongKeDTO>{
    
    public List<ThongKeDTO> getChartByTime (LocalDate startDate , LocalDate endDate){
        String sql = "SELECT cthd.name , SUM(cthd.amount) AS tong\n" +
                     "FROM ct_hoadon AS cthd \n" +
                     "INNER JOIN hoadon AS hd ON cthd.id_HD = hd.id\n" +
                     "WHERE ? <= hd.create_day <= ?   GROUP BY cthd.name \n" +
                     "ORDER BY `tong`  DESC LIMIT 6";
        List<ThongKeDTO> tk = query(sql , new ThongKeMapper() , startDate , endDate );
        return tk;
    }
}