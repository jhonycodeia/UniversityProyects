/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalera;

/**
 *
 * @author veevart
 */
public class Trampa {
    
    private boolean tiene;
    private int ubicacion;
    private int destino;

    public Trampa(){
        super();
    }

    public Trampa(boolean tiene, int ubicacion, int destino) {
        this.tiene = tiene;
        this.ubicacion = ubicacion;
        this.destino = destino;
    }
    
    public boolean isTiene() {
        return tiene;
    }

    public void setTiene(boolean tiene) {
        this.tiene = tiene;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
    
}
