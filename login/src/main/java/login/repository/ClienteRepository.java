package login.repository;

import login.cliente.model.ClienteEntity;
import login.connection.MysqlDBCon;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteRepository implements IClienteRepository{

	private final static String QUERY_LOGIN = new StringBuilder()
			.append("SELECT idCliente, emailCliente, passCliente from Cliente WHERE emailCliente = '%s' AND passCliente = '%s'")
			.toString();
			
	@Override
	public ClienteEntity getByLogin(String user, String password) throws SQLException{
		ClienteEntity response = new ClienteEntity();
		try (MysqlDBCon db = MysqlDBCon.getInstance()){
			ResultSet result = db.executeQuery(String.format(QUERY_LOGIN, user, password));
			while(result.next()) {
				response.setIdCliente(result.getInt("idCliente"));
				response.setEmailCliente(result.getString("emailCliente"));
				response.setPassCliente(result.getString("passCliente"));
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}
}
