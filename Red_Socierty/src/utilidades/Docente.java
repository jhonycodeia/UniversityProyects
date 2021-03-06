package utilidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Docente extends User implements Serializable{
    private String facultad;
    private ArrayList<String>cursos;
    private ArrayList<String> programas;
    private ArrayList<Experiencia> Experiencias;
    private ArrayList<String> seguidores;

    public Docente(String user, String name, String lastName, String pass, String email,
            String facultad, ArrayList<String> cursos, ArrayList<String> programas)
    {
        super(user, name, lastName, pass, email);
        this.cursos = cursos;
        this.programas = programas;
        Experiencias = new ArrayList<>();
        seguidores = new ArrayList<>();
    }
    
    public boolean Seguirdoc(String usuario){
        if(!seguidores.contains(usuario)){
            seguidores.add(usuario);
            return true;
        }
        else{
            seguidores.remove(usuario);
            return false;
        }
    }
    
    public void AddExperiencia(Experiencia experiencia){
        getExperiencias().add(experiencia);
    }
    
    

    /**
     * @return the facultad
     */
    public String getFacultad() {
        return facultad;
    }

    /**
     * @param facultad the facultad to set
     */
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    /**
     * @return the cursos
     */
    public ArrayList<String> getCursos() {
        return cursos;
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCursos(ArrayList<String> cursos) {
        this.cursos = cursos;
    }

    /**
     * @return the programas
     */
    public ArrayList<String> getProgramas() {
        return programas;
    }

    /**
     * @param programas the programas to set
     */
    public void setProgramas(ArrayList<String> programas) {
        this.programas = programas;
    }

    /**
     * @return the Experiencias
     */
    public ArrayList<Experiencia> getExperiencias() {
        return Experiencias;
    }

    /**
     * @param Experiencias the Experiencias to set
     */
    public void setExperiencias(ArrayList<Experiencia> Experiencias) {
        this.Experiencias = Experiencias;
    }

    /**
     * @return the seguidores
     */
    public ArrayList<String> getSeguidores() {
        return seguidores;
    }

    /**
     * @param seguidores the seguidores to set
     */
    public void setSeguidores(ArrayList<String> seguidores) {
        this.seguidores = seguidores;
    }
    
    
}
