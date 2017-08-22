package server;

import java.net.Socket;
import bbp.Bbpmain;

public class Client {
   
   public static void main(String[] args) throws Exception {
      Socket client = new Socket("192.168.53.184", 10001);
      new Bbpmain(client);
   }
}