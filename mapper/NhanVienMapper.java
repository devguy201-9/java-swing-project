/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanqlsieuthi.mapper;

import doanqlsieuthi.DTO.Gender;
import doanqlsieuthi.DTO.NhanVienDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class NhanVienMapper implements RowMapper<NhanVienDTO> {

    @Override
    public NhanVienDTO mapRow(ResultSet rs) {
        try {
            NhanVienDTO nv = new NhanVienDTO();
            nv.setId_NV(rs.getInt("id_NV"));
            nv.setName(rs.getString("name"));
            nv.setAddress(rs.getString("address"));
            nv.setAge(rs.getInt("age"));
            nv.setPhone(rs.getString("phone"));
            nv.setStart_day(rs.getDate("start_day"));
            nv.setGender((Gender) rs.getObject("gender"));
            return nv;
        } catch (SQLException e) {
            return null;
        }
    }
}
