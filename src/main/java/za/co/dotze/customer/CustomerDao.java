package za.co.dotze.customer;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * @Author - Christiaan Dotze <christiaan@dotze.co.za>
 * @Since - 03 Oct 2019
 */
public interface CustomerDao {
    void addCustomer(final Customer customer);

    Customer findCustomerById(final Integer id);
}
