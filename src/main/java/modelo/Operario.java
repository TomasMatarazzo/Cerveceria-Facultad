package modelo;
import java.util.regex.*;

public class Operario {
    private String apellido;
    private String usuario;
    private String password;
    private boolean activo;

    public Operario(String apellido, String usuario, String password, boolean activo) throws Exception {
        this.apellido = apellido;
        this.setUsuario(usuario);
        this.setPassword(password);
        this.activo = activo;
    }

    public String getApellido() {
        return apellido;
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

    public void setUsuario(String usuario) throws Exception {
                this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
