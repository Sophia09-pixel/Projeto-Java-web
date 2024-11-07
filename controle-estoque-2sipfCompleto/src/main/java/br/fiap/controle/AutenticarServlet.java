package br.fiap.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.fiap.modelo.bean.Usuario;
import br.fiap.modelo.dao.UsuarioDAO;

/**
 * Servlet implementation class AutenticarServlet
 */
@WebServlet("/Autenticar")
public class AutenticarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Usuario usuario = new UsuarioDAO().autenticar(email,senha);
		if(usuario != null && "admin".equalsIgnoreCase(usuario.getPerfil().getPerfil())) {
			HttpSession session = request.getSession();
			session.setAttribute("nome", usuario.getNome());
			response.sendRedirect("admin/dashboard.jsp");
		}

	}

}
