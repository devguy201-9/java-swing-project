/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.TaiKhoanBUS;
import DTO.Gender;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Shadow
 */
public class TaiKhoanGUI extends JPanel implements ActionListener{
    private TaiKhoanBUS tkBUS = new TaiKhoanBUS();
    private JTextField txtMaTK,txtMaNV,txtUser,txtPass;
    private JLabel btnConfirm,btnEdit,btnBack,btnAdd;    
    private JLabel lbMaTK,lbMaNV,lbUser,lbPass,lbPhai;
    private DefaultTableModel model;
    private JTable tbl;
    private int DEFAUTL_WIDTH; 
    private JComboBox cmbRole;
    private JButton btnMaNV;
        
    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit
    
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
        itemView.setBackground(new Color(201, 211, 203));
        
        lbMaTK = new JLabel("Mã tài khoản ");
        lbMaTK.setFont(font0);
        lbMaTK.setBounds(20,20,100,30);
        txtMaTK = new JTextField();
        txtMaTK.setBounds(new Rectangle(120,20,250,30));
        txtMaTK.setEditable(false);
        itemView.add(lbMaTK);
        itemView.add(txtMaTK);
        
        lbMaNV = new JLabel("Mã nhân viên ");
        lbMaNV.setFont(font0);
        lbMaNV.setBounds(20,70,100,30);
        txtMaNV = new JTextField();
        txtMaNV.setBounds(new Rectangle(120,70,220,30));        
        itemView.add(lbMaNV);
        itemView.add(txtMaNV);
        btnMaNV = new JButton("...");
        btnMaNV.setBounds(new Rectangle(340,70,30,30));
        btnMaNV.addActionListener(this);
        itemView.add(btnMaNV);
        
        lbUser = new JLabel("Tên đăng nhập");
        lbUser.setFont(font0);
        lbUser.setBounds(20,120,100,30);
        txtUser = new JTextField();
        txtUser.setBounds(new Rectangle(120,120,250,30));
        itemView.add(lbUser);
        itemView.add(txtUser);
        
        lbPass = new JLabel("Mật khẩu");
        lbPass.setFont(font0);
        lbPass.setBounds(20,170,100,30);
        txtPass = new JTextField("");
        txtPass.setBounds(new Rectangle(120,170,250,30));
        itemView.add(lbPass);
        itemView.add(txtPass);
        
        lbPhai = new JLabel("Quyền ");
        lbPhai.setFont(font0);
        lbPhai.setBounds(20,220,100,30);
        String[] role = {"Nhân Viên","Admin"}; 
        cmbRole = new JComboBox(role);
        cmbRole.setBounds(new Rectangle(120,220,250,30));
        itemView.add(lbPhai);
        itemView.add(cmbRole);
        
/**************** TẠO CÁC BTN XÓA, SỬA, VIEW, IN BILL ********************/
        btnAdd = new JLabel(new ImageIcon("./src/image/btnAdd_150px.png"));
        btnAdd.setBounds(new Rectangle(20,300,150,50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnEdit = new JLabel(new ImageIcon("./src/image/btnEdit_150px.png"));
        btnEdit.setBounds(new Rectangle(180,300,150,50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        btnConfirm = new JLabel(new ImageIcon("./src/image/btnConfirm_150px.png"));
        btnConfirm.setBounds(new Rectangle(20,300,150,50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));    
        
        btnBack = new JLabel(new ImageIcon("./src/image/btnBack_150px.png"));
        btnBack.setBounds(new Rectangle(180,300,150,50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        
        btnAdd.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                EditOrAdd = true;
                txtMaTK.setEditable(false);
                cleanView();
                btnAdd.setVisible(false);
                btnEdit.setVisible(false);                               
                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
                
                tbl.setEnabled(false);
            }
        });
        
        btnEdit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                if(txtMaTK.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn tài khoản cần sửa !!!");
                    return;
                }
                
                EditOrAdd = false;
                txtMaTK.setEditable(false);
                
                btnAdd.setVisible(false);
                btnEdit.setVisible(false);               
                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
                
                tbl.setEnabled(false);
            }
        });
              
        
        
        //MouseClick btnConfirm
        btnConfirm.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i;
                if (EditOrAdd) //Thêm Nhân Viên
                {
                    String passwd = txtPass.getText();
                    for (int j = 0; j < tkBUS.getTkBUS().size(); j++) {
                        if (tkBUS.getTkBUS().get(j).getPass().equals(passwd)) {
                            JOptionPane.showMessageDialog(null, "Mật khẩu đã tồn tại, vui lòng nhập giá trị khác !!!", "Thất bại", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm tài khoản", "", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {//yes
                        try {
                            int manv = Integer.parseInt(txtMaNV.getText().trim());
                            String user = txtUser.getText();
                            String pass = txtPass.getText();                            
                            int quyen = cmbRole.getSelectedItem().toString().equals("Nhân Viên") ? 1 : 2;
                            
                            if (user.equals("null") && pass.equals("null")) {
                                JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên hoặc mật khẩu!", "Thất bại", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }                           

                            TaiKhoanDTO nv = new TaiKhoanDTO(manv, quyen, user, pass);
                            tkBUS.add(nv);
//                        TaiKhoanBUS usBUS = new TaiKhoanBUS();
//                        TaiKhoanDTO user = new TaiKhoanDTO(maNV, removeAccent(sdt.concat(maNV)).toLowerCase(), "123456", "Nhân Viên", "1");
//                        usBUS.add(user, 1);
                            outModel(model, (ArrayList<TaiKhoanDTO>) tkBUS.getTkBUS());// Load lại table

                             
                            JOptionPane.showMessageDialog(null, "Thêm thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                            //popup lên view nhập username and password và selectbox chọn quyền
                            cleanView();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Loi");
                        }
                    }
                } else // Edit Tài khoản
                {
                    int manv = Integer.parseInt(txtMaNV.getText().trim());
                    String passwd = txtPass.getText();
                    for (int j = 0; j < tkBUS.getTkBUS().size(); j++) {
                        if (tkBUS.getTkBUS().get(j).getPass().equals(passwd) && tkBUS.getTkBUS().get(j).getId_NV() != manv) {
                            JOptionPane.showMessageDialog(null, "Tên và mật khẩu đã tồn tại, vui lòng nhập số khác !!!", "Thất bại", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa tài khoản","",JOptionPane.YES_NO_OPTION);
                    if(i == 0)
                    {
                        //Lấy dữ liệu từ TextField
                        int maTK = Integer.parseInt(txtMaTK.getText().trim());
                        int maNV = Integer.parseInt(txtMaNV.getText().trim());
                        String user = txtUser.getText();
                        String pass = txtPass.getText();
                        int role = cmbRole.getSelectedItem().toString().equals("Nhân Viên") ? 1:2;
//                        String enable = "1";

                        //Upload tài khoản lên DAO và BUS
                        TaiKhoanDTO us = new TaiKhoanDTO(maNV, role, user, pass);
                        us.setId_TK(maTK);
                        tkBUS.set(us);
                        
                        outModel(model, (ArrayList<TaiKhoanDTO>) tkBUS.getTkBUS());// Load lại table
                        
                        
                        JOptionPane.showMessageDialog(null, "Sửa thành công","Thành công",JOptionPane.INFORMATION_MESSAGE);
                                                
                    }
                    
                }

            }
        });
        
         btnBack.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                cleanView();
                
                btnAdd.setVisible(true);
                btnEdit.setVisible(true);                
                
                btnConfirm.setVisible(false);
                btnBack.setVisible(false);
                
                tbl.setEnabled(true);
            }
        });
        
        itemView.add(btnAdd);
        itemView.add(btnEdit);        
        itemView.add(btnConfirm);
        itemView.add(btnBack);
/*************************************************************************/
/**************** TẠO TABLE ************************************************************/

    /************** TẠO MODEL VÀ HEADER *********************************/
        Vector header = new Vector();
        header.add("Mã TK");
        header.add("Mã NV");
        header.add("Username");
        header.add("Pass");
        header.add("Role");
        model = new MyTable(header,5);
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        list();
        
    /*******************************************************************/
        

    /******** CUSTOM TABLE ****************/
    
        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(30);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(30);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(30);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(30);
        
        DefaultTableCellRenderer centerAlign = new DefaultTableCellRenderer();
        centerAlign.setHorizontalAlignment(JLabel.CENTER);
        tbl.getColumnModel().getColumn(0).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(1).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(2).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(3).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(4).setCellRenderer(centerAlign);

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
                txtMaTK.setText(tbl.getModel().getValueAt(i, 0).toString());
                txtMaNV.setText(tbl.getModel().getValueAt(i, 1).toString());
                txtUser.setText(tbl.getModel().getValueAt(i, 2).toString());
                txtPass.setText(tbl.getModel().getValueAt(i, 3).toString()); 
                cmbRole.setSelectedItem(tbl.getModel().getValueAt(i, 4).toString());
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
            data.add(us.getId_TK());
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
        txtMaTK.setEditable(false);

        txtMaTK.setText("");
        txtMaNV.setText("");
        txtUser.setText("");
        txtPass.setText("");
 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMaNV) // Suggest Nhan Vien
        {
            SuggestNhanVien rm = new SuggestNhanVien();
            String s = rm.getTextFieldContent();
            txtMaNV.setText(s);
        }
        
    }
}
