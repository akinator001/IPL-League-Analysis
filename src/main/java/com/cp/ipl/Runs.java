package com.cp.ipl;

import com.opencsv.bean.CsvBindByName;

public class Runs {
	@CsvBindByName(column = "POS")
	public int pos;

	@CsvBindByName(column = "PLAYER")
	public String Player;
	
	@CsvBindByName(column = "Mat")
	public int mat;

	@CsvBindByName(column = "Inns")
	public int inns;

	@CsvBindByName(column = "NO")
	public int no;

	@CsvBindByName(column = "Runs")
	public int runs;

	@CsvBindByName(column = "HS")
	public String hs;

	@CsvBindByName(column = "Avg")
	public String Avg;

	@CsvBindByName(column = "BF")
	public int bf;

	@CsvBindByName(column = "SR")
	public double SR;	
	
	@CsvBindByName(column = "100")
	int hundreds;

	@CsvBindByName(column = "50")
	public int fiftys;

	@CsvBindByName(column = "4s")
	public int fours;
	
	@CsvBindByName(column = "6s")
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