import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class State {
	int[] table;
	int zero;
	int direction;
	List<State> history;
	public State(int [] t) {
		this(t, 10, null);
	}
	public State(int[] t, int d, List<State> l) {
		table=t;
		zero = indexOfZero();
		direction = d;
		history = l==null ? new ArrayList<State>() : new ArrayList<State>(l);
		history.add(this);
	}
	public int indexOfZero() {
		for(int i = 0; i != table.length; i++) {
			if(table[i]==0) {
				return i;
			}
		}
		return -1;
	}
	public boolean numInSlot(int slot, int target) {
		return table[slot] == target;
	}
	public State moveTo(int dir) {
		
		switch(dir) {
			case 0: //UP
				return new State(trade(zero, zero - 3), 0, history);
			case 1: //RIGHT
				return new State(trade(zero, zero + 1), 1, history);
			case 2: //DOWN
				return new State(trade(zero, zero + 3), 2, history);
			case 3: //LEFT
				return new State(trade(zero, zero -1),  3, history);
		}
		return null;
		
	}
	
	public boolean inBounds(int dir) {
		switch(dir) {
		case 0: return zero-3>=0;
		case 1: return (zero-2)%3 != 0;
		case 2: return zero+3 <= 8;
		case 3: return zero%3 != 0;
		}
		return false;
	}
	public int oppDirection() {
		return direction < 2 ? 2+direction : direction-2;
	}
	public int[] trade(int a, int b){
		int[] temptable = Arrays.copyOf(table, table.length);
		temptable[a] = table[b];
		temptable[b] = table[a];
		return temptable;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i = 0 ; i<table.length; i+=3) {
			str+=String.format("%d%d%d\n", table[i], table[i+1], table[i+2]);
		}
		return str;		
	}
	public List<State> possibleMoves() {
		List<State> res = new ArrayList<State>();
		for(int i = 0; i!= 4; i++) {
			if(i!=oppDirection() && inBounds(i)) {
				res.add(moveTo(i));
			}
		}
		return res;
	}
	
	public String getHistory() {
		String str = "";
		for(State s : history) {
			str+=s.toString() + "\n";
		}
		return str;
	}
}
