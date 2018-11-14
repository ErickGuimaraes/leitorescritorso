package ProblemaLeitorEscritor;

public class Estrutura {
    
    private int dados; 
    private Monitor m;

    public Estrutura(Monitor m) {
        this.m = m;
        dados = 0;     
    }  
    public void setDados (int valor, int nome) {
      this.m.comecaEscrever(nome);
      dados = -30;  
                        
      try { Thread.sleep((int)(3000*Math.random()+1)); } catch(Exception e) { }
      dados = valor;
      this.m.acabaEscrita(nome);

  } 

    public int getDados (int nome) {
        int valor;  
        this.m.comecaLer(nome);
        try { Thread.sleep((int)(1500*Math.random()+1)); } catch(Exception e) { }
        valor = dados;
        this.m.acabaLeitura(nome);

        return valor;
    } 

} 
