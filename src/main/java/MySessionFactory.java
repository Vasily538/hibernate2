import entities.*;
import org.hibernate.cfg.Configuration;

import javax.swing.*;


public class MySessionFactory {
    public static org.hibernate.SessionFactory getSessionFactory() {
        org.hibernate.SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(Film_text.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Store.class)
                .buildSessionFactory();
        return sessionFactory;

    }
}
