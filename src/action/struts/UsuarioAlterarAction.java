/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.struts;

import action.form.bean.UsuarioForm;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Usuario;
import modelos.UsuarioNormal;
import modelos.UsuarioVip;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import persistencia.DAOFactory;
import persistencia.GenericDAO;

/**
 *
 * @author Daniel Dias
 */
public class UsuarioAlterarAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
   // private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        Usuario usuario = null;
        String msg = null;
        DAOFactory df = null;
        
        GenericDAO<Usuario> daoUsuario = null;
        
        try {
            
             
           df = DAOFactory.getDaoFactory(DAOFactory.HIBERNATE);
            
            daoUsuario = (GenericDAO<Usuario>) df.getGenericoDAOUsuarioHibernate();
            
            if (request.getParameter("rdbTipo").equals("UsuarioVip")) {
                usuario = new UsuarioVip();
            } else {
                usuario = new UsuarioNormal();
            }
            BeanUtils.copyProperties(usuario, form);
           daoUsuario.alterar(usuario);
            
            msg = "Usuario Alterado com Sucesso!!";   
        } catch(ClassNotFoundException e){
            msg = "Erro de Driver";
            e.printStackTrace();
        } catch(SQLException e){
            msg = "Erro de SQL";
            e.printStackTrace();
        } catch(Exception e){
            msg = "Erro";
            e.printStackTrace();
        }
        
        request.setAttribute("aux", msg);
        return mapping.findForward("sucessoConsultarUsuario");
    }
}
