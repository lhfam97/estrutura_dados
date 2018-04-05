package Arvore_Binaria_de_Busca;

public class arvore_binaria_busca_teste {

	public static void main(String[] args) {
		
		ArvoreBinariaBusca<Integer, Integer> arvore=new ArvoreBinariaBusca<>();
		arvore.inserir(10, 10);
		arvore.inserir(15, 15);
		arvore.inserir(8, 8);
		arvore.inserir(0, 0);
		arvore.inserir(14,14);
		System.out.println("Entra");
		System.out.println(arvore.obter(8).chave);
		System.out.println(arvore.obter(0).chave);
		System.out.println(arvore.obter(30));
	}

}
