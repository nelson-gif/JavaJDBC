package datos;

import java.sql.*;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

	private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "admin";
	
	public static DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(JDBC_URL);
		ds.setUsername(JDBC_USER);
		ds.setPassword(JDBC_PASSWORD);
		
		//definiendo tamanio inicial del pool de conexiones
		ds.setInitialSize(5); //inicializando 5 conexiones
		return ds;
	}
	
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
	
	public static void close(ResultSet rs) throws SQLException {
		rs.close();
	}
	
	public static void close(Statement instruction) throws SQLException {
		instruction.close();
	}
	
	public static void close(PreparedStatement stmt) throws SQLException {
		stmt.close();
	}
	
	public static void close(Connection conn) throws SQLException {
		conn.close();
	}
	
}
