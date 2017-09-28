package log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import linkedQueue.LinkedQueue;
import queue.QueueADT;

public class Log {
	private File logFile;
	private QueueADT<LogLine> logQueue;
	
	public Log()
	{
		this.logQueue = new LinkedQueue<>(true);
		String filename = new DateTime().getSortableDate();
		this.logFile = new File(filename);
	}
	public void add(LogLine logLine)
	{
		if(logLine  == null)
		{
			return;
		}
		
		logQueue.enqueue(logLine);
		addToFile(logLine);
		System.out.println(logLine);
		
		
		
	}
	private void addToFile(LogLine logLine)
	{
	if (logLine == null)
	{
	return;
	}
	BufferedWriter out = null;
	try
	{
	out = new BufferedWriter(new FileWriter(logFile, true));
	out.write(logLine + "\n");
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	finally
	{
	try
	{
	out.close();
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	}
	}
	public QueueADT<LogLine> getAll()
	{
		return logQueue;
	}

}
