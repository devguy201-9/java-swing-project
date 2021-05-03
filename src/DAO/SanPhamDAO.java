/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SanPhamDTO;
import mapper.SanPhamMapper;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author Asus
 */
public class SanPhamDAO extends AbstractDAO<SanPhamDTO> {

    public Integer save(SanPhamDTO sp) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO sanpham(id_Loai,name,");
        sql.append("descrption,amount,price,img)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), sp.getId_Loai(), sp.getName(), sp.getDescrption(),
                sp.getAmount(), sp.getPrice(), sp.getImg());
    }

    public List<SanPhamDTO> findAll() {
        String sql = "select * from sanpham";
        return query(sql, new SanPhamMapper());
    }
    
    public SanPhamDTO getOneByName (String name){
        String sql = "SELECT * FROM sanpham WHERE phone LIKE ?";
        List<SanPhamDTO> sp = query(sql, new SanPhamMapper(), name);
        return sp.isEmpty() ? null : sp.get(0);
    }
    
     public void delete(int idSP) throws FileNotFoundException {
        String sql = "DELETE FROM sanpham WHERE id_SP = ? ";
        update(sql, idSP);
    }

    public void update(SanPhamDTO spUpdate) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("UPDATE taikhoan SET id_Loai = ? , name = ? ,");
        sql.append(" descrption = ?, amount = ?, price = ? WHERE id_SP = ?");
        update(sql.toString(), spUpdate.getId_Loai(), spUpdate.getName(), spUpdate.getDescrption(), spUpdate.getAmount(), spUpdate.getPrice(), spUpdate.getImg());
    }

}
