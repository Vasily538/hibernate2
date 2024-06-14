import entities.Customer;

public class Runner {
    public static void main(String[] args) {
        Customer customer = CustomerManager.createCustomer();
        System.out.println(customer);
        CustomerManager.returnRentedFilm();
        CustomerManager.goToStoreAndRentInventory();
        CustomerManager.filmWasShotAndBecameAvailableForRent();
    }
}
