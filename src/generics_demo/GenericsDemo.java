package generics_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsDemo {

	public static void main(String[] args) {
		Container<String> stringStore = new Store<>();
		stringStore.set("Java");
		System.out.println(stringStore.get());
		
		Container<Integer> integerStore = new Store<>();
		integerStore.set(1);
		System.out.println(integerStore.get());
		
		Container<List<Integer>> listStrings = new Store<>();
		listStrings.set(Arrays.asList(1,2,3));
		System.out.println(listStrings.get());

		List<Number> numberList = new ArrayList<>();
		numberList.add(new Integer(1));
		numberList.add(new Double(22.0));
		
	}

}

interface Container<T> {
	void set(T a);
	T get();
}

class Store<T> implements Container<T>{
	private T a;
	
	@Override
	public void set(T a) {
		this.a = a;
	}

	@Override
	public T get() {
		return a;
	}
	
}