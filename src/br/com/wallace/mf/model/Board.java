package br.com.wallace.mf.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Board {
	private int lines;
	private int columns;
	private int mines;
	
	private final List<Field> fields = new ArrayList<>();

	public Board(int lines, int columns, int mines) {
		this.lines = lines;
		this.columns = columns;
		this.mines = mines;
		
		generateFields();
		associateNeighbors();
		drawMines();
		
	}

	private void generateFields() {
		for (int l = 0; l < lines; l++) {
			for (int c = 0; c < columns; c++) {
				fields.add(new Field(l, c));
			}
		}
		
	}
	
	private void associateNeighbors() {
		for(Field f1 : fields) {
			for(Field f2 : fields) {
				f1.addNeighbors(f2);
			}
		}
	}
	
	private void drawMines() {
		long minesArmed = 0;
		Predicate<Field> undermine = c -> c.isUndermine();
		do {
			minesArmed = fields.stream().filter(undermine).count();
			int randomVariable = (int) (Math.random() * fields.size());
			fields.get(randomVariable).undermine();;
		} while(minesArmed < mines);
	}
	
	public boolean objectiveAchieved() {
		return fields.stream().allMatch(c -> c.objectiveAchieved());
	}
	
	public void restart() {
		fields.stream().forEach(c -> c.restart());
	}
}
