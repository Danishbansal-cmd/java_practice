package recursion;

public class CheckPalindrome {
    public static void main(String[] args) {
        String s = "namandf";

        System.out.println(checkPalindrome(0, s, s.length() - 1));
    }

    public static boolean checkPalindrome(int left, String s, int right){
        if(left > right){
            return true;
        }

        if(s.charAt(left) != s.charAt(right)){
            return false;
        }

        return checkPalindrome(left + 1, s, right - 1);
    }
}
