package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
	/** The id produto. */
	private String idProduto;
	
	/** The nome produto. */
	private String nomeProduto;
	
	/** The quant produto. */
	private String quantProduto;
	
	/** The preco produto. */
	private String precoProduto;
	
	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
	}

	/**
	 * Instantiates a new java beans.
	 *
	 * @param idProduto the id produto
	 * @param nomeProduto the nome produto
	 * @param quantProduto the quant produto
	 * @param precoProduto the preco produto
	 */
	public JavaBeans(String idProduto, String nomeProduto, String quantProduto, String precoProduto) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.quantProduto = quantProduto;
		this.precoProduto = precoProduto;
	}

	/**
	 * Gets the id produto.
	 *
	 * @return the id produto
	 */
	public String getIdProduto() {
		return idProduto;
	}

	/**
	 * Sets the idproduto.
	 *
	 * @param idProduto the new idproduto
	 */
	public void setIdproduto(String idProduto) {
		this.idProduto = idProduto;
	}

	/**
	 * Gets the nome produto.
	 *
	 * @return the nome produto
	 */
	public String getNomeProduto() {
		return nomeProduto;
	}

	/**
	 * Sets the nome produto.
	 *
	 * @param nomeProduto the new nome produto
	 */
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	/**
	 * Gets the quant produto.
	 *
	 * @return the quant produto
	 */
	public String getQuantProduto() {
		return quantProduto;
	}

	/**
	 * Sets the quant produto.
	 *
	 * @param quantProduto the new quant produto
	 */
	public void setQuantProduto(String quantProduto) {
		this.quantProduto = quantProduto;
	}

	/**
	 * Gets the preco produto.
	 *
	 * @return the preco produto
	 */
	public String getPrecoProduto() {
		return precoProduto;
	}

	/**
	 * Sets the preco produto.
	 *
	 * @param precoProduto the new preco produto
	 */
	public void setPrecoProduto(String precoProduto) {
		this.precoProduto = precoProduto;
	}
}

