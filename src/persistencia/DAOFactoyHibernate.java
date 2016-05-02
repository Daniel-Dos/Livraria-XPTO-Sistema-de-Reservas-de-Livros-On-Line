package persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Daniel Dias
 *
 */
public class DAOFactoyHibernate  extends DAOFactory {
	
	
	private static EntityManagerFactory emf;
	
	
	//HibernateDAOFactory() {}

		public static EntityManagerFactory getEntityManagerFactory() {
			if(emf == null) {
				emf = Persistence.createEntityManagerFactory("DAO");
			}
			return emf;
		}
		
		public static void closeEntityManagerFactory() {
			if(emf != null && emf.isOpen()) emf.close();
		
		}
	

	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOUsuario()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOUsuario() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOLivro()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOLivro() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOReserva()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOReserva() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOUsuarioHibernate()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOUsuarioHibernate() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return new UsuarioHibernate();
	}

	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOLivroHibernate()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOLivroHibernate() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return new LivroHibernate();
	}

	/* (non-Javadoc)
	 * @see persistencia.DAOFactory#getGenericoDAOReservaHibernate()
	 */
	@Override
	public GenericDAO<?> getGenericoDAOReservaHibernate() throws ClassCastException, Exception {
		// TODO Auto-generated method stub
		return new ReservaHibernate();
	}

}
