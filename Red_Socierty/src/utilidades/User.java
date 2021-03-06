package utilidades;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
    private String usuario;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String correo;
    private ArrayList<Experiencia> compartidas; 
    private ArrayList<Integer> siguiendo;
    private ArrayList<Experiencia> meGusta;
    private int cantMegusta,cantComentarios;
    
    public User(String user, String name, String lastName, String pass, String email){
        usuario = user;
        nombre = name;
        apellido = lastName;
        contrasena = pass;
        correo = email;  
        compartidas = new ArrayList<>();
        siguiendo = new ArrayList<>();
        meGusta = new ArrayList<>();
        cantComentarios = 0;
        cantMegusta = 0;
    }
    
    public boolean Seguir(String usuario){
        for (int i = 0; i < redsocial.RedSocial.docentes.size(); i++) {
            if(usuario.equals(redsocial.RedSocial.docentes.get(i).getUsuario()))
                if(!siguiendo.contains(i)){
                    siguiendo.add(i);
                    return true;
                }else{
                    for (int j = 0; j < siguiendo.size(); j++) {
                        if(siguiendo.get(j)==i){
                            siguiendo.remove(j);
                            return false;
                        }
                    }
                }
        }
        return false;
    }
    
    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
//    public void setUsuario(String Usuario) {
//        this.usuario = Usuario;
//    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.correo = Correo;
    }
    
    public String toString(){
        return String.format("*****Usuario Registrado*****\nUsuario: %s\nNombre: %s\nApellido: %s\nCorreo: %s\n",usuario,nombre,apellido,correo);
    }

    /**
     * @return the compartidas
     */
    public ArrayList<Experiencia> getCompartidas() {
        return compartidas;
    }

    /**
     * @param compartidas the compartidas to set
     */
    public void setCompartidas(ArrayList<Experiencia> compartidas) {
        this.compartidas = compartidas;
    }
    
    /**
     * @return the siguiendo
     */
    public ArrayList<Integer> getSiguiendo() {
        return siguiendo;
    }

    /**
     * @param siguiendo the siguiendo to set
     */
    public void setSiguiendo(ArrayList<Integer> siguiendo) {
        this.siguiendo = siguiendo;
    }

    /**
     * @return the meGusta
     */
    public ArrayList<Experiencia> getMeGusta() {
        return meGusta;
    }

    
    public void addMeGusta(Experiencia exp){
        meGusta.add(exp);
    }
    public void removeMeGusta(Experiencia exp){
        meGusta.remove(exp);
    }

    /**
     * @return the cantMegusta
     */
    public int getRepresenta() {
        
        return cantComentarios+cantMegusta;
    }

    
    public void addMegusta() {
         cantMegusta++;
    }

    
    public int removeMegusta() {
        return cantMegusta--;
    }

    
    public void addComentario() {
        cantComentarios++;
    }
    
    public void removeComentario() {
        cantComentarios--;
    }
}
