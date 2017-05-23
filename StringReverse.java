package com.sphinix.challenge2;

import java.util.Scanner;

public class StringReverse {


	static void strReverse(String s) 
	{ 
	int i,c=0,res; 
	char ch[]=new char[s.length()]; 
	for(i=0;i < s.length();i++) 
	ch[i]=s.charAt(i); 
	for(i=s.length()-1;i>=0;i--) 
	System.out.print(ch[i]);
	} 
    
    public static void main(String[] args) {
        System.out.println("Enter any string to print reverse");
        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();
        strReverse(inputString);
    }   

}
