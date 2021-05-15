/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.PermissionBUS;
import BUS.TaiKhoanBUS;
import DTO.PermissionDTO;
import DTO.TaiKhoanDTO;
import com.kingaspx.toast.util.Toast;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
public class TaiKhoanGUI extends JPanel implements ActionListener {

    private TaiKhoanBUS tkBUS = new TaiKhoanBUS();
    private PermissionBUS roleBUS = new PermissionBUS();
    private JTextField txtMaTK, txtMaNV, txtUser;
    private JPasswordField txtPass;
    private JButton btnConfirm, btnEdit, btnBack, btnAdd;
    private JLabel lbMaTK, lbMaNV, lbUser, lbPass, lbPhai;
    private DefaultTableModel model;
    private JTable tbl;
    private int DEFAUTL_WIDTH;
    private JComboBox cmbRole;
    private JButton btnMaNV;

    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit

    private boolean tableSelectionActive = true;

    public TaiKhoanGUI(int width) {
        this.DEFAUTL_WIDTH = width;
        init();
    }

    public void init() {
        setSize(DEFAUTL_WIDTH, 700);
        setLayout(null);

        Font font0 = new Font("Segoe UI", Font.PLAIN, 14);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);

        //HEADER
        /**
         * *************** PHẦN HIỂN THỊ THÔNG TIN **************************
         */
        RoleModelCB roleModel = listRoles();
        JPanel itemView = new JPanel(null);
        itemView.setBounds(new Rectangle(0, 0, this.DEFAUTL_WIDTH, 700));
        itemView.setBackground(new Color(247, 241, 227));

        lbMaTK = new JLabel("Mã tài khoản ");
        lbMaTK.setFont(font0);
        lbMaTK.setBounds(20, 20, 100, 30);
        txtMaTK = new JTextField();
        txtMaTK.setBounds(new Rectangle(120, 20, 250, 30));
        txtMaTK.setEditable(false);
        itemView.add(lbMaTK);
        itemView.add(txtMaTK);

        lbMaNV = new JLabel("Mã nhân viên ");
        lbMaNV.setFont(font0);
        lbMaNV.setBounds(20, 70, 100, 30);
        txtMaNV = new JTextField();
        txtMaNV.setBounds(new Rectangle(120, 70, 220, 30));
        txtMaNV.setEditable(false);
        itemView.add(lbMaNV);
        itemView.add(txtMaNV);
        btnMaNV = new JButton("...");
        btnMaNV.setBackground(new Color(131, 149, 167));
        btnMaNV.setBounds(new Rectangle(340, 70, 30, 30));
        btnMaNV.addActionListener(this);
        itemView.add(btnMaNV);

        lbUser = new JLabel("Tên đăng nhập");
        lbUser.setFont(font0);
        lbUser.setBounds(20, 120, 100, 30);
        txtUser = new JTextField();
        txtUser.setBounds(new Rectangle(120, 120, 250, 30));
        itemView.add(lbUser);
        itemView.add(txtUser);

        lbPass = new JLabel("Mật khẩu");
        lbPass.setFont(font0);
        lbPass.setBounds(20, 170, 100, 30);
        txtPass = new JPasswordField("");
        txtPass.setBounds(new Rectangle(120, 170, 250, 30));
        itemView.add(lbPass);
        itemView.add(txtPass);

        lbPhai = new JLabel("Quyền ");
        lbPhai.setFont(font0);
        lbPhai.setBounds(20, 220, 100, 30);
        cmbRole = new JComboBox<>(roleModel);
        cmbRole.setBounds(new Rectangle(120, 220, 250, 30));
        itemView.add(lbPhai);
        itemView.add(cmbRole);

        /**
         * ************** TẠO CÁC BTN XÓA, SỬA, VIEW, IN BILL
         * *******************
         */
        Font font2 = new Font("Tahoma", Font.PLAIN, 18);
        //        btnEdit,btnDelete,btnConfirm,btnBack,btnFile
        btnAdd = new JButton("THÊM");
        btnEdit = new JButton("SỬA");
        btnConfirm = new JButton("XÁC NHẬN");
        btnBack = new JButton("QUAY LẠI");

        //font chữ
        btnAdd.setFont(font2);
        btnAdd.setForeground(Color.WHITE);
        btnEdit.setFont(font2);
        btnEdit.setForeground(Color.WHITE);
        btnConfirm.setFont(font2);
        btnConfirm.setForeground(Color.WHITE);
        btnBack.setFont(font2);
        btnBack.setForeground(Color.WHITE);

        //màu nền
        Color colorAdd = new Color(255, 218, 121);
        btnAdd.setBackground(colorAdd);
        Color colorEdit = new Color(255, 218, 121);
        btnEdit.setBackground(colorEdit);
        Color colorConfirm = new Color(255, 218, 121);
        btnConfirm.setBackground(colorConfirm);
        Color colorBack = new Color(255, 218, 121);
        btnBack.setBackground(colorBack);

        //viền
        btnAdd.setBorder(createLineBorder(new Color(134, 64, 0), 3, true));
        btnEdit.setBorder(createLineBorder(new Color(134, 64, 0), 3, true));
        btnConfirm.setBorder(createLineBorder(new Color(134, 64, 0), 3, true));
        btnBack.setBorder(createLineBorder(new Color(134, 64, 0), 3, true));

//        btnAdd = new JLabel(new ImageIcon("./src/image/btnAdd_150px.png"));
        btnAdd.setBounds(new Rectangle(20, 300, 150, 30));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));

//        btnEdit = new JLabel(new ImageIcon("./src/image/btnEdit_150px.png"));
        btnEdit.setBounds(new Rectangle(180, 300, 150, 30));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));

//        btnConfirm = new JLabel(new ImageIcon("./src/image/btnConfirm_150px.png"));
        btnConfirm.setBounds(new Rectangle(20, 300, 150, 30));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));

//        btnBack = new JLabel(new ImageIcon("./src/image/btnBack_150px.png"));
        btnBack.setBounds(new Rectangle(180, 300, 150, 30));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnAdd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                EditOrAdd = true;
                txtMaTK.setEditable(false);
                cleanView();
                setEdit(true);
                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
                tableSelectionActive = false;
                tbl.setEnabled(false);
            }
        });

        btnEdit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (txtMaTK.getText().equals("")) {
                    new Toast.ToastWarning("Vui lòng chọn sản phẩm cần sửa !!!", Toast.SHORT_DELAY);
                    return;
                }
                setEdit(true);
                EditOrAdd = false;
                txtMaTK.setEditable(false);
                tableSelectionActive = false;
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
                    String userName = txtUser.getText();
                    for (int j = 0; j < tkBUS.getTkBUS().size(); j++) {
                        if (tkBUS.getTkBUS().get(j).getUser_name().equals(userName)) {
                            new Toast.ToastError("Tên đăng nhập đã tồn tại, vui lòng nhập tên khác !!!", Toast.SHORT_DELAY);
                            return;
                        }
                    }

                    if (userName.equals("null") && String.valueOf(txtPass.getPassword()).equals("null")) {
                        new Toast.ToastError("Bạn chưa nhập tên hoặc mật khẩu !!!", Toast.SHORT_DELAY);
                        return;
                    }

                    i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm tài khoản", "", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {//yes
                        try {
                            int manv = Integer.parseInt(txtMaNV.getText().trim());
                            String user = txtUser.getText();
                            String pass = String.valueOf(txtPass.getPassword());
                            PermissionDTO role = (PermissionDTO) cmbRole.getSelectedItem();
                            
                            if(!user.equals("") && !pass.equals("")){
                                //Upload  lên DAO và BUS
                                TaiKhoanDTO nv = new TaiKhoanDTO(manv, role.getId_Permission(), user, pass);
                                tkBUS.add(nv);
                                outModel(model, (ArrayList<TaiKhoanDTO>) tkBUS.getTkBUS());// Load lại table
                                new Toast.ToastSuccessful("Thành công", "Thêm tài khoản thành công !!!", Toast.SHORT_DELAY);
                            }
                            else{
                                new Toast.ToastError("Vui lòng nhập đầy đủ thông tin !!!", Toast.SHORT_DELAY);
                            }    
                                
                            cleanView();
                        } catch (NumberFormatException ex) {
                            new Toast.ToastError("Lỗi", Toast.SHORT_DELAY);
                        }
                    }
                } else // Edit Tài khoản
                {
                    int manv = Integer.parseInt(txtMaNV.getText().trim());

                    i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa tài khoản", "", JOptionPane.YES_NO_OPTION);
                        if (i == 0) {
                            //Lấy dữ liệu từ TextField
                            int maTK = Integer.parseInt(txtMaTK.getText().trim());
                            int maNV = Integer.parseInt(txtMaNV.getText().trim());
                            String user = txtUser.getText();
                            String pass = String.valueOf(txtPass.getPassword());
                            PermissionDTO role = (PermissionDTO) cmbRole.getSelectedItem();

                        if(!user.equals("") && !pass.equals("")){
                            //Upload  lên DAO và BUS
                            TaiKhoanDTO us = new TaiKhoanDTO(maNV, role.getId_Permission(), user, pass);
                            us.setId_TK(maTK);
                            tkBUS.set(us);

                            outModel(model, (ArrayList<TaiKhoanDTO>) tkBUS.getTkBUS());// Load lại table

                            new Toast.ToastSuccessful("Thành công", "Sửa thông tin tài khoản thành công !!!", Toast.SHORT_DELAY);
                        }
                        else{
                            new Toast.ToastError("Vui lòng nhập đầy đủ thông tin !!!", Toast.SHORT_DELAY);
                        } 
                    }

                }

            }
        });

        btnBack.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cleanView();

                btnAdd.setVisible(true);
                btnEdit.setVisible(true);
                setEdit(false);
                btnConfirm.setVisible(false);
                btnBack.setVisible(false);
                tableSelectionActive = true;
                tbl.setEnabled(true);
            }
        });

        //hiển thị
        itemView.add(btnAdd);
        itemView.add(btnEdit);
        itemView.add(btnConfirm);
        itemView.add(btnBack);
        /**
         * ************** TẠO TABLE
         * ***********************************************************
         */

        /**
         * ************ TẠO MODEL VÀ HEADER ********************************
         */
        Vector header = new Vector();
        header.add("Mã TK");
        header.add("Mã NV");
        header.add("Username");
        header.add("Pass");
        header.add("Role");
        model = new MyTable(header, 5);
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        list();
        /**
         * ****** CUSTOM TABLE ***************
         */
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
        tbl.setIntercellSpacing(new Dimension(0, 0));
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(134, 64, 0));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52, 152, 219));

        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(400, 20, DEFAUTL_WIDTH - 650, 500));
        scroll.setBackground(null);

        itemView.add(scroll);

        add(itemView);
        tableSelectionActive = true;
        /**
         * **************************************************************************************
         */
        tbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (tableSelectionActive) {
                    int i = tbl.getSelectedRow();
                    if (i == -1) {
                        return;
                    }
                    if (tbl.getRowSorter() != null) {
                        i = tbl.getRowSorter().convertRowIndexToModel(i);
                    }
                    txtMaTK.setText(tbl.getModel().getValueAt(i, 0).toString());
                    txtMaNV.setText(tbl.getModel().getValueAt(i, 1).toString());
                    txtUser.setText(tbl.getModel().getValueAt(i, 2).toString());
                    txtPass.setText(tbl.getModel().getValueAt(i, 3).toString());
                    cmbRole.setSelectedItem(roleBUS.searchID((int) tbl.getModel().getValueAt(i, 4)));
                }
            }
        });
        setEdit(false);
    }

    public void outModel(DefaultTableModel model, ArrayList<TaiKhoanDTO> user) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for (TaiKhoanDTO us : user) {
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
        if (tkBUS.getTkBUS() == null) {
            tkBUS.list();
        }
        ArrayList<TaiKhoanDTO> nv = (ArrayList<TaiKhoanDTO>) tkBUS.getTkBUS();
//        model.setRowCount(0);
        outModel(model, nv);
    }

    public RoleModelCB listRoles() {
        if (roleBUS.getPermissionList() == null) {
            roleBUS.list();
        }
        PermissionDTO[] roles = new PermissionDTO[roleBUS.getPermissionList().size() + 1];
        PermissionDTO all = new PermissionDTO();
        all.setId_Permission(0);
        all.setName("Chọn quyền");
        int i = 0;
        roles[i] = all;
        for (PermissionDTO roleDTO : roleBUS.getPermissionList()) {
            i++;
            roles[i] = roleDTO;
        }
        RoleModelCB model = new RoleModelCB(roles);
        return model;
    }

    public void cleanView() //Xóa trắng các TextField
    {
        txtMaTK.setEditable(false);

        txtMaTK.setText("");
        txtMaNV.setText("");
        txtUser.setText("");
        txtPass.setText("");
        cmbRole.setSelectedIndex(0);

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

    private void setEdit(boolean flag) {
        txtPass.setEditable(flag);
        txtUser.setEditable(flag);
    }
}
