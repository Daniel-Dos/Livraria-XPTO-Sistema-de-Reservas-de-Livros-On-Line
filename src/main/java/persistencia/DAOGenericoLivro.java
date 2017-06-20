/*
 * Copyright © 2017 Daniel Dias (daniel.dias.analistati@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelos.Livro;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public class DAOGenericoLivro implements GenericDAO<Livro> {

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
		stm.setString(1, entidade.getNome());
		stm.setString(2, entidade.getAutor());
		stm.setString(3, entidade.getDescricao());
		stm.executeUpdate();
		stm.close();
	}

	@Override
	public Livro consultar(Livro entidade) throws SQLException {

		Livro aux = entidade;

		stm = conexao.prepareStatement("SELECT * from LIVRO WHERE CODIGO = ?");
		stm.setString(1, entidade.getCodigo());

		resultado = stm.executeQuery();

		while (resultado.next()) {
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
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
	public Livro lembrarSenha(Livro entidade) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Livro consultarLoginSenha(Livro entidade) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
	public List<Livro> getUser(Livro entidade) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}