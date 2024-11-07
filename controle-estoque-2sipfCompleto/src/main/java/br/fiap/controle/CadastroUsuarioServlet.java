package br.fiap.controle;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.modelo.bean.Perfil;
import br.fiap.modelo.bean.Usuario;
import br.fiap.modelo.dao.UsuarioDAO;
import br.fiap.modelo.util.Util;

/**
 * Servlet implementation class CadastroUsuarioServlet
 */
@WebServlet("/cadastroUsuario")
public class CadastroUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		Perfil perfilUsuario = new Perfil ();
		UsuarioDAO dao = new UsuarioDAO();
		
	String nome = request.getParameter("nome");
	String senha = request.getParameter("senha");
	String email = request.getParameter("email");
	String perfil = request.getParameter("perfil");
	
	
	byte [] salt = Util.getSalt();
	
	String senhaCodificada =Util.codificar(senha, salt);
	
	usuario.setNome(nome);
	usuario.setEmail(email);
	usuario.setSenha(senhaCodificada);
	perfilUsuario.setPerfil(perfil);
	usuario.setPerfil(perfilUsuario);
	usuario.setSalt(Base64.getEncoder().encodeToString(salt));
	
	dao.cadastrar(usuario);

	//redirecional para a pagina de index.html
	response.sendRedirect("index.html");
	
	
	}

}
