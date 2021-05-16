/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.SanPhamDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class SanPhamMapper implements RowMapper<SanPhamDTO>{

    @Override
    public SanPhamDTO mapRow(ResultSet rs) {
        try {
            SanPhamDTO sp = new SanPhamDTO();
            sp.setId_SP(rs.getInt("id_SP"));
            sp.setId_Loai(rs.getInt("id_Loai"));
            sp.setName(rs.getString("name"));
            sp.setDescrption(rs.getString("descrption"));
            sp.setPrice(rs.getFloat("price"));
            sp.setImg(rs.getString("img"));
            return sp;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
