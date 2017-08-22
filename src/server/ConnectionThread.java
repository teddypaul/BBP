package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import bbp.Bbpmain;

public class ConnectionThread extends Thread{

	Bbpmain bbpmain;
	private Socket sock;
	private DataInputStream dis;
	private DataOutputStream dos;
	private String msg;
	private PrintWriter pw;
	private BufferedReader br;

	public ConnectionThread(Socket sock) {
		this.sock = sock;
	}
	public void run(){
		try {
			System.out.println("메인 쓰레드 생성 완료");

			InetAddress inetAddr = sock.getInetAddress();
			System.out.println(sock.getInetAddress() + "님이 접속");
			dos = new DataOutputStream(sock.getOutputStream());
			dis = new DataInputStream(sock.getInputStream());
			pw = new PrintWriter(new OutputStreamWriter(dos));
			br = new BufferedReader(new InputStreamReader(dis));

			while(true){
				msg = dis.readUTF();
				if(msg.equals("search")){
					System.out.println("책 검색 버튼 쓰레드 생성 완료");
					continue;
				}else if(msg.equals("책 등록")){
					System.out.println("책 등록 버튼 쓰레드 생성 완료");      
					continue;
				}else if(msg.equals("나의 정보")){
					System.out.println("나의 정보 버튼 쓰레드 생성 완료");
					continue;
				}else if(msg.equals("종료")){
					System.out.println("종료 버튼 쓰레드 생성 완료");
				}
			}
		} catch (Exception e) { //쓰레드 아웃, 프로그램 종료
			//e1.printStackTrace();
			System.exit(0);
		}
	}
}