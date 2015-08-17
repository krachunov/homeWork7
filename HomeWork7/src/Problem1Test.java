import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Problem1Test {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		File file = new File("D:\\test.txt");

		List<String> list = Problem1.readFile(file);
		System.out.println(list.size());
	}

}
