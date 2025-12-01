//Tcpclient 
package tcpserver;
import java.io.*;
import java.net.*;
public class Tcpclient {
    public static void main(String[] args) {
        String serverIP = "localhost";
        int port = 1026;
        
        try (Socket socket = new Socket(serverIP, port)){
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            
            BufferedReader inFormServer= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            String message = "HELLO FROM CLIENT! ";
            outToServer.writeBytes(message + "\n");

            String response = inFormServer.readLine();
            System.out.println("Server Response: "+response);
              
        }catch(IOException ex){
            ex.printStackTrace();
        }
        }
    }

