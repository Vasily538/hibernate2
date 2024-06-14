package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.Date;

@Entity
@Table(name = "customer", schema = "movie")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    Short id;
    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;
    @Column(name = "first_name", length = 45, nullable = false)
    String firstName;
    @Column(name = "last_name", length = 45, nullable = false)
    String lastName;
    @Column(name = "email", length = 50)
    String email;
    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;
    @Column(name = "active", columnDefinition = "tinyint(1)", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean active;
    @Column(name = "create_date", nullable = false)
    Date createDate;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {

        return "Customer:{" +
                "first name:" + firstName + "\n" +
                "last name:" + lastName + "\n" +
                "email:" + email + "\n" +
                "active:" + active + "\n" +
                "createDate:" + createDate + "\n" +
                "address:" + address +
                "}";
    }
}
