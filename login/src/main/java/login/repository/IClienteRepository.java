package login.repository;

import java.sql.SQLException;
import login.cliente.model.ClienteEntity;

public interface IClienteRepository {
	ClienteEntity getByLogin(final String user, final String pass) throws SQLException;
}
