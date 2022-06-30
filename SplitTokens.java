/**
@Author James Cato
Programming Language Concepts
2022-06-22
@Purpose To split an input file's content based on alphabetic, numeric, or symbol status.
*/

import java.io.IOException;
import java.nio.file.*;

public class SplitTokens
{
	static void splitString(String str)
	{
		StringBuffer alpha = new StringBuffer(),
		number = new StringBuffer(), symbol = new StringBuffer();
		
		for (int i=0; i<str.length(); i++)
		{
			if (Character.isAlphabetic(str.charAt(i)))
				alpha.append(str.charAt(i));
			else if(Character.isDigit(str.charAt(i)))
				number.append(str.charAt(i));
			else
				symbol.append(str.charAt(i));
		}
	   
		System.out.println(alpha + " --Word");
		System.out.println(number + " --Number");
		System.out.println(symbol + " --SS");
	}
	
	public static void main(String args[]) throws IOException
	{
      try
      {
         Path filePath = Paths.get("input.txt");
         String input = Files.readString(filePath);
         splitString(input);
         }
         catch (IOException e)
         {
            e.printStackTrace();
         }
         
	}
}