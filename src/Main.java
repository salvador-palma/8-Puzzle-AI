import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		
		// DEFINIR O ESTADO INICIAL AQUI
		State s = new State(new int[] {1,2,3,4,0,5,6,7,8});	
		
		// LargeSearch( Estado Inicial, Index Destino, Numero a meter no Index Destino)
		//Search.LargeSearch(s, 8, 1);
		
		Play(s, 8, 1);
		
	}
	
	public static void Play(State start, int index, int target) {
		boolean playing = true;
		int turns=0;
		State current = start;
		
		boolean validInput = true;
		String input ="";
		while(playing) {
			Scanner s = new Scanner(System.in);
			
			if(validInput) { System.out.println(current.toString()); input = s.nextLine(); validInput =true; turns++;}
			
			switch(input) {
				case "up": case "W":  current = current.moveTo(0); break;
				case "right": case "D":  current = current.moveTo(1); break;
				case "down": case "S":  current = current.moveTo(2); break;
				case "left": case "A": current = current.moveTo(3); break;
				case "exit": case "Q": playing = false; break;
				default: validInput=false;
			}
			
			if(current.numInSlot(index, target)) {
				System.out.println(String.format("You Won in %d turns!", turns));
			}
		}
	}
}
