/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Shadow
 */
public class header extends JPanel{
    private int height,width;
    private JFrame frame;
    public header(int w,int h)
    {
        width = w;
        height = h;
        init();
    }
    public void init()
    {
        setLayout(null);
        setSize(width,height);
        setBackground(null);
        
        JLabel logo = new JLabel(new ImageIcon("./src/image/SieuThi_25px.png"),JLabel.CENTER);
        logo.setBounds(new Rectangle(30,10, 25, 25));
        Font font = new Font("Segoe UI",Font.BOLD,15);
        JLabel name = new JLabel("QUẢN LÝ SIÊU THỊ",JLabel.CENTER);
        name.setFont(font);
        name.setForeground(Color.white);
        name.setBounds(new Rectangle(60, 0, 150, 40));
        
        add(logo);
        add(name);
        
//        JLabel exit = new JLabel(new ImageIcon("./src/image/exit_25px.png")));
        
//        navItem exit = new navItem("", new Rectangle(width-40, -8, 40, 50), "exit_25px.png", "exit_25px.png", new Color(80,80,80));
//        navItem minimize = new navItem("", new Rectangle(width-80, -8, 40, 50), "minimize_25px.png", "minimize_25px.png", new Color(80,80,80));
//        
//        exit.addMouseListener(new MouseAdapter() {
//           public void mouseClicked(MouseEvent e)
//           {
//              System.exit(0);
//           }
//        });
//        
//        minimize.addMouseListener(new MouseAdapter() {
//           public void mouseClicked(MouseEvent e)
//           {
//              frame.setState(Frame.ICONIFIED);
//           }
//        });
        
    }
}
