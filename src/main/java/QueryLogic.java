/**
* QueryLogic
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



public class QueryLogic{
	
	private Connection conn;
	
	public QueryLogic(){
		
	}
	
	public void getAlbumStockAtAllLocations(String albumTitle){
		System.out.println("Thinking this will print a list of availability by location");
	}
	
}