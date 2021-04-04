package doanqlsieuthi.mapper;


import doanqlsieuthi.DTO.PhieuNhapHangDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class PNHMapper implements RowMapper<PhieuNhapHangDTO>{

    @Override
    public PhieuNhapHangDTO mapRow(ResultSet rs) {
        try {
            PhieuNhapHangDTO pnh = new PhieuNhapHangDTO();
            pnh.setId_PNH(rs.getInt("id_PNH"));
            pnh.setId_NV(rs.getInt("id_NV"));
            pnh.setId_NCC(rs.getInt("id_NCC"));
            pnh.setTotal_money(rs.getFloat("total_money"));
            pnh.setDate_add(rs.getDate("date_add"));
            return pnh;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
