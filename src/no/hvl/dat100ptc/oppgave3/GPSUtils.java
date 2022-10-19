package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];
		
		for(double d: da) {
			if(d < min) {
				min = d;
			}
		}
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitude = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			latitude[i] = gpspoints[i].getLatitude();
		}
		
		return latitude;
		
	
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitude = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			longitude[i] = gpspoints[i].getLongitude();
		}
		
		return longitude;

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;
		
		latitude1 = gpspoint1.getLatitude();
		latitude2 = gpspoint2.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		longitude2 = gpspoint2.getLongitude();
		
		double lat1Rad = Math.toRadians(latitude1);
		double lat2Rad = Math.toRadians(latitude2);
		double f1 = lat1Rad - lat2Rad;
		double f2 = Math.toRadians(longitude2) - Math.toRadians(longitude1);
		
		double a = Math.pow(Math.sin(f1/2),2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(f2/2),2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		d = R * c;
		
		return d;
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		
		double distance = distance(gpspoint1, gpspoint2);
		
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		
		double mps = distance / secs;
		
		speed = mps * 3.6;
		
		return speed;
		
	}
	
	private static String twoDigitString(int number) {

	    if (number == 0) {
	        return "00";
	    }

	    if (number / 10 == 0) {
	        return "0" + number;
	    }

	    return String.valueOf(number);
	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
		int hh = secs / 3600;
		int mm = (secs % 3600) / 60;
		int ss = secs % 60;
		
		timestr = twoDigitString(hh) + TIMESEP + twoDigitString(mm) + TIMESEP + twoDigitString(ss);
		
		timestr = String.format("%10.10s", timestr);
		
		return timestr;

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		

		str = String.format("%.2f", d);
		
		str = String.format("%10.10s", str);
		
		return str;
		
	}
}
