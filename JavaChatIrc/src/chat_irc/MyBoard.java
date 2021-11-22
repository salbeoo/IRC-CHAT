/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_irc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.TextArea;
import java.awt.TextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Alber
 */
public class MyBoard extends JFrame {

    public MyBoard() throws HeadlessException {
        init();
    }

    public void init() {
        JFrame f = new JFrame();
        JPanel p=new JPanel();
        
        TextArea textOutput = new TextArea(13, 38);
        p.add(textOutput);
        
        TextArea textInput=new TextArea(1, 38);
        p.add(textInput);
        p.setBackground(Color.black);
        
        f.add(p);
        f.setSize(new Dimension(300, 300));
        f.setVisible(true);
        f.setResizable(false);
        f.setTitle(" ");
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
