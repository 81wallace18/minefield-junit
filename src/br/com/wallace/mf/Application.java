package br.com.wallace.mf;

import br.com.wallace.mf.model.Board;

public class Application {

	public static void main(String[] args) {
		
		
		Board board = new Board(6, 6, 6);
		
		board.toggleMarking(4, 4);
		board.toggleMarking(4, 5);
		board.open(3, 3);
		
		System.out.println(board);
	}
}
