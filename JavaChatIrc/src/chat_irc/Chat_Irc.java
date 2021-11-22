/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_irc;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Scanner;
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
        Scanner tastiera = new Scanner(System.in);
        
        System.out.println("Inserire nome");
        String nome=tastiera.nextLine();
        
        System.out.println("Inserire porta");
        int port=tastiera.nextInt();
        
        System.out.println("Inserire porta destinartio");
        int portD=tastiera.nextInt();
        
        PeerInfo peer1 = new PeerInfo(nome, port,portD);
        
        PeerT pt1 = new PeerT(peer1);
        pt1.start();
        pt1.join();
    }

}
