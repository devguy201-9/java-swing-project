/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.KhachHangDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class KhachHangMapper implements RowMapper<KhachHangDTO> {

    @Override
    public KhachHangDTO mapRow(ResultSet rs) {
        try {
            KhachHangDTO kh = new KhachHangDTO();
            kh.setId_KH(rs.getInt("id_KH"));
            kh.setId_HD(rs.getInt("id_HD"));
            kh.setFirst_name(rs.getString("first_name"));
            kh.setLast_name(rs.getString("last_name"));
            kh.setPhone(rs.getString("phone"));
            return kh;
        } catch (SQLException e) {
            return null;
        }
    }

}
