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
class Condition {
    private int number;// specifies the number of readers/writers waiting

    public Condition() {
        number = 0;
    }

    public synchronized boolean is_non_empty() {
        if (number == 0)
            return false;
        else
            return true;
    }

    public synchronized void release_all() {
        number = 0;
        notifyAll();
    }

    public synchronized void release_one() {
        number -= 1;
        notify();
    }

    public synchronized void wait_() throws InterruptedException {
        number++;
        wait(1000);
    }

}