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
import java.util.Scanner;
public class TCPClient {
    public static void main(String args[]){
         String serverIP="localhost";
         int port=1026;
           Scanner ob=new Scanner(System.in);
             
         try(Socket socket = new Socket(serverIP,port)){
             DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
             BufferedReader inFromServer=new BufferedReader(new InputStreamReader(socket.getInputStream()));
              System.out.println("Client Local Port: "+socket.getLocalPort());
          String filename;
        
             System.out.println("Enter the filename");
             filename=ob.nextLine();
              if(filename.isEmpty()){
                  System.out.println("FILE should not be empty ");
                  return;
              
              }
              //String message="Hello from client!";
             outToServer.writeBytes(filename+ "\n");
               String responseLine;
             while ((responseLine=inFromServer.readLine())!=null){
             if(responseLine.startsWith("ERROR")){
                 System.err.println(responseLine);
             }
             else{
             System.out.println(responseLine);
             }
             }
             // System.out.println("Server response: "+response);
         }catch(IOException ex){
              
                ex.printStackTrace();
              }
        
    }
}
