package Arvore_decisao_tenis;

public class Arvore_teste<K> {
	public static void main(String[] args) {
		Arvore_tenis arvore_decisao =new Arvore_tenis();
		System.out.println(arvore_decisao.Consulta("Aspecto","Nuvens"));
		System.out.println(arvore_decisao.Consulta("Aspecto","Chuva","Vento","Forte"));
	}
	
}
