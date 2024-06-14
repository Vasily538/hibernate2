package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "city", schema = "movie")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    Short id;
    @Column(name = "city", length = 50, nullable = false)
    String city;
    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "{city:" + city + "\n" +
                "country:" + country +
                              "}";
    }
}
