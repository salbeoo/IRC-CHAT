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
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alber
 */
public class ClientPeer {

    Socket peer = null;
    int portConnessione;
    
    String nome;
    InputStreamReader inputStreamReader = null;
    OutputStreamWriter outputStreamWriter = null;
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;

    public ClientPeer(String nome,int port) {
        this.nome=nome;
        portConnessione = port;
    }

    public void connetti() {

        try {
            System.out.println("Provo a connettermi al server del peer2");
            peer = new Socket(InetAddress.getLocalHost(), portConnessione);
            System.out.println("Client Connesso");
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClientPeer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientPeer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void messaggia() {
        try {
            inputStreamReader = new InputStreamReader(peer.getInputStream());
            outputStreamWriter = new OutputStreamWriter(peer.getOutputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner tastiera = new Scanner(System.in);
            String msgToSend = "";
            while (!msgToSend.equalsIgnoreCase("Bye")) {
                System.out.print("[" + nome + "]");
                msgToSend = tastiera.nextLine();
                bufferedWriter.write(msgToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientPeer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
