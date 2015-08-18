import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * Problem 2
 */
public class PriceList {
	private TreeMap<Integer, List<Product>> product;
	private int count;

	public TreeMap<Integer, List<Product>> getProduct() {
		return product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public PriceList() {
		product = new TreeMap<Integer, List<Product>>();
		setCount(0);
	}

	/**
	 * Add new element, if element has same value and same price there is equals
	 * 
	 * @param value
	 * @param price
	 * @return - true if element add success or false if not
	 */
	public boolean add(String value, int price) {
		if (!getProduct().containsKey(price)) {
			List<Product> currentList = new ArrayList<Product>();
			currentList.add(new Product(value, price));
			getProduct().put(price, currentList);
			int currentCount = getCount();
			setCount(currentCount + 1);
			return true;
		} else {
			List<Product> currentList = getProduct().get(price);
			Product newProduct = new Product(value, price);
			if (!currentList.contains(newProduct)) {
				// TODO - do not work
				currentList.add(newProduct);
				int currentCount = getCount();
				setCount(currentCount + 1);
				return true;
			} else {
				System.out.println("Already in list");
				return false;
			}
		}
	}
	public Product find(){
		return null;
		
	}

	private class Product {
		private String value;
		private int price;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public Product(String value, int price) {
			setValue(value);
			setPrice(price);
		}

		@Override
		public boolean equals(Object o) {
			if (this.getValue().equals(((Product) o).getValue())) {
				return this.getPrice() == ((Product) o).getPrice();
			}
			return false;

		}
	}

}
