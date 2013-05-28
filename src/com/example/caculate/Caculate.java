package com.example.caculate;

import android.util.Log;

public class Caculate {
	
	String currentNum = "0";
	String previewNum = "0";
	char currentOp = '\0';
	char preOp = '\0';
	
	public void addDigit( char dig )
	{
		if( currentNum == "0")
			currentNum = "" + dig;
		else
			currentNum += dig;
	}

	public String getValue()   //??????
	{	
		Log.i("currentNum",currentNum);
		Log.i("previewNum",previewNum);
		if(currentNum != "0")
			return currentNum;
		else
			return previewNum;
	}
	
	public void compute( char op )
	{
		if( op == 'C')
		{
			currentNum = "0";
			previewNum = "0";
			currentOp = '\0';
			preOp = '\0';
			return;
		}
		
		if( op == '←')
		{
			if(currentNum.length() == 1)
				currentNum = "0";
			currentNum = currentNum.substring(0, currentNum.length()-1);
			return;
		}
		
		if( op == '√')
		{
			currentNum = Double.toString( Math.sqrt(Double.parseDouble(currentNum)) );
			return;
		}
		if( op == '~')
		{
			currentNum = Double.toString( -1 * (Double.parseDouble(currentNum)) );
			return;
		}
		if( op == 's')
		{
			currentNum = Double.toString( Math.sin(Double.parseDouble(currentNum)) );
			return;
		}
		if( op == 'c')
		{
			currentNum = Double.toString( Math.cos(Double.parseDouble(currentNum)) );
			return;
		}
		if( op == 't')
		{
			currentNum = Double.toString( Math.tan(Double.parseDouble(currentNum)) );
			return;
		}	
		
		if(currentOp == '\0')
		{
			currentOp = op;
			previewNum = currentNum;
			currentNum = "0";
		}
		else 
		{		
			preOp = currentOp;
			currentOp = op;
			
			if(preOp == '+')
			{
				currentNum = Double.toString( (Double.parseDouble(currentNum) + Double.parseDouble(previewNum)) );
			}
			else if(preOp == '-')
			{
				currentNum = Double.toString( (Double.parseDouble(previewNum) - Double.parseDouble(currentNum)) );

			}
			else if(preOp == '*')
			{
				currentNum = Double.toString( (Double.parseDouble(previewNum) * Double.parseDouble(currentNum)) );
			}
			else if(preOp == '/')
			{
				currentNum = Double.toString( (Double.parseDouble(previewNum) / Double.parseDouble(currentNum)) );
			}
			else if(preOp == '%')
			{
				currentNum = Double.toString( (Double.parseDouble(previewNum) % Double.parseDouble(currentNum)) );
			}
			
			previewNum = currentNum;
			currentNum = "0"; 
			
			if (currentOp == '=')
			{
				preOp = '\0';
				currentOp = '\0';
			}
			else
			{
				preOp = '\0';
			}
		}
		
	}
}
