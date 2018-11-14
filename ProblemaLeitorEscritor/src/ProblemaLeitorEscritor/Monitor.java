package ProblemaLeitorEscritor;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class Monitor extends JPanel {

    private int contaLeitor;
    private int contaEscritor;
//    private int readers;
//    private boolean writing;
//    private Condition OK_to_Read, OK_to_Write;

    public Led wantsRead[] = new Led[10];
    public Led wantsWrite[] = new Led[10];
    public Led readerWaiting[] = new Led[10];
    public Led writerWaiting[] = new Led[10];
    public Led readerReading[] = new Led[10];
    public Led writerWriting[] = new Led[10];
    public Led finishedReading[] = new Led[10];
    public Led finishedWriting[] = new Led[10];

    public Monitor() {
        contaLeitor = 0;
        contaEscritor = 0;
        for (int i = 0; i < 10; i++) {
            this.wantsRead[i] = new Led(23 + 30 * i, 20);
        }
        for (int i = 0; i < 10; i++) {
            this.wantsWrite[i] = new Led(350 + 30 * i, 20);
        }
        for (int i = 0; i < 10; i++) {
            this.readerWaiting[i] = new Led(23 + 30 * i, 80);
        }
        for (int i = 0; i < 10; i++) {
            this.writerWaiting[i] = new Led(350 + 30 * i, 80);
        }
        for (int i = 0; i < 10; i++) {
            this.readerReading[i] = new Led(23 + 30 * i, 140);
        }
        for (int i = 0; i < 10; i++) {
            this.writerWriting[i] = new Led(350 + 30 * i, 140);
        }
        for (int i = 0; i < 10; i++) {
            this.finishedReading[i] = new Led(23 + 30 * i, 200);
        }
        for (int i = 0; i < 10; i++) {
            this.finishedWriting[i] = new Led(350 + 30 * i, 200);
        }

//        readers = 0;
//        writing = false;
//        OK_to_Read = new Condition();
//        OK_to_Write = new Condition();
    }

    public void wantsRead(int n) {
        this.wantsRead[n].setImagem("ativo.png");
        this.readerWaiting[n].setImagem("desativo.png");
        this.readerReading[n].setImagem("desativo.png");
        this.finishedReading[n].setImagem("desativo.png");
    }

    public void readerWaiting(int n) {
        this.wantsRead[n].setImagem("desativo.png");
        this.readerWaiting[n].setImagem("ativo.png");
        this.readerReading[n].setImagem("desativo.png");
        this.finishedReading[n].setImagem("desativo.png");
    }

    public void readerReading(int n) {
        this.wantsRead[n].setImagem("desativo.png");
        this.readerWaiting[n].setImagem("desativo.png");
        this.readerReading[n].setImagem("ativo.png");
        this.finishedReading[n].setImagem("desativo.png");
    }

    public void finishedReading(int n) {
        this.wantsRead[n].setImagem("desativo.png");
        this.readerWaiting[n].setImagem("desativo.png");
        this.readerReading[n].setImagem("desativo.png");
        this.finishedReading[n].setImagem("ativo.png");
    }

    public void wantsWrite(int n) {
        this.wantsWrite[n].setImagem("ativo.png");
        this.writerWaiting[n].setImagem("desativo.png");
        this.writerWriting[n].setImagem("desativo.png");
        this.finishedWriting[n].setImagem("desativo.png");
        
    }

    public void writerWaiting(int n) {
        this.wantsWrite[n].setImagem("desativo.png");
        this.writerWaiting[n].setImagem("ativo.png");
        this.writerWriting[n].setImagem("desativo.png");
        this.finishedWriting[n].setImagem("desativo.png");
    }

    public void writerWriting(int n) {
        this.wantsWrite[n].setImagem("desativo.png");
        this.writerWaiting[n].setImagem("desativo.png");
        this.writerWriting[n].setImagem("ativo.png");
        this.finishedWriting[n].setImagem("desativo.png");
    }

    public void finishedWriting(int n) {
        this.wantsWrite[n].setImagem("desativo.png");
        this.writerWaiting[n].setImagem("desativo.png");
        this.writerWriting[n].setImagem("desativo.png");
        this.finishedWriting[n].setImagem("ativo.png");
    }

//    public synchronized void Start_Read(int n) {
//
//        wantsRead(n);
//        System.out.println("wants to read " + n);
//        if (writing || OK_to_Write.is_non_empty()) {
//            try {
//                readerWaiting(n);
//                System.out.println("reader is waiting " + n);
//                OK_to_Read.wait_();
//            } catch (InterruptedException e) {
//            }
//        }
//        readers += 1;
//        OK_to_Read.release_all();
//
//    }
//    
    public synchronized void comecaLer(int n) {
        this.repaint();
        wantsRead(n);
        this.repaint();
        while (contaEscritor > 0) {
            try {
                readerWaiting(n);
                this.repaint();
                wait();
            } catch (Exception e) {
            };
        }
        contaLeitor++;
    }

//    public synchronized void End_Read(int n) {
//
//        finishedReading(n);
//        System.out.println("finished reading " + n);
//        readers -= 1;
//
//        if (OK_to_Write.is_non_empty()) {
//            OK_to_Write.release_one();
//        } else if (OK_to_Read.is_non_empty()) {
//            OK_to_Read.release_one();
//        } else {
//            OK_to_Write.release_all();
//        }
//
//    }
    public synchronized void acabaLeitura(int n) {
        this.repaint();
        finishedReading(n);
        this.repaint();
        contaLeitor--;
        if (contaLeitor == 0) {
            notifyAll();
        }
    }

//    public synchronized void Start_Write(int n) {
//
//        wantsWrite(n);
//        System.out.println("wants to write " + n);
//        if (readers != 0 || writing) {
//            try {
//                writerWaiting(n);
//                System.out.println("Writer is waiting " + n);
//                OK_to_Write.wait_();
//            } catch (InterruptedException e) {
//            }
//        }
//
//        writing = true;
//
//    }
    public synchronized void comecaEscrever(int n) {
        this.repaint();
        wantsWrite(n);
        this.repaint();
        while (contaLeitor > 0 || contaEscritor > 0) {
            try {
                writerWaiting(n);
                this.repaint();
                wait();
            } catch (Exception e) {
            };
        }
        contaEscritor++;
    }

    public synchronized void acabaEscrita(int n) {
        this.repaint();
        finishedWriting(n);
        this.repaint();
        contaEscritor--;
        notifyAll();
    }

//    public synchronized void End_Write(int n) {
//
//        finishedWriting(n);
//        System.out.println("finished writing " + n);
//        writing = false;
//        if (OK_to_Read.is_non_empty()) {
//            OK_to_Read.release_one();
//        } else if (OK_to_Write.is_non_empty()) {
//            OK_to_Write.release_one();
//        } else {
//            OK_to_Read.release_all();
//        }
//
//    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;

        ImageIcon ref = new ImageIcon(getClass().getResource("wantsread.png"));
        Image imagem = ref.getImage();
        graficos.drawImage(imagem, 23, 0, this);

        ImageIcon ref1 = new ImageIcon(getClass().getResource("wantswrite.png"));
        Image imagem1 = ref1.getImage();
        graficos.drawImage(imagem1, 350, 0, this);

        ImageIcon ref2 = new ImageIcon(getClass().getResource("waiting.png"));
        Image imagem2 = ref2.getImage();
        graficos.drawImage(imagem2, 23, 60, this);

        ImageIcon ref3 = new ImageIcon(getClass().getResource("waiting.png"));
        Image imagem3 = ref3.getImage();
        graficos.drawImage(imagem3, 350, 60, this);

        ImageIcon ref4 = new ImageIcon(getClass().getResource("reading.png"));
        Image imagem4 = ref4.getImage();
        graficos.drawImage(imagem4, 23, 120, this);

        ImageIcon ref5 = new ImageIcon(getClass().getResource("writing.png"));
        Image imagem5 = ref5.getImage();
        graficos.drawImage(imagem5, 350, 120, this);

        ImageIcon ref6 = new ImageIcon(getClass().getResource("finished.png"));
        Image imagem6 = ref6.getImage();
        graficos.drawImage(imagem6, 23, 180, this);

        ImageIcon ref7 = new ImageIcon(getClass().getResource("finished.png"));
        Image imagem7 = ref7.getImage();
        graficos.drawImage(imagem7, 350, 180, this);

        for (int i = 0; i < 10; i++) {
            graficos.drawImage(this.wantsRead[i].getImagem(), this.wantsRead[i].getX(), this.wantsRead[i].getY(), this);
        }
        for (int i = 0; i < 10; i++) {
            graficos.drawImage(this.wantsWrite[i].getImagem(), this.wantsWrite[i].getX(), this.wantsWrite[i].getY(), this);
        }
        for (int i = 0; i < 10; i++) {
            graficos.drawImage(this.readerWaiting[i].getImagem(), this.readerWaiting[i].getX(), this.readerWaiting[i].getY(), this);
        }
        for (int i = 0; i < 10; i++) {
            graficos.drawImage(this.writerWaiting[i].getImagem(), this.writerWaiting[i].getX(), this.writerWaiting[i].getY(), this);
        }
        for (int i = 0; i < 10; i++) {
            graficos.drawImage(this.readerReading[i].getImagem(), this.readerReading[i].getX(), this.readerReading[i].getY(), this);
        }
        for (int i = 0; i < 10; i++) {
            graficos.drawImage(this.writerWriting[i].getImagem(), this.writerWriting[i].getX(), this.writerWriting[i].getY(), this);
        }
        for (int i = 0; i < 10; i++) {
            graficos.drawImage(this.finishedReading[i].getImagem(), this.finishedReading[i].getX(), this.finishedReading[i].getY(), this);
        }
        for (int i = 0; i < 10; i++) {
            graficos.drawImage(this.finishedWriting[i].getImagem(), this.finishedWriting[i].getX(), this.finishedWriting[i].getY(), this);
        }
        g.dispose(); //Atualiza.
    }

}
