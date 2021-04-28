/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ct_quyenDAO;
import DTO.ct_quyenDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thuan Vo
 */
public class ct_quyenBUS {

    private List<ct_quyenDTO> detailList;

    public ct_quyenBUS() {
        detailList = null;
    }

    public List<ct_quyenDTO> getPermissionList() {
        return detailList;
    }

    public void getByIdPermission(int id_permission) {
        ct_quyenDAO permissionDetail = new ct_quyenDAO();
        detailList = new ArrayList<>();
        try {
            detailList = permissionDetail.getByIdPermission(id_permission);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void list() {
        ct_quyenDAO QuyenCuaNhiemVuDAO = new ct_quyenDAO();
        detailList = new ArrayList<>();
        detailList = QuyenCuaNhiemVuDAO.findAll();
    }

    public void add(ct_quyenDTO detail) {
        detailList.add(detail);
        ct_quyenDAO QuyenCuaNhiemVuDAO = new ct_quyenDAO();
        try {
            QuyenCuaNhiemVuDAO.save(detail);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id_permission) {
        for (ct_quyenDTO detailDTO : detailList) {
            if (detailDTO.getId_permission() == id_permission) {
                detailList.remove(detailDTO);
                ct_quyenDAO QuyenCuaNhiemVuDAO = new ct_quyenDAO();
                try {
                    QuyenCuaNhiemVuDAO.delete(id_permission);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(ct_quyenDTO detail) {
        for (int i = 0; i < detailList.size(); i++) {
            if (detailList.get(i).getId_permission() == detail.getId_permission()) {
                detailList.set(i, detail);
                ct_quyenDAO QuyenCuaNhiemVuDAO = new ct_quyenDAO();
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
