/**
* DatabaseUpdater
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



public class DatabaseUpdater {
	
	private Connection conn;
	
	public DatabaseUpdater() {
		
	}

	// Consider using a hashmap for column, value pairs for insert statements
	public void insert(String table, String[] values){
		System.out.println("Inserting into table: " + table);
	}
	
	public void update(String table){
		System.out.println("Updating" + table);
	}
	
	public void delete(String table){
		System.out.println("Not sure about this one yet");
	}
	
	
}