/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author oscar fernando diaz
 */
public class clsArticulo extends Conexion {

    private int codigoArticulo;
    private String nombre;
    private double previoVenta;
    private String presentacion;
    private int CodigoCategoria;
    

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrevioVenta() {
        return previoVenta;
    }

    public void setPrevioVenta(double previoVenta) {
        this.previoVenta = previoVenta;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getCodigoCategoria() {
        return CodigoCategoria;
    }

    public void setCodigoCategoria(int CodigoCategoria) {
        this.CodigoCategoria = CodigoCategoria;
    }

    public String[] obtenerCamposFiltro() {
        String campos[] = {"codigo_articulo", "nombre", "presentacion", "linea", "categoria"};
        return campos;
    }

    public ResultSet listar() throws Exception {
        String sql = "select * from f_listar_articulo();";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }

    public boolean agregar() throws Exception {
        /*Inicio generando un nuevo correlativo*/
        String sql = "select * from f_generar_correlativo('linea') as correlativo";
        ResultSet rsCorrelativo = this.ejecutarSQLSelect(sql);

        int nummeroCorrelativo = 0;

        if (rsCorrelativo.next()) {
            nummeroCorrelativo = rsCorrelativo.getInt("correlativo");
            this.setCodigoArticulo(nummeroCorrelativo);
        } else {
            throw new Exception("No se ah configurado el correlativo para linea");
        }
        /*FIN*/

        /*Creando una nueva transaccion*/
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        /*Fin de crear la transaccion*/

        /*insertamos en la tabla linea*/
        sql = "INSERT INTO articulo(codigo_articulo, nombre, precio_venta, presentacion, codigo_categoria)VALUES (?, ?, ?, ?, ?);";
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setInt(1, getCodigoArticulo());
        sp.setString(2, getNombre());
        sp.setDouble(3, getPrevioVenta());
        sp.setString(4, getPresentacion());
        sp.setInt(5, getCodigoCategoria());
        this.ejecutarSQLsp(sp, con);
        /*FIN de la insercion de la tabla linea*/

        /*Inicio actualizar la tabla correlativo*/
        sql = "update correlativo set numero=? where tabla='articulo'";
        PreparedStatement spActualizarCorrelativo = con.prepareStatement(sql);
        spActualizarCorrelativo.setInt(1, getCodigoArticulo());
        this.ejecutarSQLsp(spActualizarCorrelativo, con);

        /*Inicio cerrando  la transaccion*/
        con.commit();
        con.close();
        /*FIn de cerrar la transaccion*/
        return true;

    }

    public ResultSet leerDatos(int codigoLinea) throws Exception {
        String sql = "select * from f_leer_datos_articulo(?);";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setInt(1, codigoArticulo);
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }

    public boolean editar() throws Exception {
        String sql = "UPDATE articulo SET nombre=?, precio_venta=?, presentacion=?, codigo_categoria=? WHERE codigo_articulo=?";
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setString(1, this.getNombre());
        sp.setDouble(2, this.previoVenta);
        sp.setString(3, this.presentacion);
        sp.setInt(4, this.CodigoCategoria);
        sp.setInt(5, this.codigoArticulo);
        this.ejecutarSQLsp(sp, con);

        con.commit();
        con.close();
        return true;
    }
    
        public boolean eliminar() throws Exception {
        String sql = "DELETE FROM articulo WHERE codigo_articulo=?";
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setInt(1, this.codigoArticulo);
        this.ejecutarSQLsp(sp, con);

        con.commit();
        con.close();
        return true;
    }
}
