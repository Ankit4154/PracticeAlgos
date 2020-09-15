
public class DetectCapitalUse {
	
	public static boolean detectCapitalUse(String word) {
		if(word.length() == 1)
			return true;
        for(int i=word.length()-1;i>0;i--) {
        	if((word.charAt(i-1) >= 'a' && word.charAt(i-1) <= 'z') && (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'))
        		return false;
        }
        for(int i=word.length()-1;i>1;i--) {
        	if((word.charAt(i) >= 'a' && word.charAt(i) <= 'z') && (word.charAt(i-1) >= 'A' && word.charAt(i-1) <= 'Z'))
        		return false;
        }
        return true;
    }

	public static void main(String[] args) {
		System.out.println("1 "+detectCapitalUse("FlaG"));
		System.out.println("2 "+detectCapitalUse("USA"));
		System.out.println("3 "+detectCapitalUse("Ag"));
		System.out.println("3 "+detectCapitalUse("Agggg"));
		System.out.println("4 "+detectCapitalUse("GGa"));
		System.out.println("5 "+detectCapitalUse("FFFFFFFFFFFFFFFFFFFFf"));
		System.out.println("6 "+detectCapitalUse("GaG"));
		System.out.println("7 "+detectCapitalUse("aG"));
		System.out.println("8 "+detectCapitalUse("aaG"));
		System.out.println("9 "+detectCapitalUse("aaaG"));
		System.out.println("10 "+detectCapitalUse("aGG"));
		System.out.println("11 "+detectCapitalUse("aaaa"));
	}

}
