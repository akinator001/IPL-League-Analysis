package com.cp.ipl;

import com.opencsv.bean.CsvBindByName;

public class Runs {
	@CsvBindByName
	public int Pos;
	@CsvBindByName
	public String Player;
	@CsvBindByName
	public int Mat;
	@CsvBindByName
	public int Inns;
	@CsvBindByName
	public int NO;
	@CsvBindByName
	public int Runs;
	@CsvBindByName
	public String HS;
	@CsvBindByName
	private String Avg;
	@CsvBindByName
	public int BF;
	@CsvBindByName
	public double SR;
	@CsvBindByName
	public int hundreds;
	@CsvBindByName
	public int fifties;
	@CsvBindByName
	public int fours;
	@CsvBindByName
	public int sixes;

	public double getAvg() {
		if (Avg.equals("-"))
			return -1;
		else
			return Double.parseDouble(Avg);
	}

	public void setAvg(String avg) {
		Avg = avg;
	}
}