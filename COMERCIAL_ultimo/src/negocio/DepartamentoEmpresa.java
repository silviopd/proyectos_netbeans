package negocio;

import accesodatos.Conexion;
import java.sql.ResultSet;

public class DepartamentoEmpresa extends Conexion{
    
    public ResultSet listar() throws Exception{
        String sql = "select * from departamento_empresa";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        return resultado;
    }
    
}
