package com.neosoft.lab;
import java.awt.*;
public class ColourChecking {

	public static void main(String[] args) {
		Color rgb,hsb;
		rgb = new Color(193,255,183);
		int red,blue,green;
		red = rgb.getRed();
		blue = rgb.getBlue();
		green = rgb.getGreen();
		
		float[] x = {0.0f,0.0f,0.0f}; 
		rgb.RGBtoHSB(red, green, blue, x);
		System.out.println("RGB Combination");
		System.out.println("Red = "+red+" Blue = "+blue+" Green = "+green);
		System.out.println("Hue = "+x[0]+" Saturation = "+x[1]+" Brightness = "+x[2]);
	}

}
