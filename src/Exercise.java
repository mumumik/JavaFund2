import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
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
	
	public void findLongestWord() throws IOException {
		int length = 8;
		String longestWord = 
				Files.lines(Paths.get(inputFile))
				.filter(word->!word.contains("a"))
				.filter(word->!word.contains("e"))
				.findFirst()
				.orElse(null);
		System.out.printf("The first 8 letters word found that contain 'a', 'b', 'c' is : %s\n", longestWord);
	}
	
	
}
