import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Exercise2 {
	String inputFile = "enable1.txt";
	
	public void findFirst10LetterWord() throws IOException {
		Stream<String> enable1 = Files.lines(Paths.get(inputFile));
		String result1 = enable1.filter(word->word.length() == 10).findFirst().orElse(null);
		System.out.println(result1);
		
		String result2 = 
				Files.lines(Paths.get(inputFile))
				.filter(word->word.length() == 10)
				.findFirst()
				.orElse(null);
		System.out.println(result2);
		
		
	}
}
