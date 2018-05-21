package aplikasichat2;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
  
public class ServerBaruu {
     
    public static void main(String args[]) {
 
        int port;
        ServerSocket server_socket;
        BufferedReader input;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        BufferedReader in;
        PrintWriter out;
 

  
try {
     
    server_socket = new ServerSocket(2000);
    
    
    System.out.println("Server waiting for client on port " + 
       server_socket.getLocalPort());
     
    // server infinite loop

while(server_socket.isBound()){
Socket socket = server_socket.accept();

socket.setKeepAlive(true);
System.out.println("New connection accepted " +
   socket.getInetAddress() +
   ":" + socket.getPort());


//dis = new DataInputStream(socket.getInputStream()); 
in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
out = new PrintWriter(socket.getOutputStream(),true);
//send notif setelah dapat message




// print received data 
try {
    
//String message = dis.readUTF();
String message = in.readLine();
System.out.println(message);
String notif = "sent";
out.println(notif);

if(message != null){
    out.println("server accepted");
}
    
}
catch (IOException e) {
    
    System.out.println(e);
}
}
// connection closed by client
 
    
     
     
}
 
catch (IOException e) {
    System.out.println(e);
}
    }
}