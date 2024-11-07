package br.fiap.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.fiap.modelo.bean.Perfil;
import br.fiap.modelo.connection.ConnectionFactory;

public class PerfilDAO extends DAO {
	
	public PerfilDAO() {
		this.connection = ConnectionFactory.getInstance().getConnection();
	}
	
	public List<Perfil> listar() {
		List<Perfil> lista = new LinkedList<Perfil>();
		sql = "select * from java_perfil order by nome";
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Perfil perfil = new Perfil();
				perfil.setIdPerfil(rs.getInt("id_perfil"));
				perfil.setPerfil(rs.getString("nome"));
				
				lista.add(perfil);
			}
			
		}catch(SQLException e) {
			System.out.println("Erro ao listar perfil\n "+e);
		}
		
		return lista;
	}
}
