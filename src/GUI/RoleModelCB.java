/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.PermissionDTO;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Asus
 */
public class RoleModelCB extends DefaultComboBoxModel<PermissionDTO>{
    
    public RoleModelCB(PermissionDTO[] items) {
        super(items);
    }
    
}
