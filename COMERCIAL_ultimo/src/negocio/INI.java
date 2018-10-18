package negocio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.ini4j.*;
import presentacion.FrmSesion;
import util.Funciones;

/**
 *
 * @author oscar fernando diaz
 */
public class INI {

    private String correo;
    private String contraseña;
    private int combo;
    private int bandera;

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getCombo() {
        return combo;
    }

    public void setCombo(int combo) {
        this.combo = combo;
    }

    public static String leerContraseña() throws Exception {
        String filename = "E:\\proyectos_netbeans\\COMERCIAL_ultimo\\Cargar.ini";
        String pass = "";
        Ini ini = new Ini(new FileReader(filename));
        try {
            for (Ini.Section section : ini.values()) {
                for (String option : section.keySet()) {
                    if (option.equals("contraseña")) {
                        pass = section.fetch(option);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("leer contraseña error: " + e.getMessage());
        }
        return pass;
    }

    public static String leerCorreo() throws Exception {
        String filename = "E:\\proyectos_netbeans\\COMERCIAL_ultimo\\Cargar.ini";
        String pass = "";
        Ini ini = new Ini(new FileReader(filename));
        try {
            for (Ini.Section section : ini.values()) {
                for (String option : section.keySet()) {
                    if (option.equals("correo")) {
                        pass = section.fetch(option);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("leer correo error: " + e.getMessage());
        }
        return pass;
    }

    public static String leerCombo() throws Exception {
        String filename = "E:\\proyectos_netbeans\\COMERCIAL_ultimo\\Cargar.ini";
        String pass = "";
        Ini ini = new Ini(new FileReader(filename));
        try {
            for (Ini.Section section : ini.values()) {
                for (String option : section.keySet()) {
                    if (option.equals("combo")) {
                        pass = section.fetch(option);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("leer contraseña error: " + e.getMessage());
        }
        return pass;
    }

    public static String leerBandera() throws Exception {
        String flag = "";
        try {
            String filename = "E:\\proyectos_netbeans\\COMERCIAL_ultimo\\Cargar.ini";

            Ini ini = new Ini(new FileReader(filename));
            for (Ini.Section section : ini.values()) {
                for (String option : section.keySet()) {
                    if (option.equals("bandera")) {
                        if (section.fetch(option) == null) {
                            flag = "0";
                        } else {
                            flag = section.fetch(option);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "error a leer bandera");
        }
        return flag;
    }

    public static void Guardar(String pCorreo, String pContrasenia, String pCombo, String pBandera) throws Exception {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("E:\\proyectos_netbeans\\COMERCIAL_ultimo\\Cargar.ini");
            pw = new PrintWriter(fichero);
            
            pw.println("[DB]");
            pw.println("correo = " + pCorreo);
            pw.println("contraseña = " + pContrasenia);
            pw.println("combo = " + pCombo);
            pw.println("bandera = " + pBandera);

            pw.flush();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            fichero.close();
            pw.close();
        }
    }
}
