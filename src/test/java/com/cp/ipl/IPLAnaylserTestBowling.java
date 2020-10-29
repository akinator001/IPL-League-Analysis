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
}
