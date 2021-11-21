/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_irc;

import java.io.IOException;

/**
 *
 * @author Alber
 */
public class Chat_Irc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        PeerInfo peer1=new PeerInfo("Peer1",666);
        PeerInfo peer2=new PeerInfo("Peer1",777);
        
        PeerT pt1=new PeerT(peer1, 'c');
        
        System.out.println("C : Connessione \nM : Comunica \nD : Chiusura");
        peer1.connessione(peer2);
        peer1.comunicazione();
        
    }
    
}
