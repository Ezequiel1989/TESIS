/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis.sistema.de.control;

import Controladora.UsuarioControladora;
import DAO.UsuarioDAO;
import Modelo.Usuario;
import com.google.zxing.BarcodeFormat;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.hibernate.HibernateException;

/**
 *
 * @author matias
 */
public class TESISSISTEMADECONTROL {

    /**
     * @param args the command line arguments
     */
    private static final String FORMATO_IMAGEN = "png";
    private static final String RUTA_IMAGEN = System.getProperty("user.home") + "/qrZxing.png";
    private static final int ancho = 500;
    private static final int alto = 500;
    private static String datos = "http://monillo007.blogspot.com";

    public static void main(String[] args) throws WriterException {

        // TODO code application logic here
        UsuarioControladora ContUser = new UsuarioControladora();
        Usuario confirmar = ContUser.confirmarUsuario("1", "1");
        System.out.println("usuario: " + confirmar.getUsuario() + "  password: " + confirmar.getPassword());
        Reader lector = new MultiFormatReader();
        File ubicacionImagen = new File(System.getProperty("user.home") + "/qrcodeDemo.png");
        BufferedImage imagen;

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
        BitMatrix bm;
        Writer writer = new QRCodeWriter();
        bm = writer.encode(datos, BarcodeFormat.QR_CODE, ancho, alto);
        BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < ancho; y++) {
            for (int x = 0; x < alto; x++) {
                int grayValue = (bm.get(x, y) ? 1 : 0) & 0xff;
                image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
            }
        }
        image = invertirColores(image);
        try {
            FileOutputStream qrCode = new FileOutputStream(RUTA_IMAGEN);
            ImageIO.write(image, FORMATO_IMAGEN, qrCode);
            qrCode.close();
            Desktop d = Desktop.getDesktop();
            d.open(new File(RUTA_IMAGEN));
        } catch (IOException x) {
            System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + x);
            throw new ExceptionInInitializerError(x);
        }
    }

    private static BufferedImage invertirColores(BufferedImage imagen) {
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                int rgb = imagen.getRGB(x, y);
                if (rgb == -16777216) {
                    imagen.setRGB(x, y, -1);
                } else {
                    imagen.setRGB(x, y, -16777216);
                }
            }
        }
        return imagen;
    }

}
