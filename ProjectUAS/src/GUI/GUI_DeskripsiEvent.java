package GUI;

import controller.AllObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI_DeskripsiEvent extends JFrame {


    JLabel labelPenyelenggara , labelNamaEvent , labelSlot , labelDeskripsi , labelTempat , labelSyarat , labelRegion , labelHarga , labelGenre , labelGame;
    JButton btnJoinEvent;
    JTextField txtPenyelenggara , txtNamaEvent , txtSlot  , txtTempat  , txtRegion , txtHarga , txtGame ,txtGenre , txtStatus;
    JTextArea txtDeskripsi ,txtSyarat;
    JScrollPane sp_deskripsi = new JScrollPane();
    JScrollPane sp_syarat = new JScrollPane();

    Object a;

    public GUI_DeskripsiEvent(){
        initComponent();
    }

    public void initComponent(){
        JFrame frame = new JFrame("Deskripsi");

        labelPenyelenggara = new JLabel("Penyelenggara");
        labelPenyelenggara.setBounds(30,30,150,60);
        labelPenyelenggara.setFont(new Font("Arial" , Font.BOLD,15));
        frame.add(labelPenyelenggara);
        txtPenyelenggara = new JTextField();
        txtPenyelenggara.setBounds(180,45,250,30);
        frame.add(txtPenyelenggara);

        labelNamaEvent = new JLabel("Nama Event");
        labelNamaEvent.setBounds(30,65,150,60);
        labelNamaEvent.setFont(new Font("Arial" , Font.BOLD,15));
        frame.add(labelNamaEvent);
        txtNamaEvent = new JTextField();
        txtNamaEvent.setBounds(180,80,250,30);
        frame.add(txtNamaEvent);

        labelSlot = new JLabel("Slot");
        labelSlot.setBounds(30,100,150,60);
        labelSlot.setFont(new Font("Arial" , Font.BOLD,15));
        frame.add(labelSlot);
        txtSlot = new JTextField();
        txtSlot.setBounds(180,115,100,30);
        frame.add(txtSlot);

        labelDeskripsi = new JLabel("Deskripsi");
        labelDeskripsi.setBounds(30,135,150,60);
        labelDeskripsi.setFont(new Font("Arial" , Font.BOLD,15));
        frame.add(labelDeskripsi);
        txtDeskripsi = new JTextArea();
        sp_deskripsi.setViewportView(txtDeskripsi);
        sp_deskripsi.setBounds(180,150,250,90);
        frame.add(sp_deskripsi);

        labelGame = new JLabel("Game");
        labelGame.setBounds(30,240,150,60);
        labelGame.setFont(new Font("Arial" , Font.BOLD,15));
        frame.add(labelGame);
        txtGame = new JTextField();
        txtGame.setBounds(180 , 255 , 150 , 30);
        frame.add(txtGame);

        labelTempat = new JLabel("Tempat");
        labelTempat.setBounds(30,285,150,60);
        labelTempat.setFont(new Font("Arial" , Font.BOLD,15));
        frame.add(labelTempat);
        txtTempat = new JTextField();
        txtTempat.setBounds(180,300,250,30);
        frame.add(txtTempat);

        labelSyarat = new JLabel("Syarat Dan Ketentuan");
        labelSyarat.setBounds(30,325,170,60);
        labelSyarat.setFont(new Font("Arial" , Font.BOLD,15));
        frame.add(labelSyarat);
        txtSyarat = new JTextArea();
        sp_syarat.setViewportView(txtSyarat);
        sp_syarat.setBounds(190,340,240,100);
        frame.add(sp_syarat);

        labelRegion = new JLabel("Region");
        labelRegion.setBounds(30,430,150,60);
        labelRegion.setFont(new Font("Arial" , Font.BOLD,15));
        frame.add(labelRegion);
        txtRegion = new JTextField();
        txtRegion.setBounds(180,445,250,30);
        frame.add(txtRegion);

        labelHarga = new JLabel("Harga");
        labelHarga.setBounds(30,470,150,60);
        labelHarga.setFont(new Font("Arial" , Font.BOLD,15));
        frame.add(labelHarga);
        txtHarga = new JTextField();
        txtHarga.setBounds(180,485,250,30);
        frame.add(txtHarga);

        labelGenre = new JLabel("Genre/Status");
        labelGenre.setBounds(30 , 515 , 150 , 60);
        labelGenre.setFont(new Font("Arial" , Font.BOLD,15));
        frame.add(labelGenre);

        txtGenre = new JTextField();
        txtGenre.setBounds(180 , 530 , 150 , 30);
        frame.add(txtGenre);

        txtStatus = new JTextField();
        txtStatus.setBounds(335 , 530 , 100 , 30);
        frame.add(txtStatus);

        btnJoinEvent = new JButton("Join Event");
        btnJoinEvent.setBounds(180 , 580 , 100 ,30);
        frame.add(btnJoinEvent);

        btnJoinEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI_Pembayaran();
                frame.dispose();
            }
        });

        txtPenyelenggara.setEnabled(false);
        txtPenyelenggara.setText(AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getPenyelenggara());

        txtNamaEvent.setEnabled(false);
        txtNamaEvent.setText(AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getNamaEvent());

        String slot = Integer.toString(AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getSlot());
        txtSlot.setEnabled(false);
        txtSlot.setText(slot);

        txtTempat.setEnabled(false);
        txtTempat.setText(AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getTempat());

        txtRegion.setEnabled(false);
        txtRegion.setText(AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getRegion());

        txtHarga.setEnabled(false);
        txtHarga.setText(AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getPenyelenggara());

        txtGame.setEnabled(false);
        txtGame.setText(AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getNamaGame());

        txtDeskripsi.setEnabled(false);
        txtDeskripsi.setText(AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getDeskripsi());

        txtSyarat.setEnabled(false);
        txtSyarat.setText(AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getSyaratDanKetentuan());

        txtStatus.setEnabled(false);
        txtStatus.setText(AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getOfflineOnline());

        txtGenre.setEnabled(false);
        txtGenre.setText(AllObject.event.getEvent()[AllObject.event.getIdPilEvent()].getGenreEvent());


        frame.setSize(600,700);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void sukses(MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Sukses Create !! " + AllObject.event.getId_event());
    }
    public void gagal(MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Gagal Create !! ");
    }
}
