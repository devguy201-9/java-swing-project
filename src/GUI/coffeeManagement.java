/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.TaiKhoanDTO;
import java.io.FileNotFoundException;

/**
 *
 * @author Thuan Vo
 */
public final class coffeeManagement {

    public static void main(String[] args) throws FileNotFoundException {

        TaiKhoanDTO tk = new TaiKhoanDTO();
        QLCoffee gui = new QLCoffee(1, tk.getUser_name(), 1);
    }

}
