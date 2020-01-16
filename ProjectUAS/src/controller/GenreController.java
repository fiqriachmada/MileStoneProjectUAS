package controller;

import model.Genre;

public class GenreController {
    private Genre [] genre = new Genre[100];
    private int id_genre = 4;

    public GenreController(){
        fixGenre();
    }

    public void fixGenre(){
        genre[0] = new Genre("FPS");
        genre[1] = new Genre("RPG");
        genre[2] = new Genre("MOBA");
        genre[3] = new Genre("MMORPG");
    }

    public Genre[] getGenre() {
        return genre;
    }

    public int getId_genre() {
        return id_genre;
    }
}
