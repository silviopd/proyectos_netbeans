/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.ResultSet;
import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class articulo extends Conexion{
    
    private int codigo_articulo;
    private String nombre;
    private double precio;
    private int codigo_linea;
    private int codigo_categoria;
    private int codigo_marca;
    private int stock;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(int codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo_linea() {
        return codigo_linea;
    }

    public void setCodigo_linea(int codigo_linea) {
        this.codigo_linea = codigo_linea;
    }

    public int getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(int codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }

    public int getCodigo_marca() {
        return codigo_marca;
    }

    public void setCodigo_marca(int codigo_marca) {
        this.codigo_marca = codigo_marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
    public ResultSet listar() throws Exception{
        //String sql = "select codigo_articulo,nombre,precio_venta,stock from articulo order by nombre";
        String sql = "SELECT   articulo.codigo_articulo,   articulo.nombre,   articulo.precio_venta precio,   linea.descripcion as linea,    categoria.descripcion as categoria,     marca.descripcion as marca,   articulo.stock ,articulo.estado FROM   public.articulo,   public.categoria,   public.linea,  public.marca WHERE   articulo.codigo_categoria = categoria.codigo_categoria AND  articulo.codigo_marca = marca.codigo_marca AND  categoria.codigo_linea = linea.codigo_linea order by 2";
       PreparedStatement sentencia = abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultado = ejecutarSQLSelectSP(sentencia);
        return resultado;
        
//        return ejecutarSQLSelect("select * from linea");
    }
    
     public String[] obtenerCamposBusqueda() {
        String campos[] = {"codigo_articulo", "nombre", "precio","linea","categoria","marca","stock","estado"};
        return campos;
    }
     
     
    public boolean agregar() throws Exception {
        String sql = "select * from f_generar_correlativo('articulo') as numero";
        ResultSet resultado = ejecutarSQLSelect(sql);

        if (resultado.next()) {
            int nuevoCodigo = resultado.getInt("numero");
            setCodigo_articulo(nuevoCodigo);

            Connection transaccion = abrirConexion();
            transaccion.setAutoCommit(false);

            sql = "INSERT INTO articulo(codigo_articulo, nombre, precio_venta, codigo_categoria, codigo_marca, stock,estado)  VALUES (?, ?, ?, ?, ?, ?,?);";
            PreparedStatement sentencia1 = transaccion.prepareStatement(sql);
            sentencia1.setInt(1, this.getCodigo_articulo());
            sentencia1.setString(2, this.getNombre());
            sentencia1.setDouble(3, this.getPrecio());
            sentencia1.setInt(4, this.getCodigo_categoria());
            sentencia1.setInt(5, this.getCodigo_marca());
            sentencia1.setInt(6, this.getStock());
            sentencia1.setString(7, this.getEstado());
            this.ejecutarSQL(sentencia1, transaccion);

            sql = "UPDATE correlativo SET numero=numero+1 WHERE tabla=?";
            PreparedStatement sentencia2 = transaccion.prepareStatement(sql);
            sentencia2.setString(1, "articulo");
            this.ejecutarSQL(sentencia2, transaccion);

            transaccion.commit();
            transaccion.close();
        } else {
            throw new Exception("No existe un correlativo registrado para la tabla articulo");
        }
        return true;
    }
    
    public ResultSet leerDatos(int cod_cat) throws Exception {
        String sql = "SELECT   articulo.codigo_articulo,   articulo.nombre,   articulo.precio_venta precio,   linea.descripcion as linea,    categoria.descripcion as categoria,     marca.descripcion as marca,   articulo.stock,articulo.estado FROM   public.articulo,   public.categoria,   public.linea,  public.marca WHERE   articulo.codigo_categoria = categoria.codigo_categoria AND  articulo.codigo_marca = marca.codigo_marca AND  categoria.codigo_linea = linea.codigo_linea and codigo_articulo=?";       
        PreparedStatement sentencia = abrirConexion().prepareStatement(sql);
        sentencia.setInt(1, cod_cat);
        return ejecutarSQLSelectSP(sentencia);
    }
    
    public ResultSet estado(int cod_estado) throws Exception {
        String sql = "select estado from articulo where codigo_articulo=?";       
        PreparedStatement sentencia = abrirConexion().prepareStatement(sql);
        sentencia.setInt(1, cod_estado);
        return ejecutarSQLSelectSP(sentencia);
    }
    
    public boolean editar() throws Exception {
        Connection transaccion = abrirConexion();
        transaccion.setAutoCommit(false);

        String sql = "UPDATE articulo  SET nombre=?, precio_venta=?, codigo_categoria=?, codigo_marca=?, stock=?,estado=? WHERE codigo_articulo=?;";
        
        PreparedStatement sentencia = transaccion.prepareStatement(sql);
        sentencia.setString(1,getNombre());
        sentencia.setDouble(2,getPrecio());
        sentencia.setInt(3,getCodigo_categoria());
        sentencia.setInt(4,getCodigo_marca());
        sentencia.setInt(5,getStock());
        sentencia.setString(6,getEstado());        
        sentencia.setInt(7,getCodigo_articulo());
        
        this.ejecutarSQL(sentencia, transaccion);
        transaccion.commit();
        transaccion.close();
        
        return true;
    }
    
    public boolean eliminar() throws Exception {
        Connection transaccion = abrirConexion();
        transaccion.setAutoCommit(false);

        String sql = "delete from articulo where codigo_articulo=?";
        
        PreparedStatement sentencia = transaccion.prepareStatement(sql);
        sentencia.setInt(1,getCodigo_articulo());
        
        this.ejecutarSQL(sentencia, transaccion);
        transaccion.commit();
        transaccion.close();
        
        return true;
    }
     
}
