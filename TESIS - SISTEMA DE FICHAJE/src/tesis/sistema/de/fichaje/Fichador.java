/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis.sistema.de.fichaje;

import Controladora.EmpleadoControladora;
import DAO.RegistroDAO;
import Modelo.Empleado;
import Modelo.Registro;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.qrcode.QRCodeMultiReader;
import com.rp.util.DateTime;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.core.Core;

/**
 *
 * @author Ezequiel
 */
public class Fichador extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private DaemonThread myThread = null;
    int count = 0;
    VideoCapture webSource = null;

    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();

    String File_path = "";
    String texto = "";

    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
//        public void run() {
//            synchronized (this) {
//                while (runnable) {
//                    if (webSource.grab()) {
//                        try {
//                            webSource.retrieve(frame);
//                            Highgui.imencode(".bmp", frame, mem);
//                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
//                            Result result = null;
//                            BufferedImage buff = (BufferedImage) im;
//                            Graphics g = jPanel1.getGraphics();
//                            LuminanceSource source = new BufferedImageLuminanceSource(buff);
//                            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
//                            try {                                
//                                result = new MultiFormatReader().decode(bitmap);  
//                                //this.wait(3000);
//                                webSource.release();
//                                tim.stop();
//                                texto = result.getText();
//                                final Saludo frame1 = new Saludo(texto, lbl_dia.getText(), lbl_hora.getText());
//                                frame1.setVisible(true);
//                                webSource = new VideoCapture(0);
//                                tim.start();
//                                this.wait(5005);
//                            } catch (NotFoundException e) {
//                                // fall thru, it means there is no QR code in image
//                                System.out.println("Error1");
//                            }
//
//                            if (g.drawImage(buff, 0, 0, getWidth(), getHeight() - 150, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
//                                if (runnable == false) {
//                                    System.out.println("Going to wait()");
//                                    this.wait();
//                                }
//                            }
//                        } catch (Exception ex) {
//                            System.out.println("Error");
//                        }
//                    }
//                }
//            }
//        }
        public void run() {
            synchronized (this) {
                while (runnable) {
                    if (webSource.grab()) {
                        try {
                            webSource.retrieve(frame);
                            Highgui.imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            BufferedImage buff = (BufferedImage) im;
                            Graphics g = jPanel1.getGraphics();
                            LuminanceSource source = new BufferedImageLuminanceSource(buff);
                            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                            Reader reader = new QRCodeMultiReader();
                            String sResult = "";

                            try {
                                Result result = reader.decode(bitmap);
                                webSource.release();
                                tim.stop();
                                sResult = result.getText();
                                if (!sResult.equals("")) {
                                    System.out.println("puto");
                                    final Saludo frame1 = new Saludo(sResult, lbl_dia.getText(), lbl_hora.getText());
                                    frame1.setVisible(true);
                                    sResult = "";
                                }
                                webSource = new VideoCapture(0);
                                tim.start();
                                this.wait(5005);
                                //System.out.println(sResult);
                            } catch (Exception ex) {
                                //System.out.println("Code Not Found");
                            }
                            try {
                                if (g.drawImage(buff, 0, 0, getWidth(), getHeight() - 150, 0, 0, buff.getWidth(), buff.getHeight(), null)) // if (g2.drawImage(buff2, 0, 0, getWidth(), getHeight() -150 , 0, 0, buff2.getWidth(), buff2.getHeight(), null))
                                {
                                    if (runnable == false) {
                                        System.out.println("Going to wait()");
                                        this.wait();
                                    }
                                }
                            } catch (InterruptedException ex) {
                                System.out.println(ex.getMessage());
                            }
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
            }
        }
    }

    public Fichador() {
        tim.start();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_hora = new javax.swing.JLabel();
        lbl_dia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(320, 240));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Gisha", 1, 24)); // NOI18N
        jLabel2.setText("Bienvenido al Sistema de Fichaje por Codigo QR");

        jLabel1.setFont(new java.awt.Font("Gisha", 1, 14)); // NOI18N
        jLabel1.setText("Aproxime su codigo QR y automaticamente sera identificado");

        lbl_hora.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N

        lbl_dia.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(164, 164, 164))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_hora, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(lbl_dia, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (myThread != null) {
            myThread.runnable = false;
            webSource.release();
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        if (webSource == null) {
            webSource = new VideoCapture(0);
            myThread = new DaemonThread();
            Thread t = new Thread(myThread);
            t.setDaemon(true);
            myThread.runnable = true;
            t.start();
        }
    }//GEN-LAST:event_formWindowActivated
    Timer tim = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            DateTime hora = new DateTime();
            Date now = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
            SimpleDateFormat format1 = new SimpleDateFormat ("HH:mm:ss");
            lbl_dia.setText(format.format(now));
            lbl_hora.setText(format1.format(now));         
        }
    });

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fichador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fichador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fichador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fichador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //System.loadLibrary("OpenCV");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Fichador.setDefaultLookAndFeelDecorated(true);
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception ex) {
                    System.out.println("Failed loading L&F: ");
                    System.out.println(ex);
                    System.out.println("Loading default Look & Feel Manager!");
                }

                new Fichador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_dia;
    private javax.swing.JLabel lbl_hora;
    // End of variables declaration//GEN-END:variables
}
