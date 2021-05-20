/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Gender;
import DTO.NhanVienDTO;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import mapper.NhanVienMapper;
import java.util.List;

/**
 *
 * @author Asus
 */
public class NhanVienDAO extends AbstractDAO<NhanVienDAO> {

    public NhanVienDTO findOneByCode(int id) {
        String sql = "SELECT * FROM nhanvien WHERE id_NV = ?";
        List<NhanVienDTO> nhanviens = query(sql, new NhanVienMapper(), id);
        return nhanviens.isEmpty() ? null : nhanviens.get(0);
    }

    public NhanVienDTO getOneByPhone(String phone) {
        String sql = "SELECT * FROM nhanvien WHERE phone = ?";
        List<NhanVienDTO> nhanviens = query(sql, new NhanVienMapper(), phone);
        return nhanviens.isEmpty() ? null : nhanviens.get(0);
    }
    
    public NhanVienDTO getOneByGender(Gender gender){
        String sql = "SECLECT * FROM nhanvien WHERE gender = ?";
        List<NhanVienDTO> nhanvien = query(sql, new NhanVienMapper(), gender);
        return nhanvien.isEmpty() ? null : nhanvien.get(0);
    }

    public Integer save(NhanVienDTO nv) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO nhanvien(name,age,");
        sql.append("gender,address,phone,start_day,status,img)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), nv.getName(), nv.getAge(), nv.getGender().toString(), nv.getAddress(),
                nv.getPhone(), new SimpleDateFormat("yyyy/MM/dd").format(nv.getStart_day()), true ,nv.getImg());
    }

    public List<NhanVienDTO> findAll() {
        String sql = "SELECT * FROM nhanvien";
        return query(sql, new NhanVienMapper());
    }

    public void delete(int idNV) throws FileNotFoundException {
        String sql = "UPDATE nhanvien SET status = 0 WHERE id_NV = ? ";
        update(sql, idNV);
    }

    public void update(NhanVienDTO nv) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("UPDATE nhanvien SET name = ? , age = ? ,");
        sql.append(" gender = ?, address = ?, phone = ?, start_day = ?, img = ?  WHERE id_NV = ?");
        update(sql.toString(), nv.getName(), nv.getAge(), nv.getGender().toString(), nv.getAddress(),
                nv.getPhone(), new SimpleDateFormat("yyyy/MM/dd").format(nv.getStart_day()), nv.getImg(), nv.getId_NV());
    }

}
