package refactoring;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bernat
 */
public class PrinterInventoryTest {
    
    public PrinterInventoryTest() {
    }

    /**
     * Test of getExpensesInventory method, of class PrinterInventory.
     */
    @Test
    public void testGetExpensesInventory() {
        
        PrinterInventory inventory = new PrinterInventory();
        inventory.addPrinter(new Printer("LSJ41223", Printer.HP_LASERJET_VII, 0, 3050));
        inventory.addPrinter(new Printer("LSJ01295", Printer.HP_LASERJET_VII, 0, 8972));
        inventory.addPrinter(new Printer("OFJ00122", Printer.HP_OFFICEJET_5, 210, 675));
        inventory.addPrinter(new Printer("LSJ01223", Printer.HP_LASERJET_VII, 0, 634));
        inventory.addPrinter(new Printer("OFJ00123", Printer.HP_OFFICEJET_5, 560, 1200));
        inventory.addPrinter(new Printer("RT000001", Printer.RENTING_LASER_JET, 0, 3600));
        inventory.addPrinter(new Printer("RT000002", Printer.RENTING_LASER_JET, 0, 456));
        inventory.addPrinter(new Printer("RT000003", Printer.RENTING_LASER_JET, 0, 5621));
        
        String result = inventory.getExpensesInventory();
        String expectedResult=
                "================================================\n"+
                "       PRINTER EXPENSES INVENTORY \n"+
                "================================================\n"+
                " * LSJ41223:HP Laserjet VII >		 expenses: 380.5€ > number of B&W copies 3050\n"+
                " * LSJ01295:HP Laserjet VII >		 expenses: 439.72€ > number of B&W copies 8972\n"+
                " * OFJ00122:HP Office 5 >		 expenses: 146.45€ > number of B&W copies 675 > number of Color copies 210\n"+
                " * LSJ01223:HP Laserjet VII >		 expenses: 356.34€ > number of B&W copies 634\n"+
                " * OFJ00123:HP Office 5 >		 expenses: 176.2€ > number of B&W copies 1200 > number of Color copies 560\n"+
                " * RT000001:Renting >		 expenses: 216.0€ > number of B&W copies 3600\n"+
                " * RT000002:Renting >		 expenses: 27.36€ > number of B&W copies 456\n"+
                " * RT000003:Renting >		 expenses: 337.26€ > number of B&W copies 5621\n"+
                "------------------------------------------------\n"+
                "              Summary \n"+
                "------------------------------------------------\n"+
                " - HP Laserjet VII > 	# of printers:3,	 total cost:1176.56€\n"+
                " - HP Office 5 > 	# of printers:2,	 total cost:322.65€\n"+
                " - Renting > 	# of printers:3,	 total cost:580.62€\n"+
                "------------------------------------------------\n"+
                " TOTAL PRINTERS:8\n"+
                " TOTAL COST:2079.83€\n"+
                "------------------------------------------------\n";
        
        System.out.println(">"+result+".");
        System.out.println(">"+expectedResult+".");
        
        assertEquals(expectedResult, result);
                
    }
    
}
