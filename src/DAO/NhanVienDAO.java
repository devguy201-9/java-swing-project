/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
import mapper.NhanVienMapper;
import java.util.List;

/**
 *
 * @author Asus
 */
public class NhanVienDAO extends AbstractDAO<NhanVienDAO>{
    public NhanVienDTO findOneByCode(int id) {
        String sql = "SELECT * FROM nhanvien WHERE id = ?";
        List<NhanVienDTO> nhanviens = query(sql, new NhanVienMapper(), id);
        return nhanviens.isEmpty() ? null : nhanviens.get(0);
    }
}
