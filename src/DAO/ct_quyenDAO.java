/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ct_quyenDTO;
import java.io.FileNotFoundException;
import java.util.List;
import mapper.ct_quyenMapper;

/**
 *
 * @author Thuan Vo
 */
public class ct_quyenDAO extends AbstractDAO<ct_quyenDTO>{
    
    public List<ct_quyenDTO> getByIdPermission(int id_permission) throws FileNotFoundException{
        ct_quyenDAO permissionDetail = new ct_quyenDAO();
        StringBuilder sql =  new StringBuilder("SELECT * FROM `ct_quyen` WHERE id_permission = ?");
        List<ct_quyenDTO> result = permissionDetail.query(sql.toString(),new ct_quyenMapper() ,id_permission);
        return result;
    }
    
    public Integer save(ct_quyenDTO detail) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO ct_quyen(id_permission,id_duty");
        sql.append(" VALUES(?, ?)");
        return insert(sql.toString(), detail.getId_permission(), detail.getid_duty());
    }

    public List<ct_quyenDTO> findAll() {
        String sql = "select * from ct_quyen";
        return query(sql, new ct_quyenMapper());
    }

    public void delete(int idDetail) throws FileNotFoundException {
        String sql = "DELETE FROM ct_quyen WHERE id_permission = ? ";
        update(sql, idDetail);
    }
    
    public void update(ct_quyenDTO detail) throws FileNotFoundException {
		StringBuilder sql = new StringBuilder("UPDATE ct_quyen SET id_duty = ? ");
		sql.append("WHERE id_permisison = ?");
		update(sql.toString() , detail.getid_duty(),detail.getId_permission());
	}
    
}
