package controller;
import model.Event;

public class EventController {
    private Event [] event = new Event[100];
    private int id_event = 0;

    public int getIdPilEvent() {
        return idPilEvent;
    }

    public void setIdPilEvent(int idPilEvent) {
        this.idPilEvent = idPilEvent;
    }

    private int idPilEvent;

    public void tambahEvent(String penyelenggara , String namaEvent , String deskripsi , String tempat , String syaratDanKetentuan , String region , int slot , float harga
            , String offlineOnline , int id_user , String genre ,String namaGame){

        event[id_event] = new Event(penyelenggara , namaEvent , deskripsi , tempat , syaratDanKetentuan , region ,slot , harga , offlineOnline , id_user , genre , namaGame);
        this.id_event++;
    }

    public Event[] getEvent() {
        return event;
    }

    public int getId_event() {
        return id_event;
    }

    public void updateEvent(String penyelenggara , String namaEvent , String deskripsi , String tempat , String syaratDanKetentuan , String region , int slot , float harga
            , String offlineOnline , int id_user , String genre ,String namaGame , int indexLogin){

        event[indexLogin] = new Event(penyelenggara , namaEvent , deskripsi , tempat , syaratDanKetentuan , region ,slot , harga , offlineOnline , id_user , genre , namaGame);
    }

    public int cekUser(int id_user){
        int cekUser = 0;
        if(id_event == 0){
            cekUser = -2;
        }else {
            for (int i = 0; i <= this.id_event; i++) {
                if (id_user == event[i].getId_user()) {
                    break;
                } else if (i == this.id_event) {
                    cekUser = -1;
                }
                cekUser++;
            }
        }
        return cekUser;
    }
}
