package tbd.taller1.modelo;

//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "film")
public class Pelicula {

   @Id
   @Column(name="film_id", unique=true, nullable=false)
   private int filmId;

    @Column(name="title", nullable=false, length=45)
    private String title;

    @ElementCollection
    List<Actor> actores;

    public Pelicula() {
        actores = new ArrayList<Actor>();
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
