package Arvore_Binaria_de_Busca;

import java.util.Collection;
import java.util.LinkedList;

public class ArvoreBinariaBusca<K, V> implements IArvore<K, V> {

	int tamanho;
	No<K, V> raiz;

	public ArvoreBinariaBusca() {
		this.raiz = null;
		this.tamanho = 0;
	}

	@Override
	public No<K, V> inserir(K key, V valor) {
		No<K, V> novoNo = new No<K, V>(key, valor);
		novoNo.chave = key;
		novoNo.valor = valor;
		if (raiz == null) {
			raiz = novoNo;
			tamanho++;
			return novoNo;

		}
		LinkedList<No> fila = new LinkedList();

		fila.addLast(raiz);
		No no = fila.getFirst();
		while (!fila.isEmpty()) {
			if ((int) novoNo.chave < (int) no.chave) {
				if (no.filhoEsquerdo != null) {
					fila.addLast(no.filhoEsquerdo);
				} else {
					novoNo.pai = no;
					no.filhoEsquerdo = novoNo;
					return novoNo;

				}
			} else {

			}
			if (no.filhoDireito != null) {
				fila.addLast(no.filhoDireito);
			} else {
				novoNo.pai = no;
				no.filhoDireito = novoNo;
				return novoNo;
			}
		}
		fila.removeFirst();

		return null;
	}

	@Override
	public No<K, V> remover(No<K, V> no) {
		No no1 = null;
		No no3 = null;
		LinkedList<No> fila = new LinkedList<No>();
		fila.addLast(raiz);
		No no2 = fila.getFirst();
		if (no2.equals(no)) {
			if (no2.filhoDireito.equals(null) && no2.filhoEsquerdo.equals(null)) {
				no1 = no2;
				raiz = null;
				tamanho--;
				return no1;
			}
			if (no2.filhoDireito.equals(null) || no2.filhoEsquerdo.equals(null)) {
				tamanho--;
				return removerUmfilho(no2);
			
			} else {
				tamanho--;
				return removerdoisFilhos(no2);
				
			}
		}
		while (!fila.isEmpty()) {

			no2 = fila.getFirst();
			if (no2.filhoEsquerdo != null) {
				fila.addLast(no2.filhoEsquerdo);
				if (no2.filhoEsquerdo.equals(no)) {
					no1 = no2.filhoEsquerdo;
					if (no1.filhoDireito.equals(null) && no1.filhoEsquerdo.equals(null)) {
						no2.filhoEsquerdo = null;
						tamanho--;
						return no1;
					}
					if (no1.filhoDireito.equals(null) || no1.filhoEsquerdo.equals(null)) {
						tamanho--;
						return removerUmfilho(no1);
					} else {
						tamanho--;
						return removerdoisFilhos(no1);
					}
				}

			}

			if (no2.filhoDireito != null) {
				fila.addLast(no2.filhoDireito);
				if (no2.filhoDireito.equals(no)) {
					no1 = no2.filhoDireito;
					no2.filhoDireito = null;
					tamanho--;
					return no1;
				}

			}

			fila.removeFirst();
		}

		return null;
	}

	private No<K, V> removerdoisFilhos(No no2) {
		No novoNo = null;
		LinkedList<No> fila = new LinkedList();
		fila.addLast(no2.filhoDireito);

		while (!fila.isEmpty()) {
			No no = fila.getFirst();
			if (no.filhoEsquerdo.equals(null)) {
				novoNo = no;
				break;
			}
			fila.add(no.filhoEsquerdo);
			fila.removeFirst();
		}

		if (novoNo.filhoDireito.equals(null)) {
			novoNo.pai.filhoEsquerdo = null;
		} else {
			if(!novoNo.pai.equals(no2))
			novoNo.pai.filhoEsquerdo = novoNo.filhoDireito;
			novoNo.filhoDireito.pai=novoNo.pai;
		}
		novoNo.pai = no2.pai;
		if (novoNo.pai.filhoDireito.equals(no2)) {
			novoNo.pai.filhoDireito = novoNo;
		} else {
			novoNo.pai.filhoEsquerdo = novoNo;
		}
		novoNo.filhoDireito = no2.filhoDireito;
		no2.filhoDireito.pai = novoNo;
		novoNo.filhoEsquerdo = no2.filhoEsquerdo;
		no2.filhoEsquerdo.pai = novoNo;

		return no2;
	}

	private No<K, V> removerUmfilho(No no2) {
		No no1 = null;
		if (no2.filhoDireito.equals(null)) {
			no1 = no2.filhoEsquerdo;
			if (no2.pai.filhoDireito.equals(no2)) {
				no2.filhoDireito = no1;
				no1.pai = no2.pai;
			} else {
				no2.filhoEsquerdo = no1;
				no1.pai = no2.pai;
			}
		} else {
			no1 = no2.filhoEsquerdo;
			if (no2.pai.filhoDireito.equals(no2)) {
				no2.filhoDireito = no1;
				no1.pai = no2.pai;
			} else {
				no2.filhoEsquerdo = no1;
				no1.pai = no2.pai;
			}

		}

		return no2;
	}

	@Override
	public No<K, V> remover(K K) {
		No no1 = null;
		LinkedList<No> fila = new LinkedList<No>();
		fila.addLast(raiz);
		No no2 = fila.getFirst();
		if (no2.chave.equals(K)) {
			no1 = no2;
			raiz = null;
			tamanho--;
			return no1;
		}
		while (!fila.isEmpty()) {

			no2 = fila.getFirst();
			if (no2.filhoEsquerdo != null) {
				fila.addLast(no2.filhoEsquerdo);
				if (no2.filhoEsquerdo.chave.equals(K)) {
					no1 = no2.filhoEsquerdo;
					no2.filhoEsquerdo = null;
					tamanho--;
					return no1;
				}

			}

			if (no2.filhoDireito != null) {
				fila.addLast(no2.filhoDireito);
				if (no2.filhoDireito.chave.equals(K)) {
					no1 = no2.filhoDireito;
					no2.filhoDireito = null;
					tamanho--;
					return no1;
				}

			}

			fila.removeFirst();
		}

		return null;
	}

	@Override
	public No<K, V> obter(K key) {
		No no1=null;
		LinkedList<No> fila = new LinkedList<No>();
		fila.addLast(raiz);
		No no2 = fila.getFirst();
		if (no2.chave.equals(key)) { 
				return no2;
		}
		while (!fila.isEmpty()) {

			no2 = fila.getFirst();
			if (no2.filhoEsquerdo != null) {
				fila.addLast(no2.filhoEsquerdo);
				if (no2.filhoEsquerdo.chave.equals(key)) {
					no1 = no2.filhoEsquerdo;
					return no1;
				}

			}

			if (no2.filhoDireito != null) {
				fila.addLast(no2.filhoDireito);
				if (no2.filhoDireito.chave.equals(key)) {
					no1 = no2.filhoDireito;
					return no1;
				}

			}

			fila.removeFirst();
		}

		return null;
	}

	@Override
	public Collection<V> obterVes() {
		// TODO Auto-generated method stub
		return null;
	}
}
