import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<Integer, String> customerDatabase = new HashMap<>();

    @Override
    public String findCustomerById(int id) {
        return customerDatabase.getOrDefault(id, "Customer not found");
    }

    @Override
    public void addCustomer(int id, String name) {
        customerDatabase.put(id, name);
    }
}
