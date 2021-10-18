package demo;

import java.util.Arrays;

public class CheckStringAnaagram {
	
static void IsAnagram(String str1,String str2) {
	
	
	String s1= str1.replaceAll("\\s","");
	String s2 = str1.replaceAll("\\s","");
	
	boolean status = true;
	
	if(s1.length()!=s2.length())
	{
		status =  false;
				
	}
	
	else {
		
	
	char[] ArrayS1 = s1.toLowerCase().toCharArray();
	
	char[] ArrayS2 = s2.toLowerCase().toCharArray();
	
	Arrays.sort(ArrayS1);
	
	Arrays.sort(ArrayS2);
	
}


if (status) {  
    System.out.println(s1 + " and " + s2 + " are anagrams");  
} else {  
    System.out.println(s1 + " and " + s2 + " are not anagrams");  
}  

}

public static void main(String[] args) {
	
	
	IsAnagram("Keep", "Peek");  
	IsAnagram("Mother In Law", "Hitler Woman");  
}

}
