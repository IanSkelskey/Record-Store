/**
* DatabaseUpdater
*/
import java.sql.*;
import java.io.*;
import java.util.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import util.SQLHelper;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



public class DatabaseUpdater {
	
	private Connection conn;
	
	public DatabaseUpdater(){
		
	}

	// Consider using a hashmap for column, value pairs for insert keyss
	public void insert(String table, HashMap<String, String> insert){
		
		StringBuilder keys = new StringBuilder();
		StringBuilder values = new StringBuilder();
		StringBuilder statement = new StringBuilder();
		
		keys.append("INSERT INTO " + table + " (");
		values.append("VALUES (");
		
		Iterator mapIt = insert.entrySet().iterator();
		
		while(mapIt.hasNext()){
			Map.Entry mapEnt = (Map.Entry)mapIt.next();
			if(mapIt.hasNext()){
				keys.append(mapEnt.getKey() + ", ");
				values.append(mapEnt.getValue() + ", ");
			}else {
				keys.append(mapEnt.getKey() + ") ");
				values.append(mapEnt.getValue() + ");");
			}
		}
		statement.append(keys).append(values);
		System.out.println("Inserting into table: " + table + "\n");
		
		SQLHelper.runStatement(statement.toString());
	}
	
	
	public void update(String table){
		System.out.println("Updating" + table);
	}
	
	public void delete(String table){
		System.out.println("Not sure about this one yet");
	}
	
	
}