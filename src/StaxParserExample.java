import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class StaxParserExample {
	static String name;
	static String add1;
	static String add2;
	public static void main(String[] args) throws FileNotFoundException{


		try {
			File inputFile = new File("D:/xml/대학목록.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("row");
			System.out.println(nList.getLength());
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				for(int temp2 = 0; temp2 < nNode.getChildNodes().getLength();temp2++) {
					Node nNode2 = nNode.getChildNodes().item(temp2);
					
					if (nNode2.getNodeName().equals("NAME_KOR")) {//대학이름
//						System.out.println(nNode2.getNodeName() + " : " + nNode2.getTextContent());
						name = nNode2.getTextContent();
					}
					if (nNode2.getNodeName().equals("BRANCH")) {//대학 캠퍼스
//						System.out.println(nNode2.getNodeName() + " : " + nNode2.getTextContent());
						add1 = nNode2.getTextContent();
					}
					if (nNode2.getNodeName().equals("ADD_KOR")) {//주소
//						System.out.println(nNode2.getNodeName() + " : " + nNode2.getTextContent());
						add2 = nNode2.getTextContent();
					}
					
					
				}
				System.out.println(name +":"+ add1 +":"+ add2);
				
//				System.out.println("\nCurrent Element :" + nNode.getNodeName());
//
//				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//					Element eElement = (Element) nNode;
//					System.out.println(eElement.getAttribute("TYPE"));
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}