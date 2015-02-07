/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis.sistema.de.control;

import DAO.LocalidadDAO;
import Modelo.Localidad;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ezequiel
 */
public class BuscarLocalidades extends javax.swing.JFrame {

    LocalidadDAO dloc = new LocalidadDAO();
    int nroFilas = 0;

    /**
     * Creates new form BuscarLocalidad
     */
    public BuscarLocalidades() {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txt_localidad = new java.awt.TextField();
        label2 = new java.awt.Label();
        btn_buscar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Localidad", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        label2.setAlignment(java.awt.Label.CENTER);
        label2.setText("LOCALIDAD");

        btn_buscar.setLabel("AGREGAR");
        btn_buscar.setName(""); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txt_localidad, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_localidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        List<Localidad> listalocalidades = null;

        if (!"".equals(txt_localidad.getText())) {
            //limpiarTabla(tabla);
            listalocalidades = dloc.obtenListaLocalidadesNombre(txt_localidad.getText());

            if (!listalocalidades.isEmpty()) {
                DefaultTableModel modeloDeMiTabla = (DefaultTableModel) tabla.getModel();
                for (Localidad l : listalocalidades) {
                    modeloDeMiTabla.addRow(new Object[nroFilas]);
                    tabla.setValueAt(l.getLocalidad(), nroFilas, 0);
                    tabla.setValueAt(l.getIdlocalidades(), nroFilas, 1);
                    nroFilas++;
                }
                nroFilas = 0;
            }
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (evt.getClickCount() == 2) {
            DefaultTableModel modeloDeMiTabla = (DefaultTableModel) tabla.getModel();
            int fila = tabla.rowAtPoint(evt.getPoint());
            int columna = tabla.columnAtPoint(evt.getPoint());
            if ((fila > -1) && (columna > -1)) {
                JOptionPane.showMessageDialog(null, modeloDeMiTabla.getValueAt(fila, columna).toString());
            }
        }

    }//GEN-LAST:event_tablaMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btn_buscar;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label2;
    private javax.swing.JTable tabla;
    private java.awt.TextField txt_localidad;
    // End of variables declaration//GEN-END:variables
}
