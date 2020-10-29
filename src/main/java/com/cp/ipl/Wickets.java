package com.cp.ipl;

import com.opencsv.bean.CsvBindByName;

public class Wickets {
	@CsvBindByName(column = "POS")
	public int pos;

	@CsvBindByName(column = "PLAYER")
	public String Player;

	@CsvBindByName(column = "Mat")
	public int mat;

	@CsvBindByName(column = "Inns")
	public int inns;

	@CsvBindByName(column = "Ov")
	public double ov;

	@CsvBindByName(column = "Runs")
	public int runs;

	@CsvBindByName(column = "Wkts")
	public int wkts;

	@CsvBindByName(column = "BBI")
	public int bbi;

	@CsvBindByName(column = "Avg")
	public String Avg;
	
	@CsvBindByName(column = "Econ")
	public double econ;

	@CsvBindByName(column = "SR")
	public String sr;

	@CsvBindByName(column = "4w")
	public int four;

	@CsvBindByName(column = "5w")
	public int five;

	public double getAvg() {
		if (Avg.equals("-"))
			return -1;
		else
			return Double.parseDouble(Avg);
	}

	public void setAvg(String avg) {
		Avg = avg;
	}

	public double getSR() {
		if (sr.equals("-")) {
			return 0;
		}
		return Double.parseDouble(sr);
	}
	
	public double getFourW() {
		return four;
	}

	public double getFiveW() {
		return five;
	}

	public double getEC() {
		return econ;
	}
	
}