package log;

import java.util.Date;

public class TestLogWithSingleton {

	public static void main(String[] args) {

		LogWithSingleton log1 = LogWithSingleton.getInstance();
		LogWithSingleton log2 = LogWithSingleton.getInstance();
		
	LogLine logLine = new LogLine("Log line number 1");
		LogLine logLine2 = new LogLine("Log line number 2");
		log1.add(logLine);
		log2.add(logLine2);
		System.out.println(log1.toString());
		System.out.println(log2);
	}

}
