package filmSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Get {
	public String[] line;

	/**
	 * a function to get some data.
	 */
	public Get() {
		Row R = new Row();
		int num = R.filmnumber;
		line = new String[num + 1];
		int i = 0;
		try {
			File myFile = new File("FilmDetail.txt");
			FileReader fileReader = new FileReader(myFile);
			BufferedReader reader = new BufferedReader(fileReader);
			while ((line[i] = reader.readLine()) != null) {
				i++;
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}