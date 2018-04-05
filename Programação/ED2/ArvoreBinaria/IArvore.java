package ArvoreBinaria;

import Arvore.No;

import java.util.Collection;

public interface IArvore <K,V> {
	
	
	 No<K,V> inserir(K key, V valor, No<K, V> pai, Lado lado);
	 No<K, V> inserir(K key, V valor);
	 No<K, V> obterFilho(No<K, V> pai, Lado lado);
	 No<K, V> obterFilho(K key, Lado lado);
	 No<K, V> remover(No<K, V> no);
	 No<K, V> remover(No<K, V> pai, Lado lado);
	 No<K, V> remover(K K);
	 Collection<V> obterVes();
}