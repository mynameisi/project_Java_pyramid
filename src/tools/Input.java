package tools;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public final class Input {
	@SuppressWarnings("resource")
	public static String getOneStringFromFile(String fileName) throws FileNotFoundException{
		return new Scanner(new File(fileName)).next();
	}
	
}
