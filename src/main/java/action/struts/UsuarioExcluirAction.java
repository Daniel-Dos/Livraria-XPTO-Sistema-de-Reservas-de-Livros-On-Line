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

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.bean.UsuarioForm;
import modelos.Usuario;
import modelos.UsuarioVip;
import persistencia.DAOFactory;
import persistencia.GenericDAO;

/**
 * @author daniel
 * github:Daniel-Dos
 * daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
public class UsuarioExcluirAction extends org.apache.struts.action.Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Usuario usuario = null;
		DAOFactory df = null;
		String msg = null;
		GenericDAO<Usuario> daoUsuario = null;

		try {

			df = DAOFactory.getDaoFactory(DAOFactory.HIBERNATE);
			daoUsuario = (GenericDAO<Usuario>) df.getGenericoDAOUsuarioHibernate();

			usuario = new UsuarioVip();
			BeanUtils.copyProperties(usuario, (UsuarioForm) form);

			daoUsuario.excluir(usuario);
			msg = "Exclusão de Usuario Realizada com Sucesso.";
		} catch (ClassNotFoundException e) {
			msg = "Erro de Driver";
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			msg = "Erro de SQL";
			System.out.println(e.getMessage());
		} catch (Exception e) {
			msg = "Erro generio";
			System.out.println(e.getMessage());
		}
		request.setAttribute("excluir", msg);
		request.getSession().invalidate();
		return mapping.findForward("sucessoExcluir");
	}
}