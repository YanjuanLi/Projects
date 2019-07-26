package filmSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Row {
	public int filmnumber;

	/**
	 *  to get the count of rows.
	 */
	public Row() {
		try {
			File myFile = new File("FilmDetail.txt");
			FileReader fileReader = new FileReader(myFile);
			BufferedReader reader = new BufferedReader(fileReader);
			while (reader.readLine() != null) {
				filmnumber++;
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}