/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.ThongKeDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thuan Vo
 */
public class ThongKeMapper implements RowMapper<ThongKeDTO>{

    @Override
    public ThongKeDTO mapRow(ResultSet rs) {
        ThongKeDTO tk = new ThongKeDTO();
        try {
            tk.setNameSP(rs.getString("name"));
            tk.setSoluongDaBan(rs.getInt("tong"));
            return tk;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
