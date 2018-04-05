package Arvore_decisao_tenis;

public class No<K,V> {
		
	K chave;
	V valor;
	private boolean visitado;
	No<K, V> pai;
	No<K, V> filhoEsquerdo;
	No<K, V> filhoMeio;
	No<K, V> filhoDireito;
	public No(K chave, V valor) {
		
		this.chave = chave;
		this.valor = valor;
	}
	public boolean isVisitado() {
		return visitado;
	}
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	
	

	

}
