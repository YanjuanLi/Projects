package ticket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class Movie {

	private String date;
	private String movie;
	private String screen;
	private String seat;
	private String ticketID;
	private String price;
	private String time;
	private String type;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		result = prime * result + ((ticketID == null) ? 0 : ticketID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		if (ticketID == null) {
			if (other.ticketID != null)
				return false;
		} else if (!ticketID.equals(other.ticketID))
			return false;
		return true;
	}

	public void readFile() {
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