import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PathVar1 {
	
	public void Path() throws IOException{
		String inputFile = "enable1.txt";
		String outputFile = "four-letter-words.txt";
		String outputFile2 = "palindrome-words.txt";
		
		int length = 4;
		
		List<String> words = 
				Files.lines(Paths.get(inputFile))
				.filter(word -> word.length() == length)
				.map(String::toUpperCase)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		
		Files.write(Paths.get(outputFile), words, Charset.defaultCharset());
		System.out.println("Print to file  words that contain four letters");
		System.out.printf("Wrote %s words to %s.%n", words.size(), outputFile);
		
		List<String> words2 = 
				Files.lines(Paths.get(inputFile))
				.filter(StringUtils::isPalindrome)
				.collect(Collectors.toList());
		Files.write(Paths.get(outputFile2), words2, Charset.defaultCharset());
		System.out.println("Print to file  Palindrome words");
		System.out.printf("Wrote %s palindrome words to %s.%n", words2.size(), outputFile2);
		
		String words3 = 
				Files.lines(Paths.get(inputFile))
				.filter(word -> word.length() == 6)
				.filter(StringUtils::isPalindrome)
				.findFirst()
				.orElse(null);
		System.out.printf("The first 6 letters Palindrome word is %s", words3);
		
		Long words4 = 
				Files.lines(Paths.get(inputFile))
				.filter(word->word.contains("q"))
				.filter(word->!word.contains("qu"))
				.count();
		System.out.printf("\nWords that contains 'q' but not 'u' is %s", words4);
		
		int words5 =
				Files.lines(Paths.get(inputFile))
				.filter(word->word.contains("x"))
				.filter(word->word.contains("y"))
				.mapToInt(String::length)
				.sum();
		System.out.printf("\nTotal Letters in Words with Both x & y : %s", words5);
		
		Path p1 = Paths.get("enable1.txt");
		System.out.println("");
		System.out.println("");
		System.out.println("Simple Path");
		System.out.printf("toString: %s%n%n", p1);
		
		Path p2 = p1.toAbsolutePath();
		System.out.println("Absolute Path");
		System.out.printf("toString: %s%n", p2);
		System.out.printf("getFileName: %s%n", p2.getFileName());
		System.out.printf("getName(0): %s%n", p2.getName(0));
		System.out.printf("getNameCount: %d%n", p2.getNameCount());
		System.out.printf("subpath(0,2): %s%n", p2.subpath(0,2));
		System.out.printf("getParent: %s%n", p2.getParent());
		System.out.printf("getRoot: %s%n", p2.getRoot());
	}
	
}
