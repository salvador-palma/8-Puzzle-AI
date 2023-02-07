import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
		int[] n = new int[] {1,2,3,4,0,5,6,7,8};
		State s = new State(n, -1);		
		DeepSearch(s, 5, 1);
		System.out.println(s.numInSlot(0,1));
	}
	
	public static void DeepSearch(State start, int index, int target) {
		Stack<State> stack = new Stack<State>();
		stack.add(start);
		while(!stack.peek().numInSlot(index, target)) {
			
			for(State state : stack.pop().possibleMoves()) {
				if(state!=null) {
					System.out.println(state.toString());
					stack.add(state);
				}
			}
		}
		
		
		
	}
	
	

}
