package entities;


import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "address", schema = "movie")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    Short id;
    @Column(name = "address", length = 50, nullable = false)
    String address;
    @Column(name = "address2", length = 50)
    String address2;
    @Column(name = "district", length = 20, nullable = false)
    String district;
    @ManyToOne
    @JoinColumn(name = "city_id")
    City city;
    @Column(name = "postal_code", length = 20)
    String postalCode;
    @Column(name = "phone", length = 20, nullable = false)
    String phone;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{address:" + address + "\n" +
                "address2:" + address2 + "\n" +
                "distinct:" + district + "\n" +
                "city" + city + "\n" +
                "postal code:" + postalCode + "\n" +
                "phone:" + phone +
                "}"
                ;
    }
}
