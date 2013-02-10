package com.blundell.kata.pragprog.four;

/**
 * http://codekata.pragprog.com/2007/01/kata_four_data_.html
 * 
 * Part One: Weather Data
 * In weather.dat you’ll find daily weather data for Morristown, NJ for June 2002. 
 * Write a program to output the day number (column one) with the smallest temperature spread 
 * (the maximum temperature is the second column, the minimum the third column).
 * 
 * @author Blundell
 *
 */
public class DataMunging {

	public static void main(String[] args) {
		new WeatherData().findMinimumTemperatureSpreadFor("/weather.dat");
	}
}
