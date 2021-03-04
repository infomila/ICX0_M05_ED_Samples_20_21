package refactoring.reports;

import refactoring.Customer;
import refactoring.Rental;

/**
 *
 * @author Usuari
 */
public class CustomerStatementFormat_HTML extends CustomerStatementFormat_TEXT {

    @Override
    public String getHeader(Customer customer) {        
        return "<html><body><main><header>"+super.getHeader(customer)+"</header><ul>";
    }

    @Override
    public String getLine(Rental curRental) {
        return "<li>"+super.getLine(curRental)+"</li>";
    }

    @Override
    public String getFooter(Customer customer) {
        return "</ul><footer>"+super.getFooter(customer)+"</footer></main></body></html>";
    }

}
