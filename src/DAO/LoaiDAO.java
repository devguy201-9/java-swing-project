/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LoaiDTO;
import mapper.LoaiMapper;
import java.util.List;

/**
 *
 * @author Asus
 */
public class LoaiDAO extends AbstractDAO<LoaiDTO> {

    public List<LoaiDTO> findAll() {
        String sql = "select * from sanpham";
        return query(sql, new LoaiMapper());
    }
}
