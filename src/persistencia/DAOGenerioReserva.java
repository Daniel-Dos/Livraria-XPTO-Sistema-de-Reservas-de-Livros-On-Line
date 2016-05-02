/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import modelos.Livro;
import modelos.Reserva;
import modelos.Usuario;
import modelos.UsuarioVip;

/**
 *
 * @author Daniel Dias
 */
public class DAOGenerioReserva implements GenericDAO<Reserva> {

    private PreparedStatement stm = null;
    private Connection conexao = null;
    private ResultSet resultado = null;

    public DAOGenerioReserva() {

        conexao = DAOFactoryOracle.createConnection();
        
    }

    @Override
    public void incluir(Reserva entidade) throws SQLException {

       
       stm = conexao.prepareStatement("INSERT INTO RESERVA VALUES(?,?,?)");

        stm.setString(1, entidade.getUsuario().getLogin());
        stm.setString(2, entidade.getCodLivro().getCodigo());
        stm.setDate(3, new Date(entidade.getDataCadastro().getTimeInMillis()));

        stm.executeUpdate();
        stm.close();
    }

    @Override
    public void excluir(Reserva entidade) throws SQLException {
       
        stm = conexao.prepareStatement("DELETE FROM RESERVA WHERE DATARESERVA = ? AND USUARIO = ? AND CODLIVRO = ?");

        stm.setDate(1, new Date(entidade.getDataCadastro().getTimeInMillis()));
        stm.setString(2, entidade.getUsuario().getLogin());
        stm.setString(3, entidade.getCodLivro().getCodigo());

        stm.executeUpdate();
        stm.close();
    }

    @Override
    public void alterar(Reserva entidade) throws SQLException {
        
        stm = conexao.prepareStatement("UPDATE RESERVA SET DATARESERVA = ? WHERE USUARIO = ? AND CODLIVRO = ? ");

        stm.setDate(1, new Date(entidade.getDataCadastro().getTimeInMillis()));
        stm.setString(2, entidade.getUsuario().getLogin());
        stm.setString(3, entidade.getCodLivro().getCodigo());
        stm.executeUpdate();
        stm.close();
    }

    @Override
    public Reserva consultar(Reserva entidade) throws SQLException {

        Reserva aux = null;
        Usuario usuario = null;
        Livro livro = null;
        
        stm = conexao.prepareStatement("SELECT * FROM RESERVA WHERE USUARIO = ?");

        stm.setString(1, entidade.getUsuario().getLogin());

        resultado = stm.executeQuery();

        while (resultado.next()) {

            usuario = new UsuarioVip();
            livro = new Livro();
            aux = new Reserva();

            usuario.setLogin(resultado.getString(1));

            aux.setUsuario(usuario);
          //  usuario.addReserva(aux);

            livro.setCodigo(resultado.getString(2));
            aux.setCodLivro(livro);
          //  livro.addReserva(aux);

            Calendar data = Calendar.getInstance();
            data.setTime(resultado.getDate(3));
            aux.setDataCadastro(data);

        }
        stm.close();
        return aux;
    }

   

    
    @Override
    public List<Reserva> getAllUsers() throws SQLException {
       
        List<Reserva> users = new ArrayList<Reserva>();
		
		
			
			stm = conexao.prepareStatement("SELECT * FROM RESERVA ORDER BY CODLIVRO");
			resultado = stm.executeQuery();
			
			while(resultado.next()) {
				
				Reserva reserva = new Reserva();
				Livro livro = new Livro();
				Usuario usuario = new UsuarioVip();
				
				
				usuario.setLogin(resultado.getString(1));
				
				  reserva.setUsuario(usuario);
				 // usuario.addReserva(reserva);
				  
				  livro.setCodigo(resultado.getString(2));
				  reserva.setCodLivro(livro);
				//livro.addReserva(reserva);
				  
				   
				  Calendar data = Calendar.getInstance();
				  data.setTime(resultado.getDate(3));
				  reserva.setDataCadastro(data);
				  
				  users.add(reserva);
				  	
			}
		
		
		return users;

    }

    @Override
    public Reserva lembrarSenha(Reserva entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reserva consultarLoginSenha(Reserva entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reserva> getUser(Reserva entidade) throws SQLException {
         
        List<Reserva> user = null;
		
		Reserva aux = null;
		Usuario usuario = null;
		Livro livro = null;
		
		stm = conexao.prepareStatement("SELECT * FROM RESERVA WHERE USUARIO = ?");
		
		stm.setString(1, entidade.getUsuario().getLogin());
		
		resultado = stm.executeQuery();
		user  = new ArrayList<Reserva>();
		
		while(resultado.next()) {
			
			 aux = new Reserva();
			 livro = new Livro();
			 usuario = new UsuarioVip();
			
			
			usuario.setLogin(resultado.getString(1));
			
			aux.setUsuario(usuario);
			//  usuario.addReserva(aux);
			  
			  livro.setCodigo(resultado.getString(2));
			  aux.setCodLivro(livro);
			//livro.addReserva(aux);
			  
			   
			  Calendar data = Calendar.getInstance();
			  data.setTime(resultado.getDate(3));
			  aux.setDataCadastro(data);
			  
			  user.add(aux);
			  	
		}
		
		
		
		return user;
    }

}
