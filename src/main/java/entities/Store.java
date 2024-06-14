package entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "store", schema = "movie")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    Byte id;
    @OneToOne
    @JoinColumn(name = "manager_staff_id")
    Staff managerStaff;
    @OneToOne
    @JoinColumn(name = "address_id")
    Address address;
    @Column(name = "last_update", nullable = false)
    OffsetDateTime lastUpdate;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Staff getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(Staff managerStaff) {
        this.managerStaff = managerStaff;
    }

    @Override
    public String toString() {
        return "{address:" + address + "\n" +
                "last update:" + lastUpdate +
                "}";
    }
}
