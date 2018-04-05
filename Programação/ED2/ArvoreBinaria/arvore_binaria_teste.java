package ArvoreBinaria;

import Arvore.No;

public class arvore_binaria_teste {
	public static void main(String[] args) {
		ArvoreBinaria<String, String> arvore = new ArvoreBinaria();

		No<String, String> aracaju = arvore.inserir("Aracaju", "Aracaju", null, null);
		No<String, String> itabaiana = arvore.inserir("Itabaiana", "Itabaiana", aracaju, Lado.Esquerdo);
		No<String, String> lagarto = arvore.inserir("lagarto", "lagarto", itabaiana, Lado.Direito);
		System.out.println(arvore.obterFilho(itabaiana, Lado.Direito).chave);

		System.out.println(arvore.tamanho);
		System.out.println(arvore.obterFilho(aracaju, Lado.Direito));
		System.out.println(arvore.obterFilho(aracaju, Lado.Esquerdo).chave);
		System.out.println(arvore.obterFilho("Itabaiana", Lado.Direito).chave);
		System.out.println(arvore.obterFilho("Itabaiana", Lado.Direito));
		System.out.println(arvore.remover(lagarto).chave);
		System.out.println(arvore.obterFilho("Itabaiana", Lado.Direito));
		System.out.println(arvore.remover("Itabaiana").chave);
		System.out.println(arvore.obterFilho(aracaju, Lado.Esquerdo));
		System.out.println(arvore.tamanho);
	}
}