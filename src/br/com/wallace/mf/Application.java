package br.com.wallace.mf;

import br.com.wallace.mf.model.Board;
import br.com.wallace.mf.vision.BoardConsole;

public class Application {

	public static void main(String[] args) {
		
		
		Board board = new Board(5, 5, 2);
		
		new BoardConsole(board);
	}
}
