/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachHangDTO;
import mapper.KhachHangMapper;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author Asus
 */
public class KhachHangDAO extends AbstractDAO<KhachHangDTO> {

    public Integer save(KhachHangDTO kh) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO khachhang(first_name,");
        sql.append("last_name,phone)");
        sql.append(" VALUES(?, ?, ?)");
        return insert(sql.toString(), kh.getFirst_name(), kh.getLast_name(), kh.getPhone());
    }

    public List<KhachHangDTO> findAll() {
        String sql = "select * from khachhang";
        return query(sql, new KhachHangMapper());
    }
}
