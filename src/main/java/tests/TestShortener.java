package tests;

import utils.URLShortener;

public class TestShortener {
	public static void main(String[] args) {
		String encoded = URLShortener.shortenUrl("www.globo.com");
		System.out.println(encoded);
		String decoded = URLShortener.retrieveUrl(encoded);
		System.out.println(decoded);
		
	}

}
