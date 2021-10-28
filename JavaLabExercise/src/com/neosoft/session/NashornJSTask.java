package com.neosoft.session;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornJSTask {

	public static void main(String[] args) throws NoSuchMethodException, ScriptException, FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number 1: ");
		int n1 = sc.nextInt();
		System.out.println("Enter number 2: ");
		int n2 = sc.nextInt();
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("resources/calci.js"));
		Invocable invocable = (Invocable) engine;
		invocable.invokeFunction("add",n1,n2);
		invocable.invokeFunction("sub",n1,n2);
		invocable.invokeFunction("multi",n1,n2);
		invocable.invokeFunction("div",n1,n2);

	}

}
