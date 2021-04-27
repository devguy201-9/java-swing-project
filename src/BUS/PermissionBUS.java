/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PermissionDAO;
import DTO.PermissionDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thuan Vo
 */
public class PermissionBUS {

    private List<PermissionDTO> permissionList;

    public PermissionBUS() {
        permissionList = null;
    }

    public List<PermissionDTO> getPermissionList() {
        return permissionList;
    }

    public void list() {
        PermissionDAO permissionDAO = new PermissionDAO();
        permissionList = new ArrayList<>();
        permissionList = permissionDAO.findAll();
    }

    public void add(PermissionDTO permission) {
        permissionList.add(permission);
        PermissionDAO permissionDAO = new PermissionDAO();
        try {
            permissionDAO.save(permission);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id_permission) {
        for (PermissionDTO permissionDTO : permissionList) {
            if (permissionDTO.getId_Permission() == id_permission) {
                permissionList.remove(permissionDTO);
                PermissionDAO permissionDAO = new PermissionDAO();
                try {
                    permissionDAO.delete(id_permission);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(PermissionDTO permissionDTO) {
        for (int i = 0; i < permissionList.size(); i++) {
            if (permissionList.get(i).getId_Permission() == permissionDTO.getId_Permission()) {
                permissionList.set(i, permissionDTO);
                PermissionDAO permissionDAO = new PermissionDAO();
                try {
                    permissionDAO.update(permissionDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }
}
