/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.NguyenLieuDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class NguyenLieuMapper implements RowMapper<NguyenLieuDTO>{

    @Override
    public NguyenLieuDTO mapRow(ResultSet rs) {
        try {
            NguyenLieuDTO nl = new NguyenLieuDTO();
            nl.setId_NL(rs.getInt("id_NL"));
            nl.setName(rs.getString("name"));
            nl.setAmount(rs.getInt("amount"));
            nl.setPrice(rs.getFloat("price"));
            return nl;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
