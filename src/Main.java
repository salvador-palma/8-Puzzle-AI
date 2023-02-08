public class Main {
	public static void main(String[] args) {	
		
		// DEFINIR O ESTADO INICIAL AQUI
		State s = new State(new int[] {1,2,3,4,0,5,6,7,8});	
		
		// LargeSearch( Estado Inicial, Index Destino, Numero a meter no Index Destino)
		Search.LargeSearch(s, 8, 1);
		
	}
}
