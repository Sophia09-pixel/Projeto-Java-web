package br.fiap.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.fiap.modelo.bean.Fornecedor;
import br.fiap.modelo.dao.FornecedorDAO;

/**
 * Servlet implementation class FornecedorServlet
 */
@WebServlet("/fornecedor")
public class FornecedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FornecedorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Fornecedor> lista = new FornecedorDAO().listar();
		HttpSession session = request.getSession();
		
		session.setMaxInactiveInterval(30 * 60);
		session.setAttribute("lista", lista);
		response.sendRedirect("produto/formCadastroProduto.jsp");
	}

}
