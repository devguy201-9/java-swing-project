/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.KhuyenMaiDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class KhuyenMaiMapper implements RowMapper<KhuyenMaiDTO>{

    @Override
    public KhuyenMaiDTO mapRow(ResultSet rs) {
        try {
            KhuyenMaiDTO km = new KhuyenMaiDTO();
            km.setId_KM(rs.getInt("id_KM"));
            km.setName(rs.getString("name"));
            km.setType(rs.getString("type"));
            km.setStart_time(rs.getDate("start_time"));
            km.setEnd_time(rs.getDate("end_time"));
            return km;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
