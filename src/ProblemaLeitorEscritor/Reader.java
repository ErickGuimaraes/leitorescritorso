package ProblemaLeitorEscritor;

class Reader extends Thread {
//    private String value;

    int nomeThread;
    Estrutura dados;
    private Led wantsRead[];

    public Reader(int nome, Estrutura SD) {
        nomeThread = nome;
        dados = SD;
    }

    public void run() {
        int val;
        for (int i = 0; i < 10; i++) {
            System.out.println("Leitor " + nomeThread + "esta querendo ler os dados");
            val = dados.getDados(this.nomeThread);
            System.out.println("Leitor " + nomeThread + " leu o valor " + val);
            try {
                sleep((int) (8000.0 * Math.random()));
            } catch (Exception e) {
                break;
            }
//            M.Start_Read(i);
//            M.readerReading(i);
//            M.repaint();
//            System.out.println("Reader is reading " + i);
//            M.End_Read(i);
        }
    }
}
