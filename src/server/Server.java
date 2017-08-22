package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
   public static void main(String[] args) throws Exception {
      try{
         ServerSocket server = new ServerSocket(10001);
         System.out.println("������ Ŭ���̾�Ʈ���� ������ ����ϴ� ��..");   
         while(true){
            Socket sock = server.accept();
            ConnectionThread ct = new ConnectionThread(sock);
            ct.start();
         }
         
      }catch(IOException e){
         e.printStackTrace();
      }

   }

}