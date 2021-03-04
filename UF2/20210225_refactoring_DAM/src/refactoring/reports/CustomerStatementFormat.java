
package refactoring.reports;

import refactoring.Customer;
import refactoring.Rental;

/**
 *
 * @author Usuari
 */
public abstract class CustomerStatementFormat {
    
    public abstract String getHeader(Customer customer);

    public abstract String getLine(Rental curRental);

    public abstract String getFooter(Customer customer);
}
