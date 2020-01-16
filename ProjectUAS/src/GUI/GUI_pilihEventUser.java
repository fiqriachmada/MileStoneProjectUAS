package GUI;

import controller.AllObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_pilihEventUser extends JFrame {

    DefaultTableModel modelEvent;
    JScrollPane sp_Event = new JScrollPane();
    JTable tblEvent = new JTable();
    Object a;
    JTextField txtgetIdEvent;
    public GUI_pilihEventUser(){
        initComponent();
    }

    public void initComponent(){
        JFrame frame = new JFrame("Pilih Event");

        sp_Event.setViewportView(tblEvent);
        modelEvent = (DefaultTableModel) tblEvent.getModel();
        tblEvent.setDefaultEditor(Object.class , null);
        modelEvent.addColumn("Nama Event");
        modelEvent.addColumn("Genre");
        modelEvent.addColumn("Tempat");
        modelEvent.addColumn("Harga");
        modelEvent.addColumn("Game");
        modelEvent.addColumn("On/Off");
        modelEvent.addColumn("Id User");
        sp_Event.setBounds(30 , 20 , 700 , 400);
        tblEvent.getColumnModel().getColumn(6).setMinWidth(0);
        tblEvent.getColumnModel().getColumn(6).setMaxWidth(0);
        tblEvent.getColumnModel().getColumn(6).setWidth(0);
        frame.add(sp_Event);

        cetakEvent();

        tblEvent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                tblEventClicked((MouseAdapter) a);
                new GUI_UpdateEvent();
            }
        });

        txtgetIdEvent = new JTextField();
        frame.add(txtgetIdEvent);

        frame.setSize(800,500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void cetakEvent(){
        for(int i = 0 ; i<AllObject.event.getId_event() ; i++){
            if(AllObject.user.getId_login() == AllObject.event.getEvent()[i].getId_user()) {
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
    private void tblEventClicked(java.awt.event.MouseAdapter evt){
        int selectedRow = tblEvent.getSelectedRow();
        txtgetIdEvent.setText(modelEvent.getValueAt(selectedRow,6).toString());
        AllObject.event.setIdPilEvent(Integer.parseInt(txtgetIdEvent.getText()));
    }
}
