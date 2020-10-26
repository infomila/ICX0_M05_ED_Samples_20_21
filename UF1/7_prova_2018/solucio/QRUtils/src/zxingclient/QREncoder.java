package zxingclient;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.imageio.ImageIO;


/**
 *
 * @author bernat
 */
public class QREncoder {
    	public static void main(String[] args) throws IOException, FileNotFoundException, NotFoundException {
            
            if(args.length<2) {
                System.out.println("Error en els paràmetres. Us: [arxiu_que_conte_missatge] [nom_imatge_QR]");
                return;
            }
           try {
                String myCodeText = readLineByLineJava8(args[0]);

                String fileType = "png";
                String filePath = args[1];
                if(!filePath.endsWith(fileType)){
                    System.out.println("Error en els paràmetres. Només es suporten *.png");
                    return;
                }

                int size = 250;

                File myFile = new File(filePath);

                Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
                hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

                // Now with zxing version 3.2.1 you could change border size (white border size to just 1)
                hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
                hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

                QRCodeWriter qrCodeWriter = new QRCodeWriter();
                BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, size,
                                size, hintMap);
                int CrunchifyWidth = byteMatrix.getWidth();
                BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
                                BufferedImage.TYPE_INT_RGB);
                image.createGraphics();

                Graphics2D graphics = (Graphics2D) image.getGraphics();
                graphics.setColor(Color.WHITE);
                graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
                graphics.setColor(Color.BLACK);

                for (int i = 0; i < CrunchifyWidth; i++) {
                        for (int j = 0; j < CrunchifyWidth; j++) {
                                if (byteMatrix.get(i, j)) {
                                        graphics.fillRect(i, j, 1, 1);
                                }
                        }
                }
                ImageIO.write(image, fileType, myFile);
            
                System.out.println("\n\nYou have successfully created QR Code.");
                
            } catch (WriterException e) {
                    e.printStackTrace();
            } catch (IOException e) {
                    e.printStackTrace();
            }
            //------------------------------------------------------
    }
        
    private static String readLineByLineJava8(String filePath) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        return new String(encoded, "UTF-8");
  /*
        StringBuilder contentBuilder = new StringBuilder();
 
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            throw e;
        }
 
        return contentBuilder.toString().trim();*/
    }        
        
}
