package presentacion;

import java.awt.Dimension;
import java.sql.ResultSet;
import negocio.clsLinea;
import util.Funciones;

/**
 *
 * @author oscar fernando diaz
 */
public class FrmLineaListado extends javax.swing.JInternalFrame {

    private ResultSet resultado;

    public FrmLineaListado() {
        initComponents();
        cargarCampos();
        cargartabla();
        listar();
    }

    private void cargarCampos() {
        String campos[] = new clsLinea().obtenerCamposFiltro();
        cboListar.removeAllItems();
        for (int i = 0; i < campos.length; i++) {
            cboListar.addItem(campos[i]);
        }
    }

    private void cargartabla() {
        try {
            this.resultado = new clsLinea().listar();
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }

    private void listar() {
        try {
            String alineacion[] = {"C", "I"};
            int anchoColumnas[] = {80, 200};
            Funciones.llenarTablaBusqueda(tblListado, resultado, anchoColumnas, alineacion, this.cboListar.getSelectedItem().toString(), this.txtValorBusquedad.getText());
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblOpciones = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        cboListar = new javax.swing.JComboBox();
        txtValorBusquedad = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable(){
            public boolean isCellEditable(int fila,int columna){
                return false;
            }
        };

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
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

        tblOpciones.setRollover(true);

        jLabel1.setText("Buscar:");
        tblOpciones.add(jLabel1);

        cboListar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tblOpciones.add(cboListar);

        txtValorBusquedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorBusquedadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorBusquedadKeyTyped(evt);
            }
        });
        tblOpciones.add(txtValorBusquedad);
        tblOpciones.add(jSeparator1);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add2.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setFocusable(false);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        tblOpciones.add(btnAgregar);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        tblOpciones.add(btnEditar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        tblOpciones.add(btnEliminar);

        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        btnRefrescar.setText("Refrescar     ");
        btnRefrescar.setFocusable(false);
        btnRefrescar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRefrescar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        tblOpciones.add(btnRefrescar);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setFocusable(false);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        tblOpciones.add(btnSalir);

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tblOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmLineaAregarEditar obj = new FrmLineaAregarEditar(null, true);
        obj.setTitle("Agregar nueva linea");
        obj.setVisible(true);
        Funciones.mensajeInformacion(String.valueOf(obj.accion), "Accion");
        if (obj.accion == 1) {
            try {
                clsLinea objlinea = new clsLinea();
                //objlinea.setCodigoLinea(Integer.valueOf(obj.txtCodigo.getText()));
                objlinea.setDescripcion((obj.txtDescripcion.getText()).toLowerCase());
                if (objlinea.agregar() == true) {
                    this.cargartabla();
                    this.listar();
                }
            } catch (Exception e) {
                Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed

    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        this.cboListar.setPreferredSize(new Dimension(100, 25));
        this.txtValorBusquedad.setPreferredSize(new Dimension(150, 25));
        tblOpciones.add(cboListar, 1);
        tblOpciones.add(txtValorBusquedad, 1);
        listar();
    }//GEN-LAST:event_formInternalFrameActivated

    private void txtValorBusquedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorBusquedadKeyTyped

    }//GEN-LAST:event_txtValorBusquedadKeyTyped

    private void txtValorBusquedadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorBusquedadKeyReleased
        listar();
    }//GEN-LAST:event_txtValorBusquedadKeyReleased

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = this.tblListado.getSelectedRow();
        if (fila < 0) {
            Funciones.mensajeError("Debe seleccionar una fila", Funciones.NOMBRE_SOFTWARE);
            return;
        }

        int codigoLinea = Integer.parseInt(this.tblListado.getValueAt(fila, 0).toString());
        clsLinea obj = new clsLinea();
        try {
            ResultSet resultado = obj.leerDatos(codigoLinea);
            if (resultado.next()) {
                FrmLineaAregarEditar objFrm = new FrmLineaAregarEditar(null, true);
                objFrm.setTitle("Editar");
                objFrm.txtCodigo.setText(String.valueOf(resultado.getInt("codigo_linea")));
                objFrm.txtDescripcion.setText(resultado.getString("descripcion"));
                objFrm.setVisible(true);

                if (objFrm.accion == 1) {
                    try {
                        obj.setDescripcion(objFrm.txtDescripcion.getText());
                        obj.setCodigoLinea(Integer.parseInt(objFrm.txtCodigo.getText()));
                        if (obj.editar()) {
                            this.cargartabla();
                            this.listar();
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }

        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        if (evt.getClickCount() == 2) {
            this.btnEditar.doClick();
        }
    }//GEN-LAST:event_tblListadoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = this.tblListado.getSelectedRow();
        if (fila < 0) {
            Funciones.mensajeError("Debe seleccionar una fila", Funciones.NOMBRE_SOFTWARE);
            return;
        }

        int codigoLinea = Integer.parseInt(this.tblListado.getValueAt(fila, 0).toString());
        clsLinea obj = new clsLinea();
        int r= Funciones.mensajeConfirmacion("esta seguro de eliminar el registro de la tabla", "confirmacion");
        if (r==0) {
            try {
                obj.setCodigoLinea(codigoLinea);
                if (obj.eliminar()) {
                    this.cargartabla();
                    this.listar();
                }
            } catch (Exception e) {
                Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTable tblListado;
    private javax.swing.JToolBar tblOpciones;
    private javax.swing.JTextField txtValorBusquedad;
    // End of variables declaration//GEN-END:variables
}
