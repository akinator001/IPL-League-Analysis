package com.cp.ipl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cp.opencsv.CSVException;
import com.google.gson.Gson;

public class IPLAnaylserTestBowling {
	public final String WicketsCSV = "Wkts.csv";
	
	IPLAnalyser ipl = null;
	int noOfEntries = 0;
	String sortedData = null;

	@Before
	public void setUp() {
		ipl = new IPLAnalyser();

	}

	@Test
	public void givenWicketsCSVFile_ShouldSortAccordingBowlingAverage() {
		int noOfEntries = 0;
		String sortedData = null;
		try {
			noOfEntries = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.MaximumBowlingAverage();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Wickets[] wickets = new Gson().fromJson(sortedData, Wickets[].class);
		Assert.assertEquals("Krishnappa Gowtham", wickets[0].Player);
	}
	
	@Test
	public void TopStrikeRates() {

		try {
			noOfEntries = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.BowlersStrikeRate();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Wickets[] wickets = new Gson().fromJson(sortedData, Wickets[].class);
		Assert.assertEquals("Krishnappa Gowtham", wickets[0].Player);
	}

	@Test
	public void BestEconomyBowler() {
		try {
			noOfEntries = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.BestEconomySort();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Wickets[] wickets = new Gson().fromJson(sortedData, Wickets[].class);
		Assert.assertEquals("Shivam Dube", wickets[0].Player);
	}
	
	@Test
	public void givenMostWktsCSVFile_ShouldLoad_And_SortAccordingToBestStrikeRate_And_4w_5w() {

		try {
			noOfEntries = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.StrikeRateAnd4w5w();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Wickets[] wickets = new Gson().fromJson(sortedData, Wickets[].class);
		Assert.assertEquals("Imran Tahir", wickets[0].Player);
	}

}
