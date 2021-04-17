/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.QuyenCuaNhiemVuDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thuan Vo
 */
public class QuyenCuaNhiemVuMapper implements RowMapper<QuyenCuaNhiemVuDTO>{

    @Override
    public QuyenCuaNhiemVuDTO mapRow(ResultSet rs) {
        try {
            QuyenCuaNhiemVuDTO pm = new QuyenCuaNhiemVuDTO();
            pm.setId_permission(rs.getInt("id_permission"));
            pm.setid_duty(rs.getInt("id_duty"));
            return pm;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
