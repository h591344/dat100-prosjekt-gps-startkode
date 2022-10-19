package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import static java.lang.Double.*;
import static java.lang.Integer.*;


public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		antall = 0;
		
		gpspoints = new GPSPoint[n];
		
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			inserted = true;
		}
		return inserted;
	}
	

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;
		
		int timeInt = parseInt(time.substring(11,12)) * 60 * 60 + parseInt(time.substring(14,15)) * 60 + parseInt(time.substring(17,18));
		double latitudeDouble = parseDouble(latitude);
		double longitudeDouble = parseDouble(longitude);
		double elevationDouble = parseDouble(elevation);
		
		gpspoint = new GPSPoint(timeInt,latitudeDouble,longitudeDouble,elevationDouble);
		
		boolean inserted = insertGPS(gpspoint);
		
		return inserted;
		
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		for (GPSPoint gpspoint : gpspoints ) {
			
			System.out.println(gpspoint.toString());
			
		}
		
	    System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
