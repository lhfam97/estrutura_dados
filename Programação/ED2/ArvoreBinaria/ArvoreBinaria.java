package ArvoreBinaria;

import Arvore.No;
import Arvore_Binaria_de_Busca.IArvore;

import java.util.Collection;
import java.util.LinkedList;

public class ArvoreBinaria<K, V> implements IArvore<K, V> {

	int tamanho;
	No<K, V> raiz;

	public ArvoreBinaria() {
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
	public Arvore_Binaria_de_Busca.No<K, V> obter(K key) {
		return null;
	}

	@Override
	public Arvore_Binaria_de_Busca.No<K, V> remover(Arvore_Binaria_de_Busca.No<K, V> no) {
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
					} 

				}

			}
			fila.removeFirst();

		}

		return null;
	}


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
				
				
					if (lado.equals(Lado.Direito)) {
						no1 = no2.filhoEsquerdo;
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
	// int tamanho;
	// No <K,V> raiz;
	// Vetor<No> vetor ;
	// public ArvoreBinaria() {
	// this.raiz=null;
	// this.tamanho =0;
	// vetor=new Vetor<>();
	// }
	//
	//
	//
	// @Override
	// public No<K, V> inserir(K key, V valor, No<K, V> pai, Lado lado) {
	// No<K,V> novoNo =new No<K, V>(key, valor);
	// novoNo.chave=key;
	// novoNo.valor=valor;
	// if(raiz==null) {
	// raiz=novoNo;
	// vetor.adicionar(novoNo);
	// return novoNo;
	// }
	// novoNo.pai=pai;
	// if(lado==Lado.Esquerdo) {
	// pai.filhoEsquerdo=novoNo;
	// }
	// if(lado==Lado.Direito) {
	// pai.filhoDireito=novoNo;
	// }
	// vetor.adicionar(novoNo);
	// return novoNo;
	// }
	//
	// @Override
	// public No<K, V> inserir(K key, V valor, int indice) {
	// LinkedList<No> fila = new LinkedList();
	//
	// fila.addLast(raiz);
	// No no=fila.getFirst();
	// while (!fila.isEmpty()) {
	//
	// if(no.filhoEsquerdo!=null) {
	// fila.addLast(no.filhoEsquerdo);
	// }
	// else {
	// No<K,V> novoNo =new No<K, V>(key, valor);
	// novoNo.chave=key;
	// novoNo.valor=valor;
	// novoNo.pai=no;
	// try{
	// vetor.adicionar(indice, novoNo);
	// no.filhoEsquerdo=novoNo;
	// }
	// catch(Exception e) {
	// System.err.println("�ndice n�o encontrado");
	// }
	//
	// }
	// if(no.filhoDireito!=null) {
	// fila.addLast(no.filhoDireito);
	// }
	// else {
	// No<K,V> novoNo =new No<K, V>(key, valor);
	// novoNo.chave=key;
	// novoNo.valor=valor;
	// novoNo.pai=no;
	//
	// try{
	// vetor.adicionar(indice, novoNo);
	// no.filhoDireito=novoNo;
	// }
	// catch(Exception e) {
	// System.err.println("�ndice n�o encontrado");
	// }
	// }
	// fila.removeFirst();
	// }
	//
	// return null;
	// }
	//
	// @Override
	// public No<K, V> inserir(K key, V valor) {
	// LinkedList<No> fila = new LinkedList();
	//
	// fila.addLast(raiz);
	// No no=fila.getFirst();
	// while (!fila.isEmpty()) {
	//
	// if(no.filhoEsquerdo!=null) {
	// fila.addLast(no.filhoEsquerdo);
	// }
	// else {
	// No<K,V> novoNo =new No<K, V>(key, valor);
	// novoNo.chave=key;
	// novoNo.valor=valor;
	// novoNo.pai=no;
	// no.filhoEsquerdo=novoNo;
	// vetor.adicionar(novoNo);
	// }
	// if(no.filhoDireito!=null) {
	// fila.addLast(no.filhoDireito);
	// }
	// else {
	// No<K,V> novoNo =new No<K, V>(key, valor);
	// novoNo.chave=key;
	// novoNo.valor=valor;
	// novoNo.pai=no;
	// no.filhoDireito=novoNo;
	// vetor.adicionar(novoNo);
	// }
	// fila.removeFirst();
	// }
	//
	// return null;
	// }
	//
	// @Override
	// public No<K, V> obterFilho(No<K, V> pai, Lado lado) {
	// if(pai!=null&& lado==Lado.Direito) {
	// return pai.filhoDireito;
	// }
	// else if(pai!=null&& lado==Lado.Esquerdo) {
	// return pai.filhoEsquerdo;
	// }
	// return null;
	// }
	//
	// @Override
	// public No<K, V> obterFilho(K key, Lado lado) {
	// for (No no : vetor) {
	// if (no.chave.equals(key)) {
	// if (lado == Lado.Direito) {
	// return no.filhoDireito;
	// }
	// if (lado == Lado.Esquerdo) {
	// return no.filhoEsquerdo;
	// }
	// break;
	// }
	// }
	// return null;
	// }
	//
	// @Override
	// public No<K, V> obterNo(int indice) {
	// return vetor.obter(indice);
	// }
	//
	// @Override
	// public No<K, V> remover(No<K, V> no) {
	// try {
	// if(no.pai.filhoEsquerdo.equals(no)) {
	// no.pai.filhoEsquerdo=null;
	// }
	// if(no.pai.filhoDireito.equals(no)) {
	// no.pai.filhoDireito=null;
	// }
	// vetor.remover(no);
	// return no;
	// }
	// catch(Exception e){
	// vetor.remover(no);
	// raiz=null;
	// return no;
	// }
	// }
	//
	// @Override
	// public No<K, V> remover(No<K, V> pai, Lado lado) {
	// if (lado.equals(Lado.Direito)) {
	// vetor.remover(pai.filhoDireito);
	// pai.filhoDireito=null;
	// return null;
	// }
	// if (lado.equals(Lado.Esquerdo)) {
	// vetor.remover(pai.filhoEsquerdo);
	// pai.filhoEsquerdo=null;
	// return null;
	//
	// }
	// return null;
	// }
	//
	// @Override
	// public No<K, V> remover(int indice) {
	// try {
	// return remover(vetor.obter(indice));
	// }
	// catch(Exception e) {
	// return null;
	// }
	// }
	//
	// @Override
	// public No<K, V> remover(K key) {
	// for (No no : vetor) {
	// if (no.chave.equals(key)) {
	// return remover(no);
	//
	// }
	// }
	// return null;
	// }
	//
	// @Override
	// public Collection<V> obterVes() {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
