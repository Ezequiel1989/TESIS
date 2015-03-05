/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis.sistema.de.control;

import Controladora.EmpleadoControladora;
import Controladora.LocalidadControladora;
import Modelo.Empleado;
import Modelo.Localidad;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ezequiel
 */
public class ABMEmpleados extends javax.swing.JInternalFrame {

    LocalidadControladora dloc = new LocalidadControladora();
    EmpleadoControladora demp = new EmpleadoControladora();
    int nroFilas = 0;
    List<Empleado> listaempleados = null;
    Empleado empleado = null;

    /**
     * Creates new form ABMEmpleado
     */
    public ABMEmpleados() {

        initComponents();
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        cmb_localidad.removeAllItems();
        List<Localidad> listaLocalidades = null;
        listaLocalidades = dloc.obtenListaLocalidades();
        Iterator it = null;
        it = listaLocalidades.iterator();

        while (it.hasNext()) {

            Localidad l = (Localidad) it.next();
            cmb_localidad.addItem(l.getLocalidad());
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

        EMPLEADOS = new java.awt.Label();
        txt_nombre = new java.awt.TextField();
        label2 = new java.awt.Label();
        label1 = new java.awt.Label();
        txt_apellido = new java.awt.TextField();
        txt_domicilio = new java.awt.TextField();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        txt_telefono = new java.awt.TextField();
        label5 = new java.awt.Label();
        btn_agregar = new java.awt.Button();
        btn_modif = new java.awt.Button();
        btn_borrar = new java.awt.Button();
        cmb_localidad = new javax.swing.JComboBox();
        btn_nuevo = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txt_nombre1 = new java.awt.TextField();
        label6 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_documento = new java.awt.TextField();
        label7 = new java.awt.Label();
        btn_generador = new java.awt.Button();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Empleados");
        setMaximumSize(new java.awt.Dimension(701, 477));
        setMinimumSize(new java.awt.Dimension(701, 477));
        setPreferredSize(new java.awt.Dimension(701, 477));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        EMPLEADOS.setAlignment(java.awt.Label.CENTER);
        EMPLEADOS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EMPLEADOS.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        EMPLEADOS.setText("EMPLEADOS");

        txt_nombre.setEnabled(false);

        label2.setAlignment(java.awt.Label.CENTER);
        label2.setText("NOMBRE");

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setText("APELLIDO");

        txt_apellido.setEnabled(false);
        txt_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellidoActionPerformed(evt);
            }
        });

        txt_domicilio.setEnabled(false);

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setText("DOMICILIO");

        label4.setText("TELEFONO");

        txt_telefono.setEnabled(false);

        label5.setText("LOCALIDAD");

        btn_agregar.setLabel("GUARDAR");
        btn_agregar.setName(""); // NOI18N
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_modif.setLabel("MODIFICAR");
        btn_modif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifActionPerformed(evt);
            }
        });

        btn_borrar.setLabel("BORRAR");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        btn_nuevo.setLabel("NUEVO");
        btn_nuevo.setName(""); // NOI18N
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
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

        label6.setAlignment(java.awt.Label.CENTER);
        label6.setText("BUSCAR POR NOMBRE");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Para seleccionar una Localidad hacer Doble Click sobre la fila deseada");

        txt_documento.setEnabled(false);

        label7.setText("DOCUMENTO");

        btn_generador.setLabel("GENERAR QR CODE");
        btn_generador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(EMPLEADOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_nuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_modif, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_generador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_domicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_telefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_localidad, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_documento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txt_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton1)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(EMPLEADOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_domicilio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmb_localidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_generador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellidoActionPerformed
    public void limpiar() {
        this.txt_nombre.setText("");
        this.txt_apellido.setText("");
        this.txt_domicilio.setText("");
        this.txt_telefono.setText("");
        this.txt_nombre1.setText("");
        this.txt_documento.setText("");

    }

    public void habilitar() {
        this.txt_nombre.enable(true);
        this.txt_apellido.enable(true);
        this.txt_domicilio.enable(true);
        this.txt_telefono.enable(true);
        this.txt_documento.enable(true);
    }

    public void deshabilitar() {
        this.txt_nombre.enable(false);
        this.txt_apellido.enable(false);
        this.txt_domicilio.enable(false);
        this.txt_telefono.enable(false);
        this.txt_documento.enable(false);
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
    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        Localidad oloc = null;
        Empleado emp = null;
        try {
            if (!"".equals(txt_nombre.getText()) && !"".equals(txt_apellido.getText()) && !"".equals(txt_domicilio.getText()) && !"".equals(txt_telefono.getText()) && !"".equals(txt_documento.getText())) {
                if (empleado == null) {
                    oloc = dloc.obtenLocalidadNombre(cmb_localidad.getSelectedItem().toString());
                    emp = new Empleado(txt_nombre.getText(), txt_apellido.getText(), txt_domicilio.getText(), Long.valueOf(txt_telefono.getText()), Long.valueOf(txt_documento.getText()), oloc);
                    demp.guardaEmpleado(emp);
                    JOptionPane.showMessageDialog(null, "Empleado Cargado Exitosamente");
                    limpiar();
                    deshabilitar();
                    empleado = null;
                    limpiarTabla(tabla);
                } else {
                    oloc = dloc.obtenLocalidadNombre(cmb_localidad.getSelectedItem().toString());
                    empleado.setApellido(txt_apellido.getText());
                    empleado.setDomicilio(txt_domicilio.getText());
                    empleado.setNombre(txt_nombre.getText());
                    empleado.setOlocalidad(oloc);
                    empleado.setTelefono(Long.parseLong(txt_telefono.getText()));
                    empleado.setDocumento(Long.parseLong(txt_documento.getText()));
                    demp.actualizaEmpleado(empleado);
                    JOptionPane.showMessageDialog(null, "Empleado Modificado");
                    limpiar();
                    deshabilitar();
                    empleado = null;
                    limpiarTabla(tabla);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe Completar Todos Los Campos");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        cmb_localidad.removeAllItems();
        List<Localidad> listaLocalidades = null;
        listaLocalidades = dloc.obtenListaLocalidades();

        Iterator it = null;
        it = listaLocalidades.iterator();

        while (it.hasNext()) {

            Localidad l = (Localidad) it.next();
            cmb_localidad.addItem(l.getLocalidad());
        }// TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameActivated

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        limpiar();
        habilitar();
        txt_nombre.requestFocus();
        empleado = null;
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarTabla(tabla);
        try {
            listaempleados = demp.obtenListaEmpleadosNombre(txt_nombre1.getText());
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

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        // TODO add your handling code here:
        try {
            if (!"".equals(txt_nombre.getText()) && empleado != null) {
                demp.eliminaEmpleado(empleado);
                limpiarTabla(tabla);
                JOptionPane.showMessageDialog(null, "Empleado Eliminado Correctamente");
                limpiar();
                deshabilitar();
                empleado = null;
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un Empleado para Eliminarlo");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_btn_borrarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            DefaultTableModel modeloDeMiTabla = (DefaultTableModel) tabla.getModel();
            int fila = tabla.rowAtPoint(evt.getPoint());
            int columna = tabla.columnAtPoint(evt.getPoint());
            if ((fila > -1) && (columna > -1)) {
                Localidad oloc = dloc.obtenLocalidadNombre(modeloDeMiTabla.getValueAt(fila, 4).toString());
                empleado = new Empleado(Long.parseLong(modeloDeMiTabla.getValueAt(fila, 0).toString()), modeloDeMiTabla.getValueAt(fila, 1).toString(), modeloDeMiTabla.getValueAt(fila, 2).toString(), modeloDeMiTabla.getValueAt(fila, 5).toString(), Long.parseLong(modeloDeMiTabla.getValueAt(fila, 6).toString()), Long.parseLong(modeloDeMiTabla.getValueAt(fila, 3).toString()), oloc);
                txt_nombre.setText(empleado.getNombre());
                txt_apellido.setText(empleado.getApellido());
                txt_domicilio.setText(empleado.getDomicilio());
                txt_documento.setText(String.valueOf(empleado.getDocumento()));
                txt_telefono.setText(String.valueOf(empleado.getTelefono()));
                cmb_localidad.setSelectedItem(oloc.getLocalidad());
                deshabilitar();
            }
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void btn_modifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txt_nombre.getText()) && empleado != null) {
            habilitar();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Empleado para Modificarlo");
        }
    }//GEN-LAST:event_btn_modifActionPerformed

    private void btn_generadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generadorActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txt_nombre.getText()) && empleado != null) {
            final GeneradorQR frame = new GeneradorQR(empleado);
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Empleado para generar su codigo correspondiente");
        }
    }//GEN-LAST:event_btn_generadorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label EMPLEADOS;
    private java.awt.Button btn_agregar;
    private java.awt.Button btn_borrar;
    private java.awt.Button btn_generador;
    private java.awt.Button btn_modif;
    private java.awt.Button btn_nuevo;
    private javax.swing.JComboBox cmb_localidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private javax.swing.JTable tabla;
    private java.awt.TextField txt_apellido;
    private java.awt.TextField txt_documento;
    private java.awt.TextField txt_domicilio;
    private java.awt.TextField txt_nombre;
    private java.awt.TextField txt_nombre1;
    private java.awt.TextField txt_telefono;
    // End of variables declaration//GEN-END:variables

}
