package refactoring;

import java.util.ArrayList;

/**
 *
 * @author bernat
 */
public class PrinterInventory {
 
    
    ArrayList<Printer> printerList;

    public PrinterInventory() {
        printerList = new ArrayList<Printer>();
    }
    
    public void addPrinter(Printer p) {
        printerList.add(p);
    }
    
    public String getExpensesInventory() {
        
        String  e  = "================================================\n";
                e += "       PRINTER EXPENSES INVENTORY \n";
                e += "================================================\n";
                
        int totalBWCopies = 0;
        int totalColorCopies = 0;
        int printers = 0;
        double totalCost = 0;
        double laserJetCost = 0;
        double officeJetCost = 0;
        double rentingCost = 0;
        int laserJetPrinters =0, officeJetPrinters =0, rentingCostPrinters =0;
        for(int i=0;i<printerList.size();i++) {
            Printer p = printerList.get(i);
            double cost=0;
            
            if(p.getPrinterType()==Printer.HP_LASERJET_VII) {
                laserJetPrinters++;
                totalBWCopies += p.getNumberOfBlackAndWhiteCopies();
                
                cost = 350.00;
                cost +=  0.01 * p.getNumberOfBlackAndWhiteCopies();  
                
                e += " * " + p.getInventoryId()+ ":HP Laserjet VII >\t\t expenses: "+cost+"€ > number of B&W copies " +p.getNumberOfBlackAndWhiteCopies() + "\n";
                totalCost += cost;                
                laserJetCost += cost;   
                printers++;
            } else if(p.getPrinterType()==Printer.HP_OFFICEJET_5) {
                officeJetPrinters++;
                totalBWCopies += p.getNumberOfBlackAndWhiteCopies();
                totalColorCopies += p.getNumberOfColorCopies();
                
                cost = 125.00;
                cost +=  0.01 * p.getNumberOfBlackAndWhiteCopies();  
                cost +=  0.07 * p.getNumberOfColorCopies();  
                totalCost += cost;   
                officeJetCost += cost;   
                printers++;
                e += " * " + p.getInventoryId()+ ":HP Office 5 >\t\t expenses: "+cost+"€ > number of B&W copies " +p.getNumberOfBlackAndWhiteCopies() +" > number of Color copies " + p.getNumberOfColorCopies()+ "\n";
            } else  {
                rentingCostPrinters++;
                totalBWCopies += p.getNumberOfBlackAndWhiteCopies();
                
                cost +=  0.06 * p.getNumberOfBlackAndWhiteCopies();
                totalCost += cost;    
                rentingCost += cost;
                printers++;
                e += " * " + p.getInventoryId()+ ":Renting >\t\t expenses: "+cost+"€ > number of B&W copies " +p.getNumberOfBlackAndWhiteCopies() + "\n";
            }
        }
        e += "------------------------------------------------\n";
        e += "              Summary \n";
        e += "------------------------------------------------\n";
        e += " - HP Laserjet VII > \t# of printers:"+laserJetPrinters+",\t total cost:"+laserJetCost+"€\n";
        e += " - HP Office 5 > \t# of printers:"+officeJetPrinters+",\t total cost:"+officeJetCost+"€\n";        
        e += " - Renting > \t# of printers:"+rentingCostPrinters+",\t total cost:"+rentingCost+"€\n";
        e += "------------------------------------------------\n";
        e += " TOTAL PRINTERS:"+printers+"\n";
        e += " TOTAL COST:"+totalCost+"€\n";
        e += "------------------------------------------------\n";
        return e;        
    }
}
