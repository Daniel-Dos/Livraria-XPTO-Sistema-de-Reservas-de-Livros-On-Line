package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import modelos.Livro;
import modelos.Reserva;
import modelos.Usuario;
import modelos.UsuarioVip;

/**
 * @author Daniel Dias
 *
 */
public class ReservaHibernate implements GenericDAO<Reserva> {

    private EntityManagerFactory emf;
    private EntityManager manager;

    public ReservaHibernate() {

        this.emf = DAOFactoyHibernate.getEntityManagerFactory();
    }

    @Override
    public void incluir(Reserva entidade) throws SQLException {

        try {

            manager = emf.createEntityManager();
            manager.getTransaction().begin();

            Livro idLivro = manager.find(Livro.class, entidade.getCodLivro().getCodigo());
            entidade.setCodLivro(idLivro);

            Usuario idU = manager.find(Usuario.class, entidade.getUsuario().getLogin());
            entidade.setUsuario(idU);

            manager.persist(entidade);
			// manager.flush();
            // manager.clear();
            manager.getTransaction().commit();
        } finally {

            manager.close();
        }

    }

    @Override
    public void excluir(Reserva entidade) throws SQLException {

        
        
    }

    @Override
    public void alterar(Reserva entidade) throws SQLException {
		// TODO Auto-generated method stub

    }

    @Override
    public Reserva consultar(Reserva entidade) throws SQLException {
        return null;
    }

    @Override
    public List<Reserva> getAllUsers() throws SQLException {

        return null;

    }

    @Override
    public Reserva lembrarSenha(Reserva entidade) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reserva consultarLoginSenha(Reserva entidade) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Reserva> getUser(Reserva entidade) throws SQLException {

        Usuario usuario = null;

        List<Reserva> lista = null;

        try {

            manager = emf.createEntityManager();
            manager.getTransaction().begin();

            usuario = new UsuarioVip();

            usuario = manager.find(Usuario.class, entidade.getUsuario().getLogin());
            String consulta = "select * from RESERVA a where a.usuario =:usuario";
            Query query = manager.createNativeQuery(consulta, Reserva.class);
            entidade.setUsuario(usuario);
            query.setParameter("usuario", entidade.getUsuario());

            lista = new ArrayList<>();

            lista.add((Reserva) query.getSingleResult());

            return lista;
        } finally {

            manager.close();
        }

    }

}
