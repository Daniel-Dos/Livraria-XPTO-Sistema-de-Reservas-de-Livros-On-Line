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
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
public class LembrarSenhaAction extends org.apache.struts.action.Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Usuario usuario = null;
		DAOFactory df = null;
		String msg = null;
		String msg1 = null;
		GenericDAO<Usuario> daoUsuario = null;

		try {

			df = DAOFactory.getDaoFactory(DAOFactory.HIBERNATE);
			daoUsuario = (GenericDAO<Usuario>) df.getGenericoDAOUsuarioHibernate();

			usuario = new UsuarioVip();

			UsuarioForm userForm = (UsuarioForm) form;

			BeanUtils.copyProperties(usuario, userForm);

			usuario = daoUsuario.lembrarSenha(usuario);

			// Utilização do envio de email
			if (usuario != null) {
				request.setAttribute("usuario", usuario);

				Properties props = new Properties();

				// Parametros de conexao com sevirdor GMAIL
				props.put("mail.smtp.host", "localhost");
				props.put("mail.smtp.socketFactory.port", "25");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "25");
				props.put("mail.smtp.starttls.enable", "false");

				String naoResponda = "nao-responda@soujava.rio.org.br";
				String passWord = "123456";
				Session session = Session.getInstance(props, new javax.mail.Authenticator() {

					@Override
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication(naoResponda, passWord);
					}
				});

				session.setDebug(true);

				try {
					MimeMessage message = new MimeMessage(session);

					InternetAddress[] toUser = InternetAddress.parse(userForm.getEmail());
					InternetAddress[] toReply = InternetAddress.parse(naoResponda);

					message.setReplyTo(toReply);
					message.setFrom(naoResponda);
					message.setRecipients(Message.RecipientType.TO, toUser);
					message.setSubject("Recuperação de Senha", "UTF-8");

					String msg11 = usuario.getNome() + " Sua Senha é : " + usuario.getSenha();
					message.setContent(msg11, "text/plain; charset=UTF-8");

					Transport.send(message);

				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
				msg = "Sua senha foi recuperada com Sucesso e enviada ao seu email";
			} else {
				msg1 = "Email nao encontrado";
				request.setAttribute("msg1", msg1);
			}

		} catch (ClassNotFoundException e) {
			msg = "Erro de Driver";
			e.printStackTrace();
		} catch (SQLException e) {
			msg = "Erro de SQL";
			e.printStackTrace();
		} catch (Exception e) {
			msg = "Erro generico";
			e.printStackTrace();
		}

		request.setAttribute("msg", msg);
		return mapping.findForward("sucessoRecuperarSenha");
	}
}
