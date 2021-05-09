/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhaCungCapDTO;
import java.io.FileNotFoundException;
import java.util.List;
import mapper.NCCMapper;

/**
 *
 * @author Asus
 */
public class NCCDAO extends AbstractDAO<NhaCungCapDTO>{
    public Integer save(NhaCungCapDTO ncc) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO nhacungcap(name_NCC,");
        sql.append("address,phone)");
        sql.append(" VALUES(?, ?, ?)");
        return insert(sql.toString(), ncc.getName_NCC(),ncc.getAddress(),ncc.getPhone());
    }

    public List<NhaCungCapDTO> findAll() {
        String sql = "SELECT * FROM nhacungcap";
        return query(sql, new NCCMapper());
    }

    public void delete(int idNCC) throws FileNotFoundException {
        String sql = "DELETE FROM nhacungcap WHERE id_NCC = ? ";
        update(sql, idNCC);
    }

    public void update(NhaCungCapDTO ncc) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("UPDATE nhacungcap SET name_NCC = ? , address = ? ,");
        sql.append(" phone = ? WHERE id_NCC = ?");
        update(sql.toString(), ncc.getName_NCC(),ncc.getAddress(),ncc.getPhone(),ncc.getId_NCC());
    }
 
}
