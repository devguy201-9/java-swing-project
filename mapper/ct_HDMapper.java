/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanqlsieuthi.mapper;

import doanqlsieuthi.DTO.ct_HoaDonDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class ct_HDMapper implements RowMapper<ct_HoaDonDTO>{

    @Override
    public ct_HoaDonDTO mapRow(ResultSet rs) {
        try {
            ct_HoaDonDTO cthd = new ct_HoaDonDTO();
            cthd.setId(rs.getInt("id"));
            cthd.setId_HD(rs.getInt("id_HD"));
            cthd.setId_SP(rs.getInt("id_SP"));
            cthd.setAmount(rs.getInt("amount"));
            cthd.setPrice(rs.getFloat("price"));
            cthd.setPromotion_price(rs.getFloat("promotion_price"));
            cthd.setTotal_money(rs.getFloat("total_money"));
            return cthd;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
