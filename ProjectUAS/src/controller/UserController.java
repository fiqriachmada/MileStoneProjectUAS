package controller;
import model.User;

public class UserController {
    private User [] user = new User[100];
    private int index = 0 , id_login = 0;

    public void tambahUser(String usr , String pass){
        this.user[index] = new User(usr,pass);
        this.index++;
    }

    public int cekLogin(String uname , String pass){
        int cekLogin = 0;
        for(int i = 0 ; i<= index ; i++){
            if(uname.equals(user[i].getUsername())&& pass.equals(user[i].getPassword())){
                cekLogin = i;
                break;
            }else if(i == index){
                cekLogin = -1;
            }
        }
        id_login = cekLogin;
        return cekLogin;
    }

    public User[] getUser() {
        return user;
    }

    public int getId_login() {
        return id_login;
    }
}
