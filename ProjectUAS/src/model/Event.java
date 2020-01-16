package model;

public class Event {
    private String Penyelenggara , NamaEvent, Deskripsi , Tempat , SyaratDanKetentuan , region ,offlineOnline , genreEvent , namaGame;
    private int slot , id_user;
    private float harga;

    public Event(String penyelenggara , String namaEvent , String deskripsi , String tempat , String syaratDanKetentuan , String region , int slot , float harga
            , String offlineOnline , int id_user , String genreEvent, String namaGame){
        this.Deskripsi = deskripsi;
        this.harga = harga;
        this.NamaEvent = namaEvent;
        this.Tempat = tempat;
        this.offlineOnline = offlineOnline;
        this.Penyelenggara = penyelenggara;
        this.SyaratDanKetentuan = syaratDanKetentuan;
        this.region = region;
        this.slot = slot;
        this.id_user = id_user;
        this.genreEvent = genreEvent;
        this.namaGame = namaGame;
    }

    public String getPenyelenggara(){return Penyelenggara;}
    public String getNamaEvent(){return NamaEvent;}
    public String getDeskripsi(){return Deskripsi;}
    public String getTempat(){return Tempat;}
    public String getSyaratDanKetentuan(){return SyaratDanKetentuan;}
    public String getRegion(){return region;}
    public String getOfflineOnline(){return offlineOnline;}
    public int getSlot(){return slot;}
    public float getHarga(){return harga;}
    public int getId_user() {
        return id_user;
    }
    public String getNamaGame() {
        return namaGame;
    }



    public String getGenreEvent() {
        return genreEvent;
    }
}
