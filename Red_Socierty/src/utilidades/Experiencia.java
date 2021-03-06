package utilidades;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.net.URL;
import java.text.DateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salas
 */
public class Experiencia implements Serializable{
    private String titulo;
    private String descripcion;
    private String curso;
    private String programa;
    private String facultad;
    private String texto;
    private Docente docente;
    private Date fecha;
    private ArrayList<String> etiquetas;
    private ArrayList<File> productosAsociados;
    private ArrayList<URL> enlaces;
    private ArrayList<Comentario> comentarios;
    private int numMegusta;
    ArrayList<String> likes; 
    ArrayList<String> shares; 
    
    public Experiencia(String titulo, String descripcion, String curso, String programa,
            String facultad, String texto,Docente docente, ArrayList<String> etiquetas,
            ArrayList<File> productosAsociados, ArrayList<URL> enlaces){
        
            fecha = new Date();
            this.titulo = titulo;
            this.descripcion = descripcion;
            this.curso = curso;
            this.programa = programa;
            this.facultad = facultad;
            this. texto = texto;
            this.docente = docente;
            this.etiquetas = etiquetas;
            this.productosAsociados = productosAsociados;
            this.enlaces = enlaces;
            this.numMegusta = 0;
            comentarios = new ArrayList<>();
            likes = new ArrayList<>();
            shares = new ArrayList<>();
    }
    
    public boolean ActionLike(User usuario){
        if(usuario.equals("")) return false;
        if(!likes.contains(usuario.getUsuario())){
            likes.add(usuario.getUsuario());
            numMegusta = likes.size();
            usuario.addMegusta();
            return true;
        }
        else{
            likes.remove(usuario.getUsuario());
            numMegusta = likes.size();
            usuario.removeMegusta();
            return false;
        }
    }
    
    public boolean ActionShare(String usuario){
        if(usuario.equals("")) return false;
        if(!shares.contains(usuario)){
            shares.add(usuario);
            return true;
        }
        else{
            shares.remove(usuario);
            return false;
        }
    }
     
    public void AddComentario(Comentario comentario){
        comentarios.add(comentario);
    }
   
    public boolean BorrarComentario(User user){
        for(Comentario c : comentarios){
            if(c.getUsuario()==user){
                user.removeComentario();
                return comentarios.remove(c);
            }
        }
        return false;
        
    }
    
    public String getInfoExperiencia(){
        return String.format("Título: %s\nDescripción: %s\nCurso: %s\n"
                + "Programa: %s\nFacultad: %s\n",titulo,descripcion,curso,programa,facultad);
    }
    
    @Override
    public String toString(){
        return String.format("Título: %s, Curso: %s, "
                + "Programa: %s\n",titulo,curso,programa);
    }
    
    public String[] getInfoTabla(){
        DateFormat formato = DateFormat.getDateInstance();
        String[] info = {titulo, docente.getNombre()+" "+docente.getApellido(), (String)formato.format(fecha)};
        return info;
    }
    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the programa
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(String programa) {
        this.programa = programa;
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
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the docente
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     * @param docente the docente to set
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the etiquetas
     */
    public ArrayList getEtiquetas() {
        return etiquetas;
    }

    /**
     * @param etiquetas the etiquetas to set
     */
    public void setEtiquetas(ArrayList etiquetas) {
        this.etiquetas = etiquetas;
    }

    /**
     * @return the productosAsociados
     */
    public ArrayList<File> getProductosAsociados() {
        return productosAsociados;
    }

    /**
     * @param productosAsociados the productosAsociados to set
     */
    public void setProductosAsociados(ArrayList<File> productosAsociados) {
        this.productosAsociados = productosAsociados;
    }

    /**
     * @return the enlaces
     */
    public ArrayList<URL> getEnlaces() {
        return enlaces;
    }

    /**
     * @param enlaces the enlaces to set
     */
    public void setEnlaces(ArrayList<URL> enlaces) {
        this.enlaces = enlaces;
    }

    /**
     * @return the comentarios
     */
    public ArrayList getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(ArrayList comentarios) {
        this.comentarios = comentarios;
    }
    
    /**
     * @return the likes
     */
    public ArrayList<String> getLikes() {
        return likes;
    }
    
    /**
     * @return the shares
     */
    public ArrayList<String> getShares() {
        return shares;
    }
     
    /**
     * @param likes the likes to set
     */
    public void setLikes(ArrayList<String> likes) {
        this.likes = likes;
    }
    
    /**
     * @return the numMegusta
     */
    public int getNumMegusta() {
        return numMegusta;
    }
}
