import java.util.Arrays;

public class State {
	int[] table;
	int zero;
	int direction;
	public State(int[] t, int d) {
		table=t;
		zero = indexOfZero();
		direction = d;
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
				return zero-3 < 0 ? null : new State(trade(zero, zero - 3), 0);
			case 1: //RIGHT
				return zero==2 || zero==5 || zero==8 ? null : new State(trade(zero, zero + 1), 1);
			case 2: //DOWN
				return zero+3 > 8 ? null : new State(trade(zero, zero + 3), 2);
			case 3: //LEFT
				return zero==0 || zero==3 || zero==6 ? null : new State(trade(zero, zero -1), 3);
		}
		return null;
		
	}
	
	public int oppDirection() {
		switch(direction) {
		case 0: return 2;
		case 1: return 3;
		case 2: return 0;
		case 3: return 1;
		}
		return -1;
	}
	public int[] getTable() {return table;}
	
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
	
	public State[] possibleMoves() {
		State[] res = new State[4];
		for(int i = 0; i!= 4; i++) {
			if(i != oppDirection()) {
				res[i] = moveTo(i);
			}else {
				res[i] = null;
			}
		}
		return res;
	}
}
