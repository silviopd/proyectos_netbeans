package presentacion;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import negocio.InicioSesion;
import negocio.*;
import util.Funciones;

public class FrmSesion extends javax.swing.JFrame {
String ruta="E:\\proyectos_netbeans\\COMERCIAL_ultimo\\Cargar.ini";
    private int cantidadIntentos;
    INI objA;
    int nume;

    public FrmSesion() throws Exception {
        initComponents();
        llenarCombo();
        CREATEini();
        cargaarNI();
        this.setLocationRelativeTo(null);
        this.txtEmail.requestFocus();
        this.mostrarPanelSeguridad(false);
    }
private void CREATEini(){
    try {
        File archi=new File(ruta);
        if (!archi.exists()) {
            archi.createNewFile();
            PrintWriter pw = new PrintWriter(archi);

            pw.println("[DB]");
            pw.println("correo = ");
            pw.println("contraseña = ");
            pw.println("combo = ");
            pw.println("bandera = ");

            pw.flush();
        }else{
            
        }
    } catch (Exception e) {
        System.out.println("error al crear: "+e.getMessage());
    }
}
    private void cargaarNI() throws Exception {
        try {
            String nume = objA.leerBandera();
            if (nume.equals("1")) {
                this.txtEmail.setText(objA.leerCorreo());
                this.txtClave.setText(objA.leerContraseña());
                this.cboSucursal.setSelectedIndex(Integer.valueOf(objA.leerCombo()));
            }else{
                objA.Guardar(null, null, null, "0");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void generarAleatorio() {
        String valor = String.valueOf(Math.random()).substring(3, 9);
        this.lblCodigoGenerado.setText(valor);
    }

    private void mostrarPanelSeguridad(boolean flag) {
        this.pnSeguridad.setVisible(flag);
        if (flag) {
            this.setSize(this.getWidth(), 450);
        } else {
            this.setSize(this.getWidth(), 350);
        }
    }

    private boolean validarCodigoSeguridad() {
        if (this.lblCodigoGenerado.getText().equalsIgnoreCase(this.txtCodigoIngresado.getText())) {
            return true;
        }
        return false;
    }

    private void llenarCombo() {
        try {
            new Sucursal().llenarCombo(cboSucursal);
            //cboSucursal.setSelectedIndex(7);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Acceso al sistema",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboSucursal = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        pnSeguridad = new javax.swing.JPanel();
        lblCodigoGenerado = new javax.swing.JLabel();
        txtCodigoIngresado = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Sucursal:");

        cboSucursal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboSucursal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSucursalActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Clave:");

        btnIngresar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ok.png"))); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIngresar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 28)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inicio_sesion.png"))); // NOI18N
        jLabel4.setText("Sistema Comercial");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClaveKeyPressed(evt);
            }
        });

        pnSeguridad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese el código de seguridad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        lblCodigoGenerado.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCodigoGenerado.setForeground(new java.awt.Color(204, 0, 0));
        lblCodigoGenerado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodigoGenerado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblCodigoGenerado.setPreferredSize(new java.awt.Dimension(4, 30));

        txtCodigoIngresado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCodigoIngresado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoIngresado.setPreferredSize(new java.awt.Dimension(111, 25));
        txtCodigoIngresado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoIngresadoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnSeguridadLayout = new javax.swing.GroupLayout(pnSeguridad);
        pnSeguridad.setLayout(pnSeguridadLayout);
        pnSeguridadLayout.setHorizontalGroup(
            pnSeguridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSeguridadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSeguridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigoGenerado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigoIngresado, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnSeguridadLayout.setVerticalGroup(
            pnSeguridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSeguridadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodigoGenerado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCodigoIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir))
                    .addComponent(cboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtClave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(pnSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        try {

            /*Inicio: Validar ingreso de datos*/
            if (this.txtEmail.getText().equalsIgnoreCase("")) {
                this.txtEmail.requestFocus();
                return;
            } else if (this.txtClave.getText().equalsIgnoreCase("")) {
                this.txtClave.requestFocus();
                return;
            }

            /*Fin: Validar ingreso de datos*/
            InicioSesion objSesion = new InicioSesion();
            objSesion.setEmail(this.txtEmail.getText());
            objSesion.setClave(this.txtClave.getText());
            objSesion.setCodigoSucursal(
                    Sucursal.listaSucursales.get(
                            this.cboSucursal.getSelectedIndex()
                    ).getCodigo()
            );

            int resultado = objSesion.iniciarSesionSP();

            switch (resultado) {
                case 0: //Usuario inactivo
                    JOptionPane.showMessageDialog(null, "El usuario se encuentra inactivo. Consulte con el administrador del sistema", "Inicio de sesión", JOptionPane.WARNING_MESSAGE);
                    break;

                case -1: //Error en el email o la clave
                    JOptionPane.showMessageDialog(null, "El email o la clave son incorrectos", "Inicio de sesión", JOptionPane.ERROR_MESSAGE);

                    /* Inicio: Validar cantidad de intentos*/
                    cantidadIntentos++;
                    if (cantidadIntentos >= 3) {
                        generarAleatorio();
                        mostrarPanelSeguridad(true);
                    }
                    /* Fin: Validar cantidad de intentos*/

                    //this.txtEmail.setText("");
                    this.txtClave.setText("");
                    this.txtEmail.requestFocus();
                    //this.cboSucursal.requestFocus();
                    break;

                case 1: //ingresa al sistema

                    /* Inicio: Validar código de seguridad*/
                    if (!this.validarCodigoSeguridad()) {
                        JOptionPane.showMessageDialog(null, "Código de seguridad incorrecto. Intentelo nuevamente", "Inicio de sesión", JOptionPane.WARNING_MESSAGE);
                        this.generarAleatorio();
                        this.txtCodigoIngresado.requestFocus();
                        return;
                    }
                    /* Fin: Validar código de seguridad*/
                    
                    objA.Guardar(this.txtEmail.getText().trim(), this.txtClave.getText().trim(),String.valueOf( this.cboSucursal.getSelectedIndex()), "1");
                    FrmMenuPrincipal objFrmMenu = new FrmMenuPrincipal();
                    objFrmMenu.setVisible(true);
                    
                    this.dispose();
                    break;

                case 2: //El usuario no esta autorizado a ingresar a una determinada sucursal o el estado es inactivo
                    JOptionPane.showMessageDialog(null, "Este usuario no esta autorizado para ingresar a esta sucursal o el estado está inactivo", "Inicio de sesión", JOptionPane.WARNING_MESSAGE);
                    this.txtEmail.requestFocus();
                    break;

            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.btnIngresar.doClick();
        }
    }//GEN-LAST:event_txtClaveKeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.txtClave.requestFocus();
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtCodigoIngresadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoIngresadoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.btnIngresar.doClick();
        }
    }//GEN-LAST:event_txtCodigoIngresadoKeyPressed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void cboSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSucursalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigoGenerado;
    private javax.swing.JPanel pnSeguridad;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtCodigoIngresado;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
