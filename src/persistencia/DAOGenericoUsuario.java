package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelos.Usuario;
import modelos.UsuarioNormal;
import modelos.UsuarioVip;

/**
 * @author Daniel Dias
 *
 */
public class DAOGenericoUsuario implements GenericDAO<Usuario> {

    private Connection conexao = null;
    //private Statement sentenca = null;
    private ResultSet resultado = null;
    private PreparedStatement stm = null;

    /**
     *
     */
    public DAOGenericoUsuario() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub

        conexao = DAOFactoryOracle.createConnection();

    }

    @Override
    public void incluir(Usuario entidade) throws SQLException {
		// TODO Auto-generated method stub

        stm = conexao.prepareStatement("INSERT INTO USUARIO VALUES (?,?,?,?,?,?)");

    	
        stm.setString(1, entidade.getLogin());
        stm.setString(2, entidade.getSenha());
        stm.setString(3, entidade.getNome());
        stm.setString(4, entidade.getTelefone());
        stm.setString(5, entidade.getEmail());
        stm.setString(6, entidade.getClass().getSimpleName());

        stm.executeUpdate();
        stm.close();

    }

    @Override
    public void excluir(Usuario entidade) throws SQLException {
		// TODO Auto-generated method stub

            
        stm = conexao.prepareStatement("DELETE FROM RESERVA WHERE USUARIO = ?");

        stm.setString(1, entidade.getLogin());
        stm.executeUpdate();
        stm.close();

       
        stm = conexao.prepareStatement("DELETE FROM USUARIO WHERE LOGIN = ?");

    	
        stm.setString(1, entidade.getLogin());
        stm.executeUpdate();
        stm.close();

    }

    @Override
    public void alterar(Usuario entidade) throws SQLException {
		// TODO Auto-generated method stub

        stm = conexao.prepareStatement("UPDATE USUARIO SET NOME = ?, TELEFONE = ? , EMAIL = ? WHERE LOGIN = ?");

    	
        stm.setString(4, entidade.getLogin());
        stm.setString(1, entidade.getNome());
        stm.setString(2, entidade.getTelefone());
        stm.setString(3, entidade.getEmail());

        stm.executeUpdate();
        stm.close();

    }

    @Override
    public Usuario consultar(Usuario entidade) throws SQLException {

        Usuario aux = null;
        String tipo = null;

       
        stm = conexao.prepareStatement("SELECT * FROM USUARIO WHERE LOGIN = ?");

        
        stm.setString(1, entidade.getLogin());

        resultado = stm.executeQuery();

        while (resultado.next()) {

            tipo = resultado.getString(6);

            if (tipo.equals("UsuarioVip")) {
                aux = new UsuarioVip();
            } else {
                aux = new UsuarioNormal();
            }

            aux.setLogin(resultado.getString(1));
            aux.setNome(resultado.getString(3));
            aux.setTelefone(resultado.getString(4));
            aux.setEmail(resultado.getString(5));

        }
        resultado.close();
        stm.close();
        return aux;

    }

    public Usuario lembrarSenha(Usuario entidade) throws SQLException {
		// TODO Auto-generated method stub

        Usuario aux = null;
        String tipo = null;

	     
        stm = conexao.prepareStatement("SELECT * FROM USUARIO WHERE EMAIL = ?");
                

	        
        stm.setString(1, entidade.getEmail());

        resultado = stm.executeQuery();

        while (resultado.next()) {

            tipo = resultado.getString(6);

            if (tipo.equals("UsuarioVip")) {
                aux = new UsuarioVip();
            } else {
                aux = new UsuarioNormal();
            }

            //aux.setLogin(resultado.getString(1));
            aux.setSenha(resultado.getString(2));
            aux.setNome(resultado.getString(3));
	           // aux.setTelefone(resultado.getString(4));

        }
        resultado.close();
        stm.close();
        return aux;

    }

    public Usuario consultarLoginSenha(Usuario entidade) throws SQLException {

        Usuario aux = null;
        String tipo = null;

        stm = conexao.prepareStatement("SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = ?");
             
        stm.setString(1, entidade.getLogin());
        stm.setString(2, entidade.getSenha());

        resultado = stm.executeQuery();

        while (resultado.next()) {

            tipo = resultado.getString(6);

            if (tipo.equals("UsuarioVip")) 
                aux = new UsuarioVip();
             else 
                aux = new UsuarioNormal();
            

            aux.setLogin(resultado.getString(1));
            aux.setSenha(resultado.getString(2));
            aux.setNome(resultado.getString(3));
            aux.setTelefone(resultado.getString(4));
            aux.setEmail(resultado.getString(5));

        }
        resultado.close();
        stm.close();
        return aux;
    }

    @Override
    public List<Usuario> getAllUsers() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Usuario> getUser(Usuario entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
