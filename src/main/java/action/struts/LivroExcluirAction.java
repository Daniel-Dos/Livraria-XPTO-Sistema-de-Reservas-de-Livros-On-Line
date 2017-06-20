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
package action.struts;

import action.form.bean.LivroForm;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Livro;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import persistencia.DAOFactory;
import persistencia.GenericDAO;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public class LivroExcluirAction extends org.apache.struts.action.Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Livro livro = null;
		DAOFactory df = null;
		String msg = null;
		GenericDAO<Livro> daoLivo = null;

		try {

			df = DAOFactory.getDaoFactory(DAOFactory.HIBERNATE);
			daoLivo = (GenericDAO<Livro>) df.getGenericoDAOLivroHibernate();

			livro = new Livro();
			BeanUtils.copyProperties(livro, (LivroForm) form);

			daoLivo.excluir(livro);

			msg = "Exclusão do Livro realizada com sucesso";

		} catch (ClassNotFoundException e) {
			msg = "Erro de Driver";
		} catch (SQLException e) {
			msg = "Erro de SQL";
		} catch (Exception e) {
			msg = "Erro";
			System.out.println(e.getMessage());
		}
		request.setAttribute("aux", msg);
		return mapping.findForward("sucessoExcluirLivro");
	}
}