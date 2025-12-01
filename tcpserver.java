//Tcpserver 
package tcpserver;
import java.io.*;
import java.net.*;
        
public class Tcpserver {

    public static void main(String[] args) {
        int port = 1026;
        try (ServerSocket serverSocket = new ServerSocket(port)){

            //Connection Making            
            Socket socket = serverSocket.accept();
            
            //i/p from client 
            BufferedReader inFormClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            //o/p to client
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
            
            String clientMessage = inFormClient.readLine();
            File fobj = new File(clientMessage)

            if(fobj.exist()&&fobj.isFile()&&(fobj.length()!=0)){
                BufferedReader fread = new BufferReader(new FileReader)
            }

            
            
            socket.close();   
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
