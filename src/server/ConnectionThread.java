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
			System.out.println("���� ������ ���� �Ϸ�");

			InetAddress inetAddr = sock.getInetAddress();
			System.out.println(sock.getInetAddress() + "���� ����");
			dos = new DataOutputStream(sock.getOutputStream());
			dis = new DataInputStream(sock.getInputStream());
			pw = new PrintWriter(new OutputStreamWriter(dos));
			br = new BufferedReader(new InputStreamReader(dis));

			while(true){
				msg = dis.readUTF();
				if(msg.equals("search")){
					System.out.println("å �˻� ��ư ������ ���� �Ϸ�");
					continue;
				}else if(msg.equals("å ���")){
					System.out.println("å ��� ��ư ������ ���� �Ϸ�");      
					continue;
				}else if(msg.equals("���� ����")){
					System.out.println("���� ���� ��ư ������ ���� �Ϸ�");
					continue;
				}else if(msg.equals("����")){
					System.out.println("���� ��ư ������ ���� �Ϸ�");
				}
			}
		} catch (Exception e) { //������ �ƿ�, ���α׷� ����
			//e1.printStackTrace();
			System.exit(0);
		}
	}
}