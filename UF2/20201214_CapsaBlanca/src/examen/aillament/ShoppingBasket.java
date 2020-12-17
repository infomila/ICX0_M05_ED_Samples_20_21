package examen.aillament;

import java.util.ArrayList;

/**
 *
 * @author bernat
 */
public class ShoppingBasket {

     public String getSummary( int customerId , ArrayList<Integer> productIds, ArrayList<Integer> units ){
         
         ProductCatalogDB pcDB = new ProductCatalogDB();
         
         double discount = pcDB.getCustomerDiscount(customerId);
         double totalAmount=0;
         String summary="";
         int i=0;
         for(int Id:productIds){
             ProductInfo pi = pcDB.getProductInfo(Id);
             if(pi!=null) {
                double linePrice = units.get(i) * pi.getUnitPrice() ;

                summary += fixedSize("{" +pi.getId() + "}",10)+fixedSize(pi.getDescription(), 30) +"\t" + fixedSize(""+
                        String.format("%.2f", pi.getUnitPrice())+"€/u",10) + " x " + units.get(i) + "u. = " + 
                        String.format("%.2f",linePrice)+ "€\n";
                i++;
                totalAmount += linePrice;
             } else {
                summary += fixedSize("{" + productIds.get(i) + "}",10)+"| Producte descatalogat\n";
             }
         }
         double dis = totalAmount*(discount/100.0);
         summary += fixedSize("SUBTOTAL",10) + "| "+ String.format("%.2f",totalAmount) +"€\n";
         summary += fixedSize("DISCOUNT",10) + "| "+ String.format("%.2f",dis) +"€\n";
         summary += fixedSize("TOTAL",10) + "| "+ String.format("%.2f",(totalAmount-dis)) +"€\n";
         return summary;
     }
    
    private String fixedSize(String s, int size ){
        return String.format("| %-"+size+"."+size+"s", s) ;
    }
}


