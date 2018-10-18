
package negocio;
import datos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class marca extends Conexion{
    
    private int codigo_marca;
    private String descripcion;
    
    public static ArrayList<marca> listaMarcas = new ArrayList<marca>(); 

    public int getCodigo_marca() {
        return codigo_marca;
    }

    public void setCodigo_marca(int codigo_marca) {
        this.codigo_marca = codigo_marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    private void cargarLista() throws Exception{
        String sql = "select codigo_marca,descripcion from marca order by 2";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        
        listaMarcas.clear();
        
        while (resultado.next()) {            
            marca obj = new marca();
            obj.setCodigo_marca(resultado.getInt("codigo_marca"));
            obj.setDescripcion(resultado.getString("descripcion"));
            listaMarcas.add(obj);
        }
    }
    
    
    public void cargarCombo(JComboBox objCombo) throws Exception{
        cargarLista();
        objCombo.removeAllItems();
        for (int i = 0; i < listaMarcas.size(); i++) {
            objCombo.addItem(listaMarcas.get(i).descripcion);
        }
    }
    
    
    public ResultSet listar() throws Exception{
        ResultSet resultado = null;
        String sql = "select * from marca order by descripcion";
        resultado = ejecutarSQLSelect(sql);
        return resultado;
        
//        return ejecutarSQLSelect("select * from linea");
    }
    
}
