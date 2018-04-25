package generics_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsDemo {

	public static void main(String[] args) {
		Container<String> stringStore = new Store<>();
		stringStore.set("Java");
		System.out.println(stringStore.get());
		System.out.println(stringStore.saySomething("Hello"));
		
		Container<Integer> integerStore = new Store<>(15);
		integerStore.set(1);
		System.out.println(integerStore.get());
		System.out.println(integerStore.saySomething(2));
		
		Container<List<Integer>> listIntegers = new Store<>(new ArrayList<Integer>());
		listIntegers.set(Arrays.asList(1,2,3));
		System.out.println(listIntegers.get());

		List<Number> numberList = new ArrayList<>();
		numberList.add(new Integer(1));
		numberList.add(new Double(22.0));
		System.out.println(numberList);
		
		Example<String> exString = new Example<>();
		exString.setExample("test");
		System.out.println(exString.getExample());
		//exString.display("2"); //does not compile
		exString.display(3);
		exString.display(2.2);
		//exString.printList(Arrays.asList("1","2")); //does not compile
		exString.printList(Arrays.asList(5,6,7));
		
		Example<Integer> exInteger = new Example<>();
		exInteger.setExample(2);
		System.out.println(exInteger.getExample());
	}

}

interface Container<T> {
	void set(T a);
	T get();
	T saySomething(T something);
}

class Store<T> implements Container<T>{
	
	private T a;
	
	Store(){
		System.out.println("Inside empty constructor");
	}
	
	Store(T obj){
		a = obj;
	}
	
	@Override
	public void set(T a) {
		this.a = a;
	}

	@Override
	public T get() {
		return a;
	}
	
	@Override
	public T saySomething(T something){
		return something;
	}
}

class Example<T>{
	private T example;

	public T getExample() {
		return example;
	}

	public void setExample(T example) {
		this.example = example;
	}

	public void printList(List<? extends Number> numberList) {
		System.out.println(numberList);
	}
	
	public <U extends Number> void display(U number) {
		System.out.println(number);
	}
	
	@Override
	public String toString() {
		return "Example [example=" + example + "]";
	}
}