package refactoring;

/**
 *
 * @author Usuari
 */
public enum PrinterType {
    HP_LASERJET_VII(LaserjetPrinter.class),
    HP_OFFICEJET_5(OfficeJetPrinter.class),
    RENTING_LASER_JET(RentingPrinter.class);
    
    Class printerClass;
    PrinterType(Class thePrinterClass) {
        printerClass = thePrinterClass;
    }
    public Class getPrinterClass(){
        return printerClass;
    }
}
