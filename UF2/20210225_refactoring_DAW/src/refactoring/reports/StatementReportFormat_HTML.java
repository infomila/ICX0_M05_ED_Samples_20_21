
package refactoring.reports;

import refactoring.Customer;
import refactoring.Rental;

/**
 *
 * @author Usuari
 */
public class StatementReportFormat_HTML extends StatementReportFormat_Text{

    
    @Override
    public String getHeader(String customerName) {
        return "<html><body><main><header>"+ super.getHeader(customerName) +"</header><ul>" ;
    } 
    @Override
    public String getLine(Rental r) {
            return  "<li>"+super.getLine(r)+"</li>";
    }
    @Override
     public String getFooter(Customer c) {         
        return "</ul><footer>"+super.getFooter(c)+"</footer></main></body></html>";                  
    }
    
}
