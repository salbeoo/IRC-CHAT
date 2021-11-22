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
public class ServerT extends Thread {
    ServerPeer serverPeer;

    public ServerT(ServerPeer serverPeer) {
        this.serverPeer = serverPeer;
    }
    
    public void run(){
        serverPeer.attenti();
    }
}
