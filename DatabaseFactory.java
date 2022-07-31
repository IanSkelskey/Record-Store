/**
* Database Factory
*/




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