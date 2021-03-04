
package refactoring.reports;

import java.util.LinkedList;
import refactoring.Customer;
import refactoring.Rental;
import refactoring.reports.DocType;

/**
 *
 * @author Usuari
 */
public class StatementReport {

    private Customer mCustomer;
    private LinkedList<Rental> mRentals;
    
    public StatementReport(Customer pClient, LinkedList<Rental> pLloguers) {
        mCustomer = pClient;
        mRentals = pLloguers;
    }
    /*
    public String toString(){
                
        String result = "Rental Record for " + mCustomer.getName() + "\n";
        for (Rental curRental : mRentals) {
            // show figures for this rental
            result += "\t" + curRental.getMovie().getTitle() + "\t" + String.valueOf(curRental.getRentalAmount()) + "\n";
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(mCustomer.getOwedAmount()) + "\n";
        result += "You earned " + String.valueOf(mCustomer.getFrequentRenterPoints()) + " frequent renter points";

        return result;
    }
    */
    
    
    
     public String getReport(DocType format){
         
        StatementReportFormat srf;
        switch(format) {
            case TEXT: srf = new StatementReportFormat_Text(); break;
            case HTML: srf = new StatementReportFormat_HTML(); break;
            default: throw new RuntimeException("Format no suportat");
        } 
         
        String result = srf.getHeader(mCustomer.getName());
        for (Rental curRental : mRentals) {
            // show figures for this rental
            result += srf.getLine(curRental);
        }
        // add footer lines
        result += srf.getFooter(mCustomer);

        return result;
    }
      

     
     
    public String toHtml(){
                
        String result = "<html><body>"
                + "<main><header>Rental Record for " + mCustomer.getName() + "</header><ul>\n";
        for (Rental curRental : mRentals) {
            // show figures for this rental
            result += "\t<li>" + curRental.getMovie().getTitle() + "\t" + String.valueOf(curRental.getRentalAmount()) + "</li>\n";
        }
        // add footer lines
        result += "</ul><footer>";
        result += "Amount owed is " + String.valueOf(mCustomer.getOwedAmount()) + "\n";
        result += "You earned " + String.valueOf(mCustomer.getFrequentRenterPoints()) + " frequent renter points";
        result +="</footer></main></body></html>";
        return result;
    }





    
    
}
