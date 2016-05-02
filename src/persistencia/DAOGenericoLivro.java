/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelos.Livro;

/**
 *
 * @author Daniel Dias
 */
public class DAOGenericoLivro  implements GenericDAO<Livro>{
    
    private Connection conexao = null;
    private PreparedStatement stm = null;
    private ResultSet resultado = null;

    public DAOGenericoLivro() throws ClassNotFoundException, Exception {
        conexao = DAOFactoryOracle.createConnection();
        
    }
    
    @Override
    public void incluir(Livro entidade) throws SQLException {
        
        
        stm = conexao.prepareStatement("INSERT INTO LIVRO VALUES(?,?,?,?)");
        
        stm.setString(1, entidade.getCodigo());
    	stm.setString(2, entidade.getNome());
    	stm.setString(3, entidade.getAutor());
    	stm.setString(4, entidade.getDescricao());
    	
    	
    	stm.execute();
    	stm.close();
    }

    @Override
    public void excluir(Livro entidade) throws SQLException {
        
        stm = conexao.prepareStatement("DELETE FROM LIVRO WHERE CODIGO = ?");
        
        stm.setString(1, entidade.getCodigo());
    	stm.executeUpdate();
    	stm.close();
        
    }

    @Override
    public void alterar(Livro entidade) throws SQLException {
         
       stm = conexao.prepareStatement("UPDATE LIVRO SET NOME = ? ,AUTOR = ?, DESCRICAO = ? WHERE CODIGO = ?");
        
        stm.setString(4, entidade.getCodigo());
    	stm.setString(1,entidade.getNome());
    	stm.setString(2, entidade.getAutor());
    	stm.setString(3, entidade.getDescricao());
    	
    	stm.executeUpdate();
    	stm.close();
        
        
    }

    @Override
    public Livro consultar(Livro entidade) throws SQLException {
        
        Livro aux = entidade;
        
        stm = conexao.prepareStatement("SELECT * from LIVRO WHERE CODIGO = ?") ;
        
        stm.setString(1, entidade.getCodigo());
        
        resultado = stm.executeQuery();
        
        while(resultado.next()){
            
        	
            aux.setCodigo(resultado.getString(1));
            aux.setNome(resultado.getString(2));
            aux.setAutor(resultado.getString(3));
            aux.setDescricao(resultado.getString(4));
        	
        }
        stm.close();
        return aux;
    }

    @Override
    public List<Livro> getAllUsers() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro lembrarSenha(Livro entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro consultarLoginSenha(Livro entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Livro> getUser(Livro entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
