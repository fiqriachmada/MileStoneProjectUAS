package GUI;

import controller.AllObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GUI_EventBuy extends JFrame {

    JLabel labelnamaTim , labelAnggota1 , labelTgl ,labelEvent;
    JTextField txtnamaTim , txtTgl , txtEvent;
    JTextArea strukAnggota;

    public GUI_EventBuy(){
        initComponent();
    }

    public void initComponent(){
        JFrame frame = new JFrame("Struk Event");

        labelnamaTim = new JLabel("Nama Tim Anda");
        labelnamaTim.setBounds(20 , 50 , 120 , 30);
        labelnamaTim.setFont(new Font("Arial" , Font.BOLD,14));
        frame.add(labelnamaTim);
        txtnamaTim = new JTextField();
        txtnamaTim.setBounds(150 , 50 ,200 ,28);
        frame.add(txtnamaTim);

        labelAnggota1 = new JLabel("Nama Anggota ");
        labelAnggota1.setBounds(20 , 90 , 120 , 30);
        labelAnggota1.setFont(new Font("Arial" , Font.BOLD,14));
        frame.add(labelAnggota1);

        labelEvent = new JLabel("Nama Event");
        labelEvent.setBounds(20 , 190 , 120 , 30);
        labelEvent.setFont(new Font("Arial" , Font.BOLD,14));
        frame.add(labelEvent);
        txtEvent = new JTextField();
        txtEvent.setBounds(150 , 190 ,200 ,28);
        frame.add(txtEvent);

        labelTgl = new JLabel("Tanggal Pembayaran");
        labelTgl.setBounds(20 , 230 , 120 , 30);
        labelTgl.setFont(new Font("Arial" , Font.BOLD,14));
        frame.add(labelTgl);
        txtTgl = new JTextField();
        txtTgl.setBounds(150 , 230 ,200 ,28);
        frame.add(txtTgl);

        int userLog = AllObject.pembayaran.getIndexUser(AllObject.user.getId_login());
        txtnamaTim.setText(AllObject.pembayaran.getPembayaran()[userLog].getNamaTim());
        strukAnggota = new JTextArea();
        strukAnggota.setBounds(150 , 90 ,200 ,100);
        strukAnggota.setText(AllObject.pembayaran.getPembayaran()[userLog].getNamaAngota());
        frame.add(strukAnggota);
        txtTgl.setText(AllObject.pembayaran.getPembayaran()[userLog].getTglPembayaran());
        txtEvent.setText(AllObject.pembayaran.getPembayaran()[userLog].getNamaEvent());

        txtnamaTim.setEnabled(false);
        strukAnggota.setEnabled(false);
        txtTgl.setEnabled(false);
        txtEvent.setEnabled(false);

        frame.setSize(600,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
