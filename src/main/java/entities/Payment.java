package entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Table(name = "payment", schema = "movie")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    Short id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    Staff staff;
    @ManyToOne
    @JoinColumn(name = "rental_id")
    Rental rental;
    @Column(name = "amount", nullable = false)
    Float amount;
    @Column(name = "payment_date", nullable = false)
    Date paymentDate;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
