/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NCCBUS;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ACER
 */
public class NhaCungCapGUI extends JPanel{
    private NCCBUS nccBUS = new NCCBUS();
    private JTable tbl;
    private JTextField txtMaNCC,txtTenNCC,txtDiaChi,txtDienThoai;
    private DefaultTableModel model;
    private int DEFAULT_WIDTH;
    private boolean EditOrAdd;  //gan co cho Edit=false/ Add=true
    
    public NhaCungCapGUI(int width){
        DEFAULT_WIDTH = width;
        init();
    }
    
    public void init(){
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, DEFAULT_WIDTH-220, 1000));
        
        Font font0
    }
}
