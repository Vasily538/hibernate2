package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "film_text", schema = "movie")

public class Film_text {
    @Id
    @Column(name = "film_id")
    Short id;
    @Column(name = "title", length = 255, nullable = false)
    String title;
    @Column(name = "description")
    String description;

   @OneToOne()
   @JoinColumn(name = "film_id")

    Film film;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
