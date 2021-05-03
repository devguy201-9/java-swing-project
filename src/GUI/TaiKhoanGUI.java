/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Shadow
 */
public class TaiKhoanGUI extends JPanel{
    private TaiKhoanBUS tkBUS = new TaiKhoanBUS();
    private JTextField txtMaNV,txtUser,txtPass;
    private JLabel btnConfirm,btnEdit,btnDelete,btnBack;
    private JLabel lbMaNV,lbUser,lbPass,lbPhai;
    private DefaultTableModel model;
    private JTable tbl;
    private int DEFAUTL_WIDTH; 
    private JComboBox cmbRole;
        
    
    public TaiKhoanGUI(int width)
    {
        this.DEFAUTL_WIDTH = width;
        init();
    }
    public void init()
    {
        setSize(DEFAUTL_WIDTH,700);
        setLayout(null);
        
        Font font0 = new Font("Segoe UI",Font.PLAIN,14);
        Font font1 = new Font("Segoe UI",Font.BOLD,13);
        
        //HEADER
/***************** PHẦN HIỂN THỊ THÔNG TIN ***************************/
        JPanel itemView = new JPanel(null);
        itemView.setBounds(new Rectangle(0, 0,this.DEFAUTL_WIDTH, 700));
        itemView.setBackground(Color.WHITE);
        
        lbMaNV = new JLabel("Mã nhân viên ");
        lbMaNV.setFont(font0);
        lbMaNV.setBounds(20,20,100,30);
        txtMaNV = new JTextField();
        txtMaNV.setBounds(new Rectangle(120,20,250,30));
        itemView.add(lbMaNV);
        itemView.add(txtMaNV);
        
        lbUser = new JLabel("Tên đăng nhập");
        lbUser.setFont(font0);
        lbUser.setBounds(20,70,100,30);
        txtUser = new JTextField();
        txtUser.setBounds(new Rectangle(120,70,250,30));
        itemView.add(lbUser);
        itemView.add(txtUser);
        
        lbPass = new JLabel("Password");
        lbPass.setFont(font0);
        lbPass.setBounds(20,120,100,30);
        txtPass = new JTextField("");
        txtPass.setBounds(new Rectangle(120,120,250,30));
        itemView.add(lbPass);
        itemView.add(txtPass);
        
        lbPhai = new JLabel("Quyền ");
        lbPhai.setFont(font0);
        lbPhai.setBounds(20,170,100,30);
        String[] role = {"Nhân Viên","Admin"}; 
        cmbRole = new JComboBox(role);
        cmbRole.setBounds(new Rectangle(120,170,250,30));
        itemView.add(lbPhai);
        itemView.add(cmbRole);
        
/**************** TẠO CÁC BTN XÓA, SỬA, VIEW, IN BILL ********************/
        btnEdit = new JLabel(new ImageIcon("./src/image/btnEdit_150px.png"));
        btnEdit.setBounds(new Rectangle(20,260,150,50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnDelete = new JLabel(new ImageIcon("./src/image/btnDelete_150px.png"));
        btnDelete.setBounds(new Rectangle(180,260,150,50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));    
        
        btnConfirm = new JLabel(new ImageIcon("./src/image/btnConfirm_150px.png"));
        btnConfirm.setBounds(new Rectangle(20,260,150,50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));    
        
        btnBack = new JLabel(new ImageIcon("./src/image/btnBack_150px.png"));
        btnBack.setBounds(new Rectangle(180,260,150,50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        
        btnEdit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                if(txtMaNV.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa !!!");
                    return;
                }
                
                txtMaNV.setEditable(false);
                
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);                
                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
                
                tbl.setEnabled(false);
            }
        });
              
        btnDelete.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                int del = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Thông báo", JOptionPane.YES_NO_OPTION);
                if(del == 0){
                    tkBUS.delete(txtMaNV.getText());
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, (ArrayList<TaiKhoanDTO>) tkBUS.getTkBUS());
                }
            }
        });
        
        btnConfirm.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa sản phẩm","",JOptionPane.YES_NO_OPTION);
                    if(i == 0)
                    {
                        //Lấy dữ liệu từ TextField
                        int maNV = Integer.parseInt(txtMaNV.getText());
                        String user = txtUser.getText();
                        String pass = txtPass.getText();
//                        String role = String.valueOf(cmbRole.getSelectedItem());
                        int role = Integer.parseInt(String.valueOf(cmbRole.getSelectedItem()));
//                        String enable = "1";

                        //Upload sản phẩm lên DAO và BUS
                        TaiKhoanDTO us = new TaiKhoanDTO(maNV, role, user, pass);
                        tkBUS.set(us);
                        
                        outModel(model, (ArrayList<TaiKhoanDTO>) tkBUS.getTkBUS());// Load lại table
                        
//                        saveIMG();// Lưu hình ảnh 
                        
                        JOptionPane.showMessageDialog(null, "Sửa thành công","Thành công",JOptionPane.INFORMATION_MESSAGE);
                        
                    }
            }
        });
        
         btnBack.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                cleanView();
                
                btnEdit.setVisible(true);
                btnDelete.setVisible(true);
                
                btnConfirm.setVisible(false);
                btnBack.setVisible(false);
//                btnFile.setVisible(false);
                
                tbl.setEnabled(true);
            }
        });
        
        itemView.add(btnEdit);
        itemView.add(btnDelete);
        itemView.add(btnConfirm);
        itemView.add(btnBack);
/*************************************************************************/
/**************** TẠO TABLE ************************************************************/

    /************** TẠO MODEL VÀ HEADER *********************************/
        Vector header = new Vector();
        header.add("Mă NV");
        header.add("Username");
        header.add("Pass");
        header.add("Role");
        model = new DefaultTableModel(header,5);
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        list();
        
    /*******************************************************************/
        

    /******** CUSTOM TABLE ****************/
    
        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(50);

        // Custom table
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0,0));     
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);              
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(134, 64, 0));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52,152,219));          
        
        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(400, 20, DEFAUTL_WIDTH - 650 , 500));
        scroll.setBackground(null);
        
        itemView.add(scroll);
        
        add(itemView);
    /**************************************/
/*****************************************************************************************/
        tbl.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbl.getSelectedRow();
                if(tbl.getRowSorter() != null)
                {
                    i = tbl.getRowSorter().convertRowIndexToModel(i);
                }
                txtMaNV.setText(tbl.getModel().getValueAt(i, 0).toString());
                txtUser.setText(tbl.getModel().getValueAt(i, 1).toString());
                txtPass.setText(tbl.getModel().getValueAt(i, 2).toString()); 
                cmbRole.setSelectedItem(tbl.getModel().getValueAt(i, 3).toString());
             }
        });
/*********************************************************************/
    }
    public void outModel(DefaultTableModel model , ArrayList<TaiKhoanDTO> user) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for(TaiKhoanDTO us : user)
        {
            data = new Vector();
            data.add(us.getId_NV());
            data.add(us.getUser_name());
            data.add(us.getPass());
            data.add(us.getId_permission());
            model.addRow(data);
        }
        tbl.setModel(model);
    }
    public void list() // Chép ArrayList lên table
    {
        if(tkBUS.getTkBUS()== null)tkBUS.list();
        ArrayList<TaiKhoanDTO> nv = (ArrayList<TaiKhoanDTO>) tkBUS.getTkBUS();
//        model.setRowCount(0);
        outModel(model,nv);
    }
    
    public void cleanView() //Xóa trắng các TextField
    {
        txtMaNV.setEditable(true);

        txtMaNV.setText("");
        txtUser.setText("");
        txtPass.setText("");
 
    }
}
