package exercise.ex122.com.example;

import exercise.ex122.com.example.model.Book;
import exercise.ex122.com.example.model.Item;
import exercise.ex122.com.example.model.Stationery;

public class Seller {

	public static void main(String[] args) {
		
		Item[] items = {
			new Book("0001", "ドメイン駆動設計", 5200, "Eric Evans"),
			new Book("0002", "新装版リファクタリング", 4200, "Martin Fowler"),
			new Stationery("5001", "パーカーボールペン", 1212, "筆記用具"),
			new Stationery("6001", "高橋 2017ウィークリーB6", 1512, "手帳"),
		};
		
		int totalPrice = 0;
		for(Item item : items) {
			System.out.println(item);
			totalPrice += item.getPrice();
		}
		
		System.out.println("---");
		System.out.print("品数" + items.length + "点");
		System.out.println(",合計金額=" + totalPrice + "円");
		
	}

}
