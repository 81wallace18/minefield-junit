package br.com.wallace.mf.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.wallace.mf.exceptions.ExplosionException;

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
	
	@Test
	void testValueStandardAttributeMarked() {
		assertFalse(field.isMarked());
	}
	
	@Test
	void testToggleMarking() {
		field.toggleMarking();
		assertTrue(field.isMarked());
	}
	
	@Test
	void testToggleMarkingTwoCall() {
		field.toggleMarking();
		field.toggleMarking();
		assertFalse(field.isMarked());
	}
	
	
	@Test
	void testOpenNoUnderminedNoMarked() {
		assertTrue(field.open());
	}
	
	@Test
	void testOpenNoUnderminedIsMarked() {
		field.toggleMarking();
		assertFalse(field.open());
	}
	
	@Test
	void testOpenUnderminedIsMarked() {
		field.toggleMarking();
		field.undermine();
		assertFalse(field.open());
	}
	
	@Test
	void testOpenUnderminedNoMarked() {
		field.undermine();
		assertThrows(ExplosionException.class, 
				() -> field.open());
	}
	
	@Test
	void testOpenWithNeighbors1() {
		Field field11 = new Field(1, 1);
		
		Field field22 = new Field(2, 2);
		field22.addNeighbors(field11);
		
		field.addNeighbors(field22);
		field.open();
		
		assertTrue(field22.isOpened() && field11.isOpened());
	}
	
	@Test
	void testOpenWithNeighbors2() {
		Field field11 = new Field(1, 1);
		Field field12 = new Field(1, 2);
		field12.undermine();
		
		Field field22 = new Field(2, 2);
		field22.addNeighbors(field11);
		field22.addNeighbors(field12);
		
		field.addNeighbors(field22);
		field.open();
		
		assertTrue(field22.isOpened() && field11.isClosed());
	}
}
