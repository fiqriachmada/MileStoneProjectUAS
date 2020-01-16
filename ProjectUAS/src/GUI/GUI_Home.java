package GUI;

import controller.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_Home extends JFrame {

    DefaultTableModel modelEvent;
    JScrollPane sp_Event = new JScrollPane();
    JTable tblEvent = new JTable();
    Object a;

    JLabel labelMenu = new JLabel("Menu") , labelEvent = new JLabel("List Event");
    JButton btnNewevent = new JButton("Buat Event") , btnEventUser = new JButton("Event Anda"),btnIkutEvent = new JButton("Event Yang Anda Ikuti"),
            btnCariEvent = new JButton("Cari") , btnLogout = new JButton("Logout");
    JComboBox combo_genre;
    JTextField txtgetIdEvent;

    int z = 0;
    public GUI_Home(){

        initComponent();
    }

    public void initComponent(){
        JFrame frame = new JFrame("Home");

        labelMenu.setBounds(130,20,500,60);
        labelMenu.setFont(new Font("Consolas" ,Font.BOLD,38));
        labelMenu.setForeground(new Color(20,1,188));
        frame.add(labelMenu);

        labelEvent.setBounds(900,20,500,60);
        labelEvent.setFont(new Font("Consolas" ,Font.BOLD,38));
        labelEvent.setForeground(new Color(20,1,188));
        frame.add(labelEvent);

        btnNewevent.setBounds(30 , 90 , 120 , 30);
        frame.add(btnNewevent);

        btnEventUser.setBounds(160 , 90 , 120 , 30);
        frame.add(btnEventUser);

        btnIkutEvent.setBounds(30 , 130 , 190 , 30);
        frame.add(btnIkutEvent);

        btnLogout.setBounds(30 , 490, 120 ,30);
        frame.add(btnLogout);
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI_Login();
                frame.dispose();
            }
        });

        sp_Event.setViewportView(tblEvent);
        modelEvent = (DefaultTableModel) tblEvent.getModel();
        tblEvent.setDefaultEditor(Object.class , null);
        modelEvent.addColumn("Nama Event");
        modelEvent.addColumn("Genre");
        modelEvent.addColumn("Tempat");
        modelEvent.addColumn("Harga");
        modelEvent.addColumn("Game");
        modelEvent.addColumn("On/Off");
        modelEvent.addColumn("Id Event");
        sp_Event.setBounds(750 , 110 , 500 , 400);
        tblEvent.getColumnModel().getColumn(6).setMinWidth(0);
        tblEvent.getColumnModel().getColumn(6).setMaxWidth(0);
        tblEvent.getColumnModel().getColumn(6).setWidth(0);
        frame.add(sp_Event);

        String [] tampung_genre = new String[AllObject.genre.getId_genre()];
        for(int i = 0 ; i <AllObject.genre.getId_genre() ; i++){
            tampung_genre[i] = AllObject.genre.getGenre()[i].getTipeGenre();
        }
        combo_genre =  new JComboBox(tampung_genre);
        combo_genre.setBounds(750 , 75 , 300 , 30);
        frame.add(combo_genre);

        btnCariEvent.setBounds(1050 , 75 , 90 , 30);
        frame.add(btnCariEvent);

        btnNewevent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI_createEvent();
                frame.dispose();
            }
        });


        if(z==0){
            cetakEvent();
        }

        btnCariEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cetakEventFilter();
                z=1;
            }
        });

        btnEventUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(AllObject.event.cekUser(AllObject.user.getId_login())>-1) {
                        new GUI_pilihEventUser();
                    }else{
                        throw new Exception ();
                    }
                }catch (Exception ex){
                    dataKosong((MouseEvent) a);
                }
            }
        });

        //MouseClicked
        tblEvent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tblEventClicked((MouseAdapter) a);
                new GUI_DeskripsiEvent();
            }
        });

        txtgetIdEvent = new JTextField();
        frame.add(txtgetIdEvent);

        btnIkutEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int a = AllObject.pembayaran.getIndexUser(AllObject.user.getId_login());
                    if(a>-1) {
                        new GUI_EventBuy();
                    }else{
                        throw new Exception ();
                    }
                }catch (Exception ex){
                    dataKosong((MouseEvent) a);
                }
            }
        });


        frame.setSize(1300,600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void cetakEvent(){
        for(int i = 0 ; i<AllObject.event.getId_event() ; i++){
            Object[] obj =new Object[7];
            obj[0] = AllObject.event.getEvent()[i].getNamaEvent();
            obj[1] = AllObject.event.getEvent()[i].getGenreEvent();
            obj[2] = AllObject.event.getEvent()[i].getTempat();
            obj[3] = AllObject.event.getEvent()[i].getHarga();
            obj[4] = AllObject.event.getEvent()[i].getNamaGame();
            obj[5] = AllObject.event.getEvent()[i].getOfflineOnline();
            obj[6] = i;
            modelEvent.addRow(obj);
        }
    }

    public void cetakEventFilter(){
        clearJtable();
        for(int i = 0 ; i<AllObject.event.getId_event() ; i++){
            String filter = (String) combo_genre.getSelectedItem();
            if(filter == AllObject.event.getEvent()[i].getGenreEvent()) {
                Object[] obj = new Object[7];
                obj[0] = AllObject.event.getEvent()[i].getNamaEvent();
                obj[1] = AllObject.event.getEvent()[i].getGenreEvent();
                obj[2] = AllObject.event.getEvent()[i].getTempat();
                obj[3] = AllObject.event.getEvent()[i].getHarga();
                obj[4] = AllObject.event.getEvent()[i].getNamaGame();
                obj[5] = AllObject.event.getEvent()[i].getOfflineOnline();
                obj[6] = i;
                modelEvent.addRow(obj);
            }
        }
    }

    public void clearJtable(){
        int row = tblEvent.getRowCount();
        for(int a = 0 ; a < row ; a++) {
            modelEvent.removeRow(a);
        }
    }
    public void dataKosong(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Data Kosong ! ");
    }

    private void tblEventClicked(java.awt.event.MouseAdapter evt){
        int selectedRow = tblEvent.getSelectedRow();
        txtgetIdEvent.setText(modelEvent.getValueAt(selectedRow,6).toString());
        AllObject.event.setIdPilEvent(Integer.parseInt(txtgetIdEvent.getText()));
    }

}