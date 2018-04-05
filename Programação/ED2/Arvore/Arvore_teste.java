package Arvore;

public class Arvore_teste {

	public static void main(String[] args) {
		Árvore<String,String> arvore=new Árvore<>();
		
		No<String,String> aracaju=arvore.inserir("Aracaju","Aracaju", null, null); 
		No<String,String> itabaiana= arvore.inserir("Itabaiana","Itabaiana",aracaju, Lado.Esquerdo); 
		No<String,String> lagarto = arvore.inserir("lagarto","lagarto",itabaiana, Lado.Meio); 
		System.out.println(arvore.obterFilho(itabaiana, Lado.Meio).chave);
		System.out.println(arvore.tamanho);
		System.out.println(arvore.obterFilho(aracaju, Lado.Direito));
		System.out.println(arvore.obterFilho(aracaju, Lado.Esquerdo).chave);
		System.out.println(arvore.obterFilho("Itabaiana", Lado.Meio).chave);
		System.out.println(arvore.obterFilho("Itabaiana", Lado.Direito));
		System.out.println(arvore.remover(lagarto).chave);
		System.out.println(arvore.obterFilho("Itabaiana", Lado.Meio));
		System.out.println(arvore.remover("Itabaiana").chave);
		System.out.println(arvore.obterFilho(aracaju, Lado.Esquerdo));
		System.out.println(arvore.tamanho);
	}

}
