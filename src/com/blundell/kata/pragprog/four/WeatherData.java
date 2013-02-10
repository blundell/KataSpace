package com.blundell.kata.pragprog.four;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WeatherData {

	public void findMinimumTemperatureSpreadFor(String dataFile) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(dataFile)));

			List<Weather> forecast = new ArrayList<Weather>();
			String currentLine;
			boolean inData = false;
			while ((currentLine = br.readLine()) != null) {
				if (inData == true && currentLine.startsWith("  mo")) {
					inData = false;
				} else if (inData == false && currentLine.startsWith("   ")) {
					inData = true;
				}
				if (inData) {
					Pattern p = Pattern.compile("\\d");
					Matcher m = p.matcher(currentLine);
					m.find();
					int dayStartIndex = m.start();
					p = Pattern.compile("\\d ");
					m = p.matcher(currentLine);
					m.find();
					int dayEndIndex = m.start() + 1;
					int day = Integer.valueOf(currentLine.substring(dayStartIndex, dayEndIndex));

					p = Pattern.compile("\\d  ");
					m = p.matcher(currentLine);
					m.find();
					int maxStartIndex = m.end();
					p = Pattern.compile("\\d  \\d+");
					m = p.matcher(currentLine);
					m.find();
					int maxEndIndex = m.end();
					int maxTemp = Integer.valueOf(currentLine.substring(maxStartIndex, maxEndIndex));

					p = Pattern.compile("    \\d");
					m = p.matcher(currentLine);
					m.find();
					int minStartIndex = m.end() - 1;
					p = Pattern.compile("    [\\d]+");
					m = p.matcher(currentLine);
					m.find();
					int minEndIndex = m.end();
					int minTemp = Integer.valueOf(currentLine.substring(minStartIndex, minEndIndex));

					forecast.add(new Weather(day, maxTemp, minTemp));
				}
			}

			Weather smallestTemperatureSpead = forecast.get(0);
			for (Weather weather : forecast) {
				System.out.println(weather.toString());
				int temperatureSpread = weather.getTemperatureSpread();
				if (temperatureSpread < smallestTemperatureSpead.getTemperatureSpread()) {
					smallestTemperatureSpead = weather;
				}
			}

			System.out.println("Smallest is Day " + smallestTemperatureSpead.getDay());
			System.out.println("with spread of " + smallestTemperatureSpead.getTemperatureSpread());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static class Weather {
		private final int day;
		private final int maximumTemp;
		private final int minimumTemp;

		public Weather(int day, int maximumTemp, int minimumTemp) {
			this.day = day;
			this.minimumTemp = minimumTemp;
			this.maximumTemp = maximumTemp;
		}

		public int getDay() {
			return day;
		}

		public int getTemperatureSpread() {
			return maximumTemp - minimumTemp;
		}

		@Override
		public String toString() {
			return "Weather [day=" + day + ", maximumTemp=" + maximumTemp + ", minimumTemp=" + minimumTemp + "]";
		}

	}

}