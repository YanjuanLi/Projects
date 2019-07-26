package file;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Time {

	// public static void main(String[] args) {

	// new Time();

	// }

	private static final long period_day = 24 * 60 * 60 * 1000;

	/**
	 * the constructor of Time.
	 */
	public Time() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 24);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		Date date = calendar.getTime();
		if (date.before(new Date())) {
			date = this.addDay(date, 24);
		}
		Timer timer = new Timer();

		Task task = new Task();
		timer.schedule(task, date, period_day);

	}

	public Date addDay(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, num);
		return startDT.getTime();
	}

}
