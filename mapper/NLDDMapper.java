/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanqlsieuthi.mapper;

import doanqlsieuthi.DTO.NguyenLieuDaDungDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class NLDDMapper implements RowMapper<NguyenLieuDaDungDTO>{

    @Override
    public NguyenLieuDaDungDTO mapRow(ResultSet rs) {
        try {
            NguyenLieuDaDungDTO nldd = new NguyenLieuDaDungDTO();
            nldd.setId(rs.getInt("id"));
            nldd.setId_NL(rs.getInt("id_NL"));
            nldd.setId_SP(rs.getInt("id_SP"));
            nldd.setAmount_material(rs.getInt("amount_material"));
            nldd.setAmount_product(rs.getInt("amount_product"));
            return nldd;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
