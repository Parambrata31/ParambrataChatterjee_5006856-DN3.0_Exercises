public interface CustomerRepository {
    String findCustomerById(int id);
    void addCustomer(int id, String name);
}
