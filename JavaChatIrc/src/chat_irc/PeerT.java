/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_irc;

/**
 *
 * @author Alber
 */
public class PeerT extends Thread {

    PeerInfo peer;
    char scelta;

    public PeerT(PeerInfo peer) {
        this.peer = peer;
        this.scelta = ' ';
    }

    public PeerT(PeerInfo peer, char scelta) {
        this.peer = peer;
        this.scelta = scelta;
    }

    public void connessione() {

    }

    public void comunica() {

    }
    
    public void chiusura(){
        
    }

}
