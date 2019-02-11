package com.anita.onlineFE.exception;

import java.io.Serializable;

	public class ItemNotFoundException extends Exception implements Serializable {

		private static final long serialVersionUID = 1L;
		private String message;
		
		public ItemNotFoundException() {
			this("Item is not available!");
		}
		
		public ItemNotFoundException(String message) {
			this.message = System.currentTimeMillis() + ": " + message;
		}

		public String getMessage() {
			return message;
		}
	}



