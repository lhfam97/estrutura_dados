package Arvore_decisao_tenis;

import java.util.LinkedList;

public class Arvore_tenis implements IArvore<String, String> {
	No<String, String> raiz;

	public Arvore_tenis() {
		String chave = (String) "Aspecto";
		String valor = "Sim";
		No<String, String> noAspecto = new No<String, String>(chave, null);
		inserir(chave, null, null, null);
		chave = "Sol";
		No<String, String> noSol = new No<String, String>(chave, null);
		inserir(chave, null, noAspecto, Lado.Esquerdo);
		chave = "Nuvens";
		inserir(chave, valor, noAspecto, Lado.Meio);
		chave = "Chuva";
		No<String, String> noChuva = new No<String, String>(chave, null);
		inserir(chave, null, noAspecto, Lado.Direito);
		chave = "Humidade";
		No<String, String> noHumidade = new No<String, String>(chave, null);
		inserir(chave, null, noSol, Lado.Meio);
		chave = "Vento";
		No<String, String> noVento = new No<String, String>(chave, null);
		inserir(chave, null, noChuva, Lado.Meio);
		chave = (String) "Normal";
		inserir(chave, valor, noHumidade, Lado.Direito);
		chave = (String) "Forte";
		inserir(chave, valor, noVento, Lado.Direito);
		valor = "N�o";
		chave = (String) "Elevada";
		inserir(chave, valor, noHumidade, Lado.Esquerdo);
		chave = (String) "Fraco";
		inserir(chave, valor, noVento, Lado.Esquerdo);
		
	}

	private void inserir(String chave, String valor, No<String, String> pai, Lado lado) {
		// No<String,String> novoNo =new No<String, String>(chave, valor);
		// novoNo.chave=chave;
		// novoNo.valor=valor;
		// if(raiz==null) {
		// raiz=novoNo;
		//
		// return;
		//
		// }
		// if(raiz.chave==pai.chave) {
		// novoNo.pai=pai;
		// if(lado==Lado.Esquerdo) {
		// raiz.filhoEsquerdo=novoNo;
		// }
		// if(lado==Lado.Direito) {
		//
		// raiz.filhoDireito=novoNo;
		// } if(lado==Lado.Meio) {
		//
		// raiz.filhoMeio=novoNo;
		// }
		//
		//
		//
		//
		// }
		//
		// novoNo.pai=pai;
		// if(lado==Lado.Esquerdo) {
		// pai.filhoEsquerdo=novoNo;
		// }
		// if(lado==Lado.Direito) {
		//
		// pai.filhoDireito=novoNo;
		// } if(lado==Lado.Meio) {
		//
		// pai.filhoMeio=novoNo;
		// }
		No<String, String> no1;
		No<String, String> novoNo = new No<String, String>(chave, valor);
		novoNo.chave = chave;
		novoNo.valor = valor;
		if (raiz == null) {
			raiz = novoNo;

			return;

		}
		LinkedList<No> fila = new LinkedList<No>();
		fila.addLast(raiz);
		No no2 = fila.getFirst();
		if (no2.chave.equals(pai.chave)) {
			novoNo.pai = no2;
			if (lado == Lado.Esquerdo) {
				no2.filhoEsquerdo = novoNo;
			}
			if (lado == Lado.Direito) {

				no2.filhoDireito = novoNo;
			}
			if (lado == Lado.Meio) {

				no2.filhoMeio = novoNo;
			}

		}
		while (!fila.isEmpty()) {
			no2 = fila.getFirst();
			
			
			if (no2.filhoEsquerdo != null) {

				fila.addLast(no2.filhoEsquerdo);
				if (no2.filhoEsquerdo.chave.equals(pai.chave)) {
					no1 = no2.filhoEsquerdo;
					novoNo.pai = no1;
					if (lado == Lado.Esquerdo) {
						no1.filhoEsquerdo = novoNo;
					}
					if (lado == Lado.Direito) {

						no1.filhoDireito = novoNo;
					}
					if (lado == Lado.Meio) {

						no1.filhoMeio = novoNo;
					}

				}

			}

			if (no2.filhoMeio != null) {
				fila.addLast(no2.filhoMeio);
				if (no2.filhoMeio.chave.equals(pai.chave)) {
					no1 = no2.filhoMeio;
					novoNo.pai = no1;
					if (lado == Lado.Esquerdo) {
						no1.filhoEsquerdo = novoNo;
					}
					if (lado == Lado.Direito) {

						no1.filhoDireito = novoNo;
					}
					if (lado == Lado.Meio) {

						no1.filhoMeio = novoNo;
					}
				}

			}

			if (no2.filhoDireito != null) {
				fila.addLast(no2.filhoDireito);
				if (no2.filhoDireito.chave.equals(pai.chave)) {
					no1 = no2.filhoDireito;
					novoNo.pai = no1;
					if (lado == Lado.Esquerdo) {
						no1.filhoEsquerdo = novoNo;
					}
					if (lado == Lado.Direito) {

						no1.filhoDireito = novoNo;
					}
					if (lado == Lado.Meio) {

						no1.filhoMeio = novoNo;
					}
				}

			}
			fila.removeFirst();

		}


	}

	private String obter(String String) {

		No no1 = null;
		LinkedList<No> fila = new LinkedList<No>();
		fila.addLast(raiz);

		No no2 = fila.getFirst();
		if (no2.chave.equals(String)) {
			no1 = no2;

			return (String) no1.valor;
		}
		while (!fila.isEmpty()) {
			no2 = fila.getFirst();
			
			if (no2.filhoEsquerdo != null) {

				fila.addLast(no2.filhoEsquerdo);
				if (no2.filhoEsquerdo.chave.equals(String)) {
					no1 = no2.filhoEsquerdo;
					return (String) no1.valor;
				}

			}

			if (no2.filhoMeio != null) {
				fila.addLast(no2.filhoMeio);
				if (no2.filhoMeio.chave.equals(String)) {
					no1 = no2.filhoMeio;
					return (String) no1.valor;
				}

			}

			if (no2.filhoDireito != null) {
				fila.addLast(no2.filhoDireito);
				if (no2.filhoDireito.chave.equals(String)) {
					no1 = no2.filhoDireito;
					return (String) no1.valor;
				}

			}
			fila.removeFirst();

		}

		return null;
	}

	@Override
	public String Consulta(String chave, String chave1) {

		return obter(chave1);
	}

	@Override
	public String Consulta(String chave, String chave1, String chave2, String chave3) {
		return obter(chave3);
	}

}
