package com.neosoft.session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ComparatorTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Movies> movie = new ArrayList<Movies>();
		movie.add(new Movies(4.5,"Shawshank Redemption",2006));
		movie.add(new Movies(4.1,"3 Idiots",2011));
		movie.add(new Movies(3.5,"The end of the world",2013));
		movie.add(new Movies(3.1,"Dragon Ball Z",2009));
		movie.add(new Movies(4.9,"Squid games",2019));
		int choice = 0;
		while(choice != 7) {
			System.out.println("1. Sort by ratings\r\n"
					+ "2. Sort by name\r\n"
					+ "3. Sort by year\r\n"
					+ "4. Sort by ratings in Reverse\r\n"
					+ "5. Sort by name in Reverse\r\n"
					+ "6. Sort by year in Reverse\r\n"
					+ "7. EXIT");
			
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			
			switch(choice){
			case 1:
				System.out.println("==============================================================");
				System.out.println("Sorted by ratings");
				Collections.sort(movie,new ratingComp());
				for(Movies m: movie) {
					System.out.println(m);
				}
				System.out.println("==============================================================");
				break;
			case 2:
				System.out.println("==============================================================");
				System.out.println("Sorted by name");
				Collections.sort(movie,new nameComp());
				for(Movies m: movie) {
					System.out.println(m);
				}
				System.out.println("==============================================================");
				break;
			case 3:
				System.out.println("==============================================================");
				System.out.println("Sorted by year");
				Collections.sort(movie,new yearComp());
				for(Movies m: movie) {
					System.out.println(m);
				}
				System.out.println("==============================================================");
				break;
			case 4:
				System.out.println("==============================================================");
				System.out.println("Sorted by ratings reversed");
				Collections.sort(movie,new ratingComp().reversed());
				for(Movies m: movie) {
					System.out.println(m);
				}
				System.out.println("==============================================================");
				break;
			case 5:
				System.out.println("==============================================================");
				System.out.println("Sorted by name reversed");
				Collections.sort(movie,new nameComp().reversed());
				for(Movies m: movie) {
					System.out.println(m);
				}
				System.out.println("==============================================================");
				break;
			case 6:
				System.out.println("==============================================================");
				System.out.println("Sorted by year reversed");
				Collections.sort(movie,new yearComp().reversed());
				for(Movies m: movie) {
					System.out.println(m);
				}
				System.out.println("==============================================================");
				break;
			case 7:
				break;
			default:
				break;		
			}
		}
	}
}

class Movies{
	double ratings;
	String name;
	int year;
	public Movies(double ratings, String name, int year) {
		this.ratings = ratings;
		this.name = name;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Name: "+name+" \tRatings: "+ratings+" \tYear: "+year;
	}
}

class ratingComp implements Comparator<Movies>{

	@Override
	public int compare(Movies o1, Movies o2) {
		if(o1.ratings == o2.ratings) {
			return 0;
		}
		else if(o1.ratings > o2.ratings) {
			return 1;
		}
		else {
			return -1;
		}
	}	
}

class nameComp implements Comparator<Movies>{

	@Override
	public int compare(Movies o1, Movies o2) {
		return o1.name.compareTo(o2.name);
	}
	
}

class yearComp implements Comparator<Movies>{

	@Override
	public int compare(Movies o1, Movies o2) {
		if(o1.year == o2.year) {
			return 0;
		}
		else if(o1.year > o2.year) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}