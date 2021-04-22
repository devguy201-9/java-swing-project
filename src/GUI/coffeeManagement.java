/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ct_PNHDAO;
import DTO.ct_PhieuNhapHangDTO;
import GUI.QLCoffee;
import java.io.FileNotFoundException;


/**
 *
 * @author Thuan Vo
 */
public final class coffeeManagement{
    
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
//        try{
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e)
//        {
//            
//        }
        QLCoffee gui = new QLCoffee(1, "thuan", 1);
    }

    
}

