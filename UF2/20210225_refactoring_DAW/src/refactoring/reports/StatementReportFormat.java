
package refactoring.reports;

import refactoring.Customer;
import refactoring.Rental;

/**
 *
 * @author Usuari
 */
public abstract class StatementReportFormat {
    
    public abstract String getHeader(String customerName);
    
    public abstract String getLine(Rental r);
    
    public abstract String getFooter(Customer c);
        
}
