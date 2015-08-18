import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

public class PriceListTest {

	public static void main(String[] args) {
		PriceList priceList = new PriceList();

		long startTime = System.nanoTime();

		for (int i = 0; i < 500000; i++) {
			Random random = new Random();
			int randomPrice = random.nextInt(100);
			priceList.add("product" + i, randomPrice);
		}

		long endTime = System.nanoTime();
		System.out.println("Total Time to add 500 000 elements: "
				+ (endTime - startTime) * (Math.pow(10, -9)));
		
		
		long startTime2 = System.nanoTime();
		Object[] arrayProduc = priceList.findPriceRange(15, 99);
		long endTime2 = System.nanoTime();
		System.out.println("Time to finde element: "
				+ (endTime2 - startTime2) * (Math.pow(10, -9)));
		
		//TOTO print result
	System.out.println("");
	}
}
