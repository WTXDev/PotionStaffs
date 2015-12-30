package com.wtx.potionstaffs.exceptions;

public class InvalidStaffException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidStaffException()
	{
		super("Staff was invalid or not found!");
	}
	

}
