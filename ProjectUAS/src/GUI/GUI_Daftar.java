package GUI;

import controller.AllObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI_Daftar extends JFrame {
    Object a;
    public GUI_Daftar(){
        initComponent();
    }

    public void initComponent(){
        JFrame frame = new JFrame("Daftar");


        JLabel labelLogin = new JLabel("Daftar");
        labelLogin.setBounds(330,30,500,60);
        labelLogin.setFont(new Font("Consolas" ,Font.BOLD,45));
        labelLogin.setForeground(new Color(20,1,188));
        frame.add(labelLogin);

        JLabel labelUname = new JLabel("Username");
        labelUname.setBounds(250,150,200,60);
        labelUname.setFont(new Font("Consolas" , Font.BOLD,20));

        JTextField txtUname = new JTextField();
        txtUname.setBounds(250 , 190 , 300 , 30);
        txtUname.setFont(new Font("Consolas" , Font.BOLD,15));
        frame.add(labelUname);
        frame.add(txtUname);

        JLabel labelPass = new JLabel("Password");
        labelPass.setBounds(250,220,200,60);
        labelPass.setFont(new Font("Consolas" , Font.BOLD,20));

        JTextField txtPass = new JTextField();
        txtPass.setBounds(250 , 260 , 300 , 30);
        frame.add(labelPass);
        frame.add(txtPass);

        JButton btnDaftar = new JButton("Daftar");
        btnDaftar.setBounds(250 , 290 , 100 , 30);
        frame.add(btnDaftar);

        btnDaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    AllObject.user.tambahUser(txtUname.getText() , txtPass.getText());
                    sukses((MouseEvent) a);
                    frame.dispose();
                    new GUI_Login();
                }catch (Exception ex){
                    gagal((MouseEvent) a);
                }
            }
        });

        frame.setSize(800,500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void sukses(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Daftar Sukses !! ");
    }
    public void gagal(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Daftar Gagal !! ");
    }
}
