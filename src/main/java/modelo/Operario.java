package modelo;
import java.io.Serializable;
import java.util.regex.*;

<<<<<<< Updated upstream
public class Operario implements Comparable<Operario>{
=======
public class Operario implements Serializable {
>>>>>>> Stashed changes
    private String apellido;
    private String usuario;
    private String password;
    private boolean activo;
    private boolean administrador = false; // true si es administrador

    public Operario(String apellido, String usuario, String password, boolean activo) {
        this.apellido = apellido;
        this.setUsuario(usuario);
        this.setPassword(password);
        this.activo = activo;
    }

    public String getApellido() {
        return apellido;
    }

    public boolean esAdministrador(){
        return this.administrador;
    }

    public void setAdministrador(){
        this.administrador = true;
    }
    public void setApellido(String apellido) {
            this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


    @Override
    public int compareTo(Operario o) {
        return this.apellido.equalsIgnoreCase(o.apellido) ? 0 : 1;
    }
}
