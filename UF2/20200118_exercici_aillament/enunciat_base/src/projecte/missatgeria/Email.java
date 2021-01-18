package projecte.missatgeria;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import java.util.Properties;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author bernat
 */
public class Email {

    public Email() {
    }

    
    public void enviarEmail(String adresa, String subject, String missatge) throws Exception  {

        String from = "mailer@servidor.com";

        // connectar-se al servidor SMTP i enviar el correu electrònic
        //Set the host smtp address
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.jcom.net");

        // create some properties and get the default Session
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(false);

        // create a message
        Message msg = new MimeMessage(session);

        // set the from and to address
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[1];
        addressTo[0] = new InternetAddress(adresa);

        msg.setRecipients(Message.RecipientType.TO, addressTo);

        // Setting the Subject and Content Type
        msg.setSubject(subject);
        msg.setContent(missatge, "text/plain");
        Transport.send(msg);
            
    }
}
