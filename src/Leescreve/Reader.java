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
class Reader extends Thread {
    private Monitor M;
    private String value;

    public Reader(String name, Monitor c) {
        super(name);
        M = c;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            M.Start_Read(i);
            // System.out.println("Reader "+getName()+" is retreiving data...");
            System.out.println("Reader is reading " + i);
            M.End_Read(i);
        }

    }
}

