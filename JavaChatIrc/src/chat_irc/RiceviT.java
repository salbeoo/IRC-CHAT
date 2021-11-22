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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alber
 */
public class RiceviT extends Thread {

    PeerInfo peer;

    InputStreamReader inputStreamReader = null;
    OutputStreamWriter outputStreamWriter = null;
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;

    public RiceviT(PeerInfo peer) {
        this.peer = peer;
    }

    public void run() {
        try {
            inputStreamReader = new InputStreamReader(peer.peer.getInputStream());
            outputStreamWriter = new OutputStreamWriter(peer.peer.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            String msgToSend = "";
            while (!msgToSend.equalsIgnoreCase("Bye")) {
                msgToSend = bufferedReader.readLine();
                
                System.out.print("[" + peer.nome + "] "+msgToSend );
                
                bufferedWriter.write(msgToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

        } catch (IOException ex) {
            Logger.getLogger(RiceviT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
