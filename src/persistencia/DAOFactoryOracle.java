package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactoryOracle extends DAOFactory{
	
	
	
	public  DAOFactoryOracle() {
		
		createConnection();
	}
	
	
	public static Connection createConnection() {
		
		Connection conexao = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","akatsuki");
		} catch(SQLException e) {
			System.out.println("Erro de SQL :" + e.getMessage());
		} catch(ClassNotFoundException e) {
			System.out.println("Classe não encontrada :" + e.getMessage());
		}
		
		return conexao;
	}
    
	@Override
	public GenericDAO<?> getGenericoDAOUsuario() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return new DAOGenericoUsuario();
	}

    @Override
    public GenericDAO<?> getGenericoDAOLivro() throws ClassCastException, Exception {
        return new DAOGenericoLivro();
    }

    @Override
    public GenericDAO<?> getGenericoDAOReserva() throws ClassCastException, Exception {
        return new DAOGenerioReserva();
    }


	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOUsuarioHibernate()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOUsuarioHibernate() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOLivroHibernate()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOLivroHibernate() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOReservaHibernate()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOReservaHibernate() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
	
}
