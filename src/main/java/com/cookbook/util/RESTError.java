package com.cookbook.util;



	public class RESTError extends Exception {
		
		
		private Integer code;
		
		private String message;
		public RESTError(Integer code, String message) {
			super();
			this.code = code;
			this.message = message;
		}

		public RESTError() {
			super();
		}

		public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		

	}

