package examen.aillament;

/**
 *
 * @author bernat
 */
public class ProductInfo {

    int id;
    double unitPrice;
    String description;

    public ProductInfo(int id, double unitPrice, String description) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getDescription() {
        return description;
    }
    
}
