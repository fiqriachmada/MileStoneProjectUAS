package GUI;

import controller.AllObject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI_createEvent extends JFrame {


    JLabel labelPenyelenggara , labelNamaEvent , labelSlot , labelDeskripsi , labelTempat , labelSyarat , labelRegion , labelHarga , labelGenre , labelGame;
    JButton btnCreate , btnBack;
    JTextField txtPenyelenggara , txtNamaEvent , txtSlot  , txtTempat  , txtRegion , txtHarga , txtGame;
    JTextArea txtDeskripsi ,txtSyarat;
    JScrollPane sp_deskripsi = new JScrollPane();
    JScrollPane sp_syarat = new JScrollPane();

    Object a;

    public GUI_createEvent(){
        initComponent();
    }

    public void initComponent(){
        JFrame frame = new JFrame("Create Event");

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

        String [] tampung_genre = new String[AllObject.genre.getId_genre()];
        for(int i = 0 ; i <AllObject.genre.getId_genre() ; i++){
            tampung_genre[i] = AllObject.genre.getGenre()[i].getTipeGenre();
        }
        JComboBox combo_genre = new JComboBox(tampung_genre);
        combo_genre.setBounds(180 , 530 , 150 , 30);
        frame.add(combo_genre);

        String [] arrayStatus = {"Offline" , "Online"};
        JComboBox combo_status = new JComboBox(arrayStatus);
        combo_status.setBounds(335 , 530 , 100 , 30);
        frame.add(combo_status);

        btnCreate = new JButton("Create");
        btnCreate.setBounds(30 , 580 , 120 , 30);
        frame.add(btnCreate);

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String status = (String) combo_status.getSelectedItem();
                    String genre = (String) combo_genre.getSelectedItem();

                    AllObject.event.tambahEvent(txtPenyelenggara.getText(),txtNamaEvent.getText(),txtDeskripsi.getText(),txtTempat.getText()
                    ,txtSyarat.getText(),txtRegion.getText(),Integer.parseInt(txtSlot.getText()),Integer.parseInt(txtHarga.getText()),status
                        , AllObject.user.getId_login(),genre,txtGame.getText());

                    sukses((MouseEvent) a);
                    frame.dispose();
                    new GUI_Home();
                }catch (Exception ex){
                    gagal((MouseEvent) a);
                }
            }
        });

        btnBack = new JButton("Back");
        btnBack.setBounds(160 , 580 , 120 , 30);
        frame.add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI_Home();
                frame.dispose();
            }
        });

        frame.setSize(600,700);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void sukses(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Sukses Create !! " + AllObject.event.getId_event());
    }
    public void gagal(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Gagal Create !! ");
    }
}
