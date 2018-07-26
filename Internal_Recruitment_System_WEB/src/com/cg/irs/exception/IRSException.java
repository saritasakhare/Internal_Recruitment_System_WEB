package com.cg.irs.exception;

@SuppressWarnings("serial")
public class IRSException extends Exception 
{

	public IRSException() 
	{
		super();
	}

	public IRSException(String arg0, Throwable arg1, boolean arg2, boolean arg3) 
	{
		super(arg0, arg1, arg2, arg3);
	}

	public IRSException(String arg0, Throwable arg1)
	{
		super(arg0, arg1);
	}

	public IRSException(String arg0) 
	{
		super(arg0);
	}

	public IRSException(Throwable arg0)
	{
		super(arg0);
	}

	
}
