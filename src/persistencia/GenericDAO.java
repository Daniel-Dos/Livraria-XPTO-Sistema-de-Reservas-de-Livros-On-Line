package persistencia;

import java.sql.SQLException;
import java.util.List;
import modelos.Reserva;

/**
 * @author Daniel Dias
 *
 */
public interface GenericDAO<T> {

	void incluir(T entidade) throws SQLException;
	void excluir(T entidade) throws SQLException;
	void alterar(T entidade) throws SQLException;
	T consultar(T entidade) throws SQLException;
	List<T> getAllUsers() throws SQLException;
        T lembrarSenha(T entidade) throws SQLException; // para retornar a senha e o nome do usuario
        T consultarLoginSenha(T entidade) throws SQLException;
        List<T> getUser(T entidade) throws SQLException;
       

   
}
