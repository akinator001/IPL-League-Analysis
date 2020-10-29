package com.cp.ipl;

import org.junit.Assert;
import org.junit.Test;

import com.cp.opencsv.CSVException;
import com.google.gson.Gson;

public class IPLAnalyserTest {
	public final String RunsCSV = "./Runs.csv";
	public final String WicketsCSV = "./Wickets.csv";

	@Test
	public void BattingAverage() {
		IPLAnalyser ipl = new IPLAnalyser();
		int noOfEntries = 0;
		String sortedData = null;
		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			sortedData = ipl.battingAverageSort();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Runs[] runs = new Gson().fromJson(sortedData, Runs[].class);
		Assert.assertEquals("MS Dhoni", runs[0].Player);
	}
}