import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.customorm.database.Database;

public class Application {
	
	public static void main(String[] args) {

// Native query
//		String insertQuery = "INSERT INTO "
//							 + "td_sample(id, title) "
//							 + "VALUES(1, 'Mihail')";
//		Database.getInstance().executeQuery(insertQuery);
		
//		Insert Query Builder

// v1 Insert
//		String[] into 	= {"id", "title"};
//		String[] values = {"2", "'Pesho'"};
//		String query 	= Database.getInstance()
//						 .insert("td_sample", into , values);
//
//		Database.getInstance().executeQuery(query);

// v2 Insert
//		String query = Database.getInstance().insert("td_sample", new HashMap<>() {{
//			put("id", "3");
//			put("title", "'Manol'");
//		}});
//		
//		Database.getInstance().executeQuery(query);
		
// v3 Insert
		Database.getInstance()
			.insert("td_sample")
			.into("id", "title")
			.values(0, "Ivancho")
			.exec();
		
// v1 Update 
		// UPDATE td_sample 
		// SET id = 1
		// WHERE title = 'Ivan'
		Database.getInstance()
			.update("td_sample")
			.set("id", 666)
			.set("title", "The Devil")
			.where("id", 4)
			.exec();
		
		Database.getInstance()
			.insert("td_sample")
			.into("id", "title")
			.values(40, "Andrei")
			.exec();		
		
		Database.getInstance()
			.insert("td_sample")
			.into("id", "title")
			.values(50, "Matei")
			.exec();		
		
		Database.getInstance()
			.update("td_sample")
			.set("id", 999)
			.set("title", "Ultimate")
			.where("id", ">", 40).andWhere("title", "Matei")
			.exec();
		
		Database.getInstance()
			.delete("td_sample")
			.where("id", 666)
			.exec();
		
		// ORM candadate
		ResultSet collection = Database.getInstance()
								.select("td_sample")
								.where("id", 0)
								.fetch();
		try {
			collection.next(); // 
			System.out.println(collection.getString("title"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
