package GUI;

import BUS.CategoryBUS;
import BUS.ct_quyenBUS;
import DTO.CategoryDTO;
import DTO.ct_quyenDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import GUI.model.header;
import GUI.model.navItem;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class QLCoffee extends JFrame implements MouseListener {

    private int userId;
    private String userName;
    private int id_permission;
    private boolean flag = true;
    private JPanel header, nav, main;
    private int DEFAULT_HEIGHT = 730, DEFALUT_WIDTH = 1300;
    private ArrayList<String> navItem = new ArrayList<>();  //Chứa thông tin có button cho menu gồm
    private ArrayList<navItem> navObj = new ArrayList<>();  //Chứa cái button trên thanh menu
    private ArrayList<Integer> permissions = new ArrayList<>();

    public QLCoffee(int userId, String userName, int id_permission) throws FileNotFoundException {
        this.userId = userId;
        this.userName = userName;
        this.id_permission = id_permission;
        view();
    }

    public void view() throws FileNotFoundException {
        Font font = new Font("Time new", Font.BOLD, 14);
        setTitle("Coffee Management");
//        ImageIcon logo = ImageIcon("");
//        setIconImage(logo.getImage);
        setLayout(new BorderLayout());
        setSize(DEFALUT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

//    ****************************Header****************************************
        header = new JPanel(null);
        header.setBackground(new Color(25, 25, 34));
        header.setPreferredSize(new Dimension(DEFALUT_WIDTH, 40));

        header hmain = new header(DEFALUT_WIDTH, 40);

        if (userName != null) {
            JLabel user = new JLabel("Hello " + userName);
            user.setFont(font);
            user.setForeground(Color.WHITE);
            user.setBounds(DEFALUT_WIDTH - 300, -7, 150, 50);
            hmain.add(user);

            navItem btnLogOut = new navItem("", new Rectangle(DEFALUT_WIDTH - 150, -8, 50, 50), "logout_25px.png", "logout_25px.png", "logout_hover_25px.png", new Color(80, 80, 80));
            hmain.add(btnLogOut.isButton());
            btnLogOut.addMouseListener(new MouseAdapter() {
                public void mouseClicked() {
//                    Login lg = new Login();
                    dispose();
                }
            });
        }

        navItem exit = new navItem("", new Rectangle(DEFALUT_WIDTH - 50, -8, 50, 50), "exit_25px.png", "exit_25px.png", "exit_hover_25px.png", new Color(240, 71, 74));
        navItem mini = new navItem("", new Rectangle(DEFALUT_WIDTH - 100, -8, 50, 50), "minimize_25px.png", "minimize_25px.png", "minimize_hover_25px.png", new Color(80, 80, 80));

        hmain.add(exit.isButton());
        hmain.add(mini.isButton());

        exit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        mini.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setState(Frame.ICONIFIED);
            }
        });

        header.add(hmain);

//       *************************************nav********************************
        nav = new JPanel(null);
//        nav.setBackground(new Color(55, 63, 81));
        nav.setBackground(new Color(204, 142, 53));
        nav.setPreferredSize(new Dimension(220, DEFAULT_HEIGHT));

        JScrollPane scroll = new JScrollPane(nav);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(1, 100));
        scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_NEVER);

        ct_quyenBUS permisisondetail = new ct_quyenBUS();
        permisisondetail.getByIdPermission(id_permission);
        List<ct_quyenDTO> detail = permisisondetail.getPermissionList();
        for (ct_quyenDTO temp : detail) {
            CategoryBUS category = new CategoryBUS();
            CategoryDTO cate = category.getByIdDuty(temp.getid_duty());
            permissions.add(temp.getid_duty());
            navItem.add(cate.toString());
        }

        outNav();

        /**
         * ********** PHẦN MAIN ( HIỂN THỊ ) *************************
         */
        main = new JPanel(null);
        main.setBackground(new Color(247, 241, 227));
        changeMainInfo(Collections.min(permissions) -1);  //HIEN THI MAC DINH
        /**
         * ***********************************************************
         */

        add(header, BorderLayout.NORTH);
        add(scroll, BorderLayout.WEST);
        add(main, BorderLayout.CENTER);

        setVisible(true);
    }

    public void outNav() {
        navObj.clear();
        for (int i = 0; i < navItem.size(); i++) {
            String s = navItem.get(i).split(":")[0];
            String icon = navItem.get(i).split(":")[1];
            String iconActive = navItem.get(i).split(":")[2];
            navObj.add(new navItem(s, new Rectangle(0, 200 + 50 * i, 220, 50), icon, iconActive));
            navObj.get(i).addMouseListener(this);
        }
        if (!flag && navObj.size() > 8) //Đổi màu phần DropDown của thống kê
        {
            for (Integer permission : permissions) {
                if (permission == 5) {
                    navObj.get(permission - 1).setColorNormal(new Color(255, 177, 66));
                    navObj.get(permission).setColorNormal(new Color(255, 177, 66));
                }
            }
        }

        //Xuất ra Naigation
        nav.removeAll();
        JLabel profile = new JLabel(new ImageIcon("./src/image/profile_150px.png"));
        profile.setBounds(0, 0, 220, 200);
        nav.add(profile);
        for (navItem n : navObj) {
            nav.add(n);
        }
        repaint();
        revalidate();
    }

    public void changeMainInfo(int i) throws FileNotFoundException //Đổi Phần hiển thị khi bấm btn trên menu
    {
        if (flag && i > 4 && i < 8) // Thay đổi nếu Thông kế đang dropdown
        {
            i = i + 2;
        }
        switch (i) {
            case 0: //  BÁN HÀNG 
                main.removeAll();
                main.add(new BanHangGUI(DEFALUT_WIDTH, userId));
                main.repaint();
                main.revalidate();
                break;
            case 1: // QUẢN LÝ SẢN PHẨM
                main.removeAll();
                main.add(new SanPhamGUI(DEFALUT_WIDTH));
                main.repaint();
                main.revalidate();
                break;

            case 2: // QUẢN LÝ NHÂN VIÊN
                main.removeAll();
                main.add(new NhanVienGUI(DEFALUT_WIDTH));
                main.repaint();
                main.revalidate();
                break;
            case 3: // QUẢN LÝ KHÁCH HÀNG
                main.removeAll();
                main.add(new KhachHangGUI(DEFALUT_WIDTH));
                main.repaint();
                main.revalidate();
                break;
            case 4: //NHẬP VẦ XUẤT
                if (flag) {
                    // Thêm 2 btn vào dưới thống kê
                    navItem.add(i, "Hóa Đơn:KhachHang_20px.png:KhachHang_20px_active.png");
                    navItem.add(i + 1, "Nhập Hàng:KhachHang_20px.png:KhachHang_20px_active.png");
                    flag = false; // Thông báo là đang Dropdown thống kê
                } else {
                    // Xóa 2 btn của thống kê
                    navItem.remove(i);
                    navItem.remove(i);

                    flag = true;  // Thông báo là Dropdown thống kê đă ẩn
                }
                outNav(); //Load lại phần Navigation
                break;
            case 5: // BÁN HÀNG
                main.removeAll();
                main.add(new HoaDonGUI(DEFALUT_WIDTH));
                main.repaint();
                main.revalidate();
                break;
            case 6: // NHẬP HÀNG
                main.removeAll();
//                main.add(new Page404(DEFALUT_WIDTH, "THỐNG KÊ - NHẬP HÀNG"));
                main.add(new NhapHangGUI(DEFALUT_WIDTH));
                main.repaint();
                main.revalidate();
                break;
            case 7: //NHÀ CUNG CẤP
                main.removeAll();
                main.add(new NhaCungCapGUI(DEFALUT_WIDTH));
                main.repaint();
                main.revalidate();
                break;
            case 8: //USER
                main.removeAll();
                main.add(new TaiKhoanGUI(DEFALUT_WIDTH));
                main.repaint();
                main.revalidate();
                break;
            case 9: // THỐNG KÊ
                main.removeAll();
                main.add(new ThongKeGUI(DEFALUT_WIDTH));
                main.repaint();
                main.revalidate();
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        for (int i = 0; i < navObj.size(); i++) {
            navItem item = navObj.get(i); // lấy vị trí item trong menu
            if ( e.getSource() == item) {
                item.doActive(); // Active NavItem đc chọn
                try {
                    int j = i;
                    if (!flag) {
                        j -=2;
                    }
                    int index = permissions.get(j);
                    if (!flag) {
                        index += 2;
                    }
                    changeMainInfo(index - 1); // Hiển thị ra phần main
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(QLCoffee.class.getName()).log(Level.SEVERE, null, ex);
                }
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
