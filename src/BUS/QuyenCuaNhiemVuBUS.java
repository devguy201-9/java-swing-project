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

    public void getByIdPermission(int id_permission) {
        QuyenCuaNhiemVuDAO permissionDetail = new QuyenCuaNhiemVuDAO();
        detailList = new ArrayList<>();
        try {
            detailList = permissionDetail.getByIdPermission(id_permission);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void list() {
        QuyenCuaNhiemVuDAO QuyenCuaNhiemVuDAO = new QuyenCuaNhiemVuDAO();
        detailList = new ArrayList<>();
        detailList = QuyenCuaNhiemVuDAO.findAll();
    }

    public void add(QuyenCuaNhiemVuDTO detail) {
        detailList.add(detail);
        QuyenCuaNhiemVuDAO QuyenCuaNhiemVuDAO = new QuyenCuaNhiemVuDAO();
        try {
            QuyenCuaNhiemVuDAO.save(detail);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id_permission) {
        for (QuyenCuaNhiemVuDTO detailDTO : detailList) {
            if (detailDTO.getId_permission() == id_permission) {
                detailList.remove(detailDTO);
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

    public void set(QuyenCuaNhiemVuDTO detail) {
        for (int i = 0; i < detailList.size(); i++) {
            if (detailList.get(i).getId_permission() == detail.getId_permission()) {
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
