package login.connection;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class MysqlDBCon implements Closeable{
	
	private static MysqlDBCon instance;
	
	private static final String USERNAME = "myconstructionuser";
	private static final String PASSWORD = "holahola";
	private static final String URL = "jdbc:mysql://localhost:3306/myconstructionbd?serverTimezone=UTC";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private Connection connection;
	
	private PreparedStatement preparedStatement;
	
	private MysqlDBCon() {
		try{
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		}catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(MysqlDBCon.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
	}
	
	public static MysqlDBCon getInstance(){
		return instance == null ? new MysqlDBCon() : instance;
	}
	
	public ResultSet executeQuery(final String query) throws SQLException{
		this.preparedStatement = connection.prepareStatement(query);
		return this.preparedStatement.executeQuery();
	}
	
	@Override
	public void close() throws IOException{
		try {
			if (!connection.isClosed()) {
				this.connection.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(MysqlDBCon.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
