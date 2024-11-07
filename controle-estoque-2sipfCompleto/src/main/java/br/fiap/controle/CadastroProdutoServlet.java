package br.fiap.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.modelo.bean.Fornecedor;
import br.fiap.modelo.bean.Produto;
import br.fiap.modelo.dao.ProdutoDAO;

/**
 * Servlet implementation class CadastroProdutoServlet
 */
@WebServlet("/CadastroProduto")
public class CadastroProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Fornecedor fornecedor = new Fornecedor();
		Produto produto = new Produto();
		ProdutoDAO dao = new ProdutoDAO();
		
		String nome = request.getParameter("nome");
		int qtdEstoque = Integer.parseInt(request.getParameter("qtdEstoque"));
		double preco = Double.parseDouble(request.getParameter("preco"));
		String idFornecedor = request.getParameter("fornecedor");
		
		produto.setNome(nome);
		produto.setQtdEstoque(qtdEstoque);
		produto.setPreco(preco);
		fornecedor.setNome(idFornecedor);
		produto.setFornecedor(fornecedor);
		
		dao.cadastrar(produto);
		System.out.println("Produto Cadastrado: "+ produto);
		
		//response.sendRedirect("index.html");
		//request.getRequestDispatcher("admin/dashboard.jsp").forward(request, response);
		response.sendRedirect("admin/dashboard.jsp");
		
	}

}
