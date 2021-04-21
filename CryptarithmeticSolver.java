import java.util.HashMap;

public class CryptarithmeticSolver {
	public static boolean solution;
	
	public static void main(String[] args) {
		HashMap<Character, Integer> charToIntMap = new HashMap<Character, Integer>();
		
		String s1 = "TO";
		String s2 = "FOR";
		String s3 = "TOO";
		String s4 = "WON";
		
		// case 1: "TO + TO = FOR", 6-numbering system
		System.out.println("Case 1, \"TO + TO = FOR\"");
		int numberingSystem = 6; //represents the numbering system
		boolean[] usedNumbers = new boolean[numberingSystem];
		charToIntMap.clear();
		String unique = uniqueSymbols(charToIntMap, s1, s1, s2);
		solution = false;
		
		
		solvePuzzle(unique, 0, charToIntMap, usedNumbers, s1, s1, s2, numberingSystem);
		if( solution == false)
			System.out.println("No solution found");
		System.out.println();
		
		
		// case 2: "TOO + TOO = FOR", 6-numbering system
		System.out.println("Case 2, \"TOO + TOO = FOR\"");
		numberingSystem = 6; //represents the numbering system
		usedNumbers = new boolean[numberingSystem];
		charToIntMap.clear();
		unique = uniqueSymbols(charToIntMap, s3, s3, s2);
		solution = false;
		
		
		solvePuzzle(unique, 0, charToIntMap, usedNumbers, s3, s3, s2, numberingSystem);
		if( solution == false)
			System.out.println("No solution found");
		System.out.println();
		
		
		// case 3: "WON + WON = TOO", 10-numbering system
		System.out.println("Case 3, \"WON + WON = TOO\"");
		numberingSystem = 10; //represents the numbering system
		usedNumbers = new boolean[numberingSystem];
		charToIntMap.clear();
		unique = uniqueSymbols(charToIntMap, s4, s4, s3);
		solution = false;
		
		
		
		solvePuzzle(unique, 0, charToIntMap, usedNumbers, s4, s4, s3, numberingSystem);
		if( solution == false)
			System.out.println("No solution found!");
		System.out.println();
	}
	
	public static String uniqueSymbols(HashMap<Character, Integer> charToIntMap, String s1, String s2, String s3) {
		String unique = "";
		
		for (int i = 0; i < s1.length(); i++) {
			 if(!charToIntMap.containsKey(s1.charAt(i))) {
				 charToIntMap.put(s1.charAt(i), -1);
				 unique += s1.charAt(i);
			 }
		 }
		 
		 for (int i = 0; i < s2.length(); i++) {
			 if(!charToIntMap.containsKey(s2.charAt(i))) {
				 charToIntMap.put(s2.charAt(i), -1);
				 unique += s2.charAt(i);
			 }
		 }
		 
		 for (int i = 0; i < s3.length(); i++) {
			 if(!charToIntMap.containsKey(s3.charAt(i))) {
				 charToIntMap.put(s3.charAt(i), -1);
				 unique += s3.charAt(i);
			 }
		 }
		 return unique;
	}
	
	 public static int getNum(String s, HashMap<Character, Integer> charToIntMap) {
		 String num = "";
		 for(int i = 0; i < s.length(); i++) {
			 num += charToIntMap.get(s.charAt(i));
		 }
		 
		 return Integer.parseInt(num);
	 }
	 
	 
	 public static String[] addInSIXNumberingSystem(int num1, int num2, String[] result) {
		 String s1 = String.valueOf(num1);
		 String s2 = String.valueOf(num2);
		 int n1, n2;
		 char tempS1;
		 char tempS2;
		 int carry;
		 
		 do {
			 tempS1 = s1.charAt(s1.length()-1);
			 s1 = s1.substring(0, s1.length()-1);
			 n1 = Character.getNumericValue(tempS1);
			 
			 tempS2 = s2.charAt(s2.length()-1);
			 s2 = s2.substring(0, s2.length()-1);
			 n2 = Character.getNumericValue(tempS2);
			 
			 if (result[1] == "")
				 carry = 0;
			 else
				 carry= Integer.parseInt(result[1]);
			 
			 if (n1 + n2 + carry >= 6) {
				 result[0] += String.valueOf((n1+n2+carry) - 6);
				 result[1] = "1"; //carry
			 }
			 else {
				 result[0] += String.valueOf(n1+n2+carry);
				 result[1] = "0"; //carry
			 }
		 
		 }while(s1.length()!=0 && s2.length()!=0);
		
		 if(s1.length() > s2.length()) {
			 tempS1 = s1.charAt(s1.length()-1);
			 s1 = s1.substring(0, s1.length()-1);
			 n1 = Character.getNumericValue(tempS1);
			 
			 carry= Integer.parseInt(result[1]);
			 
			 if (n1 + carry >= 6) {
				 result[0] += String.valueOf((n1+carry) - 6);
				 result[1] = "1"; //carry
			 }
			 else {
				 result[0] += String.valueOf(n1+carry);
				 result[1] = "0"; //carry
			 }
		 }
		 
		 if(s1.length() < s2.length()) {
			 tempS2 = s2.charAt(s2.length()-1);
			 s2 = s2.substring(0, s2.length()-1);
			 n2 = Character.getNumericValue(tempS2);
			 
			 carry= Integer.parseInt(result[1]);
			 
			 if (n2 + carry >= 6) {
				 result[0] += String.valueOf((n2+carry) - 6);
				 result[1] = "1"; //carry
			 }
			 else {
				 result[0] += String.valueOf(n2+carry);
				 result[1] = "0"; //carry
			 }
		 }
		 if(result[1] == "1") {
			 carry= Integer.parseInt(result[1]);
			 result[0] += String.valueOf(carry);
		 }
		 
		 //Reverse the String for correct answer
		 String tempArray = "";	 
		 for(int i= result[0].length()-1; i>=0 ; i--) {
			 tempArray += result[0].charAt(i); 
		 }
		 result[0] = tempArray;	
		 
		 return result;
	}
	 
	
	 public static void solvePuzzle(String unique, int index, HashMap<Character, Integer> charToIntMap, boolean[] usedNumbers,
				 String s1, String s2, String s3, int numSystem) {
			 
			 if(index == unique.length()) {
				 int num1 = getNum(s1, charToIntMap);
				 int num2 = getNum(s2, charToIntMap);
				 int num3 = getNum(s3, charToIntMap);
				 
				 if(numSystem == 10 && (num1 + num2 == num3)) {
					for(int i = 0; i < unique.length(); i++) {
						char ch = unique.charAt(i);
						if(charToIntMap.containsKey(ch)) {
							System.out.print(ch + "-" + charToIntMap.get(ch) + " ");
						}
					}
					solution = true;
					System.out.println();
				 }
				 
				 if(numSystem == 6) {
					String[] result = new String[2];
					result[0] = "";
					result[1] = "";
					String s[] = addInSIXNumberingSystem(num1, num2, result);
					int numOfSum = Integer.parseInt(s[0]);
					
					if(numOfSum == num3){
						for(int i = 0; i < unique.length(); i++) {
							char ch = unique.charAt(i);
							if(charToIntMap.containsKey(ch)) {
								System.out.print(ch + "-" + charToIntMap.get(ch) + " ");
							}
						}
						solution = true;
						System.out.println();
					 }
				 }
				 return;
			 }
			 
			 char ch = unique.charAt(index);
			 for(int num = 0; num <= numSystem-1; num++) {
				 if(usedNumbers[num] == false) {
					 charToIntMap.put(ch, num);
					 usedNumbers[num] = true;
					 solvePuzzle(unique, index+1, charToIntMap, usedNumbers, s1, s2, s3, numSystem);
					 usedNumbers[num] = false;
					 charToIntMap.put(ch, -1);
				 }
			 } 
		 }
}
