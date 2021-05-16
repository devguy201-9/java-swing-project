/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import BUS.SanPhamBUS;
import BUS.ThongKeBUS;
import BUS.ct_HDBUS;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ACER
 */
public class ThongKeGUI extends JPanel implements ActionListener,ItemListener,ChangeListener{
    private SanPhamBUS spBUS = new SanPhamBUS();
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private KhachHangBUS khBUS = new KhachHangBUS();
    private ThongKeBUS tkBUS = new ThongKeBUS();

    public void init(){
        /*************** NHẤP TOGGLE ALL **************/
        DefaultCategoryDataset dod = new DefaultCategoryDataset();
        
        tkBUS.getChartByTime(LocalDate.MAX, LocalDate.MAX);
        
//        add(scrollViewTable);
        
        
    }        

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
