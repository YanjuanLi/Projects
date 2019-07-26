package com.test.junit;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ticket.Movie;

public class MovieTest {

	@Test
	public void testReadFile() {
		// fail("Not yet implemented");
		try {

			Set<Movie> set = new HashSet<>();
			File file = new File("./ticket.txt");

			if (!file.exists()) {
				System.out.println("ticket.txt is not exist");
			} else {

				FileReader reader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					Movie movie = new Movie();
					movie.setDate(line.trim());
					movie.setMovie(bufferedReader.readLine().trim());
					movie.setScreen(bufferedReader.readLine().trim());
					movie.setSeat(bufferedReader.readLine().trim());
					movie.setTicketID(bufferedReader.readLine().trim());
					movie.setPrice(bufferedReader.readLine().trim());
					movie.setTime(bufferedReader.readLine().trim());
					movie.setType(bufferedReader.readLine().trim());

					if (set.contains(movie)) {
						set.remove(movie);
					}
					set.add(movie);
				}

				bufferedReader.close();
				reader.close();

				file = new File("./ticket.txt");
				if (!file.exists()) {
					file.createNewFile();
				}

				FileWriter writer = new FileWriter(file);
				for (Movie m : set) {
					writer.write(m.getDate() + "\n");
					writer.write(m.getMovie() + "\n");
					writer.write(m.getScreen() + "\n");
					writer.write(m.getSeat() + "\n");
					writer.write(m.getTicketID() + "\n");
					writer.write(m.getPrice() + "\n");
					writer.write(m.getTime() + "\n");
					writer.write(m.getType() + "\n");
				}
				writer.close();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
