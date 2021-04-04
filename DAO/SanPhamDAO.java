/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanqlsieuthi.DAO;

import doanqlsieuthi.DTO.SanPhamDTO;
import doanqlsieuthi.mapper.SanPhamMappper;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author Asus
 */
public class SanPhamDAO extends AbstractDAO<SanPhamDTO> {

    public Integer save(SanPhamDTO sp) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO sanpham(id_Loai,name,");
        sql.append("descrption,amount,price)");
        sql.append(" VALUES(?, ?, ?, ?, ?)");
        return insert(sql.toString(), sp.getId_Loai(), sp.getName(), sp.getDescrption(),
                sp.getAmount(), sp.getPrice());
    }

    public List<SanPhamDTO> findAll() {
        String sql = "select * from sanpham";
        return query(sql, new SanPhamMappper());
    }
}
