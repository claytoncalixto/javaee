package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The produto. */
	JavaBeans produto = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			listarProdutos(request, response);
		} else if (action.equals("/insert")) {
			inserirProduto(request, response);
		} else if (action.equals("/select")) {
			selecionarProduto(request, response);
		} else if (action.equals("/update")) {
			atualizarProduto(request, response);
		} else if (action.equals("/delete")) {
			removerProduto(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Listar produtos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Listar produtos
	protected void listarProdutos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarProdutos();
		// Encaminhar a lista ao documento compra.jsp
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("compra.jsp");
		rd.forward(request, response);
	}

	/**
	 * Inserir produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Novo produto
	protected void inserirProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variáveis JavaBeans
		produto.setNomeProduto(request.getParameter("nome"));
		produto.setQuantProduto(request.getParameter("quantidade"));
		produto.setPrecoProduto(request.getParameter("valor"));
		// invocar o método inserirProduto passando o objeto produto
		dao.inserirProduto(produto);
		// redirecionar para o documento compra.jsp
		response.sendRedirect("main");
	}// Fim - Novo produto

	/**
	 * Selecionar produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Editar produto
	protected void selecionarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id do Produto que será ediatado
		// Setar a variavel JavaBeans
		produto.setIdproduto(request.getParameter("idProduto"));
		// Executar o metodo selecionarProduto (DAO)
		dao.selecionarProduto(produto);
		// Setar os atributos do formulário com o conteudo JavaBeans
		request.setAttribute("idProduto", produto.getIdProduto());
		request.setAttribute("nome", produto.getNomeProduto());
		request.setAttribute("quantidade", produto.getQuantProduto());
		request.setAttribute("valor", produto.getPrecoProduto());
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}// Fim - editarProduto

	/**
	 * Atualizar produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Atualizar um Produto
	protected void atualizarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variaveis JavaBeans
		produto.setIdproduto(request.getParameter("idProduto"));
		produto.setNomeProduto(request.getParameter("nome"));
		produto.setQuantProduto(request.getParameter("quantidade"));
		produto.setPrecoProduto(request.getParameter("valor"));
		// Executar alterar produto
		dao.alterarProduto(produto);
		// Redirecionar para o documento compra.jsp (atualizando as alterações)
		response.sendRedirect("main");
	}// Fim - atualizarProduto

	/**
	 * Remover produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Remover um Produto
	protected void removerProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do Id do Produto a ser excluido (validador.js)
		// Setar a variavel idProduto JavaBeans
		produto.setIdproduto(request.getParameter("idProduto"));
		// Executar o métodoo deletarProduto (DAO) passando o objeto produto
		dao.deletarProduto(produto);
		// Redirecionar para o documento compra.jsp (atualizando as alterações)
		response.sendRedirect("main");
	}// Fim - remover Produto

	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Gerar relatorio em PDF
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// Tipo de conteúdo
			response.setContentType("apllication/pdf");
			// nome do documento
			response.addHeader("Content-Disposition", "inline; filename=produtos.pdf");
			// Criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// Abrir o documento -> conteúdo
			documento.open();
			documento.add(new Paragraph("Lista de Produtos:"));
			documento.add(new Paragraph(" "));
			// Criar uma tabela
			PdfPTable tabela = new PdfPTable(3);
			// Cabeçalho
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Quantidade"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Valor"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			// Popular a tabela com os produtos
			ArrayList<JavaBeans> lista = dao.listarProdutos();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNomeProduto());
				tabela.addCell(lista.get(i).getQuantProduto());
				tabela.addCell(lista.get(i).getPrecoProduto());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}// Fim - Gerar relatorio em PDF

}

