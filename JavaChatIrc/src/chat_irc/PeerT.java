/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_irc;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alber
 */
public class PeerT extends Thread {

    PeerInfo peer;

    public PeerT(PeerInfo peer) {
        this.peer = peer;
    }

    public void run() {
        MyBoard boar=new MyBoard();
        Scanner tastiera = new Scanner(System.in);
        while (true) {
            System.out.println(peer.nome + "\n" + "C : Connessione \nM : Comunica \nD : Chiusura");
            String scelta = tastiera.nextLine();
            if (scelta.equalsIgnoreCase("C"))
                try {
                peer.connessione();
            } catch (IOException ex) {
                Logger.getLogger(PeerT.class.getName()).log(Level.SEVERE, null, ex);
            } else {
                peer.comunicazione();
            }
        }
    }

}
