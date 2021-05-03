package week4;

import acm.program.ConsoleProgram;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.*;


public class WordCount extends ConsoleProgram {
	
	private BufferedReader openFileReader(String prompt) {
		
		BufferedReader br = null;
	
		while (br == null ) {
			
			try {
				String filename = readLine(prompt);
				br = new BufferedReader(new FileReader(filename));
			} catch(IOException e) {
				println("Filename is incorrect.");
			}
		}
		return br;
	}	
		
		
	static private int countWords(String line)	{
		boolean digit = false;
		int count = 0;
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				digit = true;
			} else {
				if (digit)
					count++;
				digit = false;
			}	
		}
		if (digit) count++;
		return count;
	}
		
	public void run() {
		int line = 0;
		int words = 0;
		int chars = 0;
		
		BufferedReader br = openFileReader("File: ");
		
		try {
			while (true) {
				String currentLine = br.readLine();
				if (currentLine == null) break;
				
				line++;
				words += countWords(currentLine);
				chars += currentLine.length();
				
				
				}
				br.close();
				
				println("Lines: "+ line);
				println("Words: " + words);
				println("Chars: " + chars);
				
		} catch(IOException e) {
				println("An I/O exception has occured");
		}
	}
	
		
}
