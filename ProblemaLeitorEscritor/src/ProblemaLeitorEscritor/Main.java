package ProblemaLeitorEscritor;

import javax.swing.JPanel;

public class Main extends JPanel {

    public Main(Monitor m) {
        Estrutura dados = new Estrutura(m);
        Reader r;
        Writer w;
        for (int i = 0; i < 10; i++) {
            w = new Writer(i, dados);
            r = new Reader(i, dados);
            w.start();
            r.start();
        }

        System.out.println("Main"); //linha opicional

//        Reader reader = new Reader("1", M);
//        Writer writer = new Writer("1", M);
//        reader.start();
//        writer.start();
    }

}
