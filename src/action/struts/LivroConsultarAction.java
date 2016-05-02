/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.struts;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.bean.LivroForm;
import modelos.Livro;
import persistencia.DAOFactory;
import persistencia.GenericDAO;

/**
 *
 * @author Daniel Dias
 */
public class LivroConsultarAction extends org.apache.struts.action.Action {

	/* forward name="success" path="" */
	// private static final String SUCCESS = "success";

	/**
	 * This is the action called from the Struts framework.
	 *
	 * @param mapping
	 *            The ActionMapping used to select this instance.
	 * @param form
	 *            The optional ActionForm bean for this request.
	 * @param request
	 *            The HTTP Request we are processing.
	 * @param response
	 *            The HTTP Response we are processing.
	 * @throws java.lang.Exception
	 * @return
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Livro livro = null;
		DAOFactory df = null;
		String msg1 = null;

		GenericDAO<Livro> daoLivro = null;

		try {

			df = DAOFactory.getDaoFactory(DAOFactory.HIBERNATE);
			daoLivro = (GenericDAO<Livro>) df.getGenericoDAOLivroHibernate();

			 livro = new Livro();

	            BeanUtils.copyProperties(livro, (LivroForm) form);

	            //livro = daoLivro.consultar(livro);
			    msg1 = "Consulta de Livro Realizada com Sucesso";
			    
			    
			    
		} catch (ClassNotFoundException e) {
			// msg = "Erro de Driver";
		} catch (SQLException e) {
			// msg = "Erro de SQL";
		} catch (Exception e) {
			// msg = "Erro";
		}

		request.setAttribute("aux", msg1);
		request.setAttribute("retorno", daoLivro.getAllUsers());
		return mapping.findForward("sucessoConsultarLivro");
	}
}
