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
        
        String  report  = "================================================\n";
                report += "       PRINTER EXPENSES INVENTORY \n";
                report += "================================================\n";
                
        double totalCost = 0;
        int[] countPerType = new int[PrinterType.values().length];
        double[] costPerType = new double[PrinterType.values().length];
        
        for(int i=0;i<printerList.size();i++) {
            Printer p = printerList.get(i);
            double cost=p.getCost();
            
            report += " * " + p.getInventoryId()+ ":"+p.getName()+" >\t\t expenses: "+cost+"€ > number of B&W copies " +p.getNumberOfBlackAndWhiteCopies();
            if(p.isColorSupported()){                                
                   report +=" > number of Color copies " + p.getNumberOfColorCopies();
            }
            report += "\n";
            
            countPerType[p.getPrinterType().ordinal()]++;
            costPerType[p.getPrinterType().ordinal()]+=cost;
                     
            totalCost += cost; 
        }
        report += "------------------------------------------------\n";
        report += "              Summary \n";
        report += "------------------------------------------------\n";
        
        for(PrinterType pt:PrinterType.values()){            
            report += " - "+pt.getName()+" > \t# of printers:"+countPerType[pt.ordinal()]+",\t total cost:"+costPerType[pt.ordinal()]+"€\n";
        }
        report += "------------------------------------------------\n";
        report += " TOTAL PRINTERS:"+printerList.size()+"\n";
        report += " TOTAL COST:"+totalCost+"€\n";
        report += "------------------------------------------------\n";
        return report;        
    }
}
