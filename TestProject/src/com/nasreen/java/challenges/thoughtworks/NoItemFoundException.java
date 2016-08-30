/**
 * 
 */
package com.nasreen.java.challenges.thoughtworks;

/**
 * @author Nasrin Created on Aug 27, 2016
 */
public class NoItemFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoItemFoundException() {
		super();
	}

	public NoItemFoundException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NoItemFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoItemFoundException(String arg0) {
		super(arg0);
	}

	public NoItemFoundException(Throwable arg0) {
		super(arg0);
	}

}
