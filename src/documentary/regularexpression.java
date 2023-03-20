package documentary;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class regularexpression {
	public static void main(String[] args) {
		String regex = "DCMT_[0-9]{6}";
		String input;
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		if(m.find()) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}
