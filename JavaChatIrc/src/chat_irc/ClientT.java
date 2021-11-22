/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_irc;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alber
 */
public class ClientT extends Thread{
    ClientPeer peer;

    public ClientT(ClientPeer peer) {
        this.peer = peer;
    }
    
    public void run(){
        peer.connetti();
    }
}
