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

	// Retrieve all albums and copies at user-specified location (update return type)
	public void getInventoryAtLocation(String location) {
		System.out.println("Should return: AlbumTitle, Amount");
	}

	// Retrieve price of user-specified album (update return type)
	public void getAlbumPrice(String album) {
		System.out.println("should return x.xx");
	}

	// Retrieve all album info
	public void getAlbumInfo(String album) {
		System.out.println("should return: AlbumTitle, Songs, Genre, ReleaseDate, Artist");
	}

	// Retrieve location info (say if an employee needs to call another location, they need the phone number)
	public void getLocationInfo(String location) {
		System.out.println("should return: LocationName, Phone, Address");
	}
	
}