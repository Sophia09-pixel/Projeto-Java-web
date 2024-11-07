package br.fiap.modelo.dao;

import java.sql.SQLException;

import br.fiap.modelo.bean.Fornecedor;
import br.fiap.modelo.bean.Produto;
import br.fiap.modelo.connection.ConnectionFactory;

public class ProdutoDAO extends DAO{

	public ProdutoDAO() {
		this.connection = ConnectionFactory.getInstance().getConnection();
	}
	
	public void cadastrar(Produto produto) {

		int idFornecedor = 0;

		try {
			// inicio da transação --> desativa o commit automatico
			connection.setAutoCommit(false);
			
			sql = "select id_fornecedor from java_fornecedor where nome = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, produto.getFornecedor().getNome());
			rs = ps.executeQuery();

			if (rs.next()) {
				idFornecedor = rs.getInt(1);
			}

			// inserção na tabela usuário
			sql = "insert into java_produto values (sequencia_produto.nextval, ?,?,?,?)";
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, produto.getNome());
			ps.setInt(2, produto.getQtdEstoque());
			ps.setDouble(3, produto.getPreco());
			ps.setInt(4, idFornecedor);			
			ps.execute();

			//confirma todas as operações no banco de dados
			connection.commit();
			
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar o Produto" +e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro ao cadastrar o produto" +e1);
				
			}
		}
	}
	
	
	
}
