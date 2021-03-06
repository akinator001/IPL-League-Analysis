package com.cp.ipl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cp.opencsv.CSVException;
import com.google.gson.Gson;

public class IPLAnalyserTest {
	public final String RunsCSV = "./Runs.csv";
	public final String WicketsCSV = "./Wickets.csv";
	IPLAnalyser ipl = null;
	int noOfEntries = 0;
	String sortedData = null;

	@Before
	public void setUp() {
		ipl = new IPLAnalyser();

	}

	@Test
	public void Top_BattingAverage() {
		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			sortedData = ipl.battingAverageSort();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Runs[] runs = new Gson().fromJson(sortedData, Runs[].class);
		Assert.assertEquals("MS Dhoni", runs[0].Player);
	}

	@Test
	public void Top_StrikeRate() {

		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			sortedData = ipl.StrikeRate();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Runs[] runs = new Gson().fromJson(sortedData, Runs[].class);
		Assert.assertEquals("Ishant Sharma", runs[0].Player);
	}
	
	@Test
	public void Most_FoursAndSixes() {
		int noOfEntries = 0;
		String sortedData = null;
		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			sortedData = ipl.SixesAndFours();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Runs[] runs = new Gson().fromJson(sortedData, Runs[].class);
		Assert.assertEquals("Andre Russell", runs[100].Player);
	}
	
	@Test
	public void Maximum_StrikeRate_AndFoures_Sixes() {

		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			sortedData = ipl.StrikerRateWithFouresSixes();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}

		Runs[] runs = new Gson().fromJson(sortedData, Runs[].class);
		Assert.assertEquals("Andre Russell", runs[0].Player);
	}
	
	@Test
	public void Maximum_BattingAverage_StrikeRate() {
		String sortedData = null;
		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			sortedData = ipl.BattingAverageWithStrikeRate();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Runs[] runs = new Gson().fromJson(sortedData, Runs[].class);
		Assert.assertEquals("MS Dhoni", runs[0].Player);
	}
	
	@Test
	public void MostRuns_And_BattingAverage() {

		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			sortedData = ipl.MaximumRunsWithBattingAverage();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Runs[] runs = new Gson().fromJson(sortedData, Runs[].class);
		Assert.assertEquals("MS Dhoni", runs[0].Player);
	}
	
	@Test
	public void Maximum100_With_BestAverage() {
		String data = null;
		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			data = ipl.maximumHundredandGreatBattingAverages();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Runs[] censusCsv = new Gson().fromJson(data, Runs[].class);
		Assert.assertEquals("David Warner ", censusCsv[100].Player);
	}
	
	@Test
	public void BestBattingAverage_But_With_Zero100s_And_Zero50s() {
		List<Runs> data = null;
		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			data = ipl.getPlayerWithZeroHundredsOrZeroFiftiesButBestBattingAverage();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals("Marcus Stoinis", data.get(55).Player);
	}

}