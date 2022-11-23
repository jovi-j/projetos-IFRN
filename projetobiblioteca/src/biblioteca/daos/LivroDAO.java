package biblioteca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblioteca.models.Livro;

public class LivroDAO {

	private Connection connection;

	public LivroDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Livro livro) {

		String sql = "insert into livros (nome, autor, secao, ano, quantidade) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, livro.getNome());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getSecao());
			stmt.setInt(4, livro.getAno());
			stmt.setInt(5, livro.getQuantidade());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Livro> getLivros() {
		List<Livro> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livros;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Livro
				Livro l = new Livro();
				l.setId(rs.getLong("id"));
				l.setNome(rs.getString("nome"));
				l.setAutor(rs.getString("autor"));
				l.setSecao(rs.getString("secao"));
				l.setAno(rs.getInt("ano"));
				l.setQuantidade(rs.getInt("quantidade"));
				result.add(l);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Livro livro) {
		String sql = "update livros set nome=?, autor=?, secao=?, ano=?, quantidade=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, livro.getNome());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getSecao());
			stmt.setInt(4, livro.getAno());
			stmt.setInt(5, livro.getQuantidade());
			stmt.setLong(6, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Livro livro) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from livros where id=?;");
			stmt.setLong(1, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Livro getById(Long id) {
		Livro result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livros where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = new Livro();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setAutor(rs.getString("autor"));
				result.setSecao(rs.getString("secao"));
				result.setAno(rs.getInt("ano"));
				result.setQuantidade(rs.getInt("quantidade"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	

}
