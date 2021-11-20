/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_irc;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Alber
 */
public class GestionePeer {

    DatagramSocket peer;
    InetAddress IPAddress;
    String nome;

    public GestionePeer() throws SocketException, UnknownHostException {
        this.nome="";
        this.peer = new DatagramSocket(666);
        this.IPAddress = InetAddress.getLocalHost();;
    }

    public GestionePeer(String nome,DatagramSocket server, InetAddress IPAddress) {
        this.nome=nome;
        this.peer = server;
        this.IPAddress = IPAddress;
    }
    
    public void connessione(){
            
    }
    

}
