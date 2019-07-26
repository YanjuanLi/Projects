package com.test.junit;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import org.junit.Test;

import file.Task;
import file.Time;

public class TimeTest {

	private static final long period_day = 24 * 60 * 60 * 1000;

	@Test
	public void testTime() {
		// fail("Not yet implemented");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 24);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		Date date = calendar.getTime();
		if (date.before(new Date())) {
			date = new Time().addDay(date, 24);
		}
		Timer timer = new Timer();

		Task task = new Task();
		timer.schedule(task, date, period_day);
	}

	@Test
	public void testAddDay() {
		// fail("Not yet implemented");
		Date date = new Date();
		int num = 0;
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, num);
		System.out.println(startDT.getTime());
	}

}
