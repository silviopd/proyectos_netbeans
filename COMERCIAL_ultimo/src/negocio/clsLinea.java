package negocio;


import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import negocio.*;

/**
 *
 * @author oscar fernando diaz
 */
public class clsLinea extends Conexion {

    public static ArrayList<clsLinea> listaLinea
            = new ArrayList<clsLinea>();
    private int codigoLinea;
    private String descripcion;

    public int getCodigoLinea() {
        return codigoLinea;
    }

    public void setCodigoLinea(int codigoLinea) {
        this.codigoLinea = codigoLinea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ResultSet listar() throws Exception {
        String sql = "select codigo_linea,descripcion from linea order by 2";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }

    public String[] obtenerCamposFiltro() {
        String campos[] = {"codigo_linea", "descripcion"};
        return campos;
    }

    public boolean agregar() throws Exception {
        /*Inicio generando un nuevo correlativo*/
        String sql = "select * from f_generar_correlativo('linea') as correlativo";
        ResultSet rsCorrelativo = this.ejecutarSQLSelect(sql);

        int nummeroCorrelativo = 0;

        if (rsCorrelativo.next()) {
            nummeroCorrelativo = rsCorrelativo.getInt("correlativo");
            this.setCodigoLinea(nummeroCorrelativo);
        } else {
            throw new Exception("No se ah configurado el correlativo para linea");
        }
        /*FIN*/

        /*Creando una nueva transaccion*/
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        /*Fin de crear la transaccion*/

        /*insertamos en la tabla linea*/
        sql = "insert into linea(codigo_linea,descripcion) values (?,?)";
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setInt(1, getCodigoLinea());
        sp.setString(2, getDescripcion());
        this.ejecutarSQLsp(sp, con);
        /*FIN de la insercion de la tabla linea*/

        /*Inicio actualizar la tabla correlativo*/
        sql = "update correlativo set numero=? where tabla='linea'";
        PreparedStatement spActualizarCorrelativo = con.prepareStatement(sql);
        spActualizarCorrelativo.setInt(1, getCodigoLinea());
        this.ejecutarSQLsp(spActualizarCorrelativo, con);

        /*Inicio cerrando  la transaccion*/
        con.commit();
        con.close();
        /*FIn de cerrar la transaccion*/
        return true;

    }

    public ResultSet leerDatos(int codigoLinea) throws Exception {
        String sql = "Select * from linea where codigo_linea=?";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setInt(1, codigoLinea);
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }

    public boolean editar() throws Exception {
        String sql = "update linea set descripcion=? where codigo_linea=?";
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setString(1, this.getDescripcion());
        sp.setInt(2, this.codigoLinea);
        this.ejecutarSQLsp(sp, con);

        con.commit();
        con.close();
        return true;
    }

    public boolean eliminar() throws Exception {
        String sql = "delete from linea where codigo_linea=?";
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setInt(1, this.codigoLinea);
        this.ejecutarSQLsp(sp, con);

        con.commit();
        con.close();
        return true;
    }

    private void cargarTabla() throws Exception {
        String sql = "select * from linea order by descripcion";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        while (resultado.next()) {
            clsLinea objS = new clsLinea();
            objS.setCodigoLinea(resultado.getInt("codigo_linea"));
            objS.setDescripcion(resultado.getString("descripcion"));
            listaLinea.add(objS);
        }

    }

    public void llenarCombo(JComboBox objCombo) throws Exception {
        listaLinea.clear();
        this.cargarTabla();
        objCombo.removeAllItems();
        for (int i = 0; i < listaLinea.size(); i++) {
            objCombo.addItem(listaLinea.get(i).getDescripcion());
        }

    }
}
