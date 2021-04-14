/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.TaiKhoanDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class TaiKhoanMapper implements RowMapper<TaiKhoanDTO>{

    @Override
    public TaiKhoanDTO mapRow(ResultSet rs) {
        try {
            TaiKhoanDTO tk = new TaiKhoanDTO();
            tk.setId_TK(rs.getInt("id_TK"));
            tk.setId_NV(rs.getInt("id_NV"));
            tk.setId_permission(rs.getInt("id_permission"));
            tk.setUser_name(rs.getString("user_name"));
            tk.setPass(rs.getString("pass"));
            return tk;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
