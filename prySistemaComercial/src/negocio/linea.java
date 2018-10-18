
package negocio;
import datos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class linea extends Conexion{
    
    private int codigo_linea;
    private String descripcion;
    
    public static ArrayList<linea> listaLineas = new ArrayList<linea>(); 
    
    public int getCodigo_linea() {
        return codigo_linea;
    }

    public void setCodigo_linea(int codigo_linea) {
        this.codigo_linea = codigo_linea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    private void cargarLista() throws Exception{
        String sql = "select codigo_linea,descripcion from linea order by 2";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        
        listaLineas.clear();
        
        while (resultado.next()) {            
            linea obj = new linea();
            obj.setCodigo_linea(resultado.getInt("codigo_linea"));
            obj.setDescripcion(resultado.getString("descripcion"));
            listaLineas.add(obj);
        }
    }
    
    
    public void cargarCombo(JComboBox objCombo) throws Exception{
        cargarLista();
        objCombo.removeAllItems();
        for (int i = 0; i < listaLineas.size(); i++) {
            objCombo.addItem(listaLineas.get(i).descripcion);
        }
    }
    
    
    public ResultSet listar() throws Exception{
        ResultSet resultado = null;
        String sql = "select * from linea order by descripcion";
        resultado = ejecutarSQLSelect(sql);
        return resultado;
        
//        return ejecutarSQLSelect("select * from linea");
    }
    
}
