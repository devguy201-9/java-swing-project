/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhuyenMaiDTO;
import java.io.FileNotFoundException;
import java.util.List;
import mapper.KhuyenMaiMapper;

/**
 *
 * @author Asus
 */
public class KhuyenMaiDAO extends AbstractDAO<KhuyenMaiDTO> {

    public Integer save(KhuyenMaiDTO km) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO khuyenmai(name,type,");
        sql.append("start_time,end_time)");
        sql.append(" VALUES(?, ?, ?, ?)");
        return insert(sql.toString(), km.getName(), km.getType(), km.getStart_time(), km.getEnd_time());
    }

    public List<KhuyenMaiDTO> findAll() {
        String sql = "SELECT * FROM khuyenmai";
        return query(sql, new KhuyenMaiMapper());
    }

    public void delete(int idKM) throws FileNotFoundException {
        String sql = "DELETE FROM khuyenmai WHERE id_KM = ? ";
        update(sql, idKM);
    }

    public void update(KhuyenMaiDTO km) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("UPDATE khuyenmai SET name = ? , type = ? ,");
        sql.append(" start_time = ?,end_time = ? WHERE id_KM = ?");
        update(sql.toString(), km.getName(), km.getType(), km.getStart_time(), km.getEnd_time(), km.getId_KM());
    }
}
