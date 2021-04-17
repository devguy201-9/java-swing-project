/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.QuyenCuaNhiemVuDTO;
import java.io.FileNotFoundException;
import java.util.List;
import mapper.QuyenCuaNhiemVuMapper;

/**
 *
 * @author Thuan Vo
 */
public class QuyenCuaNhiemVuDAO extends AbstractDAO<QuyenCuaNhiemVuDTO>{
    public Integer save(QuyenCuaNhiemVuDTO detail) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO ct_quyen(id_permission,id_duty");
        sql.append(" VALUES(?, ?)");
        return insert(sql.toString(), detail.getId_permission(), detail.getid_duty());
    }

    public List<QuyenCuaNhiemVuDTO> findAll() {
        String sql = "select * from ct_quyen";
        return query(sql, new QuyenCuaNhiemVuMapper());
    }

    public void delete(int idDetail) throws FileNotFoundException {
        String sql = "DELETE FROM ct_quyen WHERE id_permission = ? ";
        update(sql, idDetail);
    }
    
    public void update(QuyenCuaNhiemVuDTO detail) throws FileNotFoundException {
		StringBuilder sql = new StringBuilder("UPDATE ct_quyen SET id_duty = ? ");
		sql.append("WHERE id_permisison = ?");
		update(sql.toString() , detail.getid_duty(),detail.getId_permission());
	}
    
}
