package com.lcwd.hotel.exception;

public class ResourceNotFoundException extends RuntimeException {
 
	public ResourceNotFoundException()
	{
		super("Hotel not found associated with given id");
	}
	public ResourceNotFoundException(String msg)
	{
		super(msg);
	}

}
