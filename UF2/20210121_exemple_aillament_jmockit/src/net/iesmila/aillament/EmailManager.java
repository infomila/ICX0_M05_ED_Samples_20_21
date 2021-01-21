package net.iesmila.aillament;

/**
 *
 * @author BERNAT
 */
class EmailManager {

    
    public boolean sendEmail(String email, String subject, String body) {
        System.out.println("Estic enviant un correu de veritat");
        return true;
    }
    
    public boolean verifyEmail(String email) {
        System.out.println("Estic verificant un correu real.");
        return true;
    }
    
}
