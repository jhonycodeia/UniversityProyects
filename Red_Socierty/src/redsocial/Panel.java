package redsocial;

import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel{
    private String url;
    public Panel(String url){
        this.url=url;
    }
    public void paintComponent(Graphics g){
        Dimension tamanho = getSize();
        ImageIcon imagen = new ImageIcon(getClass().getResource(url));
        g.drawImage(imagen.getImage(),0,0,tamanho.width,tamanho.height,null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
