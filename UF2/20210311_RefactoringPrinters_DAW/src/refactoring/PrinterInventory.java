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

        String report = "================================================\n";
        report       += "       PRINTER EXPENSES INVENTORY \n";
        report       += "================================================\n";

        double totalCost = 0;
        double laserJetCost = 0;
        double officeJetCost = 0;
        double rentingCost = 0;
        int laserJetPrinters = 0, officeJetPrinters = 0, rentingCostPrinters = 0;
        
        int[] countPerType = new int[PrinterType.values().length] ;
        double[] costPerType = new double[PrinterType.values().length];
        for (int i = 0; i < printerList.size(); i++) {
            Printer p = printerList.get(i);
   
            double cost = p.getCost();
            report += " * " + p.getInventoryId() + ":"+p.getName()+" >\t\t expenses: " + cost + "€ > number of B&W copies " + p.getNumberOfBlackAndWhiteCopies(); 
            if(p.isColorSupported()) {
                report+= " > number of Color copies " + p.getNumberOfColorCopies();
            }
            report+= "\n";            
            totalCost += cost;
            
            costPerType[p.getPrinterType().ordinal()] +=cost;
            countPerType[p.getPrinterType().ordinal()]++;
                        
            
        }
        report += "------------------------------------------------\n";
        report += "              Summary \n";
        report += "------------------------------------------------\n";
        
        for(int i = 0;i< PrinterType.values().length;i++)
        {
            PrinterType t = PrinterType.values()[i];
            Class printerClass = t.getPrinterClass();
            String name = printerClass.getName();           
            report += " - "+name+" > \t# of printers:" + countPerType[i] + ",\t total cost:" + costPerType[i] + "€\n";
        }
        report += "------------------------------------------------\n";
        report += " TOTAL PRINTERS:" + printerList.size() + "\n";
        report += " TOTAL COST:" + totalCost + "€\n";
        report += "------------------------------------------------\n";
        return report;
        
    }
}
