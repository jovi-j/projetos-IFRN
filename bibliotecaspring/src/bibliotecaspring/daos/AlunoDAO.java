package bibliotecaspring.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bibliotecaspring.models.Aluno;
import bibliotecaspring.models.Livro;

public class AlunoDAO {
	private Connection connection;

	public AlunoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Aluno aluno) {

		String sql = "insert into alunos (nome, matricula, cpf, endereco, dataNascimento) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getMatricula());
			stmt.setString(3, aluno.getCpf());
			stmt.setString(4, aluno.getEndereco());
			stmt.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Aluno> pesquisar(String nomealuno) {
		List<Aluno> result = new ArrayList<>();
		String sql = "select * from alunos where nome = ?;";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nomealuno);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Aluno a = new Aluno();
				a.setId(rs.getLong("id"));
				a.setNome(rs.getString("nome"));
				a.setMatricula(rs.getInt("matricula"));
				a.setCpf(rs.getString("cpf"));
				a.setEndereco(rs.getString("endereco"));
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimeto"));
				a.setDataNascimento(dataNascimento);
				result.add(a);
			}
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Aluno> getAlunos() {
		List<Aluno> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from alunos;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto aluno
				Aluno a = new Aluno();
				a.setId(rs.getLong("id"));
				a.setNome(rs.getString("nome"));
				a.setCpf(rs.getString("cpf"));
				a.setMatricula(rs.getInt("matricula"));
				a.setEndereco(rs.getString("endereco"));
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				a.setDataNascimento(dataNascimento);
			
				result.add(a);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Aluno aluno) {
		String sql = "update alunos set nome=?, matricula=?, endereco=?, dataNascimento=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getMatricula());
			stmt.setString(3, aluno.getEndereco());
			stmt.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));
			stmt.setLong(6, aluno.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Long id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from alunos where id=?;");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Aluno getById(Long id) {
		Aluno result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from alunos where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = new Aluno();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setMatricula(rs.getInt("matricula"));
				result.setEndereco(rs.getString("endereco"));
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				result.setDataNascimento(dataNascimento);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	//Mesma coisa que o GetById, s� que usando a matricula
	
	public Aluno getByMatricula(int matricula) {
		Aluno result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from alunos where matricula = ?;");
			stmt.setInt(1, matricula);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = new Aluno();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setMatricula(rs.getInt("matricula"));
				result.setEndereco(rs.getString("endereco"));
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				result.setDataNascimento(dataNascimento);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	//Aqui � o m�todo pra ver quantos livros atrasados o aluno tem
	
//	public List<Livro> alunoLivrosAtrasados(Long idAluno) {
//		List<Livro> result = new ArrayList<>();
//		// Lista de quantos livros atrasados o aluno tem, isso aqui retorna uma lista
//
//		String sql = "select * from emprestimos where idAluno = ? and devolvido = false;";
//		Calendar dataDoEmprestimo = Calendar.getInstance();
//		Long dataAtual = dataDoEmprestimo.getTimeInMillis();
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//
//			stmt.setLong(1, idAluno);
//			ResultSet rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				dataDoEmprestimo.setTime(rs.getDate("dataEmprestimo"));
//
//				if (dataDoEmprestimo.getTimeInMillis() + 1000 * 60 * 60 * 24 * 14 < dataAtual) {
//					//se a data que foi feita o empr�stimo + 14 dias for maior que a data de hoje, ent�o t� atrasado
//					Livro l = new LivroDAO().getById(rs.getLong("idLivro"));
//					// pego o livro e coloco na lista
//					result.add(l);
//				}
//			}
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//		return result;
//
//	}

}
