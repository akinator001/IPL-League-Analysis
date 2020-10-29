package com.cp.opencsv;

import java.io.Reader;
import java.util.List;

public interface ICSVBuilder<E> {

	public List<E> getCSVFileList(Reader reader, Class csvClass) throws CSVException;
}