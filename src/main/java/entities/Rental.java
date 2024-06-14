package entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Table(name = "rental", schema = "movie")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    Integer id;
    @Column(name="rental_date",nullable = false)
    Date rentalDate;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    Inventory inventory;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
    @Column(name="return_date")
    Date returnDate;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    Staff staff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
