package com.neosoft.session;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		//HashSet Example.
		System.out.println("HashSet Example.");
		HashSet<String> set = new HashSet<String>();
		set.add("Azhan");
		set.add("Pratham");
		set.add("Amaan");
		set.add("Makrand");
		set.add("Sreejith");
		System.out.println("Initial Set: "+set);
		//Adding duplicate element.
		set.add("Amaan");
		System.out.println("Set after adding duplicate element Amaan: "+set);
		
		// removing specific element.
		set.remove("Pratham");
		System.out.println("After removing Pratham: "+set);
		
		HashSet<String> set1 = new HashSet<String>();
		set1.add("Arif");
		set1.add("Sahil");
		set.addAll(set1);
		System.out.println("Updated List: "+set);
		
		// removing new elements from new set
		set.removeAll(set1);
		System.out.println("After removing set1: "+set);
		
		// removing with specified condition.
		set.removeIf(str -> str.contains("Makrand"));
		System.out.println("After removing with condition: "+set);
		
		//clearing set
		set.clear();
		System.out.println("Clearing set: "+set);
		System.out.println("=======================================================================");
		
		System.out.println("LinkedHashSet Example");
		
		LinkedHashSet<String> lset = new LinkedHashSet<String>();
		lset.add("One");
		lset.add("Two");
		lset.add("Three");
		lset.add("Four");
		
		System.out.println("Initial Set: "+lset);
		
		//Adding duplicate element.
		lset.add("Amaan");
		System.out.println("Set after adding duplicate element Amaan: "+lset);
		
		// removing specific element.
		lset.remove("Four");
		System.out.println("After removing Four: "+lset);
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("Arif");
		set2.add("Sahil");
		lset.addAll(set2);
		System.out.println("Updated List: "+lset);
		
		// removing new elements from new set
		lset.removeAll(set2);
		System.out.println("After removing set1: "+lset);
		
		// removing with specified condition.
		lset.removeIf(str -> str.contains("Two"));
		System.out.println("After removing with condition: "+lset);
		
		//clearing set
		lset.clear();
		System.out.println("Clearing set: "+lset);
		
		System.out.println("=======================================================================");
		
		System.out.println("TreeSet Example");
		
		TreeSet<String> tset = new TreeSet<String>();
		tset.add("Saud");
		tset.add("Mohsin");
		tset.add("Hrishi");
		tset.add("Mohsin");
		System.out.println("Initial set: "+tset);
		
		TreeSet<Integer> Intset = new TreeSet<Integer>();
		Intset.add(67);
		Intset.add(12);
		Intset.add(45);
		Intset.add(90);
		System.out.println("Integer TreeSet: "+Intset);
		System.out.println("Highest Value: "+Intset.pollFirst());
		System.out.println("Lowest Value: "+Intset.pollLast());
		Intset.add(12);
		Intset.add(90);
		
		System.out.println("Descending set: "+Intset.descendingSet());
		System.out.println("Head set: "+Intset.headSet(45));
		System.out.println("Sub set: "+Intset.subSet(45, 90));
		System.out.println("Tail set: "+Intset.tailSet(45));
		
		
	}

}
