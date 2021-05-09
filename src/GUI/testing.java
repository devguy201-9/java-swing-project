/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.CategoryBUS;
import BUS.LoaiBUS;
import BUS.SanPhamBUS;
import BUS.ct_quyenBUS;
import DTO.CategoryDTO;
import DTO.LoaiDTO;
import DTO.SanPhamDTO;
import DTO.ct_quyenDTO;
import GUI.model.navItem;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Thuan Vo
 */
public class testing extends JPanel implements MouseListener{
    
    private int DEFALUT_WIDTH;
    private ArrayList<String> navItem = new ArrayList<>();  //Chứa thông tin có button cho menu gồm
    private ArrayList<navItem> navObj = new ArrayList<>();
    
    private ArrayList<String> menuItem = new ArrayList<>();
    private ArrayList<navItem> menuObj = new ArrayList<>();
    
    private DefaultTableModel model;
    private JPanel navMenu , items;
    private JTable table;
    private Button btnAdd , btnDelete , btnPrintOut;
    
    public testing(int width) throws FileNotFoundException {
        DEFALUT_WIDTH = width;
        view();
    }
    
    public void view() throws FileNotFoundException {
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 1000));
        Font font0 = new Font("Segoe UI", Font.PLAIN, 14);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);
        
		
        navMenu = new JPanel(null);
        navMenu.setBounds(20, 10, 157, 295);
        
        outNav();
        
        add(navMenu);

        items = new JPanel(null);
        items.setBounds(200, 10, 570, 295);
        add(items);

        table = new JTable();
//        table.setBounds(20, 310, 750, 350);
                
        /**
         * ********** PHẦN MAIN ( HIỂN THỊ ) *************************
         */
        navObj.get(0).doActive();
        changeMainInfo(1); 
//        

//        items.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                for (int i = 0; i < menuObj.size(); i++) {
//                 navItem item = menuObj.get(i); // lấy vị trí item trong menu
//            if (e.getSource() == item) {
//                item.doActive();// Active NavItem đc chọn 
//                SanPhamBUS spbus = new SanPhamBUS();
//                SanPhamDTO sp = spbus.getOneByName(item.getName());
//                outModel(model , sp); // Hiển thị ra phần main
//            } else {
//                item.noActive();
//            } 
//            }}});

        
/*********************************************************/
// * ************ TẠO MODEL VÀ HEADER ********************

        Vector header = new Vector();
        header.add("Mă SP");
        header.add("Tên SP");
        header.add("Số Lượng");
        header.add("Đơn Giá");
        header.add("Thành Tiền");
//        header.add("Mă NSX");
        model = new MyTable(header, 0) {
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Integer.class;
                    case 5:
                        return Integer.class;
                    default:
                        return Integer.class;
                }
            }

        };
        table = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(rowSorter);
         //Đọc từ database lên table 
        /**
         * ******************************************************
         */

        /**
         * ************** TẠO TABLE
         * ***********************************************************
         */
        // Chỉnh width các cột 
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(40);
        table.getColumnModel().getColumn(3).setPreferredWidth(40);
        table.getColumnModel().getColumn(4).setPreferredWidth(40);

        DefaultTableCellRenderer centerAlign = new DefaultTableCellRenderer();
        centerAlign.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerAlign);
        table.getColumnModel().getColumn(2).setCellRenderer(centerAlign);
        table.getColumnModel().getColumn(3).setCellRenderer(centerAlign);

        // Custom table
        table.setFocusable(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.getTableHeader().setFont(font1);
        table.setRowHeight(30);
        table.setShowVerticalLines(false);
        table.getTableHeader().setOpaque(false);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setBackground(new Color(134, 64, 0)); //232, 57, 99
        table.getTableHeader().setForeground(Color.WHITE);
        table.setSelectionBackground(new Color(52, 152, 219));

        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(new Rectangle(30, 360, this.DEFALUT_WIDTH - 400, 300));
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5, 100));
        add(scroll);
        /**
         * **************************************************************************************
         */


/******************************************************************/

//===================Button===================================
        btnAdd = new Button("Thêm");
        btnAdd.setBounds(850, 311, 133, 42);
        add(btnAdd);

        btnDelete = new Button("Xóa");
        btnDelete.setBounds(850, 372, 133, 42);
        add(btnDelete);

        btnPrintOut = new Button("In Bill");
        btnPrintOut.setBounds(850, 439, 133, 42);
        add(btnPrintOut);

//===================================================================

        setVisible(true);
    }
    
    public void outNav() {
        navObj.clear();
        LoaiBUS loai = new LoaiBUS();
        loai.list();
        List<LoaiDTO> loaiList = loai.getLoaiBUS();

        int i = 0;
        for (LoaiDTO temp : loaiList) {
            navItem.add(temp.getName());

            String s = navItem.get(i);
            navObj.add(new navItem(s, new Rectangle(0 ,60 * i, 220, 50)));
            navObj.get(i).addMouseListener(this);

            navMenu.add(navObj.get(i));
            i++;
        }
        repaint();
        revalidate();
    }
    
    public void changeMainInfo(int i) //Đổi Phần hiển thị khi bấm btn trên menu
    {
       menuItem.clear();
       menuObj.clear();
       items.removeAll();
       
       SanPhamBUS sp = new SanPhamBUS();
       List<SanPhamDTO> sps = sp.findAllByMaLoai(i);

        int j = 0;
        for (SanPhamDTO sp1 : sps) {
            menuItem.add(sp1.getName());
            
            String s = menuItem.get(j);
            menuObj.add(new navItem(s, new Rectangle(10 ,100 * j, 300, 80)));
            menuObj.get(j).addMouseListener(this);
            
            items.add(menuObj.get(j));
            j++;
        }
        

        repaint();
        revalidate();
        
    }
    
    public void outModel(DefaultTableModel model, SanPhamDTO sp) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
    
            data = new Vector();
            data.add(sp.getId_SP());
            data.add(sp.getName());
//            data.add(s.getAmount());
            data.add(sp.getPrice());

            model.addRow(data);
        
        table.setModel(model);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        for (int i = 0; i < navObj.size(); i++) {
            navItem item = navObj.get(i); // lấy vị trí item trong menu
            if (e.getSource() == item) {
                item.doActive();// Active NavItem đc chọn 
                i++;
                changeMainInfo(i); // Hiển thị ra phần main
            } else {
                item.noActive();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
