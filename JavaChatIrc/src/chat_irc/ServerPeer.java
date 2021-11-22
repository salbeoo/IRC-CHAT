/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_irc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alber
 */
public class ServerPeer {

    Socket peerTo = null;
    ServerSocket server = null;

    public ServerPeer(int port) throws IOException {
        server = new ServerSocket(port);
    }

    public void attenti() {

        try {
            System.out.println("Server in ascolto");
            peerTo = server.accept();
            server.close();
            System.out.println("connesso");
        } catch (IOException ex) {
            Logger.getLogger(ServerPeer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
