package Arvore;

import java.util.Collection;
import java.util.LinkedList;

public class Árvore<K, V> implements IÁrvore<K, V> {
	int tamanho;
	No<K, V> raiz;

	public Árvore() {
		this.raiz = null;
		this.tamanho = 0;
	}

	@Override
	public No<K, V> inserir(K key, V valor, No<K, V> pai, Lado lado) {
		No<K, V> no1;
		No<K, V> novoNo = new No<K, V>(key, valor);
		novoNo.chave = key;
		novoNo.valor = valor;
		if (raiz == null) {
			raiz = novoNo;
			tamanho++;
			return novoNo;

		}
		LinkedList<No> fila = new LinkedList<No>();
		fila.addLast(raiz);
		No no2 = fila.getFirst();
		if (no2.chave.equals(pai.chave)) {
			novoNo.pai = no2;
			if (lado == Lado.Esquerdo) {
				no2.filhoEsquerdo = novoNo;
				tamanho++;
			}
			if (lado == Lado.Direito) {

				no2.filhoDireito = novoNo;
				tamanho++;
			}
			if (lado == Lado.Meio) {

				no2.filhoMeio = novoNo;
				tamanho++;
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
						tamanho++;
					}
					if (lado == Lado.Direito) {

						no1.filhoDireito = novoNo;
						tamanho++;
					}
					if (lado == Lado.Meio) {

						no1.filhoMeio = novoNo;
						tamanho++;
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
						tamanho++;
					}
					if (lado == Lado.Direito) {

						no1.filhoDireito = novoNo;
						tamanho++;
					}
					if (lado == Lado.Meio) {

						no1.filhoMeio = novoNo;
						tamanho++;
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
						tamanho++;
					}
					if (lado == Lado.Direito) {

						no1.filhoDireito = novoNo;
						tamanho++;
					}
					if (lado == Lado.Meio) {

						no1.filhoMeio = novoNo;
						tamanho++;
					}
				}

			}
			fila.removeFirst();

		}

		return novoNo;

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

			if (no.filhoEsquerdo != null) {
				fila.addLast(no.filhoEsquerdo);
			} else {
				novoNo.pai = no;
				no.filhoEsquerdo = novoNo;
				return novoNo;

			}
			if (no.filhoMeio != null) {
				fila.addLast(no.filhoMeio);
			} else {

				novoNo.pai = no;
				no.filhoMeio = novoNo;
				return novoNo;
			}

			if (no.filhoDireito != null) {
				fila.addLast(no.filhoDireito);
			} else {
				novoNo.pai = no;
				no.filhoDireito = novoNo;
				return novoNo;
			}
			fila.removeFirst();
		}

		return null;
	}

	@Override
	public No<K, V> obterFilho(No<K, V> pai, Lado lado) {

		No no1 = null;
		LinkedList<No> fila = new LinkedList<No>();
		fila.addLast(raiz);

		No no2 = fila.getFirst();
		if (no2.chave.equals(pai.chave)) {
			no1 = no2;
			if (lado == Lado.Esquerdo) {
				return no1.filhoEsquerdo;
			}
			if (lado == Lado.Direito) {
				return no1.filhoDireito;
			} else {
				return no1.filhoMeio;
			}

		}
		while (!fila.isEmpty()) {

			no2 = fila.getFirst();
			if (no2.filhoEsquerdo != null) {
				fila.addLast(no2.filhoEsquerdo);
				if (no2.filhoEsquerdo.chave.equals(pai.chave)) {
					no1 = no2.filhoEsquerdo;

					if (lado == Lado.Esquerdo) {
						return no1.filhoEsquerdo;
					}
					if (lado == Lado.Direito) {
						return no1.filhoDireito;
					} else {
						return no1.filhoMeio;
					}

				}
			}
			if (no2.filhoMeio != null) {
				fila.addLast(no2.filhoMeio);
				if (no2.filhoMeio.chave.equals(pai.chave)) {
					no1 = no2.filhoMeio;

					if (lado == Lado.Esquerdo) {
						return no1.filhoEsquerdo;
					}
					if (lado == Lado.Direito) {
						return no1.filhoDireito;
					} else {
						return no1.filhoMeio;
					}

				}

			}
			if (no2.filhoDireito != null) {
				fila.addLast(no2.filhoDireito);
				if (no2.filhoDireito.chave.equals(pai.chave)) {
					no1 = no2.filhoDireito;

					if (lado == Lado.Esquerdo) {
						return no1.filhoEsquerdo;
					}
					if (lado == Lado.Direito) {
						return no1.filhoDireito;
					} else {
						return no1.filhoMeio;
					}

				}

			}
			fila.removeFirst();

		}

		return null;
	}

	@Override
	public No<K, V> obterFilho(K key, Lado lado) {
		No no1 = null;
		LinkedList<No> fila = new LinkedList<No>();
		fila.addLast(raiz);

		No no2 = fila.getFirst();
		if (no2.chave.equals(key)) {
			no1 = no2;
			if (lado == Lado.Esquerdo) {
				return no1.filhoEsquerdo;
			}
			if (lado == Lado.Direito) {
				return no1.filhoDireito;
			} else {
				return no1.filhoMeio;
			}

		}
		while (!fila.isEmpty()) {

			no2 = fila.getFirst();
			if (no2.filhoEsquerdo != null) {
				fila.addLast(no2.filhoEsquerdo);
				if (no2.filhoEsquerdo.chave.equals(key)) {
					no1 = no2.filhoEsquerdo;

					if (lado == Lado.Esquerdo) {
						return no1.filhoEsquerdo;
					}
					if (lado == Lado.Direito) {
						return no1.filhoDireito;
					} else {
						return no1.filhoMeio;
					}

				}
			}
			if (no2.filhoMeio != null) {
				fila.addLast(no2.filhoMeio);
				if (no2.filhoMeio.chave.equals(key)) {
					no1 = no2.filhoMeio;

					if (lado == Lado.Esquerdo) {
						return no1.filhoEsquerdo;
					}
					if (lado == Lado.Direito) {
						return no1.filhoDireito;
					} else {
						return no1.filhoMeio;
					}

				}

			}
			if (no2.filhoDireito != null) {
				fila.addLast(no2.filhoDireito);
				if (no2.filhoDireito.chave.equals(key)) {
					no1 = no2.filhoDireito;

					if (lado == Lado.Esquerdo) {
						return no1.filhoEsquerdo;
					}
					if (lado == Lado.Direito) {
						return no1.filhoDireito;
					} else {
						return no1.filhoMeio;
					}

				}

			}
			fila.removeFirst();

		}

		return null;
	}

	//
	// while (!fila.isEmpty()) {
	//
	// if (no.filhoEsquerdo != null) {
	// fila.addLast(no.filhoEsquerdo);
	// if (no.filhoEsquerdo.chave.equals(key)) {
	// if (lado == Lado.Direito) {
	// return no.filhoEsquerdo.filhoDireito;
	// }
	// if (lado == Lado.Meio) {
	// return no.filhoEsquerdo.filhoMeio;
	// }
	// if (lado == Lado.Esquerdo) {
	// return no.filhoEsquerdo.filhoEsquerdo;
	// }
	// }
	//
	// }
	//
	// if (no.filhoMeio != null) {
	// fila.addLast(no.filhoMeio);
	// if (no.filhoMeio.chave.equals(key)) {
	// if (lado == Lado.Direito) {
	// return no.filhoMeio.filhoDireito;
	// }
	// if (lado == Lado.Meio) {
	// return no.filhoMeio.filhoMeio;
	// }
	// if (lado == Lado.Esquerdo) {
	// return no.filhoMeio.filhoEsquerdo;
	// }
	// }
	// }
	//
	// if (no.filhoDireito != null) {
	// fila.addLast(no.filhoDireito);
	// if (no.filhoDireito.chave.equals(key)) {
	// if (lado == Lado.Direito) {
	// return no.filhoDireito.filhoDireito;
	// }
	// if (lado == Lado.Meio) {
	// return no.filhoDireito.filhoMeio;
	// }
	// if (lado == Lado.Esquerdo) {
	// return no.filhoDireito.filhoEsquerdo;
	// }
	// }
	// }
	// fila.removeFirst();
	// }
	//
	// return null;
	// }

	@Override
	public No<K, V> remover(No<K, V> no) {
		No no1 = null;
		LinkedList<No> fila = new LinkedList<No>();
		fila.addLast(raiz);
		No no2 = fila.getFirst();
		if (no2.equals(no)) {
			no1 = no2;
			raiz = null;
			tamanho--;
			return no1;
		}
		while (!fila.isEmpty()) {

			no2 = fila.getFirst();
			if (no2.filhoEsquerdo != null) {
				fila.addLast(no2.filhoEsquerdo);
				if (no2.filhoEsquerdo.equals(no)) {
					no1 = no2.filhoEsquerdo;
					no2.filhoEsquerdo = null;
					tamanho--;
					return no1;
				}

			}

			if (no2.filhoMeio != null) {
				fila.addLast(no2.filhoMeio);
				if (no2.filhoMeio.equals(no)) {
					no1 = no2.filhoMeio;
					no2.filhoMeio = null;
					tamanho--;
					return no1;
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

	@Override
	public No<K, V> remover(No<K, V> pai, Lado lado) {
		No no1 = null;
		No no3 = null;
		LinkedList<No> fila = new LinkedList<No>();
		fila.addLast(raiz);
		No no2 = fila.getFirst();
		if (no2.equals(pai)) {
			if (lado.equals(Lado.Esquerdo)) {
				no1 = no2.filhoEsquerdo;
				no2.filhoEsquerdo = null;
				return no1;
			}
			if (lado.equals(Lado.Meio)) {
				no1 = no2.filhoMeio;
				no2.filhoMeio = null;
				return no1;
			}
			if (lado.equals(Lado.Direito)) {
				no1 = no2.filhoDireito;
				no2.filhoDireito = null;
				return no1;
			}

		}
		while (!fila.isEmpty()) {

			no2 = fila.getFirst();
			if (no2.filhoEsquerdo != null) {
				fila.addLast(no2.filhoEsquerdo);
				if (no2.filhoEsquerdo.equals(pai)) {
					if (lado.equals(Lado.Esquerdo)) {
						no1 = no2.filhoEsquerdo;
						no3 = no1.filhoEsquerdo;
						no1.filhoEsquerdo = null;
						return no3;
					}
					if (lado.equals(Lado.Meio)) {
						no1 = no2.filhoEsquerdo;
						no3 = no1.filhoMeio;
						no2.filhoMeio = null;
						return no3;
					}
					if (lado.equals(Lado.Direito)) {
						no1 = no2.filhoEsquerdo;
						no3 = no1.filhoDireito;
						no2.filhoDireito = null;
						return no3;
					}

				}
			}

			if (no2.filhoMeio != null) {
				fila.addLast(no2.filhoMeio);
				if (no2.filhoMeio.equals(pai)) {
					if (lado.equals(Lado.Esquerdo)) {

						no1 = no2.filhoMeio;
						no3 = no1.filhoMeio;
						no1.filhoEsquerdo = null;
						return no3;
					}
					if (lado.equals(Lado.Meio)) {
						no1 = no2.filhoMeio;
						no3 = no1.filhoMeio;
						no2.filhoMeio = null;
						return no3;
					}
					if (lado.equals(Lado.Direito)) {
						no1 = no2.filhoMeio;
						no3 = no1.filhoDireito;
						no2.filhoDireito = null;
						return no3;
					}

				}
			}

			if (no2.filhoDireito != null) {
				fila.addLast(no2.filhoDireito);
				if (no2.filhoDireito.equals(pai)) {
					if (lado.equals(Lado.Esquerdo)) {

						no1 = no2.filhoDireito;
						no3 = no1.filhoEsquerdo;
						no1.filhoEsquerdo = null;
						return no3;
					}
					if (lado.equals(Lado.Meio)) {
						no1 = no2.filhoEsquerdo;
						no3 = no1.filhoMeio;
						no2.filhoMeio = null;
						return no3;
					}
					if (lado.equals(Lado.Direito)) {
						no1 = no2.filhoEsquerdo;
						no3 = no1.filhoDireito;
						no2.filhoDireito = null;
						return no3;
					}

				}
				
			}
			fila.removeFirst();
		}

		return null;
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

			if (no2.filhoMeio != null) {
				fila.addLast(no2.filhoMeio);
				if (no2.filhoMeio.chave.equals(K)) {
					no1 = no2.filhoMeio;
					no2.filhoMeio = null;
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
	public Collection<V> obterVes() {
		// TODO Auto-generated method stub
		return null;
	}
}

// private No<K, V> Buscar(No pai) {
//
// Stack<No> pilha = new Stack<No>();
// pai.setVisitado(true);
// this.visitados.add(pai);
// pilha.push(pai);
//
// while (!pilha.isEmpty()) {
// Set<No> adjacentes = pai.getAdjacentes(pilha.lastElement());
// Vertice w = getProximo(adjacentes);
// if (w != null) {
// w.setVisitado(true);
// this.visitados.add(w);
// pilha.push(w);
// } else {
// this.explorados.add(pilha.lastElement());
// pilha.pop();
// }
//
// }
//
//
// }
