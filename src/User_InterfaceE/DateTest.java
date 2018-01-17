package User_InterfaceE;

import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
		Date date = new Date();
		SimpleDateFormat ft2 = new SimpleDateFormat("YYYY-MM-dd HH:MM:ss");

		long kkk = date.getTime() + 604800000;
		Date d = new Date(kkk);
		
		System.out.println();
		System.out.println(date.getTime());
		System.out.println(ft2.format(date));
		System.out.println(ft2.format(d));

	}
}
