/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasichat2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author Aland Samuel
 */
public class ServerForm2 extends javax.swing.JPanel {

    /**
     * Creates new form ServerForm2
     */
    public ServerForm2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    
    public static void main(String args[]) {
        
        
        int port;
        ServerSocket server_socket;
        BufferedReader input;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        JTextArea servertext = null;
 

  
try {
     
    server_socket = new ServerSocket(2000);
    
    
    System.out.println("Server waiting for client on port " + 
       server_socket.getLocalPort());
     
    // server infinite loop
     
        Socket socket = server_socket.accept();
        socket.setKeepAlive(true);
        System.out.println("New connection accepted " +
           socket.getInetAddress() +
           ":" + socket.getPort());

dis = new DataInputStream((socket.getInputStream())); 
PrintWriter output = new PrintWriter(socket.getOutputStream(),true);



// print received data 
try {
    
String message = dis.readUTF();
servertext.append(message);

 
}
catch (IOException e) {
    System.out.println(e);
}
 
// connection closed by client
 
    
     
     
}
 
catch (IOException e) {
    System.out.println(e);
}
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}