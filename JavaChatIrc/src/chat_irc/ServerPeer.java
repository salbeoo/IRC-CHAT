/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_irc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

    InputStreamReader inputStreamReader = null;
    OutputStreamWriter outputStreamWriter = null;
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;

    public ServerPeer(int port) throws IOException {
        server = new ServerSocket(port);
    }

    public void attenti() {

        try {
            System.out.println("Server in ascolto");
            peerTo = server.accept();
            server.close();
            System.out.println("Server connesso");
        } catch (IOException ex) {
            Logger.getLogger(ServerPeer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ricevi() {
        try {
            inputStreamReader = new InputStreamReader(peerTo.getInputStream());
            outputStreamWriter = new OutputStreamWriter(peerTo.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            String msgToSend = "";
            while (!msgToSend.equalsIgnoreCase("Bye")) {
                msgToSend = bufferedReader.readLine();

                System.out.print(msgToSend);
                

                bufferedWriter.write(msgToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

        } catch (IOException ex) {
            Logger.getLogger(ServerPeer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
