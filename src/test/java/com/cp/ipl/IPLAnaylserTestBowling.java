package com.cp.ipl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cp.opencsv.CSVException;
import com.google.gson.Gson;

public class IPLAnaylserTestBowling {

	public final String RunsCSV = "./Runs.csv";
	public final String WicketsCSV = "Wkts.csv";
	
	IPLAnalyser ipl = null;
	int noOfEntries = 0;
	String sortedData = null;
	int noOfEntriesruns = 0;
	int noOfEntrieswickets = 0;

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
	@Test
	public void Best_StrikeRate_And_Great_Average() {

		try {
			noOfEntries = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.SortStrikeRateAndAverage();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Wickets[] wickets = new Gson().fromJson(sortedData, Wickets[].class);
		Assert.assertEquals("Krishnappa Gowtham", wickets[0].Player);
	}
	
	@Test
	public void MaximumWickets_And_BestAverage() {

		try {
			noOfEntries = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.SortWicketsAndAverage();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Wickets[] wickets = new Gson().fromJson(sortedData, Wickets[].class);
		Assert.assertEquals("Deepak Chahar", wickets[0].Player);
	}
	
	@Test
	public void BestBattingAvgerage_And_BowlingAvgerage() {
		List<String> sortedData = null;
		try {
			noOfEntriesruns = ipl.loadMostRunsCSV(RunsCSV);
			noOfEntrieswickets = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.getBestBowlerAndBattingAverage();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
//		System.out.println(noOfEntrieswickets+"  "+noOfEntriesruns);
		Assert.assertEquals("Andre Russell", sortedData.get(48));
		Assert.assertEquals("Marcus Stoinis", sortedData.get(47));

	}
}
