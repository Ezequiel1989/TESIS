/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis.sistema.de.control;

import DAO.EmpleadoDAO;
import DAO.LocalidadDAO;
import DAO.NovedadDAO;
import Modelo.Empleado;
import Modelo.Localidad;
import Modelo.Novedad;
import com.rp.util.DateTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ezequiel
 */
public class ABMNovedades extends javax.swing.JFrame {

    List<Empleado> listaempleados;
    List<Novedad> listanovedades;
    EmpleadoDAO demp = new EmpleadoDAO();
    LocalidadDAO dloc = new LocalidadDAO();
    int nroFilas = 0;
    Empleado empleado = null;
    NovedadDAO dnov = new NovedadDAO();

    /**
     * Creates new form ABMNovedade
     */
    public ABMNovedades() {
        initComponents();
        DateTime y = new DateTime();
        int ano = Integer.parseInt(y.getYear());
        ano = ano - 1;
        for (int x = 0; x < 5; x++) {
            cmb_ano.addItem(ano);
            ano = ano + 1;
        }
    }

    public void limpiar() {
        this.txt_nombre.setText("");
        this.txt_novedad.setText("");
        this.txt_empleado.setText("");
    }

    public void habilitar() {
        this.txt_nombre.enable(true);
    }

    public void deshabilitar() {
        this.txt_nombre.enable(false);
    }

    public void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    public void limpiarTabla1(JTable jTable1) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            int filas = jTable1.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_hasta = new javax.swing.JFormattedTextField();
        label9 = new java.awt.Label();
        txt_novedad = new java.awt.TextField();
        EMPLEADOS = new java.awt.Label();
        jButton2 = new javax.swing.JButton();
        txt_nombre = new java.awt.TextField();
        label6 = new java.awt.Label();
        chk_emp = new javax.swing.JCheckBox();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        txt_desde = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        label10 = new java.awt.Label();
        txt_empleado = new java.awt.TextField();
        jSeparator1 = new javax.swing.JSeparator();
        EMPLEADOS1 = new java.awt.Label();
        label11 = new java.awt.Label();
        label12 = new java.awt.Label();
        cmb_mes = new javax.swing.JComboBox();
        cmb_ano = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(651, 800));
        setMinimumSize(new java.awt.Dimension(651, 800));

        txt_hasta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txt_hasta.setToolTipText("Ej: 01/01/2015");

        label9.setAlignment(java.awt.Label.CENTER);
        label9.setText("NOVEDAD");

        EMPLEADOS.setAlignment(java.awt.Label.CENTER);
        EMPLEADOS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EMPLEADOS.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        EMPLEADOS.setText("NOVEDADES");

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        label6.setAlignment(java.awt.Label.CENTER);
        label6.setText("BUSCAR POR NOMBRE");

        chk_emp.setText("Afecta a todos los empleados");

        label7.setAlignment(java.awt.Label.CENTER);
        label7.setText("DESDE");

        label8.setAlignment(java.awt.Label.CENTER);
        label8.setText("HASTA");

        txt_desde.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txt_desde.setToolTipText("Ej: 01/01/2015");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Documento", "Localidad", "Domicilio", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane1.setViewportView(tabla);

        label10.setAlignment(java.awt.Label.CENTER);
        label10.setText("EMPLEADO");

        txt_empleado.setEnabled(false);

        EMPLEADOS1.setAlignment(java.awt.Label.CENTER);
        EMPLEADOS1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EMPLEADOS1.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        EMPLEADOS1.setText("Consulta Novedades");

        label11.setAlignment(java.awt.Label.CENTER);
        label11.setText("DESDE");

        label12.setAlignment(java.awt.Label.CENTER);
        label12.setText("HASTA");

        cmb_mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jButton3.setText("Consultar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Desde", "Hasta", "Detalle", "Empleado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton4.setText("PDF");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chk_emp)
                                .addGap(51, 51, 51)
                                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_novedad, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(254, 254, 254)
                                                .addComponent(EMPLEADOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
                        .addGap(0, 39, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_ano, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton3)
                        .addGap(48, 48, 48)
                        .addComponent(jButton4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EMPLEADOS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EMPLEADOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chk_emp)
                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_novedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(EMPLEADOS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb_ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)
                        .addComponent(jButton4))
                    .addComponent(cmb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarTabla1(tabla);
        try {
            int mes = cmb_mes.getSelectedIndex() + 1;
            int year = Integer.parseInt((String) cmb_ano.getSelectedItem());
            listaempleados = demp.obtenListaEmpleadosNombre(txt_nombre.getText());
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            if (!listaempleados.isEmpty()) {
                DefaultTableModel modeloDeMiTabla = (DefaultTableModel) tabla.getModel();
                for (Empleado e : listaempleados) {
                    modeloDeMiTabla.addRow(new Object[nroFilas]);
                    tabla.setValueAt(e.getIdempleados(), nroFilas, 0);
                    tabla.setValueAt(e.getNombre(), nroFilas, 1);
                    tabla.setValueAt(e.getApellido(), nroFilas, 2);
                    Localidad oloc = dloc.obtenLocalidad(e.getOlocalidad().getIdlocalidades());
                    tabla.setValueAt(oloc.getLocalidad(), nroFilas, 4);
                    tabla.setValueAt(e.getDomicilio(), nroFilas, 5);
                    tabla.setValueAt(e.getTelefono(), nroFilas, 6);
                    tabla.setValueAt(e.getDocumento(), nroFilas, 3);
                    nroFilas++;
                }
                nroFilas = 0;

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        try {
            if (evt.getClickCount() == 2) {
                DefaultTableModel modeloDeMiTabla = (DefaultTableModel) tabla.getModel();
                int fila = tabla.rowAtPoint(evt.getPoint());
                int columna = tabla.columnAtPoint(evt.getPoint());
                if ((fila > -1) && (columna > -1)) {
                    Localidad oloc = dloc.obtenLocalidadNombre(modeloDeMiTabla.getValueAt(fila, 4).toString());
                    empleado = new Empleado(Long.parseLong(modeloDeMiTabla.getValueAt(fila, 0).toString()), modeloDeMiTabla.getValueAt(fila, 1).toString(), modeloDeMiTabla.getValueAt(fila, 2).toString(), modeloDeMiTabla.getValueAt(fila, 5).toString(), Long.parseLong(modeloDeMiTabla.getValueAt(fila, 6).toString()), Long.parseLong(modeloDeMiTabla.getValueAt(fila, 3).toString()), oloc);
                    txt_empleado.setText(empleado.getNombre() + " " + empleado.getApellido());
                    deshabilitar();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            if (chk_emp.isSelected()) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date desde = formatter.parse(txt_desde.getText());
                Date hasta = formatter.parse(txt_hasta.getText());
                if (desde.compareTo(hasta) <= 0) {
                    Localidad oloc = new Localidad();
                    Empleado e = new Empleado(Long.parseLong("0"), "", "", "", 0, 0, oloc);
                    Novedad nov = new Novedad(desde, hasta, txt_novedad.getText(), e);
                    dnov.guardaNovedad(nov);
                    JOptionPane.showMessageDialog(null, "Novedad Cargada Exitosamente");
                    limpiar();
                    limpiarTabla(tabla);
                    empleado = null;
                } else {
                    JOptionPane.showMessageDialog(null, "La fecha Hasta debe ser Mayor o Igual a la de Desde");
                }

            } else if (!chk_emp.isSelected() && empleado != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date desde = formatter.parse(txt_desde.getText());
                Date hasta = formatter.parse(txt_hasta.getText());
                if (desde.compareTo(hasta) <= 0) {
                    Novedad nov = new Novedad(desde, hasta, txt_novedad.getText(), empleado);
                    dnov.guardaNovedad(nov);
                    JOptionPane.showMessageDialog(null, "Novedad Cargada Exitosamente");
                    limpiar();
                    limpiarTabla(tabla);
                    empleado = null;
                } else {
                    JOptionPane.showMessageDialog(null, "La fecha Hasta debe ser Mayor o Igual a la de Desde");
                }
            } else if (!chk_emp.isSelected() && empleado == null) {
                JOptionPane.showMessageDialog(null, "Primero debe seleccionar un empleado para cargar la novedad");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        limpiarTabla1(jTable1);
        try {
            int mes = cmb_mes.getSelectedIndex() + 1;
            int year = Integer.parseInt(cmb_ano.getSelectedItem().toString());
            listanovedades = dnov.obtenListaNovedades(mes, year);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            if (!listanovedades.isEmpty()) {
                DefaultTableModel modeloDeMiTabla = (DefaultTableModel) jTable1.getModel();
                for (Novedad e : listanovedades) {
                    modeloDeMiTabla.addRow(new Object[nroFilas]);
                    jTable1.setValueAt(e.getIdnovedades(), nroFilas, 0);
                    jTable1.setValueAt(e.getFechainicio(), nroFilas, 1);
                    jTable1.setValueAt(e.getFechafin(), nroFilas, 2);
                    long ex = e.getOempleado().getIdempleados();
                    Empleado emp = demp.obtenEmpleado(ex);
                    jTable1.setValueAt(e.getObservaciones(), nroFilas, 3);
                    jTable1.setValueAt(emp.getNombre() + " " + emp.getApellido(), nroFilas, 4);
                    nroFilas++;
                }
                nroFilas = 0;

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int mes = cmb_mes.getSelectedIndex() + 1;
        int year = Integer.parseInt(cmb_ano.getSelectedItem().toString());
        dnov.report("listados\\prueba.jrxml", "Report-");
        //dnov.report("listados\\classic1.jrxml", "Report-");
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label EMPLEADOS;
    private java.awt.Label EMPLEADOS1;
    private javax.swing.JCheckBox chk_emp;
    private javax.swing.JComboBox cmb_ano;
    private javax.swing.JComboBox cmb_mes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private javax.swing.JTable tabla;
    private javax.swing.JFormattedTextField txt_desde;
    private java.awt.TextField txt_empleado;
    private javax.swing.JFormattedTextField txt_hasta;
    private java.awt.TextField txt_nombre;
    private java.awt.TextField txt_novedad;
    // End of variables declaration//GEN-END:variables
}
