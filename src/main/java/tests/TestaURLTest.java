package tests;

import java.io.IOException;

import utils.URLTest;

public class TestaURLTest {

	static Long inicio;
	static Long fim;

	public static void main(String[] args) {
		URLTest test = new URLTest();
		int response;

		inicio = System.currentTimeMillis();
		try {

			response = test.getResponseCode("http://www.aaa.com");
			
		} catch (IOException e) {
			response = 404;

		} finally {
			fim = System.currentTimeMillis();
		}
		System.out.println(response);
		System.out.println(fim - inicio + " ms para processar o teste");
	}

}
