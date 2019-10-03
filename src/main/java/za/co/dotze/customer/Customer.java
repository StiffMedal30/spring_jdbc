package za.co.dotze.customer;

/**
 * @Author - Christiaan Dotze <christiaan@dotze.co.za>
 * @Since - 03 Oct 2019
 */
public class Customer {
    private Integer id;
    private String name;
    private Integer age;

    public Customer(final Integer id, final String name, final Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
