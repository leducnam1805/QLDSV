package utils;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBConnectionUtils {
	//private static String url = "jdbc:mysql://node236041-nam-bsongs.j.layershift.co.uk/bsong?useUnicode=true&characterEncoding=UTF-8";
		private static String url = "jdbc:mysql://localhost:3306/qldsv?useUnicode=true&characterEncoding=UTF-8";
		private static String user = "root";
		private static String password = "";
		//private static String password = "ISFbci95222";
		private static Connection conn = null;
		
		public static Connection getConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");

				conn = (Connection) DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.out.println("Không thể nạp driver");
				e.printStackTrace();
			}
			return conn;
		}

		public static void main(String[] args) {
			System.out.println(DBConnectionUtils.getConnection());
		}
}
