package br.com.wallace.mf.model;

import java.util.ArrayList;
import java.util.List;

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
}
