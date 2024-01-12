package br.com.wallace.mf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Teste {

	@Test
	void testarSeIgaulADois() {
		int a = 1 + 1;
		assertEquals(2, a);
	}
	
	@Test
	void testarSeIgualATres() {
		int x = 10 - 7;
		assertEquals(3, x);
	}

}
