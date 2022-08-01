/**
* Database Factory
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



public class DatabaseFactory {
	private Connection conn;
	
	public void create () {
		System.out.println("Creating database");
	}
	
	public static void main(String[] args){
		System.out.println("Creating nonexistent database");
		System.out.println("Have a nice day :)");
	}
}