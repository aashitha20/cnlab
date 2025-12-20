/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package bcs502;

/**
 *
 * @author cn
 */
import java.io.*;
import java.net.*;
public class TCPServer {
          public static void main(String args[]){
              int port = 1026;
           
             try(ServerSocket serverSocket=new ServerSocket(port)){
                  while(true){
                System.out.println("Server is listening on port "+ port);
                Socket socket=serverSocket.accept();
                
                System.out.println("Client connected"+socket.getInetAddress());
                 System.out.println("Client Port: "+socket.getPort());
                BufferedReader inFromClient=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
                String filename=inFromClient.readLine();
                  
                  //convert the string file to actual file
                File file=new File(filename);
                  
                  if(file.exists()&&file.isFile()){
        BufferedReader fileReader=new BufferedReader(new FileReader(file));
                  String line;
                  while((line=fileReader.readLine())!=null){
                      outToClient.writeBytes(line+"\n");
             
                  }
       
       
         fileReader.close();
                      System.out.println("File "+filename+" sent to client.");
                  }else{
                  outToClient.writeBytes("Error!File not found or is not a regular file");
                  }
                  
              
                  
               
                
                  
                  socket.close();
                  }
              
              }catch(IOException ex){
              
                ex.printStackTrace();
              }
            }
              }               
    
             


