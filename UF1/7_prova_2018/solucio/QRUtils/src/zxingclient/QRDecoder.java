/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zxingclient;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author bernat
 */
public class QRDecoder {
    public static void main(String[] args) throws FileNotFoundException, IOException, NotFoundException {
        
        if(args.length<2) {
            System.out.println("Error en els paràmetres. Us: [nom_imatge_QR] [arxiu_sortida_decodificat]");
            return;
        }
        Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
        hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        String decodedString = readQRCode( args[0] , "UTF-8",  hintMap);
        
        BufferedWriter writer = null;
        try {
            File logFile = new File(args[1]);            
            writer = new BufferedWriter(new FileWriter(logFile,false));
            writer.write(decodedString);//+"\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
        
        System.out.println("Successful decoding > \""+decodedString+"\"");
        //------------------------------------------------------
    }
    public static String readQRCode(String filePath, String charset, Map hintMap)
			throws FileNotFoundException, IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                        new BufferedImageLuminanceSource(
                                        ImageIO.read(new FileInputStream(filePath)))));
        Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap,
                        hintMap);
        return qrCodeResult.getText();

    }
}
