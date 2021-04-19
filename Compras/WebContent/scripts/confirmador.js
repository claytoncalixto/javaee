/**
 * Confirmação de exclusão de um produto
 *
 * @author: Clayton Roberto Calixto
 * @param idProduto
 */

function confirmar(idProduto){
	let resposta = confirm("Confirma a exclusão deste produto?")
	if(resposta === true){
		window.location.href = "delete?idProduto=" + idProduto
	}
}