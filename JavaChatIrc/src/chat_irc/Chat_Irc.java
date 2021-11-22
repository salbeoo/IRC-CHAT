/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_irc;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Alber
 */
public class Chat_Irc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        PeerInfo peer1 = new PeerInfo("Peer1", 666);
        PeerInfo peer2 = new PeerInfo("Peer2", 777);
        

        PeerT pt1 = new PeerT(peer1);
        PeerT pt2 = new PeerT(peer2);

        pt1.start();
        pt2.start();

        pt1.join();
        pt2.join();

    }

}
