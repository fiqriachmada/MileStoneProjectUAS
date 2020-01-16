package controller;

import model.Pembayaran;

public class PembayaranController {
    private int indexPembayaran = 0;
    private Pembayaran [] pembayaran = new Pembayaran[100];

    public void tambahPembayaran(int id_user, String namaTim, String namaEvent,String tglPembayaran ,String namaAnggota , int idEvent){
        this.pembayaran[indexPembayaran] = new Pembayaran(id_user , namaTim , namaEvent , tglPembayaran , namaAnggota , idEvent);
        this.indexPembayaran++;
    }

    public int getIndexPembayaran() {
        return indexPembayaran;
    }


    public Pembayaran[] getPembayaran() {
        return pembayaran;
    }

    public String finalGabung(String a , String b , String c , String d , String e){
        String gabung1 = a.concat(b);
        String gabung2 = gabung1.concat(c);
        String gabung3 = gabung2.concat(d);
        String finalString = gabung3.concat(e);
        return finalString;
    }

    public int getIndexUser(int id_user){
        int indexCari = 0;
        for(int i =0 ; i<=this.indexPembayaran; i++){
            if(id_user == getPembayaran()[i].getId_user()){
                indexCari = i;
                break;
            }else if(indexCari == indexPembayaran){
                indexCari = -1;
            }
            indexCari++;
        }

        return indexCari;
    }
}
