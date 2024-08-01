// return longest substring in which there is no duplicate charecter

/*import java.util.*;;

public class Substring {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
              while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }
        
        return maxLength;
    }
    public static void main(String[]args){
        System.out.println(lengthOfLongestSubstring("abcdcbad"));
    }
}*/

/*import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutDuplicates {
    
    public static boolean hasDuplicateChars(String s) {
        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (charSet.contains(c)) {
                return true;
            }
            charSet.add(c);
        }
        return false;
    }
    
    public static String findLargestSubstring(String s) {
        int maxLength = 0;
        String maxSubstring = "";
        
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (!hasDuplicateChars(substring) && substring.length() > maxLength) {
                    maxLength = substring.length();
                    maxSubstring = substring;
                }
            }
        }
        
        return maxSubstring;
    }
    
    public static void main(String[] args) {
        String input = "abcabdca";
        String result = findLargestSubstring(input);
        System.out.println("The largest substring without duplicate characters is: " + result);
    }
}*/

public class LongestSubstringWithoutDuplicates {

    public static boolean hasDuplicateChars(String s) {
        int[] charCount = new int[256]; // Assuming ASCII character set
        for (char c : s.toCharArray()) {
            if (charCount[c] > 0) {
                return true;
            }
            charCount[c]++;
        }
        return false;
    }
    
    public static String findLargestSubstring(String s) {
        int maxLength = 0;
        String maxSubstring = "";
        
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (!hasDuplicateChars(substring) && substring.length() > maxLength) {
                    maxLength = substring.length();
                    maxSubstring = substring;
                }
            }
        }
        
        return maxSubstring;
    }
    
    public static void main(String[] args) {
        String input = "abcabdca";
        String result = findLargestSubstring(input);
        System.out.println("The largest substring without duplicate characters is: " + result);
    }
}


