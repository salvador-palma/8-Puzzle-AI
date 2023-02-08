import java.util.ArrayList;
import java.util.List;

public class Search {
	
	public static void LargeSearch(State start, int index, int target) {
		List<State> list = new ArrayList<State>();
		list.add(start);
		while(true) {
			State next = list.get(0);
			list.remove(0);
			if(next.numInSlot(index, target)) {
				System.out.println(next.getHistory());
				System.out.println(String.format("Won in %d moves!", next.history.size()-1));
				break;
			}
			list.addAll(next.possibleMoves());
		}
	}
	
	/*
	public static void DeepSearch(State start, int index, int target) {
		Stack<State> stack = new Stack<State>();
		stack.add(start);
		while(!stack.peek().numInSlot(index, target)) {
			List<State> state_list = stack.pop().possibleMoves();
			for(State state : state_list) {
                    System.out.println(state.toString());
					if(state.numInSlot(index, target)) {
						System.out.println("Won!");
						return;
					}
					stack.add(state);
			}
		}
	}
	*/
}
