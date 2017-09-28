package log;

public class LogLine {

	private String text;
	private DateTime date;
	
	
	
	public LogLine(String text)
	{
		this.text = text;
		date = new DateTime();
	}
	public String getLogText() {
		return text;
	}
	public DateTime getDateTime()
	{
		return date;
	}
	public String getTimeStamp()
	{
		return date.getTimestamp();
	}
	public String toString()
	{
		return text + " " + date;
	}
	
}
