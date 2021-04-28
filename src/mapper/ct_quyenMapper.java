/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.ct_quyenDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thuan Vo
 */
public class ct_quyenMapper implements RowMapper<ct_quyenDTO>{

    @Override
    public ct_quyenDTO mapRow(ResultSet rs) {
        try {
            ct_quyenDTO pm = new ct_quyenDTO();
            pm.setId_permission(rs.getInt("id_permission"));
            pm.setid_duty(rs.getInt("id_duty"));
            return pm;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
