import java.io.IOException;

public class PathExamples {

	public static void main(String[] args) throws IOException  {
		
		PathVar1 pv1 = new PathVar1();
		PathVar2 pv2 = new PathVar2();
		Exercise ex = new Exercise();
		Exercise2 ex2 = new Exercise2();
		//Example Files:
		pv1.Path();
		pv2.path2();
		pv2.listExamples();
		pv2.walkExamples();
		pv2.findExamples();
		//Exercise 1 files
		System.out.println("Exercise 1 No.1");
		ex.find10Letterword();
		System.out.println("Exercise 1 No.2");
		ex.find8LetterwordABC();
		System.out.println("Exercise 1 No.3");
		ex.find8LetterwordABCIgnoreCase();
		System.out.println("Exercise 1 No.4");
		ex.longestWordNotAE();
		System.out.println("Exercise 1 No.5");
		ex.shortestWordQ();
		System.out.println("Exercise 1 No.6");
		ex.twitterWord();
		System.out.println("Exercise 1 No.7");
		ex.countFilesInFolder(".");
		System.out.println("Exercise 1 No.8");
		ex.randomNumber();
		//Exercise 2 files
		System.out.println("Exercise 2 No.2");
		ex2.findFirst10LetterWord();
	}

}
