package com.blundell.kata.pragprog.four;

/**
 * http://codekata.pragprog.com/2007/01/kata_four_data_.html
 * 
 * Part One: Weather Data
 * In weather.dat you’ll find daily weather data for Morristown, NJ for June 2002. 
 * Write a program to output the day number (column one) with the smallest temperature spread 
 * (the maximum temperature is the second column, the minimum the third column).
 * 
 * Part Two: Soccer League Table
 * 
 * The file football.dat contains the results from the English Premier League for 2001/2. 
 * The columns labeled ‘F’ and ‘A’ contain the total number of goals scored 
 * for and against each team in that season (so Arsenal scored 79 goals against opponents, 
 * and had 36 goals scored against them). 
 * Write a program to print the name of the team with the smallest difference in ‘for’ and ‘against’ goals.
 * 
 * @author Blundell
 *
 */
public class DataMunging {

	public static void main(String[] args) {
		new WeatherData().findMinimumTemperatureSpreadFor("/weather.dat");
	}
}
