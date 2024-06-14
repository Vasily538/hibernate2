import antlr.CppCodeGenerator;
import entities.*;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Year;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class CustomerManager {
    public static Customer createCustomer() {
        SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
        Customer customer;
        try (Session session = sessionFactory.openSession()) {
            Query<City> cityQuery = session.createQuery("from City where city=:city", City.class)
                    .setParameter("city", "Moscow");
            City city = cityQuery.getSingleResult();

            Query<Store> storeQuery = session.createQuery("from Store where id=:id", Store.class)
                    .setParameter("id", Byte.valueOf("1"));

            Store store = storeQuery.getSingleResult();

            Address address = new Address();
            address.setAddress("Red Square 5");
            address.setAddress2("Second address");
            address.setCity(city);
            address.setDistrict("TSAO");
            address.setPhone("+7-123-45-67");
            address.setPostalCode("123456");

            customer = new Customer();
            customer.setActive(true);
            customer.setCreateDate(Calendar.getInstance().getTime());
            customer.setAddress(address);
            customer.setEmail("mail@mail.ru");
            customer.setFirstName("Rocky");
            customer.setLastName("Balboa");
            customer.setStore(store);
            Transaction tx = session.getTransaction();
            try {
                tx.begin();
                session.persist(address);
                session.persist(customer);
                tx.commit();
            } catch (Exception e) {
                if (tx.getStatus() == TransactionStatus.ACTIVE || tx.getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                    tx.rollback();
                }
                e.printStackTrace();
            }
        }
        return customer;
    }

    public static void returnRentedFilm() {
        SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            Query<Rental> rentalQuery = session.createQuery("from Rental where id=:id", Rental.class)
                    .setParameter("id", 10);
            Rental rental = rentalQuery.getSingleResult();
            rental.setReturnDate(Calendar.getInstance().getTime());
            Transaction tx = session.getTransaction();
            try {
                tx.begin();
                session.save(rental);
                tx.commit();
            } catch (Exception e) {
                if (tx.getStatus() == TransactionStatus.ACTIVE || tx.getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                    tx.rollback();
                }
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void goToStoreAndRentInventory() {
        SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Query<Customer> cityQuery = session.createQuery("from Customer where id=:id", Customer.class)
                    .setParameter("id", Short.valueOf("10"));
            Customer customer = cityQuery.getSingleResult();

            Query<Store> storeQuery = session.createQuery("from Store where id=:id", Store.class)
                    .setParameter("id", Byte.valueOf("2"));
            Store store = storeQuery.getSingleResult();

            Query<Inventory> inventoryQuery = session.createQuery("from Inventory where id=:id and store=:store", Inventory.class)
                    .setParameter("id", Long.valueOf("9"))
                    .setParameter("store", store);
            Inventory inventory = inventoryQuery.getSingleResult();

            Query<Rental> rentalQuery = session.createQuery("from Rental where inventory=:inventory and customer=:customer order by rentalDate desc ", Rental.class)
                    .setParameter("inventory", inventory)
                    .setParameter("customer", customer)
                    .setMaxResults(1);
            Rental rental = null;
            try {
                rental = rentalQuery.getSingleResult();
            } catch (NoResultException e) {

            }

            if (!(rental == null || rental.getReturnDate() != null))
                return;
            Query<Staff> staffQuery = session.createQuery("from Staff where store=:store", Staff.class)
                    .setParameter("store", store);
            Staff staff = staffQuery.getSingleResult();

            Rental rentalNew = new Rental();
            rentalNew.setInventory(inventory);
            rentalNew.setCustomer(customer);
            rentalNew.setRentalDate(Calendar.getInstance().getTime());
            rentalNew.setStaff(staff);

            Payment payment = new Payment();
            payment.setCustomer(customer);
            payment.setStaff(staff);
            payment.setAmount(1f);
            payment.setPaymentDate(Calendar.getInstance().getTime());
            payment.setRental(rentalNew);

            Transaction tx = session.getTransaction();
            try {
                tx.begin();
                session.save(rentalNew);
                session.save(payment);
                tx.commit();
            } catch (Exception e) {
                if (tx.getStatus() == TransactionStatus.ACTIVE || tx.getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                    tx.rollback();
                }
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void filmWasShotAndBecameAvailableForRent() {
        SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Query<Language> languageQuery = session.createQuery("from Language where id=:id", Language.class)
                    .setParameter("id", Byte.valueOf("2"));
            Language language = languageQuery.getSingleResult();

            Query<Actor> actorQuery = session.createQuery("from Actor where id=:id", Actor.class)
                    .setParameter("id", Short.valueOf("25"));
            Actor actor = actorQuery.getSingleResult();

            Query<Category> categoryQuery = session.createQuery("from Category where id=:id", Category.class)
                    .setParameter("id", Byte.valueOf("9"));
            Category category = categoryQuery.getSingleResult();


            Film film = new Film();
            Set<SpecialFeatures> features = new HashSet<>();
           features.add(SpecialFeatures.Trailers);
           features.add(SpecialFeatures.Commentaries);

            film.setDescription("Super film123!");
            film.setLanguage(language);
            film.setLength(Short.valueOf("10"));
            film.setRating(Rating.NC17);
            film.setReleaseYear(Year.now().getValue());
            film.setOriginalLanguageId(Byte.valueOf("1"));
            film.setRentalDuration(Byte.valueOf("10"));
            film.setReplacementCost(150f);
            film.setSpecialFeatures(features);
            film.setTitle("Rocky 123");
            Set<Category> categories = new HashSet<>();
            categories.add(category);
            Set<Actor> actors = new HashSet<>();
            actors.add(actor);
            film.setActors(actors);
            film.setCategories(categories);
            film.setRentalRate(3.5f);

            Film_text filmText = new Film_text();
            filmText.setDescription("DESCRIPTION123 !!!");
            filmText.setTitle("TITLE123 !!!");
            filmText.setFilm(film);
            Transaction tx = session.getTransaction();
            try {
                tx.begin();
                session.save(film);
                filmText.setId(film.getId());
                session.save(filmText);
                tx.commit();
            } catch (Exception e) {
                if (tx.getStatus() == TransactionStatus.ACTIVE || tx.getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                    tx.rollback();
                }
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

