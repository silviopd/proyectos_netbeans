package presentacion;

import util.Funciones;
import util.ImagenFondo;

public class FrmMenuPrincipal extends javax.swing.JFrame {

    public FrmMenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        /*Mostrar el nombre del usuario logueado*/
        this.lblUsuario.setText(Funciones.USUARIO_LOGUEADO);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.lblSucursal.setText(Funciones.EMPRESA_SELECCIONADA);
        this.setTitle(Funciones.NOMBRE_SOFTWARE + "[Menu Principal]");
        this.DeskpContenedor.setBorder(new ImagenFondo("extendido"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        DeskpContenedor = new javax.swing.JDesktopPane();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        lblUsuario = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        lblSucursal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuLineas = new javax.swing.JMenuItem();
        mnuCategorias = new javax.swing.JMenuItem();
        mnuArticulos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuProveedor = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnuCliente = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuDepartamento_Empresa = new javax.swing.JMenuItem();
        mnuCargos = new javax.swing.JMenuItem();
        mnuAreas = new javax.swing.JMenuItem();
        mnuPersonal = new javax.swing.JMenuItem();
        mnuUsuarios = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuSucursales = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuTipo_Comprobante = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuRegistro_Compras = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mnuRegistro_Ventas = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        mnuUsuario_ADMIN = new javax.swing.JMenuItem();
        mnuAcceso_Sucursales = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        mnuCambiar_Contraseña = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/articulos.png"))); // NOI18N
        jButton1.setToolTipText("Mantenimiento de Articulos");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        jButton2.setToolTipText("Mantenimiento de Clientes");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedor.png"))); // NOI18N
        jButton3.setToolTipText("Mantenimiento de Proveedores");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator10);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/compra.png"))); // NOI18N
        jButton4.setToolTipText("Registro de Compras");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas.png"))); // NOI18N
        jButton5.setToolTipText("Registro de Compras");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator9);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        jButton6.setToolTipText("Salir del sistema");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton6);

        javax.swing.GroupLayout DeskpContenedorLayout = new javax.swing.GroupLayout(DeskpContenedor);
        DeskpContenedor.setLayout(DeskpContenedorLayout);
        DeskpContenedorLayout.setHorizontalGroup(
            DeskpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DeskpContenedorLayout.setVerticalGroup(
            DeskpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        jToolBar2.setRollover(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bienvenido.png"))); // NOI18N
        jLabel1.setText("BIENVENIDO");
        jToolBar2.add(jLabel1);
        jToolBar2.add(jSeparator11);

        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario2.png"))); // NOI18N
        lblUsuario.setText("Usuario:");
        jToolBar2.add(lblUsuario);
        jToolBar2.add(jSeparator12);

        lblSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sucursales.png"))); // NOI18N
        lblSucursal.setText("Sucursal:");
        jToolBar2.add(lblSucursal);

        jMenu1.setText("Archivo");

        mnuLineas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lineas.png"))); // NOI18N
        mnuLineas.setText("Linea de Articulos");
        mnuLineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLineasActionPerformed(evt);
            }
        });
        jMenu1.add(mnuLineas);

        mnuCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categorias.png"))); // NOI18N
        mnuCategorias.setText("Categorias");
        mnuCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCategoriasActionPerformed(evt);
            }
        });
        jMenu1.add(mnuCategorias);

        mnuArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/almacen.png"))); // NOI18N
        mnuArticulos.setText("Articulos");
        mnuArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArticulosActionPerformed(evt);
            }
        });
        jMenu1.add(mnuArticulos);
        jMenu1.add(jSeparator1);

        mnuProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedor.png"))); // NOI18N
        mnuProveedor.setText("Proveedor");
        jMenu1.add(mnuProveedor);
        jMenu1.add(jSeparator6);

        mnuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        mnuCliente.setText("Cliente");
        jMenu1.add(mnuCliente);
        jMenu1.add(jSeparator2);

        mnuDepartamento_Empresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zona.png"))); // NOI18N
        mnuDepartamento_Empresa.setText("Departamento de la empresa");
        jMenu1.add(mnuDepartamento_Empresa);

        mnuCargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargos.png"))); // NOI18N
        mnuCargos.setText("Cargos");
        jMenu1.add(mnuCargos);

        mnuAreas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/areas.png"))); // NOI18N
        mnuAreas.setText("Areas");
        jMenu1.add(mnuAreas);

        mnuPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario2.png"))); // NOI18N
        mnuPersonal.setText("Personal");
        jMenu1.add(mnuPersonal);

        mnuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N
        mnuUsuarios.setText("Usuarios");
        jMenu1.add(mnuUsuarios);
        jMenu1.add(jSeparator3);

        mnuSucursales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sucursales.png"))); // NOI18N
        mnuSucursales.setText("Sucursales");
        mnuSucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSucursalesActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSucursales);
        jMenu1.add(jSeparator4);

        mnuTipo_Comprobante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas2.png"))); // NOI18N
        mnuTipo_Comprobante.setText("Tipo de Comprobante");
        jMenu1.add(mnuTipo_Comprobante);
        jMenu1.add(jSeparator5);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        mnuSalir.setText("Salir");
        jMenu1.add(mnuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Movimientos");

        mnuRegistro_Compras.setText("Registro de Compras");
        mnuRegistro_Compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistro_ComprasActionPerformed(evt);
            }
        });
        jMenu2.add(mnuRegistro_Compras);
        jMenu2.add(jSeparator7);

        mnuRegistro_Ventas.setText("Registro de Ventas");
        jMenu2.add(mnuRegistro_Ventas);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reportes");
        jMenuBar1.add(jMenu3);

        jMenu5.setText("Administracion de sistema");

        mnuUsuario_ADMIN.setText("Usuarios");
        jMenu5.add(mnuUsuario_ADMIN);

        mnuAcceso_Sucursales.setText("Acceso a Sucursales");
        jMenu5.add(mnuAcceso_Sucursales);
        jMenu5.add(jSeparator8);

        mnuCambiar_Contraseña.setText("Cambiar la contraseña");
        jMenu5.add(mnuCambiar_Contraseña);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Ayuda");

        jMenuItem1.setText("Manual de Usuario");
        jMenu4.add(jMenuItem1);

        jMenuItem2.setText("Acerca de");
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
            .addComponent(DeskpContenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeskpContenedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuLineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLineasActionPerformed
        FrmLineaListado obj = new FrmLineaListado();
        this.DeskpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_mnuLineasActionPerformed

    private void mnuSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSucursalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuSucursalesActionPerformed

    private void mnuRegistro_ComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistro_ComprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuRegistro_ComprasActionPerformed

    private void mnuCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCategoriasActionPerformed
        FrmCategoriaListado obj = new FrmCategoriaListado();
        this.DeskpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_mnuCategoriasActionPerformed

    private void mnuArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArticulosActionPerformed
        FrmArticulo obj = new FrmArticulo();
        this.DeskpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_mnuArticulosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DeskpContenedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuItem mnuAcceso_Sucursales;
    private javax.swing.JMenuItem mnuAreas;
    private javax.swing.JMenuItem mnuArticulos;
    private javax.swing.JMenuItem mnuCambiar_Contraseña;
    private javax.swing.JMenuItem mnuCargos;
    private javax.swing.JMenuItem mnuCategorias;
    private javax.swing.JMenuItem mnuCliente;
    private javax.swing.JMenuItem mnuDepartamento_Empresa;
    private javax.swing.JMenuItem mnuLineas;
    private javax.swing.JMenuItem mnuPersonal;
    private javax.swing.JMenuItem mnuProveedor;
    private javax.swing.JMenuItem mnuRegistro_Compras;
    private javax.swing.JMenuItem mnuRegistro_Ventas;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem mnuSucursales;
    private javax.swing.JMenuItem mnuTipo_Comprobante;
    private javax.swing.JMenuItem mnuUsuario_ADMIN;
    private javax.swing.JMenuItem mnuUsuarios;
    // End of variables declaration//GEN-END:variables
}
