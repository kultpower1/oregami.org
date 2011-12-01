package org.oregami.util;

public abstract class Constants {

	public enum Url {
		games("games"),
		game("game");
		
		private String value = null;
		
		public String toString() {
			return value;
		};
		
		private Url(String u) {
			value=u;
		}
		
	}
	
}
