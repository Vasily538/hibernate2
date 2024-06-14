package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.sql.Blob;

@Entity
@Table(name = "staff", schema = "movie")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    Byte id;
    @Column(name = "first_name", length = 45, nullable = false)
    String firstName;
    @Column(name = "last_name", length = 45, nullable = false)
    String lastName;
    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;
    @Column(name = "picture")
    @Lob
    Blob picture;
    @Column(name = "email", length = 50)
    String email;
    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;
    @Column(name = "active", columnDefinition = "tinyint(1)", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean active;
    @Column(name = "username", length = 16, nullable = false)
    String userName;
    @Column(name = "password", length = 40)
    String password;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "{firstName:" + firstName + "\n" +
                "last name:" + lastName + "\n" +
                "address:" + address + "\n" +
                "email:" + email + "\n" +
                "store:" + store + "\n" +
                "active:" + active + "\n" +
                "username:" + userName +
                                "}";
    }
}
