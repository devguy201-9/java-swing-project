/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NCCBUS;
import DTO.NhaCungCapDTO;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author ACER
 */
public class NhaCungCapGUI extends JPanel{
    private NCCBUS nccBUS = new NCCBUS();
    private JTable tbl;
    private JLabel lbMaNCC, lbTenNCC, lbDienThoai, lbSoFax, lbDiaChi, iconSearch;
    private JTextField txtMaNCC,txtTenNCC,txtDiaChi,txtDienThoai,txtSearch;
    JComboBox cmbChoice;
    private DefaultTableModel model;
    private int DEFAULT_WIDTH;
    private boolean EditOrAdd = true;  //gan co cho EditAdd
    
    public NhaCungCapGUI(int width){
        DEFAULT_WIDTH = width;
        init();
    }
    
    public void init(){
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, DEFAULT_WIDTH-220, 1000));
        
        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
        Font font1 = new Font("Segoe UI",Font.BOLD,13);
        
/****************************** PHẦN HIỂN THỊ THÔNG TIN ******************************************/
        JPanel itemView = new JPanel(null);
        itemView.setBounds(new Rectangle(30, 40, DEFAULT_WIDTH - 950, 600));
        itemView.setBackground(new Color(201, 211, 203));
        
        /******** Tao Cac Label & TextField ************************/
        lbMaNCC = new JLabel("Mã NCC");
        lbMaNCC.setFont(font1);
        lbMaNCC.setBounds(new Rectangle(0, 0, 200, 30));
        txtMaNCC = new JTextField("");
        txtMaNCC.setFont(font0);
        txtMaNCC.setBorder(null);
        txtMaNCC.setBounds(new Rectangle(110, 0, 220, 30));
        txtMaNCC.setEditable(false);
        
        lbTenNCC = new JLabel("Tên NCC");
        lbTenNCC.setFont(font1);
        lbTenNCC.setBounds(new Rectangle(0, 40, 200, 30));
        txtTenNCC = new JTextField("");
        txtTenNCC.setFont(font0);
        txtTenNCC.setBorder(null);
        txtTenNCC.setBounds(new Rectangle(110, 40, 220, 30));
        
        lbDiaChi = new JLabel("Địa chỉ");
        lbDiaChi.setFont(font1);
        lbDiaChi.setBounds(new Rectangle(0, 80, 200, 30));
        txtDiaChi = new JTextField("");
        txtDiaChi.setFont(font0);
        txtDiaChi.setBorder(null);
        txtDiaChi.setBounds(new Rectangle(110, 80, 220, 30));
        
        lbDienThoai = new JLabel("Số điện thoại");
        lbDienThoai.setFont(font1);
        lbDienThoai.setBounds(new Rectangle(0, 120, 200, 30));
        txtDienThoai = new JTextField("");
        txtDienThoai.setFont(font0);
        txtDienThoai.setBorder(null);
        txtDienThoai.setBounds(new Rectangle(110, 120, 220, 30));
        
        //  THÊM VÀO PHẦN HIỆN THỊ
        itemView.add(lbMaNCC);
        itemView.add(txtMaNCC);
        itemView.add(lbTenNCC);
        itemView.add(txtTenNCC);        
        itemView.add(lbDiaChi);
        itemView.add(txtDiaChi);
        itemView.add(lbDienThoai);
        itemView.add(txtDienThoai);
        
        add(itemView);
        
        
        /**************** TẠO CÁC BTN THÊM ,XÓA, SỬA ********************/
        JLabel btnAdd = new JLabel(new ImageIcon("./src/image/btnAdd.png"));
        btnAdd.setBounds(new Rectangle(110,250,200,50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
        JLabel btnEdit = new JLabel(new ImageIcon("./src/image/btnEdit.png"));
        btnEdit.setBounds(new Rectangle(110,320,200,50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
               
        JLabel btnDelete = new JLabel(new ImageIcon("./src/image/btnDelete.png"));
        btnDelete.setBounds(new Rectangle(110,390,200,50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
      
        JLabel btnConfirm= new JLabel(new ImageIcon("./src/image/btnConfirm.png"));
        btnConfirm.setVisible(false);
        btnConfirm.setBounds(new Rectangle(110,250,200,50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel btnBack = new JLabel(new ImageIcon("./src/image/btnBack.png"));
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(110,320,200,50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        //THÊM VÀO PHẦN HIỂN THỊ
        itemView.add(btnAdd);
        itemView.add(btnEdit);
        itemView.add(btnDelete);
        itemView.add(btnConfirm);
        itemView.add(btnBack);
        
        // MouseClick btnADD
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                EditOrAdd = true;
                
                cleanView();
                
                btnAdd.setVisible(!EditOrAdd);
                btnEdit.setVisible(!EditOrAdd);
                btnDelete.setVisible(!EditOrAdd);
                
                btnConfirm.setVisible(EditOrAdd);
                btnBack.setVisible(EditOrAdd);
            }
        });
        
        // MouseClick btnEdit
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(txtMaNCC.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp cần sửa ^^");
                    return;
                }
                
                EditOrAdd = true;
                
                txtMaNCC.setEditable(false);
                btnAdd.setVisible(!EditOrAdd);
                btnEdit.setVisible(!EditOrAdd);
                btnDelete.setVisible(!EditOrAdd);
                
                btnConfirm.setVisible(EditOrAdd);
                btnBack.setVisible(EditOrAdd);
                
                tbl.setEnabled(!EditOrAdd);
            }
        });
        
        // MouseClick btnDelete
        btnDelete.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int del = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Thông báo", JOptionPane.YES_NO_OPTION);
                if(del == 0){
                    nccBUS.delete(txtMaNCC.getText());
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, (ArrayList<NhaCungCapDTO>) nccBUS.getNccBUS());
                }
            }
        });
        
        //MouseClick btnBack
        btnBack.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                cleanView();
                EditOrAdd = true;
                btnAdd.setVisible(EditOrAdd);
                btnEdit.setVisible(EditOrAdd);
                btnDelete.setVisible(EditOrAdd);
                btnConfirm.setVisible(!EditOrAdd);
                btnBack.setVisible(!EditOrAdd);
                
                tbl.setEnabled(EditOrAdd);
            }
        });
        
        //MouseClick btnConfirm
        btnConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int mess;
                if(EditOrAdd){  //thêm NCC
                    mess = JOptionPane.showConfirmDialog(null, "Xác nhận thêm nhà cung cấp", "Thông báo xác nhận", JOptionPane.YES_NO_OPTION);
                    if(mess == 0){     //YES
                        //Lấy data từ TextField lên
                        int maNCC = Integer.parseInt(txtMaNCC.getText());
                        String tenNCC = txtTenNCC.getText();
                        String diaChi = txtDiaChi.getText();
                        String sdt = txtDienThoai.getText();
                        if(nccBUS.checkIdNCC(maNCC)){
                            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp đã tồn tại");
                            return;
                        }
                        //Load data lên DAO và BUS
                        NhaCungCapDTO ncc = new NhaCungCapDTO(tenNCC, diaChi, sdt);
                        nccBUS.add(ncc);
                        //Load lên table
                        outModel(model, (ArrayList<NhaCungCapDTO>) nccBUS.getNccBUS());
                        //clear input
                        cleanView();
                    }
                }
                else{   //sửa NCC
                    mess = JOptionPane.showConfirmDialog(null, "Xác nhận sửa nhà cung cấp", "Thông báo sửa", JOptionPane.YES_NO_OPTION);
                    if(mess == 0){  //YES
                        //Lấy data từ textField lên
                        int maNCC = Integer.parseInt(txtMaNCC.getText());
                        String tenNCC = txtTenNCC.getText();
                        String diaChi = txtDiaChi.getText();
                        String sdt = txtDienThoai.getText();
                        
                        //Upload data len DAO va BUS
                        NhaCungCapDTO ncc = new NhaCungCapDTO(tenNCC, diaChi, sdt);
                        nccBUS.set(ncc);
                        
                        //Load lai table
                        outModel(model, (ArrayList<NhaCungCapDTO>) nccBUS.getNccBUS());
                        
                        JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }); 
        
/********************TABLE****************************************************************************/       

/************** TẠO MODEL VÀ HEADER *********************/
        Vector header = new Vector();
        header.add("Mã NCC");
        header.add("Tên NCC");
        header.add("Địa chỉ");
        header.add("SDT");
        model = new MyTable(header, 4);
        tbl = new JTable(model);
        //sap xep
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        
        listNCC();
/************** TẠO TABLE *********************/        
        
    //Chỉnh độ rộng cột
    tbl.getColumnModel().getColumn(0).setPreferredWidth(30);
    tbl.getColumnModel().getColumn(1).setPreferredWidth(50);
    tbl.getColumnModel().getColumn(2).setPreferredWidth(70);
    tbl.getColumnModel().getColumn(3).setPreferredWidth(30);
    
    //Chỉnh table
    tbl.setFocusable(false);
    tbl.getTableHeader().setFont(font1);
    tbl.setRowHeight(30);
    tbl.setShowVerticalLines(false);
    tbl.getTableHeader().setBackground(new Color(134, 64, 0));
    tbl.getTableHeader().setForeground(Color.WHITE);
    tbl.setSelectionBackground(new Color(52,152,219));
    tbl.setFillsViewportHeight(true);
    tbl.getTableHeader().setOpaque(false);
    tbl.setIntercellSpacing(new Dimension(0,0)); 
    
    
    //Add table vào scrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(400, 40, DEFAULT_WIDTH-700, 500));
        scroll.setBackground(null);
        add(scroll);
        
/*****************************************************************************************/        
        //event click vào Table
        tbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int click = tbl.getSelectedRow(); //Chon vao dong trong bang hiển thị lên txt
                txtMaNCC.setText(tbl.getModel().getValueAt(click, 0).toString());
                txtTenNCC.setText(tbl.getModel().getValueAt(click, 1).toString());
                txtDiaChi.setText(tbl.getModel().getValueAt(click, 2).toString());
                txtDienThoai.setText(tbl.getModel().getValueAt(click, 3).toString());
            }
        });
        
/*********************** SORT TABLE *****************************/        
        
        //PHẦN CHỌN SEARCH
        cmbChoice = new JComboBox();
        cmbChoice.setEditable(true);
        cmbChoice.setFont(font0);
        cmbChoice.addItem("Mã NCC");
        cmbChoice.addItem("Tên NCC");
        cmbChoice.addItem("Địa chỉ");
        cmbChoice.addItem("SDT");
        cmbChoice.setBounds(new Rectangle(0, 180, 100, 30));
        cmbChoice.setEditable(false);
        
        // Custem Icon search
        iconSearch = new JLabel(new ImageIcon("./src/image/search_25px.png"));
        iconSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iconSearch.setBounds(290, 170, 50, 50);
        
        
        //Phần TextField
        txtSearch = new JTextField();
        txtSearch.setFont(font0);
//        txtSearch.setBorder(null);
        txtSearch.setBackground(Color.WHITE);
        txtSearch.setOpaque(false);
        txtSearch.setBounds(new Rectangle(110, 180, 220, 30));
        
        
        //Add tất cả vào ItemView
        itemView.add(cmbChoice);
        itemView.add(iconSearch);        
        itemView.add(txtSearch);
        
        
        //bắt sự kiện FOCUS search box
        txtSearch.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e){
                iconSearch.setIcon(new ImageIcon("./src/image/search_25px_focus.png"));
                iconSearch.setBorder(createLineBorder(new Color(52,152,219)));
            }
            public void focusLost(FocusEvent e){
                iconSearch.setIcon(new ImageIcon("./src/image/search_25px.png"));
                iconSearch.setBorder(createLineBorder(Color.BLACK));
            }
        });
        
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtSearch.getText();
                int choice = cmbChoice.getSelectedIndex();
                
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text+"", choice));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtSearch.getText();
                int choice = cmbChoice.getSelectedIndex();
                
                if(text.trim().length()==0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text+"", choice));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
        
    }
    
    



//FUNCTION
    public void cleanView(){
        txtMaNCC.setEditable(false);
        txtTenNCC.setText("");
        txtDiaChi.setText("");
        txtDienThoai.setText("");
    }
    
    
    public void outModel(DefaultTableModel model , ArrayList<NhaCungCapDTO> ncc) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for(NhaCungCapDTO n:ncc)
        {
            data = new Vector();
            data.add(n.getId_NCC());
            data.add(n.getName_NCC());
            data.add(n.getAddress());
            data.add(n.getPhone());            
            model.addRow(data);
        }
        tbl.setModel(model);
    }
    //lấy data từ BUS lên Table
    public void listNCC(){
        if(nccBUS.getNccBUS()==null) nccBUS.list();
        
        outModel(model, (ArrayList<NhaCungCapDTO>) nccBUS.getNccBUS());
    }
    
    
}
