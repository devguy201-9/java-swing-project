/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.NhaCungCapDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class NCCMapper implements RowMapper<NhaCungCapDTO>{

    @Override
    public NhaCungCapDTO mapRow(ResultSet rs) {
        try {
            NhaCungCapDTO ncc = new NhaCungCapDTO();
            ncc.setId_NCC(rs.getInt("id_NCC"));
            ncc.setName_NCC(rs.getString("name_NCC"));
            ncc.setAddress(rs.getString("address"));
            ncc.setPhone(rs.getString("phone"));
            return ncc;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
