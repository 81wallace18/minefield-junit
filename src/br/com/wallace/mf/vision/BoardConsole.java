package br.com.wallace.mf.vision;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.wallace.mf.exceptions.ExitException;
import br.com.wallace.mf.exceptions.ExplosionException;
import br.com.wallace.mf.model.Board;

public class BoardConsole {

	private Board board;

	private Scanner prohibited = new Scanner(System.in);

	public BoardConsole(Board board) {
		this.board = board;
		executeGame();
	}

	private void executeGame() {
		try {
			boolean continueVariable = true;

			while (continueVariable) {
				cicleOfTheGame();

				System.out.println("Another match (Y/n): ");
				String response = prohibited.nextLine();
				if ("n".equalsIgnoreCase(response)) {
					continueVariable = false;
				} else {
					board.restart();
				}
			}
		} catch (ExitException e) {
			System.out.println("Bye Bye!!!");
		} finally {
			prohibited.close();
		}
	}

	private void cicleOfTheGame() {
		try {

			while (!board.objectiveAchieved()) {
				System.out.println(board);

				String digitated = captureTypedValue("Type (x, y): ");

				Iterator<Integer> xy = Arrays.stream(digitated.split(",")).map(s -> Integer.parseInt(s.trim()))
						.iterator();

				digitated = captureTypedValue("1 - Open or 2 - (Un)Mark: ");

				if ("1".equals(digitated)) {
					board.open(xy.next(), xy.next());
				} else if ("2".equals(digitated)) {
					board.toggleMarking(xy.next(), xy.next());
				}
			}
			
			System.out.println(board);
			System.out.println("You wins!!");
		} catch (ExplosionException e) {
			System.out.println(board);
			System.out.println("You lose!");
		}
	}

	private String captureTypedValue(String text) {
		System.out.print(text);
		String digited = prohibited.nextLine();

		if ("exit".equalsIgnoreCase(digited) || "sair".equalsIgnoreCase(digited)) {
			throw new ExitException();
		}

		return digited;
	}
}
