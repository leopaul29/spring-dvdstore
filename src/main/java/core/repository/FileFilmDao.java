package core.repository;

import core.entity.Film;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileFilmDao implements FilmDaoInterface {
    public void save(Film f){
        FileWriter fw;
        try
        {
            fw = new FileWriter("C:\\temp\\films.txt", true);
            fw.write(f.getTitre()+";"+f.getGenre()+";"+f.getNbExemplaires()+"\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Film getById(int Id) {
        return null;
    }

    @Override
    public List<Film> list() {
        return null;
    }
}
