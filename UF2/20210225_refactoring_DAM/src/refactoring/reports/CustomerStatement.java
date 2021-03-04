package refactoring.reports;

import java.util.LinkedList;
import refactoring.Customer;
import refactoring.Rental;

/**
 *
 * @author Usuari
 */
public class CustomerStatement {

    Customer mCustomer;
    LinkedList<Rental> mRentals;
    
    public CustomerStatement(Customer customer, LinkedList<Rental> rentals){
        mCustomer = customer;
        mRentals = rentals;
    }
    
    public String getStatement(DocType type) {
        CustomerStatementFormat csf;
        switch(type){
            case TEXT: csf = new CustomerStatementFormat_TEXT();break;
            case HTML: csf = new CustomerStatementFormat_HTML();break;
            default: throw new RuntimeException("Format no suportat");
        }
        
        String result = csf.getHeader(mCustomer);
        for (Rental curRental : mRentals) {
            result += csf.getLine(curRental);
        }
        result += csf.getFooter(mCustomer);

        return result;
    }



}
