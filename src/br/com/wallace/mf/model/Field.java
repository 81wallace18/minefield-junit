package br.com.wallace.mf.model;

import java.util.ArrayList;
import java.util.List;

import br.com.wallace.mf.exceptions.ExplosionException;

public class Field {
	
	private final int line;
	private final int column;
	
	private boolean opened;
	private boolean undermine;
	private boolean marked;
	
	private List<Field> neighbors = new ArrayList<>();
	
	
	Field (int line, int column) {
		this.line = line;
		this.column = column;
	}
	
	public boolean addNeighbors(Field neighbor) {
		boolean lineDifferent = line != neighbor.line;
		boolean columnDifferent = column != neighbor.column;
		boolean diagonal = lineDifferent && columnDifferent;
		
		int deltaLine = Math.abs(line - neighbor.line);
		int deltaColumn = Math.abs(column - neighbor.column);
		int deltaGeneral = deltaColumn + deltaLine;
		
		if(deltaGeneral == 1 && !diagonal) {
			neighbors.add(neighbor);
			return true;
		} else if (deltaGeneral == 2 && diagonal) {
			neighbors.add(neighbor); 
			return true;
		} else {
			return false;
		}
	}
	
	public void toggleMarking() {
		if(!opened) {
			marked = !marked;
		}
	}
	
	public boolean open() {
		if(!opened && !marked) {
			opened = true;
			
			if(undermine) {
				throw new ExplosionException();
			}
			if(neighborhoodSafe()) {
				neighbors.forEach(v -> v.open());
			}
			return true;
		} else {
			return false;
		}
	}
	
	public boolean neighborhoodSafe() {
		return neighbors.stream().noneMatch(n -> n.undermine);
	}
}
