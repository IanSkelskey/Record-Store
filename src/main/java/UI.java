/**
* UI class
*/
import java.sql.*;
import java.io.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



public class UI{
	
	private QueryLogic queryLogic;
	private DatabaseUpdater updater;
	
	public UI() {
	    this.queryLogic = new QueryLogic();
	    this.updater = new DatabaseUpdater();
	}
	
	public void menu(){
		System.out.println("Thinking this will be a switch");
	}
	
	public static void main(String[] args){
		System.out.println("Welcome...");
		
		UI ui = new UI();
		ui.menu();
	}
}