package util;

import java.sql.*;
import java.util.*;

/**
 * util.DBUpdater
 */
public class DBUpdater {
	
	private Connection conn;
	
	public DBUpdater() {
		
	}
	
	public void update(String table){
		System.out.println("Updating" + table);
	}
	
	public void delete(String table){
		System.out.println("Not sure about this one yet");
	}
	
	
}