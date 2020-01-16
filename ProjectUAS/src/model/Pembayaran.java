package model;

public class Pembayaran {
    private int id_user , idEvent;
    private  String namaTim , namaEvent , tglPembayaran , namaAngota;

    public Pembayaran(int id_user, String namaTim, String namaEvent , String tglPembayaran , String namaAngota , int idEvent) {
        this.id_user = id_user;
        this.namaTim = namaTim;
        this.namaEvent = namaEvent;
        this.tglPembayaran = tglPembayaran;
        this.namaAngota = namaAngota;
        this.idEvent = idEvent;
    }

    public String getTglPembayaran() {
        return tglPembayaran;
    }

    public int getId_user() {
        return id_user;
    }

    public String getNamaTim() {
        return namaTim;
    }

    public String getNamaEvent() {
        return namaEvent;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public String getNamaAngota() {
        return namaAngota;
    }
}
