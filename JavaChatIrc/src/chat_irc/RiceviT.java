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

    ServerPeer serverPeer;


    public RiceviT(ServerPeer peer) {
        this.serverPeer = serverPeer;
    }

    public void run() {
        serverPeer.ricevi();
    }

}
