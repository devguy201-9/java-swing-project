/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class MyTable extends DefaultTableModel {

    MyTable(Vector header, int i) {
        super(header, i);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int mColIndex) {
        return false;
    }
}
