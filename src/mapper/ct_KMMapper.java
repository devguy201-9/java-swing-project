/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.ct_KhuyenMaiDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class ct_KMMapper implements RowMapper<ct_KhuyenMaiDTO>{

    @Override
    public ct_KhuyenMaiDTO mapRow(ResultSet rs) {
        try {
            ct_KhuyenMaiDTO ctkm = new ct_KhuyenMaiDTO();
            ctkm.setId(rs.getInt("id"));
            ctkm.setId_KM(rs.getInt("id_KM"));
            ctkm.setId_SP(rs.getInt("id_SP"));
            ctkm.setDiscount(rs.getFloat("discount"));
            return ctkm;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
