package Arvore_Binaria_de_Busca;

import java.util.Collection;


public interface IArvore <K,V> {
	
	
	 No<K, V> inserir(K key, V valor);
	 No<K, V> obter(K key);
	 No<K, V> remover(No<K, V> no);
	 No<K, V> remover(K K);
	 Collection<V> obterVes();
}
