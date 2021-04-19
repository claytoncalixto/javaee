package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	// Modulo de conexão //
	/** The driver. */
	// Parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcompras?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "1234567";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 *  CRUD CREATE *.
	 *
	 * @param produto the produto
	 */
	public void inserirProduto(JavaBeans produto) {
		String create = "insert into produtos (nomeProduto, quantProduto, precoProduto) values (?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			// Preparar a query para a execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parametros (?) pelo conteudo das variaveis JavaBeans
			pst.setString(1, produto.getNomeProduto());
			pst.setString(2, produto.getQuantProduto());
			pst.setString(3, produto.getPrecoProduto());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com o banco de dados.
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// FIM CRUD CREATE

	/**
	 *  CRUD READ *.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarProdutos() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> produtos = new ArrayList<>();
		String read = "SELECT * FROM produtos order by nomeProduto";
		try {
			// abrir a conexão
			Connection con = conectar();
			// preparar a query para a execução no banco de dados
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o laço será executado enquanto houver produto
			while (rs.next()) {
				// variaveis de apoio que recebem dados do banco
				String idProduto = rs.getString(1);
				String nomeProduto = rs.getString(2);
				String quantProduto = rs.getString(3);
				String precoProduto = rs.getString(4);
				// populando o ArrayList
				produtos.add(new JavaBeans(idProduto, nomeProduto, quantProduto, precoProduto));
			}
			con.close();
			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}// FIM CRUD READ

	/**
	 *  CRUD UPDATE *.
	 *
	 * @param produto the produto
	 */
	
	// selecionar o produto
	public void selecionarProduto(JavaBeans produto) {
		String read2 = "select * from produtos where idProduto = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, produto.getIdProduto());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// setar as variaveis JavaBeans
				produto.setIdproduto(rs.getString(1));
				produto.setNomeProduto(rs.getString(2));
				produto.setQuantProduto(rs.getString(3));
				produto.setPrecoProduto(rs.getString(4));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}// FIM - selecionar o produto

	/**
	 * Alterar produto.
	 *
	 * @param produto the produto
	 */
	// Editar produto
	public void alterarProduto(JavaBeans produto) {
		String update = "update produtos set nomeProduto=?, quantProduto=?, precoProduto=? where IdProduto=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, produto.getNomeProduto());
			pst.setString(2, produto.getQuantProduto());
			pst.setString(3, produto.getPrecoProduto());
			pst.setString(4, produto.getIdProduto());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}// Fim - Editar produto
	
	/**
	 *  FIM - CRUD UPDATE *.
	 *
	 * @param produto the produto
	 */

	// CRUD - DELETE
	public void deletarProduto(JavaBeans produto) {
		String delete = "delete from produtos where idProduto=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, produto.getIdProduto());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}//Fim - CRUD - DELETE

	/**
	 * Teste conexao.
	 */
	// teste de conexão
	public void testeConexao() {
		try {
			Connection con = conectar();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// Fim - teste de conexão

}

