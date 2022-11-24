package com.example.otiashviliketevani_quiz5.exception;
public class ExceptionResponse 
{
private String message;
private String details;
public ExceptionResponse( String message, String details) 
{
super();
//this.timestamp = timestamp;
this.message = message;
this.details = details;
}
//public Date getTimestamp() 
//{
//return timestamp;
//}
public String getMessage() 
{
return message;
}
public String getDetails()
{
return details;
}
}