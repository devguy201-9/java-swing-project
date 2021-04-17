/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.PermissionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thuan Vo
 */
public class PermissionMapper implements RowMapper<PermissionDTO>{

    @Override
    public PermissionDTO mapRow(ResultSet rs) {
        try {
            PermissionDTO pm = new PermissionDTO();
            pm.setId_Permission(rs.getInt("id_permission"));
            pm.setName(rs.getString("name"));
            return pm;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
