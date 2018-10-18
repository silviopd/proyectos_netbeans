package negocio;


import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class clsCategoria extends Conexion{
    private String codigo_categoria;
    private String descripcion;
    private String codigo_linea;
    
        public static ArrayList<clsCategoria> listaCategoria = 
            new ArrayList<clsCategoria>();

    public String getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(String codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo_linea() {
        return codigo_linea;
    }

    public void setCodigo_linea(String codigo_linea) {
        this.codigo_linea = codigo_linea;
    }
     public ResultSet listar() throws Exception {
        String sql = "select codigo_categoria,descripcion,codigo_linea from categoria order by 2";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }

    public String[] obtenerCamposFiltro() {
        String campos[] = {"codigo_categoria", "descripcion","codigo_linea"};
        return campos;
    }

    public boolean agregar() throws Exception {
        /*Inicio generando un nuevo correlativo*/
        String sql = "select * from f_generar_correlativo('categoria') as correlativo";
        ResultSet rsCorrelativo = this.ejecutarSQLSelect(sql);

        int nummeroCorrelativo = 0;

        if (rsCorrelativo.next()) {
            System.out.println("error agregar");
            nummeroCorrelativo = rsCorrelativo.getInt("correlativo");
            //this.setCodigoLinea(nummeroCorrelativo);
        } else {
            throw new Exception("No se ah configurado el correlativo para linea");
        }
        /*FIN*/

        /*Creando una nueva transaccion*/
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        /*Fin de crear la transaccion*/

        /*insertamos en la tabla linea*/
        sql = "insert into categoria(codigo_categoria,descripcion,codigo_linea) values (?,?,?)";
        PreparedStatement sp = con.prepareStatement(sql);
        //sp.setInt(1, getCodigoLinea());
        sp.setInt(1, Integer.parseInt(getCodigo_categoria()));
        sp.setString(2, getDescripcion());
        sp.setInt(3, Integer.parseInt(getCodigo_linea()));
        this.ejecutarSQLsp(sp, con);
        /*FIN de la insercion de la tabla linea*/

        /*Inicio actualizar la tabla correlativo*/
        sql = "update correlativo set numero=? where tabla='categoria'";
        PreparedStatement spActualizarCorrelativo = con.prepareStatement(sql);
       // spActualizarCorrelativo.setInt(1, getCodigoLinea());
        this.ejecutarSQLsp(spActualizarCorrelativo, con);

        /*Inicio cerrando  la transaccion*/
        con.commit();
        con.close();
        /*FIn de cerrar la transaccion*/
        return true;

    }

    public ResultSet leerDatos(int codigoLinea) throws Exception {
        String sql = "Select * from categoria where codigo_categoria=?";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setInt(1, codigoLinea);
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }
    public ResultSet leerCodigo(String codigoLinea) throws Exception {
        String sql = "Select codigo_linea from linea where descripcion=?";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setString(1, codigoLinea);
        System.out.println("3");
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }

//    public boolean editar() throws Exception {
//        String sql = "update linea set descripcion=? where codigo_linea=?";
//        Connection con = this.abrirConexion();
//        con.setAutoCommit(false);
//        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
//        sp.setString(1, this.getDescripcion());
//        sp.setInt(2, this.codigoLinea);
//        this.ejecutarSQLsp(sp, con);
//
//        con.commit();
//        con.close();
//        return true;
//    }
//    public boolean eliminar() throws Exception {
//        String sql = "delete from linea where codigo_linea=?";
//        Connection con = this.abrirConexion();
//        con.setAutoCommit(false);
//        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
//        sp.setInt(1, this.codigoLinea);
//        this.ejecutarSQLsp(sp, con);
//
//        con.commit();
//        con.close();
//        return true;
//    }
    private void cargarTabla() throws Exception{
        String sql = "select * from categoria order by descripcion";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        while(resultado.next()){
            clsCategoria objS = new clsCategoria();
            objS.setCodigo_categoria(resultado.getString("codigo_categoria"));
            objS.setDescripcion(resultado.getString("descripcion") );
            objS.setCodigo_linea(codigo_linea);
            listaCategoria.add(objS);
        }
        
    }
    
    public void llenarCombo( JComboBox objCombo ) throws Exception{
        this.cargarTabla();
        objCombo.removeAllItems();
        for (int i = 0; i < listaCategoria.size(); i++) {
            objCombo.addItem( listaCategoria.get(i).getDescripcion() );
        }
        
    }
    
}
