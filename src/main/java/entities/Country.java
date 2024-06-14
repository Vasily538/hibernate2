package entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

@Entity
@Table(name = "country", schema = "movie")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    Short id;
    @Column(name = "country", length = 50, nullable = false)
    String country;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "{country:" + country +
                                "}";
    }
}
