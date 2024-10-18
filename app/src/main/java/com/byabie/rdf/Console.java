package com.byabie.rdf;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.*;

import com.byabie.rdf.util.Util;

public class Console {
	//Variables
	private static LocalTime now;
	private static DateTimeFormatter cdtf = DateTimeFormatter.ofPattern("HH:mm:ss");
	private static StringBuilder log = new StringBuilder();
	private static ArrayList<LogFilter> filters = new ArrayList<>();
	//Utility
	public enum Level {
		INFO("INFO"), WARN("WARN"), ERROR("ERROR"), SEVERE("SEVERE");
		public String text;
		Level(String text) {
			this.text = text;
		}
	}
	public static class LogLocation {
		public String thread;
		public int ID;
		public String source;
		public LogLocation(String thread, int ID, String source) {
			this.thread = thread;
			this.ID = ID;
			this.source = source;
		}
	}
	public interface LogFilter {
		public boolean isLoggable(String text);
	}
	public static void addFilter(LogFilter filter) {
		filters.add(filter);
	}
	//Log methods
	public static void log(String toLog, LogLocation location, Level level) {
		now = LocalTime.now();
		String time = now.format(cdtf);
		String logged = String.format("[%s][%s/%s][%s]:%s%n", time, location.thread, level.text, location.source, toLog);
		boolean toLogFlag = true;
		for(LogFilter f : filters) {
			if(!f.isLoggable(logged)) {
				toLogFlag = false;
				break;
			}
		}
		if(toLogFlag) {
			System.out.print(logged);
			log.append(logged);
		}
	}
	public static void logToFile(File file) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(log.toString());
		} catch (IOException exc) {
			log(Util.getStackTraceAsString(exc), new LogLocation("exception", 1111111, "logger-main"), Level.ERROR);
		}
	}
	public static void log(String toLog, Level level) {
		log(toLog, new LogLocation(Thread.currentThread().getName(), 1111111, "anonymous"), level);
	}
	public static void log(String toLog) {
		log(toLog, Level.INFO);
	}
}