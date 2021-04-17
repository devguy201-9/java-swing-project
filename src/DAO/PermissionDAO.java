/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PermissionDTO;
import java.io.FileNotFoundException;
import java.util.List;
import mapper.PermissionMapper;

/**
 *
 * @author Thuan Vo
 */
public class PermissionDAO extends AbstractDAO<PermissionDTO>{
    public Integer save(PermissionDTO pm) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO quyen(id_permission,name");
        sql.append(" VALUES(?, ?)");
        return insert(sql.toString(), pm.getId_Permission(), pm.getName());
    }

    public List<PermissionDTO> findAll() {
        String sql = "select * from quyen";
        return query(sql, new PermissionMapper());
    }

    public void delete(int idTK) throws FileNotFoundException {
        String sql = "DELETE FROM quyen WHERE id_permission = ? ";
        update(sql, idTK);
    }
    
    public void update(PermissionDTO pmUpdate) throws FileNotFoundException {
		StringBuilder sql = new StringBuilder("UPDATE quyen SET name = ? ");
		sql.append("WHERE id_permisison = ?");
		update(sql.toString(), pmUpdate.getName(), pmUpdate.getId_Permission());
	}
}
