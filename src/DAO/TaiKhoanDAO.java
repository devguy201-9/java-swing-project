/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TaiKhoanDTO;
import java.io.FileNotFoundException;
import java.util.List;
import mapper.TaiKhoanMapper;

/**
 *
 * @author Asus
 */
public class TaiKhoanDAO extends AbstractDAO<TaiKhoanDTO> {

    public TaiKhoanDTO findOneByUsernameAndPassword(String username, String password) {
        //search with username and password and get name permission of the account
        String sql = "SELECT * FROM taikhoan AS tk INNER JOIN quyen AS q ON tk.id_permission  = q.id_permission  WHERE user_name = ? AND pass = ?";
        List<TaiKhoanDTO> taikhoan = query(sql, new TaiKhoanMapper(), username, password);
        return taikhoan.isEmpty() ? null : taikhoan.get(0);
    }

    public Integer save(TaiKhoanDTO tk) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO taikhoan(id_NV,user_name,");
        sql.append("pass,id_permission)");
        sql.append(" VALUES(?, ?, ?, ?)");
        return insert(sql.toString(), tk.getId_NV(), tk.getUser_name(), tk.getPass(), tk.getId_permission());
    }

    public List<TaiKhoanDTO> findAll() {
        String sql = "select * from taikhoan";
        return query(sql, new TaiKhoanMapper());
    }

    public void delete(int idTK) throws FileNotFoundException {
        String sql = "DELETE FROM taikhoan WHERE id_TK = ? ";
        update(sql, idTK);
    }

    public void update(TaiKhoanDTO tkUpdate) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("UPDATE taikhoan SET user_name = ? , pass = ? ,");
        sql.append(" id_permission = ? WHERE id_TK = ?");
        update(sql.toString(), tkUpdate.getUser_name(), tkUpdate.getPass(), tkUpdate.getId_permission(), tkUpdate.getId_TK());
    }
}
