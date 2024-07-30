public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerNameById(int id) {
        return customerRepository.findCustomerById(id);
    }

    public void addCustomer(int id, String name) {
        customerRepository.addCustomer(id, name);
    }
}
