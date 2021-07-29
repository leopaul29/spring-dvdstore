package core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String titre;
    private String genre;
    private int nbExemplaires;

    public Film(){}

    public Film(String titre, String genre){
        this(titre, genre, 0);
    }

    public Film(String titre, String genre, int nbExemplaires){
        this.titre=titre;
        this.genre=genre;
        this.nbExemplaires = nbExemplaires;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", genre='" + genre + '\'' +
                ", nbExemplaires=" + nbExemplaires +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNbExemplaires() {
        return nbExemplaires;
    }

    public void setNbExemplaires(int nbExemplaires) {
        this.nbExemplaires = nbExemplaires;
    }
}
