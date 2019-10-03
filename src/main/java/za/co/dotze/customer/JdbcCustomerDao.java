package za.co.dotze.customer;

import za.co.dotze.exception.MySqlException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author - Christiaan Dotze <christiaan@dotze.co.za>
 * @Since - 03 Oct 2019
 */
public class JdbcCustomerDao implements CustomerDao {

    private DataSource dataSource;
    private PreparedStatement ps;
    private Connection connection = null;

    public void setDataSource(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addCustomer(final Customer customer) {
        final String insertQuery = "INSERT INTO customer (id, name, age) VALUES (?, ?, ?)";
        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement(insertQuery);
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setInt(3, customer.getAge());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new MySqlException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Customer findCustomerById(final Integer id) {
        final String findQuery = "SELECT * FROM customer WHERE id = ?";
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            ps = null;
            ps = connection.prepareStatement(findQuery);
            ps.setInt(1, id);
            Customer customer = null;
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age")
                );
            }
            ps.close();
            resultSet.close();
            return customer;
        } catch (SQLException e) {
            throw new MySqlException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
