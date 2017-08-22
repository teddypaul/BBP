package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
   public static void main(String[] args) throws Exception {
      try{
         ServerSocket server = new ServerSocket(10001);
         System.out.println("서버가 클라이언트부터 접속을 대기하는 중..");   
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