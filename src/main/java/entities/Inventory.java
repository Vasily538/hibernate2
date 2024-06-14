package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory", schema = "movie")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    Long id;
    @ManyToOne
    @JoinColumn(name = "film_id")
    Film film;
    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
