/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial;

import utilidades.Experiencia;
import utilidades.User;
import utilidades.Docente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import Estructuras.ArbolBinario;
import Estructuras.Grafo;
import Estructuras.Pila;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class RedSocial {
    
    public static Vector<User> usuarios = new Vector<>();
    public static Vector<Docente> docentes = new Vector<>();
    public static ArbolBinario Usuarios = new ArbolBinario();
    public static ArbolBinario Docentes = new ArbolBinario();
    public static ArbolBinario fechas = new ArbolBinario();
    public static ArbolBinario curso = new ArbolBinario();
    public static ArbolBinario programa = new ArbolBinario();
    public static ArbolBinario facultad = new ArbolBinario();
    public static ArbolBinario nombre = new ArbolBinario();
    public static ArbolBinario etiqueta = new ArbolBinario();
    public static User user;
    public static boolean conectado = false;
    
    public RedSocial(){
        cargar();
        crearArboles();
    }
    
    public String getUser_active() {
        if(user != null) return user.getUsuario();
        else return "";
    }
    
    public User getUserActive(){
        return user;
    }
    
    public Grafo getAllFollowers(){       
        Grafo g = new Grafo();
        for (int i = 0; i < docentes.size(); i++) {
            ArrayList list = docentes.get(i).getSeguidores();
            //System.out.println("List: "+list);
            //System.out.println(docentes.get(i).getUsuario());
            g.addLista(list,docentes.get(i).getUsuario());
        }        
        return g;
    }
    
    public ArrayList<Experiencia> recomendaciones(){
        if(user!=null)
            return recomendarPerfil(user);
        return recomendarGeneral();
    }
    
    private ArrayList<Experiencia> recomendarPerfil(User usuario){
        
        Pila experiencias = new Pila();
        
        for (int i = 0; i < usuario.getSiguiendo().size(); i++) {
            Docente doc = docentes.get(usuario.getSiguiendo().get(i));
            for (int j = 0; j < doc.getMeGusta().size(); j++) {
                Experiencia e = doc.getMeGusta().get(j);
                if(!experiencias.contiene(e)){
                    experiencias.agregar(e,1);
                }else{
                    experiencias.subirNivel(e);
                }
            }
        }
        ArrayList<Experiencia> recomendar = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Experiencia e = (Experiencia)experiencias.sacar();
            if(e!=null)
                recomendar.add(e);
            else{
                ArrayList<Experiencia> aux = recomendarGeneral();
                for (int j = 0; j < aux.size() ; j++) {
                    if(i==10)
                        return recomendar;
                    if(!recomendar.contains(aux.get(j)))
                        recomendar.add(aux.get(j));
                    i++;
                }
                return recomendar;
            }
        }
        return recomendar;
    }
        
    private ArrayList<Experiencia> recomendarGeneral(){
        Pila experiencias = new Pila();
        for (int i = 0; i < docentes.size(); i++) {
            Docente doc = docentes.get(i);
            for (int j = 0; j < doc.getExperiencias().size(); j++) {
                Experiencia e = doc.getExperiencias().get(j);
                experiencias.agregar(e,e.getLikes().size());
            }
        }
        ArrayList<Experiencia> recomendar = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Experiencia e = (Experiencia)experiencias.sacar();
            if(e!=null)
            recomendar.add(e);
        }
        
        return recomendar;
    }
        
    public static void crearArboles(){
        Usuarios = new ArbolBinario();
        Docentes = new ArbolBinario();
        fechas = new ArbolBinario();
        curso = new ArbolBinario();
        programa = new ArbolBinario();
        facultad = new ArbolBinario();
        nombre = new ArbolBinario();
        etiqueta = new ArbolBinario();
        
        for (int i = 0; i <usuarios.size(); i++) {
            Usuarios.insertar(usuarios.get(i).getUsuario(), i);
        }
        for(int i=0;i<docentes.size();i++){
            Docente docente = docentes.get(i);
            Docentes.insertar(docente.getUsuario(), i);
            for (int j = 0; j < docente.getExperiencias().size(); j++) {
                Experiencia experiencia = docente.getExperiencias().get(j);
                fechas.insertar(experiencia.getFecha(), i + ";" + j);
                curso.insertar(experiencia.getCurso(), i + ";" + j);
                programa.insertar(experiencia.getPrograma(), i + ";" + j);
                facultad.insertar(experiencia.getFacultad(), i + ";" + j);
                nombre.insertar(experiencia.getTitulo(), i + ";" + j);
                for (int k = 0; k < experiencia.getEtiquetas().size(); k++) {
                    etiqueta.insertar(experiencia.getEtiquetas().get(k), i + ";" + j);
                }
            }
        }
    }
    
    public static ArrayList<Experiencia> buscar(int option,Object elem){
        ArrayList<Experiencia> resultado = new ArrayList();
        if(option==0 || option==1 ||option==3 || option==4 || option==5 ||option==6){ //Para saber si busco una experiencia en particular
            ArrayList ids = new ArrayList();
            switch(option){ // Para ver en que arbol lo busco
                case 0: ids = nombre.buscar2(elem);break;
                case 1: ids = programa.buscar2(elem);break;
                case 3: ids = fechas.buscar2(elem);break;
                case 4: ids = facultad.buscar2(elem);break;
                case 5: ids = curso.buscar2(elem);break;
                case 6: ids = etiqueta.buscar2(elem);break;
            }
            
            //nombre.mostrarPreOrden();
            //System.out.println(ids);
            
            for (int i = 0; i < ids.size(); i++) { // todos las respuestas compatibles
                String[] posiciones = ids.get(i).toString().split(";");
                Docente docente = docentes.get(Integer.parseInt(posiciones[0])); // busca el docente en el vector
                resultado.add(docente.getExperiencias().get(Integer.parseInt(posiciones[1]))); // me busca la experiencia en el docente
            }
        }else if(option==2){// Si busco las experiencias de un docente
            ArrayList posicion = Docentes.buscar(elem);
            for (int i = 0; i < posicion.size(); i++) {
                Docente docente =docentes.get(Integer.parseInt(posicion.get(i).toString())); //me busca el docente en el vector
                resultado.addAll(docente.getExperiencias()); //me agrega todas las experiencias del docente
            }
        }
        return resultado;
    }
    
    public boolean agregarUsuario(User usuario){
       for(User c : usuarios){
           if(usuario.getUsuario().equals(c.getUsuario()))
               return false;
       }
       return usuarios.add(usuario);
    }
    
    public boolean agregarDocente(Docente docente){
       for(Docente c : docentes){
           if(docente.getUsuario().equals(c.getUsuario()))
               return false;
       }
       return docentes.add(docente);
    }
      
    public User iniciarSesion(String user, String pass){
        for(User u : usuarios){
            if(u.getUsuario().equals(user) && u.getContrasena().equals(pass)){
                return u;
            }
        }
        for(Docente d : docentes){
            if(d.getUsuario().equals(user) && d.getContrasena().equals(pass)){
                return d;
            }
        }
        return null;
    }
    
    public ArrayList<Experiencia> getAllExperiencias(){
        ArrayList<Experiencia> all_experiencias = new ArrayList<>();
        //System.out.println(docentes);
        for(int i = 0; i<docentes.size(); i++){
            ArrayList<Experiencia> experiencias = ((Docente)docentes.get(i)).getExperiencias();
            for(int idx = 0; idx<experiencias.size(); idx++){
                all_experiencias.add(experiencias.get(idx));
            }            
        }
        return all_experiencias;
    }
    
    public Experiencia getExperiencia(String title, String doc){
        ArrayList<Experiencia> all_experiencias = getAllExperiencias();
        for(Experiencia exp : all_experiencias){
            if(exp.getTitulo().equals(title)){
                String doc_name = exp.getDocente().getNombre()+" "+ exp.getDocente().getApellido(); 
                if(doc_name.equals(doc)) return exp;
            }            
        }
        return null;
    }
    
    public boolean existe(String user)
    {
        for(Docente d : docentes)
        {
            if(d.getUsuario().equals(user))
            {
                return true;
            }
        }
            return false;
    }
    
    public Experiencia getMayorGeneral(ArrayList<Experiencia> num) {
        int mayor = -1, valor = 0;
        Experiencia guardar = null;
        for (Docente docente : RedSocial.docentes) {
            for (Experiencia experiencia : docente.getExperiencias()) {
                valor = experiencia.getNumMegusta();
                if (!num.contains(experiencia)) {
                    if (mayor <= valor) {
                        mayor = experiencia.getNumMegusta();
                        guardar = experiencia;
                    }
                }
            }
        }
        num.add(guardar);

        return guardar;
    }
    
    public Experiencia getMayorComentarios(ArrayList<Experiencia> num) {
        int mayor = -1, valor = 0;
        Experiencia guardar = null;
        for (Docente docente : RedSocial.docentes) {
            for (Experiencia experiencia : docente.getExperiencias()) {
                valor = experiencia.getComentarios().size();
                if (!num.contains(experiencia)) {
                    if (mayor <= valor) {
                        mayor = experiencia.getNumMegusta();
                        guardar = experiencia;
                    }
                }
            }
        }
        num.add(guardar);

        return guardar;
    }
    
    public User getMayorInfluencia(ArrayList<User> num) {
        int mayor = -1, valor = 0;
        User guardar = null;
        for (Docente docente : RedSocial.docentes) {

            valor = docente.getRepresenta();
            if (!num.contains(docente)) {
                if (mayor <= valor) {
                    mayor = docente.getRepresenta();
                    guardar = docente;
                }
            }

        }
        for (User user : RedSocial.usuarios) {

            valor = user.getRepresenta();
            if (!num.contains(user)) {
                if (mayor <= valor) {
                    mayor = user.getRepresenta();
                    guardar = user;
                }
            }

        }
        
        num.add(guardar);

        return guardar;
    }
    
    public Docente getMayorSeguidor(ArrayList<Docente> num) {
        int mayor = -1, valor = 0;
        Docente guardar = null;
        for (Docente docente : RedSocial.docentes) {
            
                valor = docente.getSeguidores().size();
                
                if (!num.contains(docente)) {
                    if (mayor <= valor) {
                        mayor = valor;
                        guardar = docente;
                    }
                }
            
        }
        num.add(guardar);

        return guardar;
    }
    
    public Experiencia getMayor(Docente aux, ArrayList<Experiencia> num) {
        int mayor = -1, valor = 0;
        Experiencia guardar = null;
        for (Experiencia experiencia : aux.getExperiencias()) 
        {
            valor = experiencia.getNumMegusta();
            if (!num.contains(experiencia)) 
            {
                if (mayor <= valor) {
                    mayor = experiencia.getNumMegusta();
                    guardar = experiencia;
                }
            }
        }
        num.add(guardar);
        
        return guardar;
    }
    
    public Docente getDocente(String user)
    {
       for(Docente d : docentes)
        {
            if(d.getUsuario().equals(user))
            {
                return d;
            }
        }
            return null;
    }
    
    public static void cargar()
    {
        File fileUsuario,fileDocente;
        ObjectInputStream entradaUsuario,entradaDocente;
        
        fileDocente = new File("docentes"); 
        fileUsuario = new File("usuarios");
        
        
        try 
        {
          
          entradaDocente = new ObjectInputStream(new FileInputStream(fileDocente));
          entradaUsuario = new ObjectInputStream(new FileInputStream(fileUsuario));
          
          
          docentes = (Vector)entradaDocente.readObject();
          usuarios = (Vector)entradaUsuario.readObject();
          
          entradaDocente.close();
          entradaUsuario.close();
        } 
        catch (Exception e) 
        {
        }
    }
    //metodo guarda la informacion cuando se cierre  el programa de manera de serializada
    public static void guardar()
    {
        File fileUsuario,fileDocente;
        ObjectOutputStream entradaUsuario,entradaDocente;
        
        fileDocente = new File("docentes"); 
        fileUsuario = new File("usuarios");
        
        try 
        {
            
            entradaDocente = new ObjectOutputStream(new FileOutputStream(fileDocente));
            entradaUsuario = new ObjectOutputStream(new FileOutputStream(fileUsuario));
            
            entradaDocente.writeObject(docentes);
            entradaUsuario.writeObject(usuarios);
            
            entradaDocente.close();
            entradaUsuario.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void openURL(URL link) {
        String a = link.getAuthority()+link.getFile();
        String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + a);
            } else if (osName.startsWith("Mac OS X")) {
                // Runtime.getRuntime().exec("open -a safari " + url);
                // Runtime.getRuntime().exec("open " + url + "/index.html");
                Runtime.getRuntime().exec("open " + a);
            } else {
                System.out.println("Please open a browser and go to "+ a);
            }
        } catch (Exception e) {
            System.out.println("Failed to start a browser to open the url " + a);
            e.printStackTrace();
        }
    }
      
      public static void copiar(File guardar)
      {
          
          JFileChooser selecionarArchivo = new JFileChooser();
          selecionarArchivo.setSelectedFile(guardar);
          int opciones = selecionarArchivo.showSaveDialog(null);
            
            if(opciones==selecionarArchivo.APPROVE_OPTION)
            {
                try 
                {
                    FileChannel origen = new FileInputStream(guardar).getChannel();
                    FileChannel destino = new FileOutputStream(selecionarArchivo.getSelectedFile()).getChannel();
                    
                    long count = 0;
                    long size = origen.size();              
                    while((count += destino.transferFrom(origen, count, size-count))<size);
                    
                   origen.close();
                   destino.close();
                    
                } 
                catch (Exception e) 
                {
                }
            }
      }
      
      public static String nombre(String ruta)
      {
          String text="";
          for(int i=ruta.length()-1;i>=0;i--)
          {
              if(ruta.charAt(i)=='\\')
              {
                  break;
              }
              else
              {
                  text = ruta.charAt(i) + text;
              }
          }
          
          return text;
      }
    
}
