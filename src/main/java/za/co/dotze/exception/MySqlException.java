package za.co.dotze.exception;

/**
 * @Author - Christiaan Dotze <christiaan@dotze.co.za>
 * @Since - 03 Oct 2019
 */
public class MySqlException extends RuntimeException {
    public MySqlException(final Exception e) {
        super(e);
    }
}
