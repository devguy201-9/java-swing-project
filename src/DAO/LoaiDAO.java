/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LoaiDTO;
import java.io.FileNotFoundException;
import mapper.LoaiMapper;
import java.util.List;

/**
 *
 * @author Asus
 */
public class LoaiDAO extends AbstractDAO<LoaiDTO> {

    public List<LoaiDTO> findAll() {
        String sql = "SELECT * FROM loai";
        return query(sql, new LoaiMapper());
    }

    public Integer save(LoaiDTO loai) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO loai(name)");
        sql.append(" VALUES(?)");
        return insert(sql.toString(), loai.getName());
    }

    public void delete(int idLoai) throws FileNotFoundException {
        String sql = "DELETE FROM loai WHERE id_Loai = ? ";
        update(sql, idLoai);
    }

    public void update(LoaiDTO loaiUpdate) throws FileNotFoundException {
        String sql = "UPDATE loai SET  name = ? WHERE id_Loai = ?";
        update(sql, loaiUpdate.getName(), loaiUpdate.getId_Loai());
    }
}
