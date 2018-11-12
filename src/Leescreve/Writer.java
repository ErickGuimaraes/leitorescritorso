/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leescreve;

/**
 *
 * @author lilia
 */
class Writer extends Thread {
    private Monitor M;
    private int value;

    public Writer(String name, Monitor d) {
        super(name);
        M = d;
    }

    public void run() {
        for (int j = 0; j < 10; j++) {
            M.Start_Write(j);
            // System.out.println("Writer "+getName()+" is writing data...");
            System.out.println("Writer is writing " + j);
            M.End_Write(j);
        }

    }
}
