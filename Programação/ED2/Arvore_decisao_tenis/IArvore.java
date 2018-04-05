package Arvore_decisao_tenis;

import java.util.Collection;


public interface IArvore <K,V> {
	

	
	V Consulta(K chave,K chave1);
	V Consulta(K chave,K chave1,K chave2,K chave3);
	


}