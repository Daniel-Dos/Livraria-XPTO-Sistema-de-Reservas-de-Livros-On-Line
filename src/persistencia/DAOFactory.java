package persistencia;

import java.sql.SQLException;

public abstract class DAOFactory {
    
    public final static int DERBY = 1;
    public final static int ORACLE = 2;
    public static final int HIBERNATE = 3;
    
    public static DAOFactory getDaoFactory(int x) throws ClassNotFoundException, SQLException{

        if(x ==DERBY)
        return new DAOFactoryDerby();
        else
            if(x==ORACLE)
                return new DAOFactoryOracle();
        if(x==HIBERNATE)
        	return new DAOFactoyHibernate();
            else
                return null;
    }
    
    
    public abstract GenericDAO<?> getGenericoDAOUsuario() throws ClassCastException,Exception;
    public abstract GenericDAO<?> getGenericoDAOLivro() throws ClassCastException,Exception;
    public abstract GenericDAO<?> getGenericoDAOReserva() throws ClassCastException,Exception;
    public abstract GenericDAO<?> getGenericoDAOUsuarioHibernate() throws ClassCastException,Exception;
    public abstract GenericDAO<?> getGenericoDAOLivroHibernate() throws ClassCastException,Exception;
    public abstract GenericDAO<?> getGenericoDAOReservaHibernate() throws ClassCastException,Exception;
    
   
    
}