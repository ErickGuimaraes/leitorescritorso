package ProblemaLeitorEscritor;

class Writer extends Thread {

    int nome;
    Estrutura Dados;
//    private int value;

    public Writer(int n, Estrutura D) {
        nome = n;
        Dados = D;
//        super(name);
    }

    public void run() {

        int val;

        for (int j = 0; j < 10; j++) {

            val = (int) (30.0 * Math.random());

            System.out.println("Escritor " + nome + " estÃ¡ querendo escrever o valor "
                    + val + " na base de dados.");
            Dados.setDados(val, nome);

            System.out.println("Escritor " + nome + " escreveu o valor " + val
                    + " na base de dados");
            try {
                sleep((int) (90000.0 * Math.random()));
            } catch (Exception e) {
                break;
            }

//            M.Start_Write(j);
//            M.writerWriting(j);
//            M.repaint();
//            System.out.println("Writer is writing " + j);
//            M.End_Write(j);
        }

    }

}
