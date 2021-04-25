/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.SanPhamBUS;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Shadow
 */
class SuggestSanPham extends JDialog{
    private String maSP;
    private SanPhamBUS spBUS = new SanPhamBUS();
    private JTextField txtMaSP,txtTenSP,txtGia,txtSL,txtDVT;
    private String img;
    private DefaultTableModel model;
    private JTable tbl;
    private int DWIDTH = 1200;
    private JTextField txtSearch;
    private JComboBox cmbChoice;

    public SuggestSanPham(String maSP)
    {
        this.maSP = maSP;
        setModal(true);
        init();
    }
    public SuggestSanPham()
    {
        this.maSP ="";
        setModal(true);
        init();
    }
    public void init()
    {
        setTitle("Danh sách sản phẩm");
        setSize(DWIDTH,700);
        getContentPane().setBackground(new Color(55, 63, 81));
        setLayout(null);
        setLocationRelativeTo(null);
        
        Font font0 = new Font("Segoe UI",Font.PLAIN,14);
        Font font1 = new Font("Segoe UI",Font.BOLD,13);
        
        //HEADER
/***************** PHẦN HIỂN THỊ THÔNG TIN ***************************/
        JPanel itemView = new JPanel(null);
        itemView.setBounds(new Rectangle(0, 0,this.DWIDTH, 700));
        itemView.setBackground(Color.WHITE);
        
        JLabel lbMaSP = new JLabel("Mã sản phẩm ");
        lbMaSP.setFont(font0);
        lbMaSP.setBounds(20,20,100,30);
        txtMaSP = new JTextField();
        txtMaSP.setBounds(new Rectangle(120,20,250,30));
        itemView.add(lbMaSP);
        itemView.add(txtMaSP);
        
        JLabel lbTenSP = new JLabel("Tên sản phầm");
        lbTenSP.setFont(font0);
        lbTenSP.setBounds(20,70,100,30);
        txtTenSP = new JTextField();
        txtTenSP.setBounds(new Rectangle(120,70,250,30));
        itemView.add(lbTenSP);
        itemView.add(txtTenSP);
        
        JLabel lbGia = new JLabel("Đơn giá ");
        lbGia.setFont(font0);
        lbGia.setBounds(20,120,100,30);
        txtGia = new JTextField();
        txtGia.setBounds(new Rectangle(120,120,250,30));
        itemView.add(lbGia);
        itemView.add(txtGia);
        
        JLabel lbDVT = new JLabel("DVT");
        lbDVT.setFont(font0);
        lbDVT.setBounds(20,170,100,30);
        txtDVT = new JTextField();
        txtDVT.setBounds(new Rectangle(120,170,250,30));
        itemView.add(lbDVT);
        itemView.add(txtDVT);
        
        JLabel lbSL = new JLabel("SL tồn");
        lbSL.setFont(font0);
        lbSL.setBounds(20,220,100,30);
        txtSL = new JTextField();
        txtSL.setBounds(new Rectangle(120,220,250,30));
        itemView.add(lbSL);
        itemView.add(txtSL);
        
/**************** TẠO CÁC BTN XÓA, SỬA, VIEW, IN BILL ********************/

        JLabel btnConfirm = new JLabel(new ImageIcon("./src/image/btnConfirm_150px.png"));
        btnConfirm.setBounds(new Rectangle(20,320,150,50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirm.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                dispose();
            }
        });
              
        JLabel btnBack = new JLabel(new ImageIcon("./src/image/btnBack_150px.png"));
        btnBack.setBounds(new Rectangle(180,320,150,50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));    
        btnBack.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                dispose();
            }
        });
        
        itemView.add(btnConfirm);
        itemView.add(btnBack);
/*************************************************************************/

/**************** TẠO TABLE ************************************************************/

    /************** TẠO MODEL VÀ HEADER *********************************/
        Vector header = new Vector();
        header.add("Mă SP");
        header.add("Tên SP");
        header.add("Đơn giá");
        header.add("ĐVT");
        header.add("SL tồn");
        header.add("IMG");
        model = new DefaultTableModel(header,5);
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        listSP();
        if (maSP.trim().length() != 0) {
            int select = searchModel(model, maSP);
            tbl.setRowSelectionInterval(select, select);
            TabletoTXT(select);
        }
    /*******************************************************************/
        

    /******** CUSTOM TABLE ****************/
    
        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(50);

        // Custom table
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0,0));     
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);              
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(232,57,99));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52,152,219));          
        
        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(400, 20, DWIDTH - 450 , 500));
        scroll.setBackground(null);
        
        itemView.add(scroll);
        
        add(itemView);
    /**************************************/
/*****************************************************************************************/
        tbl.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbl.getSelectedRow();
                TabletoTXT(i);
             }
        });
/*********************************************************************/
/********************* THANH SEARCH ***********************************************/
        
//         Tạo Search Box
        JPanel searchBox = new JPanel(null);
        searchBox.setBackground(null);
        searchBox.setBounds(new Rectangle(20,270,350, 30)); 
        searchBox.setBorder(createLineBorder(Color.BLACK)); //Chỉnh viền 
        
        //PHẦN CHỌN SEARCH
        cmbChoice = new JComboBox();
        cmbChoice.setEditable(true);
        cmbChoice.setFont(new Font("Segoe UI",Font.PLAIN,14));
        cmbChoice.addItem("Mã SP");
        cmbChoice.addItem("Tên SP");
        cmbChoice.setBounds(new Rectangle(0,0,80,30));
        
        //Phần TextField 
        txtSearch = new JTextField();
        txtSearch.setBounds(new Rectangle(85,0,220,30));
        txtSearch.setBorder(null);
        txtSearch.setOpaque(false);
        txtSearch.setFont(new Font("Segoe UI",Font.PLAIN,15));
        
        // Custem Icon search
        JLabel searchIcon = new JLabel(new ImageIcon("./src/image/search_25px.png"));
        searchIcon.setBounds(new Rectangle(305,-9,50,50));
        searchIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Add tất cả vào search box
        searchBox.add(cmbChoice);
        searchBox.add(txtSearch);
        searchBox.add(searchIcon);

        //bắt sự kiện Focus vào search box
        txtSearch.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) 
            {
                searchIcon.setIcon(new ImageIcon("./src/image/search_25px_focus.png")); //Đổi màu icon
                searchBox.setBorder(createLineBorder(new Color(52,152,219))); // Đổi màu viền 
            }
            public void focusLost(FocusEvent e) //Trờ về như cũ
            {
                searchIcon.setIcon(new ImageIcon("./src/image/search_25px.png"));
                searchBox.setBorder(createLineBorder(Color.BLACK));
            }
        });
        txtSearch.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtSearch.getText();
                int choice = cmbChoice.getSelectedIndex();
                
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^"+ text +".*", choice));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtSearch.getText();
                int choice = cmbChoice.getSelectedIndex();
                
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^"+ text +".*", choice));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        itemView.add(searchBox);
/*********************************************************************************/
        setVisible(true);
    }
    public void outModel(DefaultTableModel model , ArrayList<SanPhamDTO> sp) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for(SanPhamDTO s:sp)
        {
            data = new Vector();
            data.add(s.getId_SP());
            data.add(s.getName());
            data.add(s.getPrice());
            data.add(s.getId_Loai());
            data.add(s.getAmount());
            data.add(s.getImg());
            model.addRow(data);
        }
        tbl.setModel(model);
    }
    public void listSP() // Chép ArrayList lên table
    {
        if(spBUS.getSpBUS()== null)spBUS.list();
        ArrayList<SanPhamDTO> nv = (ArrayList<SanPhamDTO>) spBUS.getSpBUS();
        model.setRowCount(0);
        outModel(model,nv);
    }
    public String getTextFieldContent() 
    {
        return  txtMaSP.getText()+"%"+
                txtTenSP.getText()+"%"+
                txtGia.getText()+"%"+
                img;
    }
    public int searchModel(DefaultTableModel model,String s)
    {
        for(int i = 0 ; i < model.getRowCount();i++)
        {
            if(model.getValueAt(i, 0).equals(s))
            {
                return i;
            }
        }
        return 0;
    }
    public void TabletoTXT(int i)
    {
        if(tbl.getRowSorter() != null)
        {
            i = tbl.getRowSorter().convertRowIndexToModel(i);
        }
        txtMaSP.setText(tbl.getModel().getValueAt(i, 0).toString());
        txtTenSP.setText(tbl.getModel().getValueAt(i, 1).toString());
        txtGia.setText(tbl.getModel().getValueAt(i, 2).toString()); 
        txtDVT.setText(tbl.getModel().getValueAt(i, 3).toString()); 
        txtSL.setText(tbl.getModel().getValueAt(i, 4).toString());
        img = tbl.getModel().getValueAt(i, 5).toString();
    }
}
