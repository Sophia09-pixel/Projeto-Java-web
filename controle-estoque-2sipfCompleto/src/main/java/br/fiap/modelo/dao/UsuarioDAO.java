package br.fiap.modelo.dao;

import java.sql.SQLException;
import java.util.Base64;

import br.fiap.modelo.bean.Perfil;
import br.fiap.modelo.bean.Usuario;
import br.fiap.modelo.connection.ConnectionFactory;
import br.fiap.modelo.util.Util;

public class UsuarioDAO extends DAO {

	public UsuarioDAO() {
		this.connection = ConnectionFactory.getInstance().getConnection();
	}

	public Usuario autenticar(String email, String senha) {
		Usuario usuario = null;
		Perfil perfil = null;

		sql = "select u.nome, u.senha, u.salt, p.nome as perfil from java_usuario u "
				+ "join java_usuario_perfil up on u.id_usuario = up.id_usuario "
				+ "join java_perfil p on p.id_perfil = up.id_perfil "
				+ "where email = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				byte[] salt = Base64.getDecoder().decode(rs.getString("salt"));
				String senhaCodificada = Util.codificar(senha, salt);
				
				if(senhaCodificada.equals(rs.getString("senha"))) {
					usuario = new Usuario();
					perfil = new Perfil();
					perfil.setPerfil(rs.getString("perfil"));
					usuario.setNome(rs.getString("nome"));
					usuario.setPerfil(perfil);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public void cadastrar(Usuario usuario) {

		int idUsuario = 0, idPerfil = 0;

		try {
			// inicio da transação --> desativa o commit automatico
			connection.setAutoCommit(false);

			// inserção na tabela usuário
			sql = "insert into java_usuario values (sequencia_usuario.nextval, ?,?,?,?,?)";
			ps = connection.prepareStatement(sql);

			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, 1);
			ps.setString(5, usuario.getSalt());
			ps.execute();

			// Obtem o id do usuario que acabou de ser inserido
			sql = "select sequencia_usuario.currval from dual";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				idUsuario = rs.getInt(1);
			}

			// obtém o ID do perfil que o usuario escolheu
			sql = "select id_perfil from java_perfil where nome = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, usuario.getPerfil().getPerfil());
			rs = ps.executeQuery();

			if (rs.next()) {
				idPerfil = rs.getInt(1);
			}

			// inserção na tabela java_usuario_perfil
			sql = "insert into java_usuario_perfil values (?,?) ";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idUsuario);
			ps.setInt(2, idPerfil);
			ps.execute();
			
			//confirma todas as operações no banco de dados
			connection.commit();
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro ao cadastrar o usuario\n" +e1);
				
			}
			System.out.println("Erro ao cadastrar o usuario\n" +e);
		}
	}

}
