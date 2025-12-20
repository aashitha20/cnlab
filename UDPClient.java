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
public class UDPClient {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        DatagramSocket socket=null;
        
        try{
            socket=new DatagramSocket(1027);  // Client uses different port
            
            // Receive message from server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
            System.out.println("Client is waiting for message from server...");
            socket.receive(receivePacket);
            String receivedMessage=new String(receivePacket.getData(),0,receivePacket.getLength());
            System.out.println("Message from Server: "+receivedMessage);
            
            // Send message to server
            InetAddress serverAddress= InetAddress.getByName("localhost");
            int serverPort =1026;  // Send to server's port
            System.out.println("Enter message to server: ");
            String message = sc.nextLine();
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket=new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            socket.send(sendPacket);
            System.out.println("Message sent to Server.");
            
        } catch(IOException ex){
            ex.printStackTrace();
        } finally {
            if(socket != null && !socket.isClosed()) {
                socket.close();
            }
            sc.close();
        }
    }
}
