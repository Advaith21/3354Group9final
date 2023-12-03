package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Dates {

	private @Id @GeneratedValue int month = 0;
	private int date = 0;
	private int year = 0;
	//int zone = -99;
	StarSign ssign;
	//int time = 0;
	public enum StarSign {ARIES, LEO, SAGITTARIUS, GEMINI, SCORPIO, TAURUS, AQUARIUS, PISCES, CANCER, CAPRICORN, LIBRA, VIRGO}
	
	public Dates(int m, int d, int y) {//, int z, int t) {
		month = m; date = d; year = y; //zone = z; time = t;
		calculateStarSign();
	}

	public void setMonth(int m) {month = m;}
	public void setDate(int d) {date = d;}
	public void setYear(int y) {year = y;}
	//public void setZone(int z) {zone = z;}
	//public void setTime(int t) {time = t;}	
	
	public int getMonth() {return month;}
	public int getDate() {return date;}
	public int getYear() {return year;}
	public StarSign getSign() {return ssign;}
	//public int getZone() {return zone;}
	//public int getTime() {return time;}
	
	public static boolean isNumeric(String strNum) { //Checks if input is numeric.
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int i = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public boolean checkDateInput(String s1, String s2, String s3) {
		if (isNumeric(s1) && isNumeric(s2) && isNumeric(s3)) {
			int a = Integer.parseInt(s1);
			int b = Integer.parseInt(s2);
			int c = Integer.parseInt(s3);
			
			if (a < 0) {return false;}
			if (b < 0) {return false;}
			if (c < 0) {return false;}
			
			
			if (a > 0 && a < 13) {//A valid month
				if (a == 1 || a == 3 || a == 5 || a == 7 || a == 8 || a == 10 || a == 12) { //Month with 31 days
					if (b > 0 && b < 32) {return true;}
				}
				else if (a != 2) { //Month with 30 days
					if (b > 0 && b < 31) {return true;}
				}
				else { //February
					if (c % 4 == 0) { //Leap year
						if (b > 0 && b < 30) {return true;}
						else {return false;}
					}
					
					//Non-leap year.
					if (b > 0 && b < 29) {return true;}
					else {return false;}
				}
				
			}
		}
		return false;
	}
	
	/*
	public boolean checkTimeInput(String t, String tz) {//Checks the 24-hour time and the time zone and makes sure it's ok.
		
		if (!isNumeric(t) || !isNumeric(tz)) {return false;} //If we don't have numbers for the time or time zone
		
		int ti = Integer.parseInt(t);
		int zo = Integer.parseInt(tz);
		
		if (ti > 2359 || ti < 0000) {return false;} //Invalid time checking
		if (zo < -12 || zo > 12) {return false;} //Invalid GMT/UTC-related time zone
		
		return true;
	}*/
	
	public void calculateStarSign() { //Just calculates the star sign based on the date and month.
		System.out.println(month);
		switch (month) {
			case 1:
				if (date <=19) {ssign = StarSign.CAPRICORN;}
				else {ssign = StarSign.AQUARIUS;}
				break;
			case 2:
				if (date <=18) {ssign = StarSign.AQUARIUS;}
				else {ssign = StarSign.PISCES;}
				break;
			case 3:
				if (date <=20) {ssign = StarSign.PISCES;}
				else {ssign = StarSign.ARIES;}
				break;
			case 4:
				if (date <=19) {ssign = StarSign.ARIES;}
				else {ssign = StarSign.TAURUS;}
				break;
			case 5:
				if (date <=20) {ssign = StarSign.TAURUS;}
				else {ssign = StarSign.GEMINI;}
				break;
			case 6:
				if (date <=20) {ssign = StarSign.GEMINI;}
				else {ssign = StarSign.CANCER;}
				break;
			case 7:
				if (date <=22) {ssign = StarSign.CANCER;}
				else {ssign = StarSign.LEO;}
				break;
			case 8:
				if (date <=22) {ssign = StarSign.LEO;}
				else {ssign = StarSign.VIRGO;}
				break;
			case 9:
				if (date <=22) {ssign = StarSign.VIRGO;}
				else {ssign = StarSign.LIBRA;}
				break;
			case 10:
				if (date <=22) {ssign = StarSign.LIBRA;}
				else {ssign = StarSign.SCORPIO;}
				break;
			case 11:
				if (date <=21) {ssign = StarSign.SCORPIO;}
				else {ssign = StarSign.SAGITTARIUS;}
				break;
			case 12:
				if (date <=21) {ssign = StarSign.SAGITTARIUS;}
				else {ssign = StarSign.CAPRICORN;}
				break;
			default:
				System.out.println("Something went wrong."); return;
		}			
	}
	
	public static void main(String[] args) {
		
		Dates test = new Dates(7,23,2004);
		System.out.println(test.getDate());
		System.out.println(test.getMonth());
		System.out.println(test.getYear());
		System.out.println(test.getSign());

	}

}
