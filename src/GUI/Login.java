package GUI;

//thu vien func
import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
//thu vien event
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
//thu vien frame
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author ACER
 */
public class Login extends JFrame {

    private QLCoffee qlcoffee;
    private TaiKhoanBUS usBUS = new TaiKhoanBUS();
    private NhanVienBUS nvBUS = new NhanVienBUS();

    private JPanel contentPane;
    private JTextField textUser;
    private JPasswordField textPasswd;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 432, 460);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setUndecorated(true);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 432, 99);
        contentPane.add(panel);
        panel.setLayout(null);

        //login
        JLabel labelLogin = new JLabel("Login");
        labelLogin.setBounds(37, 13, 174, 73);
        panel.add(labelLogin);
        labelLogin.setForeground(Color.WHITE);
        labelLogin.setFont(new Font("Tahoma", Font.BOLD, 60));

        //tao nut "X" thoat
        JLabel labelClose = new JLabel("X");
        labelClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        labelClose.setForeground(Color.WHITE);
        labelClose.setFont(new Font("Tahoma", Font.BOLD, 35));
        labelClose.setBounds(380, 0, 38, 65);
        labelClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(labelClose);

        //background
        JLabel labelBackground = new JLabel("");
        labelBackground.setBounds(0, 0, 432, 99);
        panel.add(labelBackground);
        labelBackground.setIcon(new ImageIcon(Login.class.getResource("/image/backLogin.jpg")));

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 99, 432, 364);
        panel_1.setBackground(new Color(240, 255, 240));
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        //user
        JLabel labelUser = new JLabel("");
        labelUser.setIcon(new ImageIcon(Login.class.getResource("/image/icons8-user-40.png")));
        labelUser.setBounds(58, 55, 40, 57);
        panel_1.add(labelUser);

        textUser = new JTextField();
        textUser.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                textUser.setBorder(null);
            }
        });
        textUser.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                textUser.setBorder(new LineBorder(new Color(0, 0, 0)));
            }
        });
        textUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textUser.setBackground(new Color(255, 255, 255));
        textUser.setForeground(Color.BLACK);
        textUser.setBounds(115, 66, 255, 40);
        textUser.setBorder(null);
        panel_1.add(textUser);

        //passwd
        JLabel labelPasswd = new JLabel("");
        labelPasswd.setIcon(new ImageIcon(Login.class.getResource("/image/icons8-privacy-40.png")));
        labelPasswd.setBounds(58, 141, 40, 57);
        panel_1.add(labelPasswd);

        textPasswd = new JPasswordField();
        textPasswd.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                textPasswd.setBorder(null);
            }
        });
        textPasswd.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                textPasswd.setBorder(new LineBorder(new Color(0, 0, 0)));
            }
        });
        textPasswd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    check();
                }
            }
        });
        textPasswd.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textPasswd.setForeground(Color.BLACK);
        textPasswd.setBackground(Color.WHITE);
        textPasswd.setBounds(115, 152, 255, 40);
        textPasswd.setBorder(null);
        panel_1.add(textPasswd);

        //btnlogin
        JButton btnLogin = new JButton("Sign in");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                check();

            }
        });
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnLogin.setBackground(new Color(204, 153, 255));
        btnLogin.setBounds(58, 249, 312, 57);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel_1.add(btnLogin);
    }

    public void check() {
        String username = textUser.getText();
        char[] passwd = textPasswd.getPassword();
        TaiKhoanDTO user = usBUS.findTKByUserNameAndPass(username, String.valueOf(passwd));
        if (user == null) {
            JOptionPane.showMessageDialog(null, "Sai tên tài khoản hoặc mật khẩu");
            return;
        }

        try {

            qlcoffee = new QLCoffee(user.getId_NV(), user.getUser_name(), user.getId_permission());
//                    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        dispose();
    }
}
