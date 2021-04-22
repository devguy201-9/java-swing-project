/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author Shadow
 */
public class Item extends JPanel{
    private JLabel itemName;
    private JLabel itemImage;
    private int x,y;
    public Item(int x,int y,String itemName, String image)
    {
        this.x = x;
        this.y = y;
        this.itemName = new JLabel(itemName,JLabel.CENTER);
        ImageIcon icon  = new ImageIcon(getClass().getResource("/image/SanPham/CocaCola.jpg"));
        this.itemImage = new JLabel("Image 200x200",JLabel.CENTER);
        init();
    }
    public void init()
    {
        JLabel edit = new JLabel("Edit",JLabel.CENTER);
        edit.setBounds(new Rectangle(0,240,100,20));
        JLabel delete = new JLabel("Delete",JLabel.CENTER);
        delete.setBounds(new Rectangle(100,240,100,20));
        JLabel moveUp = new JLabel("Move Up",JLabel.CENTER);
        moveUp.setBounds(new Rectangle(0,270,100,20));
        JLabel moveDown = new JLabel("Mouve Down",JLabel.CENTER);
        moveDown.setBounds(new Rectangle(100,270,100,20));
        
        
        setLayout(null);
        setBounds(new Rectangle(x, y, 200, 300));
//        setBackground(Color.red);
        JSeparator sep1 = new JSeparator(1);
        sep1.setBounds(new Rectangle(100,240,1,20));

        JSeparator sep2 = new JSeparator(1);
        sep2.setBounds(new Rectangle(100,270,1,20));
        
        itemName.setBounds(new Rectangle(0, 2, 200 , 30));
        
        JPanel pn = new JPanel();
        pn.setBackground(Color.GREEN);
        pn.setBounds(new Rectangle(0, 30, 200 , 200));
        
        itemImage.setBounds(new Rectangle(0, 50, 200 , 100));
        
        
        
        add(itemName);
        add(itemImage);
        add(pn);
        add(edit);
        add(delete);
        add(moveUp);
        add(moveDown);
        add(sep1);
        add(sep2);
    }
}
