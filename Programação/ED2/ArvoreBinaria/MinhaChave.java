package ÁrvoreBinária;


public class MinhaChave implements Comparable<MinhaChave> {
	int chave;
	@Override
	public int compareTo(MinhaChave o) {
		
		return Integer.compare(this.chave, o.chave);
	}
	
}