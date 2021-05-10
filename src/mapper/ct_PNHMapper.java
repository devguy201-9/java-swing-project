/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.ct_PhieuNhapHangDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class ct_PNHMapper implements RowMapper<ct_PhieuNhapHangDTO>{

    @Override
    public ct_PhieuNhapHangDTO mapRow(ResultSet rs) {
        try {
            ct_PhieuNhapHangDTO ctpnh = new ct_PhieuNhapHangDTO();
            ctpnh.setId_PNH(rs.getInt("id_PNH"));
            ctpnh.setId_NL(rs.getInt("id_NL"));
            ctpnh.setAmount(rs.getInt("amount"));
            ctpnh.setPrice(rs.getFloat("price"));
            ctpnh.setTotal_money(rs.getFloat("total_money"));
            return ctpnh;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
