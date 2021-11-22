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
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alber
 */
public class PeerInfo {

    Socket peer;
    ServerSocket server;
    int port;
    String nome;

    InputStreamReader inputStreamReader = null;
    OutputStreamWriter outputStreamWriter = null;
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;

    public PeerInfo() {
        nome = "Peer1";
        port = 7577;
        try {
            server = new ServerSocket(port);
            peer = new Socket(InetAddress.getLocalHost(), port);
        } catch (IOException ex) {
            Logger.getLogger(PeerInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PeerInfo(String nome, int port) {
        this.nome = nome;
        this.port = port;
        try {
            server = new ServerSocket(port);
            peer = new Socket(InetAddress.getLocalHost(), port);
        } catch (IOException ex) {
            Logger.getLogger(PeerInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connessione() throws IOException {
//            System.out.println("Ip: "+peer.getInetAddress()+ " Port: "+peer.getPort());
//            System.out.println("Ip: "+peer2.peer.getInetAddress()+ " Port: "+peer2.peer.getPort());
        System.out.println(nome + ": in attesa di connessione");
        peer = server.accept();
        System.out.println(nome + ": connesso");
    }

    public void comunicazione() {
        try {
            inputStreamReader = new InputStreamReader(peer.getInputStream());
            outputStreamWriter = new OutputStreamWriter(peer.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner tastiera = new Scanner(System.in);
            String msgToSend = "";
            while (!msgToSend.equalsIgnoreCase("Bye")) {
                System.out.print("["+nome+"]");
                msgToSend = tastiera.nextLine();
                bufferedWriter.write(msgToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(PeerInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
