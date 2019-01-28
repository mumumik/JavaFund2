import java.io.IOException;

public class PathExamples {

	public static void main(String[] args) throws IOException  {
		
		PathVar1 pv1 = new PathVar1();
		PathVar2 pv2 = new PathVar2();
		Exercise ex = new Exercise();
		//pv1.Path();
		//pv2.path2();
		//pv2.listExamples();
		//pv2.walkExamples();
		//pv2.findExamples();
		System.out.println("Exercise No.1");
		ex.find10Letterword();
		System.out.println("Exercise No.2");
		ex.find8LetterwordABC();
		System.out.println("Exercise No.3");
		ex.find8LetterwordABCIgnoreCase();
	}

}
