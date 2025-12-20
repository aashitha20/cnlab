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

public class UDPServer {
            public static void main(String[] args){
                Scanner sc=new Scanner(System.in);
              
            
      {
                try{
                  DatagramSocket socket=new DatagramSocket();
                 InetAddress clientAddress= InetAddress.getByName("localhost");
                int clientPort =1027;  // Send to client's port
                    System.out.println("Enter message to client: ");
                    String message = sc.nextLine();
                    byte[] sendData = message.getBytes();
                    DatagramPacket sendPacket=new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                    socket.send(sendPacket);
                    System.out.println("Message sent to client from server.");
                } catch(IOException ex){
              
                ex.printStackTrace();
              }
       }      
              
        DatagramSocket Socket=null;
    try{
      Socket=new DatagramSocket(1026);
      byte[] receiveData = new byte[1024];
       DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
        System.out.println("Client is waiting");
        Socket.receive(receivePacket);
       String receivedMessage=new String(receivePacket.getData(),0,receivePacket.getLength());
        System.out.println("Message Server: "+receivedMessage);
    }
    catch(IOException ex){
              
                ex.printStackTrace();
              }  
       
                 
}
}
