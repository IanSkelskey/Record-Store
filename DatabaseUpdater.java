/**
* DatabaseUpdater
*/




public class DatabaseUpdater {
	
	private Connection conn;
	
	public DatabaseUpdater(Connection c){
		this.conn = c;
	}
	
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