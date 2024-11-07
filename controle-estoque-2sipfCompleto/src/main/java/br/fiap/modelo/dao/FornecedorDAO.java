package br.fiap.modelo.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.fiap.modelo.bean.Fornecedor;
import br.fiap.modelo.connection.ConnectionFactory;

public class FornecedorDAO extends DAO {
	
	public FornecedorDAO() {
		this.connection = ConnectionFactory.getInstance().getConnection();
	}
	
	public List<Fornecedor> listar() {
		List<Fornecedor> lista = new LinkedList<Fornecedor>();
		sql = "select * from java_fornecedor order by nome";
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getInt("id_fornecedor"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setCnpj(rs.getDouble("cnpj"));
				lista.add(fornecedor);
			}
			
		}catch(SQLException e) {
			System.out.println("Erro ao listar perfil\n "+e);
		}
		
		return lista;
	}
}
