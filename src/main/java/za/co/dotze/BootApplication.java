package za.co.dotze;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import za.co.dotze.customer.Customer;
import za.co.dotze.customer.CustomerDao;

/**
 * @Author - Christiaan Dotze <christiaan@dotze.co.za>
 * @Since - 03 Oct 2019
 */
public class BootApplication {
    public static void main(String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext(
                "Spring-Customer.xml",
                "Spring-DataSource.xml"
        );
        final CustomerDao customerDao = (CustomerDao) context.getBean("customerDAO");
        Customer customer = new Customer(1, "Christiaan", 28);
        customerDao.addCustomer(customer);

        customer = customerDao.findCustomerById(4);
        System.out.println(customer.toString());
    }
}
