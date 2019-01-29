
public class StringUtils {
	
	public static int longestLength = 0;
	public static String longestWord = "";
	
	public static String reverseString(String s) {
		return(new StringBuilder(s).reverse().toString());
	}
	
	public static boolean isPalindrome(String s) {
		return(s.equalsIgnoreCase(reverseString(s)));
	}
	
}
