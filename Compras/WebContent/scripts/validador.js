/**
 * Validação de formulário
 * @author Clayton Roberto Calixto
 * Data: 13/01/2021
 */

function validar() {
	
	let nome = frmProduto.nome.value
	let quantidade = frmProduto.quantidade.value
	
	if(nome === ""){
		alert('Preencha o campo Nome')
		frmProduto.nome.focus()
		return false
	} else if (quantidade ===""){
		alert('Preencha o campo Quantidade')
		frmProduto.quantidade.focus()
		return false
	}else{
		document.forms["frmProduto"].submit()
	}
	
}