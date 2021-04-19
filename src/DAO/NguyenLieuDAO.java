/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NguyenLieuDTO;
import java.io.FileNotFoundException;
import java.util.List;
import mapper.NguyenLieuMapper;

/**
 *
 * @author Asus
 */
public class NguyenLieuDAO extends AbstractDAO<NguyenLieuDTO> {

    public Integer save(NguyenLieuDTO nguyenLieu) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO nguyenlieu(name,amount,");
        sql.append("price)");
        sql.append(" VALUES(?, ?, ?)");
        return insert(sql.toString(), nguyenLieu.getName(), nguyenLieu.getAmount(), nguyenLieu.getPrice());
    }

    public List<NguyenLieuDTO> findAll() {
        String sql = "SELECT * FROM nguyenlieu";
        return query(sql, new NguyenLieuMapper());
    }

    public void delete(int idNL) throws FileNotFoundException {
        String sql = "DELETE FROM nguyenlieu WHERE id_NL = ? ";
        update(sql, idNL);
    }

    public void update(NguyenLieuDTO nguyenLieu) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("UPDATE nguyenlieu SET name = ? , amount = ? ,");
        sql.append(" price = ? WHERE id_NL = ?");
        update(sql.toString(), nguyenLieu.getName(), nguyenLieu.getAmount(), nguyenLieu.getPrice(), nguyenLieu.getId_NL());
    }
}
