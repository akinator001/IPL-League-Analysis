package com.cp.ipl;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

import com.cp.opencsv.CSVBuilderFactory;
import com.cp.opencsv.CSVException;
import com.cp.opencsv.ICSVBuilder;
import com.google.gson.Gson;

public class IPLAnalyser {
	List<Runs> runsList = null;
	List<Wickets> wktsList = null;

	public int loadMostRunsCSV(String filePath) throws CSVException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePath));
			ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
			runsList = icsvBuilder.getCSVFileList(reader, Runs.class);
			return runsList.size();
		} catch (Exception e) {
			throw new CSVException("The file is not correct");
		}
	}

	public int loadMostWktsCSV(String filePath) throws CSVException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePath));
			ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
			wktsList = icsvBuilder.getCSVFileList(reader, Wickets.class);
			return wktsList.size();
		} catch (Exception e) {
			throw new CSVException("The file is not correct");
		}
	}

	public String MaximumRunsWithBattingAverage() throws CSVException {
		if (runsList.size() == 0) {
			throw new CSVException("No IPL Data");
		}
		Comparator<Runs> censusComparator = Comparator.comparing(ipl -> ipl.getAvg());
		this.reverseSort(runsList, censusComparator);
		runsList.stream().sorted(Comparator.comparing(ipl -> ipl.runs));
		String sortedBatting = new Gson().toJson(runsList);
		return sortedBatting;
	}

	public String BattingAverageWithStrikeRate() throws CSVException {
		if (runsList.size() == 0) {
			throw new CSVException("No IPL Data");
		}
		Comparator<Runs> censusComparator = Comparator.comparing(ipl -> ipl.getAvg());
		this.reverseSort(runsList, censusComparator);
		runsList.stream().sorted(Comparator.comparing(ipl -> ipl.SR));
		String json = new Gson().toJson(runsList);
		return json;
	}

	public String SixesAndFours() throws CSVException {
		if (runsList.size() == 0) {
			throw new CSVException("No IPL Data");
		}
		Comparator<Runs> censusComparator = Comparator.comparing(ipl -> ipl.sixes + ipl.fours);
		this.Sort(runsList, censusComparator);
		String json = new Gson().toJson(runsList);
		return json;
	}

	public String StrikeRate() throws CSVException {
		if (runsList.size() == 0) {
			throw new CSVException("No IPL Data");
		}
		Comparator<Runs> censusComparator = Comparator.comparing(ipl -> ipl.SR);
		this.reverseSort(runsList, censusComparator);
		String json = new Gson().toJson(runsList);
		return json;
	}

	public String battingAverageSort() throws CSVException {
		if (runsList.size() == 0) {
			throw new CSVException("No IPL Data");
		}
		Comparator<Runs> censusComparator = Comparator.comparing(ipl -> ipl.getAvg());
		this.reverseSort(runsList, censusComparator);
		String json = new Gson().toJson(runsList);
		return json;
	}

	public String StrikerRateWithFouresSixes() throws CSVException {
		if (runsList.size() == 0) {
			throw new CSVException("No IPL Data");
		}
		Comparator<Runs> censusComparator = Comparator.comparing(ipl -> ipl.sixes + ipl.fours);
		this.reverseSort(runsList, censusComparator);
		runsList.stream().sorted(Comparator.comparing(ipl -> ipl.SR));
		String json = new Gson().toJson(runsList);
		return json;
	}

	private <E> void reverseSort(List<E> list, Comparator<E> censusComparator) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1; j++) {
				E census1 = list.get(j);
				E census2 = list.get(j + 1);
				if (censusComparator.compare(census1, census2) < 0) {
					list.set(j, census2);
					list.set(j + 1, census1);
				}
			}
		}
	}

	private <E> void Sort(List<E> list, Comparator<E> censusComparator) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				E census1 = list.get(j);
				E census2 = list.get(j + 1);
				if (censusComparator.compare(census1, census2) > 0) {
					list.set(j, census2);
					list.set(j + 1, census1);
				}
			}
		}
	}

	public String MaximumBowlingAverage() throws CSVException {
		if (wktsList.size() == 0) {
			throw new CSVException("No IPL Data");
		}
		Comparator<Wickets> censusComparator = Comparator.comparing(ipl -> ipl.getAvg());
		this.reverseSort(wktsList, censusComparator);
		String json = new Gson().toJson(wktsList);
		return json;
	}

	public String BowlersStrikeRate() throws CSVException {
		if (wktsList.size() == 0 || wktsList == null) {
			throw new CSVException("No IPL Data");
		}
		Comparator<Wickets> censusComparator = Comparator.comparing(ipl -> ipl.getSR());
		this.reverseSort(wktsList, censusComparator);
		String json = new Gson().toJson(wktsList);
		return json;
	}

	public String BestEconomySort() throws CSVException {
		if (wktsList.size() == 0 || wktsList == null) {
			throw new CSVException("No IPL Data");
		}
		Comparator<Wickets> censusComparator = Comparator.comparing(ipl -> ipl.getEC());
		this.Sort(wktsList, censusComparator);
		String json = new Gson().toJson(wktsList);
		return json;
	}

	public String StrikeRateAnd4w5w() throws CSVException {
		if (wktsList.size() == 0 || wktsList == null) {
			throw new CSVException("No IPL Data");
		}
		Comparator<Wickets> censusComparator = Comparator.comparing(ipl -> ipl.getFourW() + ipl.getFiveW());
		this.reverseSort(wktsList, censusComparator);
		wktsList.stream().sorted(Comparator.comparing(ipl -> ipl.getSR()));
		String json = new Gson().toJson(wktsList);
		return json;
	}
	
	public String SortStrikeRateAndAverage() throws CSVException {
		if (wktsList.size() == 0 || wktsList == null) {
			throw new CSVException("No IPL Data");
		}
		Comparator<Wickets> censusComparator = Comparator.comparing(ipl -> ipl.getAvg());
		this.reverseSort(wktsList, censusComparator);
		wktsList.stream().sorted(Comparator.comparing(ipl -> ipl.getSR()));
		String json = new Gson().toJson(wktsList);
		return json;
	}
	
	public String SortWicketsAndAverage() throws CSVException {
		if (wktsList.size() == 0 || wktsList == null) {
			throw new CSVException("No IPL Data");
		}
		Comparator<Wickets> censusComparator = Comparator.comparing(ipl -> ipl.getW() * ipl.getAvg());
		this.reverseSort(wktsList, censusComparator);
		String json = new Gson().toJson(wktsList);
		return json;
	}
}