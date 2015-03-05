/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis.sistema.de.control;

import Controladora.UsuarioControladora;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author matias
 * @@ -16,11 +49,75 @@ public class TESISSISTEMADECONTROL {
    /
 **
 * @param args the command line arguments
 */
public class TESISSISTEMADECONTROL {


    public static void main(String[] args) throws WriterException {

        // TODO code application logic here
        UsuarioControladora ContUser = new UsuarioControladora();        
        Reader lector = new MultiFormatReader();        
        File ubicacionImagen = new File(System.getProperty("user.home") + "/qrcodeDemo.png");
        BufferedImage imagen;
        final Logueo frame = new Logueo();        
        frame.setVisible(true);
        if (ubicacionImagen.exists()) {
            try {                
                imagen = ImageIO.read(ubicacionImagen);
                LuminanceSource fuente = new BufferedImageLuminanceSource(imagen);
                BinaryBitmap mapaBits = new BinaryBitmap(new HybridBinarizer(fuente));
                try {
                    Result resultado = lector.decode(mapaBits);
                    System.out.println("Contenido del codigo = " + resultado.getText());
                } catch (ReaderException r) {
                    System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + r);
                    throw new ExceptionInInitializerError(r);
                }
            } catch (IOException ex) {
                System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + ex);
                throw new ExceptionInInitializerError(ex);
            }            
        }        
    }


}
