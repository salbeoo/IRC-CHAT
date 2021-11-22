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

    ServerPeer server;
    ClientPeer client;
    int port, portDestinatario;
    String nome;

    InputStreamReader inputStreamReader = null;
    OutputStreamWriter outputStreamWriter = null;
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;

    public PeerInfo(String nome, int port, int portDestinatario) throws IOException {
        this.nome = nome;
        this.port = port;
        this.portDestinatario = portDestinatario;
   
        server=new ServerPeer(port);
        client=new ClientPeer(nome,portDestinatario);
    }

}
