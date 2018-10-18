package negocio;


import accesodatos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Sucursal extends Conexion {

    private int codigo;
    private String nombre;
    private String direccion;
    private String telefono;

    public static ArrayList<Sucursal> listaSucursales
            = new ArrayList<Sucursal>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    private void cargarTabla() throws Exception {
        String sql = "select * from sucursal order by nombre";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        while (resultado.next()) {
            Sucursal objS = new Sucursal();
            objS.setCodigo(resultado.getInt("codigo_sucursal"));
            objS.setNombre(resultado.getString("nombre"));
            objS.setDireccion(resultado.getString("direccion"));
            objS.setTelefono(resultado.getString("telefono"));
            listaSucursales.add(objS);
        }

    }

    public void llenarCombo(JComboBox objCombo) throws Exception {
        this.cargarTabla();
        objCombo.removeAllItems();
        for (int i = 0; i < listaSucursales.size(); i++) {
            objCombo.addItem(listaSucursales.get(i).getNombre());
        }

    }
}
