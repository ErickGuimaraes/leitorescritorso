package ProblemaLeitorEscritor;

import java.awt.Image;       
import javax.swing.ImageIcon; 
/**
 *
 * @author renan
 */
public class Led {
    private Image imagem;  
    private int x,y;        
    
    public Led(int Px, int Py){
        ImageIcon ref = new ImageIcon(getClass().getResource("desativo.png"));
        this.imagem = ref.getImage();                                            
        this.x = Px;                                                            
        this.y = Py;                                                            
    }

    public Image getImagem() {
        return this.imagem;  
    }
    
    public void setImagem(String imagem) {
        ImageIcon ref = new ImageIcon(getClass().getResource(imagem)); 
        this.imagem = ref.getImage();
    }
    
    public int getX() {
        return this.x;    
    }

    public int getY() {
        return this.y;      
    }
    
    
    
    
}