package net.iesmila.aillament;

import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;
import net.iesmila.aillament.EmailManager;
import net.iesmila.aillament.Persona;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class PersonaTest_MockUp {

    public PersonaTest_MockUp() {
    }

    @Test
    public void testGetNom() {
    }

    @Test
    public void testGetCognom() {
    }

    @Test
    public void testGetNIF() {
    }

    @Test
    public void testEnviarEmail() {

        //---------------------------- INICI DEL BLOC DE FAKE-----------------------------------------
        new MockUp<EmailManager>() {
            @Mock
            public boolean sendEmail(String email, String subject, String body) {
                System.out.println("Estic enviant un correu FALS");
                if(subject.equals("ERROR")) return false;                
                return true;
            }
            @Mock
            public boolean verifyEmail(String email) {
                System.out.println("Estic verificant un correu FALS.");
                if(email.equals("EMAIL@NO_EXISTENT.COM")) return false;
                return true;
            }
        };

        //---------------------------- INICI DEL TEST-----------------------------------------
        //-------------------------------------------------------
        // Codi del test normal i corrent
        //-------------------------------------------------------
        Persona p = new Persona("Paco", "Pil", "1111111H", "pordios@nolohagas.com");

        boolean resultat = p.enviarEmail("Hola!", "Això és un missatge");
        assertEquals(true, resultat);
        assertEquals(1, p.getEmailsEnviats());
        //--------------------------------------------------------------------
        resultat = p.enviarEmail("ERROR", "ARA VOLEM SIMULAR UN ERROR DE TRANSMISSIÖ");
        assertEquals(false, resultat);
        assertEquals(1, p.getEmailsEnviats());
        //--------------------------------------------------------------------
        Persona p2 = new Persona("Paco", "Pil", "1111111H", "EMAIL@NO_EXISTENT.COM");
        try {
            resultat = p2.enviarEmail("Hola!", "Això és un missatge");
            fail("els emails erronis han de petar");
        } catch (Exception ex) {
            // passar per aquí és el normal
        }
        assertEquals(0, p2.getEmailsEnviats());

    }

}
