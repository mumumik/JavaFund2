import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.regex.Pattern;

public class Exercise {

	String inputFile = "enable1.txt";
	
	public void find10Letterword() throws IOException {
		int length = 10;
		String tenLetterWord = 
				Files.lines(Paths.get(inputFile))
				.filter(word->word.length() == length)
				.findFirst()
				.orElse(null);
		System.out.printf("The first 10 letters word found is : %s\n", tenLetterWord);
	}
	
	public void find8LetterwordABC() throws IOException {
		int length = 8;
		String eightLetterWordABC = 
				Files.lines(Paths.get(inputFile))
				.filter(word->word.length() == length)
				.filter(word->word.contains("a"))
				.filter(word->word.contains("b"))
				.filter(word->word.contains("c"))
				.findFirst()
				.orElse(null);
		System.out.printf("The first 8 letters word found that contain 'a', 'b', 'c' is : %s\n", eightLetterWordABC);
	}
	
	public void find8LetterwordABCIgnoreCase() throws IOException {
		int length = 8;
		String eightLetterWordABC = 
				Files.lines(Paths.get(inputFile))
				.filter(word->word.length() == length)
				.filter(word->Pattern.compile(Pattern.quote("a"), Pattern.CASE_INSENSITIVE).matcher(word).find())
				.filter(word->Pattern.compile(Pattern.quote("b"), Pattern.CASE_INSENSITIVE).matcher(word).find())
				.filter(word->Pattern.compile(Pattern.quote("c"), Pattern.CASE_INSENSITIVE).matcher(word).find())
				.findFirst()
				.orElse(null);
		System.out.printf("The first 8 letters word found that contain 'a', 'b', 'c' (case insensitive) is : %s\n", eightLetterWordABC);
	}
	
	public void longestWordNotAE() throws IOException {

		String longestWord = 
				Files.lines(Paths.get(inputFile))
				.filter(word->!word.contains("a"))
				.filter(word->!word.contains("e"))
				.max(Comparator.comparingInt(String::length))
				.get();
				
		System.out.printf("The longest word found that does not contain 'a', 'e' is : %s\n", longestWord);
	}
	
	public void shortestWordQ() throws IOException {

		String shortestWord = 
				Files.lines(Paths.get(inputFile))
				.filter(word->word.contains("q"))
				.min(Comparator.comparingInt(String::length))
				.get();
				
		System.out.printf("The shortest word found that contain a 'q' is : %s\n", shortestWord);
	}
	
	public void twitterWord() throws IOException {
		String outputFile = "twitter-words.txt";
		List<String> twitterWord = 
				Files.lines(Paths.get(inputFile))
				.filter(word->word.contains("f"))
				.filter(word->word.contains("q"))
				.map(word->word.toUpperCase() + "!")
				.collect(Collectors.toList());
		Files.write(Paths.get(outputFile), twitterWord, Charset.defaultCharset());
		System.out.printf("Created twitter-word.txt\n");
	}
	
	
	public void countFilesInFolder(String folder) throws IOException {
		long total= 
				Files.list(Paths.get(folder))
				.count();
		System.out.printf("Total Files in %s folder: %s",folder,total);
	}
	
	public void randomNumber() {
		Path path2 = Paths.get("exercise-8.txt");
		Charset characterSet = Charset.defaultCharset();
		int numLines = 17;
		
		try(PrintWriter pwriter = new PrintWriter(Files.newBufferedWriter(path2, characterSet))){
			System.out.println("Print random number between 0 and 100 and 3 point decimals");
			for(int j=0; j<numLines; j++) {
				pwriter.printf("Number is %5.3f%n", 100 * Math.random());
			}
		}
		catch(IOException ioe) {
			System.err.printf("PrintWriter IOEx : %s", ioe);
		}
	}
	
	
}
