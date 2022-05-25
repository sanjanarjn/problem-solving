/***
Suppose you have a string, S, made up of only 'a's and 'b's. Write a recursive function that checks if the string was generated using the following rules:
  a. The string begins with an 'a'
  b. Each 'a' is followed by nothing or an 'a' or "bb"
  c. Each "bb" is followed by nothing or an 'a'
If all the rules are followed by the given string, return true otherwise return false.


**/

public class CheckAB {

	public static boolean checkAB(String input) {
		
        if(input.charAt(0) != 'a')
            return false;
        
        return check(input, 0);
  }
    
    private static boolean check(String s, int si) {
        
        if(si >= s.length() - 1)
            return true;
        
        char curr = s.charAt(si);
        
        if(curr == 'a') {
            return (isNextA(s, si) && check(s, si + 1)) || (isNextBb(s, si) && check(s, si + 2));
        }
        else {
            return isNextA(s, si) && check(s, si + 1);
        }
    }
    
    private static boolean isNextA(String s, int si) {
        return s.charAt(si + 1) == 'a';
    } 
    
    private static boolean isNextBb(String s, int si) {
        
        if((si + 2) <= s.length() - 1) {
            return s.charAt(si + 1) == 'b' && s.charAt(si + 2) == 'b';
        }
        return false;
     
    } 
    
}
