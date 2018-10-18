package negocio;


import accesodatos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.Funciones;

public class InicioSesion extends Conexion{
    private String email;
    private String clave;
    private int codigoSucursal;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }
    
    public int iniciarSesion() throws Exception{
        String sql = "select "
                + "p.apellido_paterno, "
                + "p.apellido_materno, "
                + "p.nombres, "
                + "p.dni, "
                + "u.estado "
                + "from personal p "
                + "inner join usuario u on ( p.dni = u.dni_usuario ) "
                + "where p.email = '"+ this.getEmail() +"' "
                + "and u.clave = md5('"+this.getClave()+"')";
        System.out.println(sql);
        
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        if (resultado.next()){
            if (resultado.getString("estado").equalsIgnoreCase("I") ){
                return 0;
            }else{
                return 1;
            }
        }
        
        return -1;
        
    }
    
    public int iniciarSesionSP() throws Exception{
        String sql = "select "
                + "p.apellido_paterno, "
                + "p.apellido_materno, "
                + "p.nombres, "
                + "p.dni, "
                + "u.estado,"
                + "u.codigo_usuario "
                + "from personal p "
                + "inner join usuario u on ( p.dni = u.dni_usuario ) "
                + "where p.email = ? "
                + "and u.clave = md5( ? )";
        
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setString(1, this.getEmail());
        sentencia.setString(2, this.getClave());
        
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        
        if (resultado.next()){
            if (resultado.getString("estado").equalsIgnoreCase("I") ){
                return 0;
            }else{
                if (this.validarSucursal( resultado.getInt("codigo_usuario") ) == true ){
                    Funciones.USUARIO_LOGUEADO=resultado.getString("apellido_paterno")+" "+resultado.getString("apellido_materno")+" "+resultado.getString("nombres");
                    return 1;
                }else{
                    return 2;
                }
                
            }
        }
        
        return -1;
        
    }
    
    private boolean validarSucursal(int codigoUsuario) throws Exception{
        String sql  = "select * "
                + "from usuario_sucursal "
                + "where codigo_usuario = ? "
                + "and codigo_sucursal = ? "
                + "and estado = 'A'";
        
        PreparedStatement sentencia = 
                this.abrirConexion().prepareStatement(sql);
        sentencia.setInt(1, codigoUsuario);
        sentencia.setInt(2, this.getCodigoSucursal());
        
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        
        if (resultado.next()){ 
            return true; //Cuando el usuario esta registrado en una sucursal y ademas esta en estado activo 'A'
        }
        
        return false; //Cuando el usuario n o esta registrado en la sucursal o esta en estado inactivo 'I'
    }
    
    
    
}
