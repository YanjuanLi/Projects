package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Read {

	/**
	 * the function to get the file.
	 */
	public void getFile() {
		String path = "tickets";
		File f = new File(path);
		if (!f.exists()) {
			System.out.println(path + " not exists");
			return;
		}
		File fa[] = f.listFiles();
		double[] total = new double[fa.length];
		int a = 0, b = 0, c = 0, d = 0, e = 0;
		int A = 0, B = 0, C = 0, D = 0;
		int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0, a7 = 0, a8 = 0, a9 = 0, a10 = 0, a11 = 0, a12 = 0;
		double num = 0;
		float money1 = 0, money2 = 0, money3 = 0, money4 = 0, money5 = 0;
		float money6 = 0, money7 = 0, money8 = 0, money9 = 0;
		float mon1 = 0, mon2 = 0, mon3 = 0, mon4 = 0, mon5 = 0, mon6 = 0, mon7 = 0, mon8 = 0, mon9 = 0, mon10 = 0,
				mon11 = 0, mon12 = 0;
		for (int i = 0; i < fa.length; i++) {

			File fs = fa[i];

			String path1 = "tickets/".concat(fs.getName());
			java.io.File file = new java.io.File(path1);
			ArrayList<String> ReadFile = new ArrayList<String>();
			try {
				Scanner input = new Scanner(file);
				while (input.hasNextLine()) {
					ReadFile.add(input.nextLine());
				}
				input.close();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
			java.io.File file2 = new java.io.File(path1);
			String[][] ticketInfo = new String[17][2];

			int ss = 0;
			int no = 0;
			String s[] = new String[8];
			String temp[] = new String[8];

			try {
				Scanner input1 = new Scanner(file2);

				for (; ss < ReadFile.size(); ss++) {
					s[ss] = input1.nextLine();
					ticketInfo[no++] = s[ss].split("\t");
					temp[ss] = ticketInfo[ss][1];
				}

				input1.close();
			} catch (FileNotFoundException e2) {

				e2.printStackTrace();
			}
			double money = Double.parseDouble(temp[5]);

			total[i] = money;
			num += total[i];
			if (temp[1].equals("LOGAN")) {
				a = a + 1;
				money1 += money;
			} else if (temp[1].equals("KONG:SKULL_ISLAND")) {
				b = b + 1;
				money2 += money;
			} else if (temp[1].equals("BEAUTY_AND_THE_BEAST")) {
				c = c + 1;
				money3 += money;

			} else if (temp[1].equals("MOONLIGHT")) {
				d = d + 1;
				money4 += money;

			} else if (temp[1].equals("LA_LA_LAND")) {
				e = e + 1;
				money5 += money;

			}
			if (temp[7].equals("Adult")) {
				A = A + 1;
				money6 += money;
			} else if (temp[7].equals("Child")) {
				B = B + 1;
				money7 += money;
			} else if (temp[7].equals("Senior")) {
				C = C + 1;
				money8 += money;
			} else if (temp[7].equals("Student")) {
				D = D + 1;
				money9 += money;
			}
			if (temp[6].equals("10:00") || temp[6].equals("10:30")) {
				if (temp[7].equals("Adult")) {

					a1 = a1 + 1;
					mon1 += money;
				} else if (temp[7].equals("Child")) {
					a2 = a2 + 1;
					mon2 += money;
				} else if (temp[7].equals("Senior")) {
					a3 = a3 + 1;
					mon3 += money;
				} else if (temp[7].equals("Student")) {
					a4 = a4 + 1;
					mon4 += money;
				}
			} else if (temp[6].equals("12:30") || temp[6].equals("13:00") || temp[6].equals("15:30")
					|| temp[6].equals("16:00")) {
				if (temp[7].equals("Adult")) {
					a5 = a5 + 1;
					mon5 += money;
				} else if (temp[7].equals("Child")) {
					a6 = a6 + 1;
					mon6 += money;
				} else if (temp[7].equals("Senior")) {
					a7 = a7 + 1;
					mon7 += money;
				} else if (temp[7].equals("Student")) {
					a8 = a8 + 1;
					mon8 += money;
				}
			} else if (temp[6].equals("18:00") || temp[6].equals("18:30") || temp[6].equals("20:00")
					|| temp[6].equals("20:30") || temp[6].equals("21:00")) {
				if (temp[7].equals("Adult")) {
					a9 = a9 + 1;
					mon9 += money;
				} else if (temp[7].equals("Child")) {
					a10 = a10 + 1;
					mon10 += money;
				} else if (temp[7].equals("Senior")) {
					a11 = a11 + 1;
					mon11 += money;
				} else if (temp[7].equals("Student")) {
					a12 = a12 + 1;
					mon12 += money;
				}
			}

		}

		Date date1 = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String time = format.format(date1);
		String file2 = time.concat(".txt");

		Date date2 = new Date();
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time1 = format1.format(date2);

		String time2 = time.concat(" 22:00:00");
		String time3 = time.concat(" 23:59:59");

		try {
			java.io.PrintWriter output = new java.io.PrintWriter(file2);
			output.println("Date: " + time);
			output.println(
					"------------------------------------------------------------------------------------------------------------------------------------");
			output.println("Total people: " + fa.length + " Total sales: $" + num);
			output.println(
					"------------------------------------------------------------------------------------------------------------------------------------");
			output.println("LOGAN");
			output.println("People: " + a + "  Sales: $" + money1);
			output.println(
					"------------------------------------------------------------------------------------------------------------------------------------");
			output.println("KONG:SKULL_ISLAND");
			output.println("People: " + b + "  Sales: $" + money2);
			output.println(
					"------------------------------------------------------------------------------------------------------------------------------------");
			output.println("BEAUTY_AND_THE_BEAST");
			output.println("People: " + c + "  Sales: $" + money3);
			output.println(
					"------------------------------------------------------------------------------------------------------------------------------------");
			output.println("MOONLIGHT");
			output.println("People: " + d + "  Sales: $" + money4);
			output.println(
					"------------------------------------------------------------------------------------------------------------------------------------");
			output.println("LA_LA_LAND");
			output.println("People: " + e + "  Sales: $" + money5);
			output.println(
					"------------------------------------------------------------------------------------------------------------------------------------");
			output.println("Adult");
			output.println("People: " + A + "  Sales: $" + money6);
			output.println(
					"------------------------------------------------------------------------------------------------------------------------------------");
			output.println("Child");
			output.println("People: " + B + "  Sales: $" + money7);
			output.println(
					"------------------------------------------------------------------------------------------------------------------------------------");
			output.println("Senior");
			output.println("People: " + C + "  Sales: $" + money8);
			output.println(
					"------------------------------------------------------------------------------------------------------------------------------------");
			output.println("Student");
			output.println("People: " + D + "  Sales: $" + money9);
			output.println(
					"------------------------------------------------------------------------------------------------------------------------------------");
			output.println("Morning");
			output.println("Adult       P:" + a1 + "  S:$" + mon1 + "       //" + "Child       P:" + a2 + "  S:$" + mon2
					+ "       //" + "Senior      P:" + a3 + "  S:$" + mon3 + "       //" + "Student     P:" + a4
					+ "  S:$" + mon4);
			output.println(
					"------------------------------------------------------------------------------------------------------------------------------------");
			output.println("Afternoon");
			output.println("Adult       P:" + a5 + "  S:$" + mon5 + "       //" + "Child       P:" + a6 + "  S:$" + mon6
					+ "       //" + "Senior      P:" + a7 + "  S:$" + mon7 + "       //" + "Student     P:" + a8
					+ "  S:$" + mon8);
			output.println(
					"------------------------------------------------------------------------------------------------------------------------------------");
			output.println("Evening");
			output.println("Adult       P:" + a9 + "  S:$" + mon9 + "       //" + "Child       P:" + a10 + "  S:$"
					+ mon10 + "       //" + "Senior      P:" + a11 + "  S:$" + mon11 + "       //" + "Student     P:"
					+ a12 + "  S:$" + mon12);

			output.close();
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}

	}

}
