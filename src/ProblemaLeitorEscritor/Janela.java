package ProblemaLeitorEscritor;

import javax.swing.JFrame; 

public class Janela extends JFrame{
    
    public Janela(){
        Monitor M = new Monitor();
        Main Main = new Main(M);                            
        add(M);                                            
        setTitle("Leitor e Escritor");                          
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setSize(800,391);                                 
        setLocationRelativeTo(null);                      
        setResizable(false);                             
        setVisible(true);                                
    }
}
