package Arvore;

import java.util.Collection;


public interface IArvore <K,V> {
	

	 No<K,V> inserir(K key, V valor, No<K, V> pai, Lado lado); //OK
	 No<K, V> inserir(K key, V valor); //OK
	 No<K, V> obterFilho(No<K, V> pai, Lado lado); //OK
	 No<K, V> obterFilho(K key, Lado lado); //OK
	 No<K, V> remover(No<K, V> no);//OK
	 No<K, V> remover(No<K, V> pai, Lado lado); //OK
	 No<K, V> remover(K K);//OK
	 Collection<V> obterVes();
	


}