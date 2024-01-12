package br.com.wallace.mf.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FieldTest {
	
	private Field field;
	
	@BeforeEach
	void startField() {
		field = new Field(3, 3);
	}
	
	@Test
	void testNeighborsRealDistanceOneLeft() {
		Field neighbor = new Field(3, 2);
		boolean result= field.addNeighbors(neighbor);
		assertTrue(result);
	}
	
	@Test
	void testNeighborsRealDistanceOneRight() {
		Field neighbor = new Field(3, 4);
		boolean result= field.addNeighbors(neighbor);
		assertTrue(result);
	}
	
	@Test
	void testNeighborsRealDistanceOneUp() {
		Field neighbor = new Field(2, 3);
		boolean result= field.addNeighbors(neighbor);
		assertTrue(result);
	}
	
	@Test
	void testNeighborsRealDistanceOneDown() {
		Field neighbor = new Field(4, 3);
		boolean result= field.addNeighbors(neighbor);
		assertTrue(result);
	}
	
	@Test
	void testNeighborsRealDistanceTwo() {
		Field neighbor = new Field(2, 2);
		boolean result= field.addNeighbors(neighbor);
		assertTrue(result);
	}
	
	@Test
	void testNotNeighborsRealDistance() {
		Field neighbor = new Field(1, 1);
		boolean result= field.addNeighbors(neighbor);
		assertFalse(result);
	}
}
