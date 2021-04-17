/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.QuyenCuaNhiemVuDAO;
import DTO.QuyenCuaNhiemVuDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import mapper.QuyenCuaNhiemVuMapper;

/**
 *
 * @author Thuan Vo
 */
public class QuyenCuaNhiemVuBUS {
    private List<QuyenCuaNhiemVuDTO> detailList;
    
    public QuyenCuaNhiemVuBUS() {
        detailList = null;
    }

    public List<QuyenCuaNhiemVuDTO> getPermissionList() {
        return detailList;
    }
    
    public List<QuyenCuaNhiemVuDTO> getByIdPermission(int id_permission) throws FileNotFoundException{
        QuyenCuaNhiemVuDAO permissionDetail = new QuyenCuaNhiemVuDAO();
        String sql = "SELECT `id_duty` FROM `quyencuanhiemvu` WHERE id_permission = ?";
        List<QuyenCuaNhiemVuDTO> result = permissionDetail.query(sql.toString(),new QuyenCuaNhiemVuMapper() ,id_permission);
        return result;
    }
    
    public void list(){
        QuyenCuaNhiemVuDAO QuyenCuaNhiemVuDAO = new QuyenCuaNhiemVuDAO();
        detailList = new ArrayList<>();
        detailList = QuyenCuaNhiemVuDAO.findAll();
    }
    
    public void show(){
        for(QuyenCuaNhiemVuDTO detail : detailList) {
            System.out.println(detail.getId_permission() + " : " + detail.getid_duty());
        }
    }
    
    public void add(QuyenCuaNhiemVuDTO category){
        detailList.add(category);
        QuyenCuaNhiemVuDAO QuyenCuaNhiemVuDAO = new QuyenCuaNhiemVuDAO();
        try {
            QuyenCuaNhiemVuDAO.save(category);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(int id_permission) {
        for(QuyenCuaNhiemVuDTO categoryDTO : detailList){
            if(categoryDTO.getId_permission() == id_permission) {
                detailList.remove(categoryDTO);
                QuyenCuaNhiemVuDAO QuyenCuaNhiemVuDAO = new QuyenCuaNhiemVuDAO();
                try {
                    QuyenCuaNhiemVuDAO.delete(id_permission);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }
    
    public void set(QuyenCuaNhiemVuDTO detail){
        for(int i = 0 ; i < detailList.size() ; i++) {
            if(detailList.get(i).getId_permission()== detail.getId_permission()) {
                detailList.set(i, detail);
                QuyenCuaNhiemVuDAO QuyenCuaNhiemVuDAO = new QuyenCuaNhiemVuDAO();
                try {
                    QuyenCuaNhiemVuDAO.update(detail);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }
}
