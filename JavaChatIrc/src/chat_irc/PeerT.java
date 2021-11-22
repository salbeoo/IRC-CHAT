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
//        MyBoard boar=new MyBoard(peer.nome);
        ComunicaT comunica = new ComunicaT(peer.client);
        
        ServerT serverT=new ServerT(peer.server);
        serverT.start();
        
        Scanner tastiera = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + "C : Connessione \nM : Comunica \nD : Chiusura");
            System.out.print("[" + peer.nome + "] ");

            String scelta = tastiera.nextLine();
            
            if (scelta.equalsIgnoreCase("C")) {
                peer.client.connetti();
            } else {
                comunica.start();
            }
        }
    }

}
