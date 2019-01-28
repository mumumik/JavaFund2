import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PathVar2 {
	
	public void path2() {
		Charset characterSet = Charset.defaultCharset();
		int numLines = 10;
		Path path = Paths.get("example-output-2.txt");
		try(BufferedWriter writer = Files.newBufferedWriter(path, characterSet)){
			for(int i = 0; i < numLines; i++) {
				writer.write("Number is "+ 100 * Math.random());
				writer.newLine();
			}
		}
		catch(IOException ioe) {
			System.err.printf("IOEx : %s", ioe);
		}
		
		Path path2 = Paths.get("example-output-3.txt");
		try(PrintWriter pwriter = new PrintWriter(Files.newBufferedWriter(path2, characterSet))){
			for(int j=0; j<numLines; j++) {
				pwriter.println("PrintWriter number : "+ 100 * Math.random());
			}
		}
		catch(IOException ioe) {
			System.err.printf("PrintWriter IOEx : %s", ioe);
		}
		
	}
	
	public static void printAllPaths(Stream<Path> paths) {
		paths.forEach(System.out::println);
	}
	
	public static void printAllPathsInFolder(String folder) {
		try(Stream<Path> paths = Files.list(Paths.get(folder))) {
			printAllPaths(paths);
		} catch(IOException ioe) {
			System.err.println("IOException: " + ioe);
		}
	}
	
	public static void printPaths(Stream<Path> paths, Predicate<Path> test) {
		paths.filter(test).forEach(System.out::println);
	}
	
	public static void printPathsInFolder(String folder, Predicate<Path> test) {
		try(Stream<Path> paths = Files.list(Paths.get(folder))) {
			printPaths(paths, test);
		} catch(IOException ioe) {
			System.err.println("IOException: " + ioe);
		}
	}
	
	public static void listExamples() {
		System.out.println("All files in project root");
		printAllPathsInFolder(".");
		System.out.println("Text files in project root");
		printPathsInFolder(".", p -> p.toString().endsWith(".txt"));
	}
	
	public static void printAllPathsInTree(String rootFolder) {
		try(Stream<Path> paths = Files.walk(Paths.get(rootFolder))) {
			printAllPaths(paths);
		} catch(IOException ioe) {
			System.err.println("IOException: " + ioe);
		}
	}
	
	public static void printPathsInTree(String rootFolder, Predicate<Path> test) {
		try(Stream<Path> paths = Files.walk(Paths.get(rootFolder))) {
			printPaths(paths, test);
		} catch(IOException ioe) {
			System.err.println("IOException: " + ioe);
		}
	}
	
	public static void walkExamples() {
		System.out.println("All files under project root");
		printAllPathsInTree(".");
		System.out.println("Java files under project root");
		printPathsInTree(".", p -> p.toString().endsWith(".java"));
	}
	
	public static void findPathsInTree(String rootFolder, BiPredicate<Path,BasicFileAttributes> test) {
		try(Stream<Path> paths = Files.find(Paths.get(rootFolder), 10, test)) {
			printAllPaths(paths);
		} catch(IOException ioe) {
			System.err.println("IOException: " + ioe);
		}
	}
	
	public static void findExamples() {
		System.out.println("Java files under project root");
		findPathsInTree(".", (path,attrs) -> path.toString().endsWith(".java"));
		System.out.println("Folders under project root");
		findPathsInTree(".", (path,attrs) -> attrs.isDirectory());
		System.out.println("Large files under project root");
		findPathsInTree(".", (path,attrs) -> attrs.size() > 10000);
	}
}
