/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.LoaiDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class LoaiMapper implements RowMapper<LoaiDTO>{

    @Override
    public LoaiDTO mapRow(ResultSet rs) {
        try {
          LoaiDTO loai = new LoaiDTO();
          loai.setId_Loai(rs.getInt("id_Loai"));
          loai.setName(rs.getString("name"));
          return loai;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
