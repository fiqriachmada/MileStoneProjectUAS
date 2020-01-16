package GUI;

import controller.AllObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GUI_Pembayaran extends JFrame {

    JLabel labelnamaTim , labelAnggota , labelHarga , labelBayar;
    JTextField txtnamaTim , txtHarga , txtBayar;
    JTextArea txtAnggota;
    JButton btnDaftar;
    JScrollPane sp = new JScrollPane();
    Object a;
    int ask;

    public GUI_Pembayaran(){
        initComponent();
    }

    public void initComponent(){
        JFrame frame = new JFrame("Pembayaran");

        labelnamaTim = new JLabel("Nama Tim Anda");
        labelnamaTim.setBounds(20 , 50 , 120 , 30);
        labelnamaTim.setFont(new Font("Arial" , Font.BOLD,14));
        frame.add(labelnamaTim);
        txtnamaTim = new JTextField();
        txtnamaTim.setBounds(150 , 50 ,200 ,28);
        frame.add(txtnamaTim);

        labelAnggota = new JLabel("Nama Anggota ");
        labelAnggota.setBounds(20 , 90 , 120 , 30);
        labelAnggota.setFont(new Font("Arial" , Font.BOLD,14));
        frame.add(labelAnggota);
        txtAnggota = new JTextArea();
        sp.setViewportView(txtAnggota);
        sp.setBounds(150 , 90 ,200 ,100);
        frame.add(sp);


        labelBayar = new JLabel("Bayar");
        labelBayar.setBounds(20 ,290 , 120 , 30);
        txtBayar = new JTextField();
        txtBayar.setBounds(150 , 290 ,150 ,28);
        frame.add(txtBayar);
        frame.add(labelBayar);

        labelHarga = new JLabel("Rp.");
        labelHarga.setBounds(320 ,290 , 120 , 30);
        txtHarga = new JTextField();
        txtHarga.setEnabled(false);
        String harga = Float.toString(AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getHarga());
        txtHarga.setText(harga);
        txtHarga.setBounds(350 ,290 ,100 , 28);
        frame.add(txtHarga);
        frame.add(labelHarga);

        btnDaftar = new JButton("Daftar");
        btnDaftar.setBounds(20 ,330 , 200 , 30);
        frame.add(btnDaftar);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        btnDaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comfirm((MouseEvent) a);
                if(ask==0){
                    if(Float.parseFloat(txtBayar.getText()) < AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getHarga() ){
                        bayarKurang((MouseEvent) a);
                    }else{
                        String nowDate = formatter.format(date) , namaEvent = AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getNamaEvent();

                        AllObject.pembayaran.tambahPembayaran(AllObject.user.getId_login(),txtnamaTim.getText(),namaEvent,nowDate,txtAnggota.getText(),AllObject.event.getIdPilEvent());
                        success((MouseEvent) a);
                        frame.dispose();
                    }
                }
            }
        });

        frame.setSize(600,500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void comfirm(MouseEvent evt) {
        ask=JOptionPane.showConfirmDialog(null,"Apa Anda Yakin ?");
    }
    public void success(MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Sukses ! " + AllObject.user.getId_login());
    }
    public void bayarKurang(MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Bayar Kurang ! ");
    }
}
