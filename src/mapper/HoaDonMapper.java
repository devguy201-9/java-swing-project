/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.HoaDonDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class HoaDonMapper implements RowMapper<HoaDonDTO>{

    @Override
    public HoaDonDTO mapRow(ResultSet rs) {
        try {
            HoaDonDTO hd = new HoaDonDTO();
            hd.setId(rs.getInt("id"));
            hd.setId_KH(rs.getInt("id_KH"));
//            hd.setId_KM(rs.getInt("id_KM"));
            hd.setId_NV(rs.getInt("id_NV"));
            hd.setTotal_money(rs.getFloat("total_money"));
//            hd.setTotal_promo(rs.getFloat("total_promo"));
//            hd.setTotal_remaining_money(rs.getFloat("total_remaining_money"));
            hd.setCreate_day(rs.getTimestamp("create_day"));
            return hd;
        } catch (SQLException e) {
            return null;
        }
    }
}
