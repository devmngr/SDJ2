package model;

import java.io.Serializable;

/** A class containing a Log object class
 * @author Alexandru
 *
 */
public class Log implements Serializable{
	private String log_time;
	private String log_id;
	private String description;
	
	
	/** Constructor initializing the Log Object
	 * @param log_time
	 * 		log_time of the Log object
	 * @param log_id
	 * 		log_id of the Log object
	 * @param description
	 * 		description of the Log object
	 */
	public Log(String log_time, String log_id, String description) {
		this.log_time = log_time;
		this.log_id = log_id;
		this.description = description;
	}


	/**	Gets the log_time of the Log object
	 * @return
	 * 		returns log_time
	 */
	public String getLog_time() {
		return log_time;
	}


	/**	 Sets the log_time to Log Object
	 * @param log_time
	 */
	public void setLog_time(String log_time) {
		this.log_time = log_time;
	}


	/** Gets the log_id of the Log object
	 * @return
	 */
	public String getLog_id() {
		return log_id;
	}


	/** Sets the log_id of the Log Object
	 * @param log_id
	 */
	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}


	/** Gets description of the Log object
	 * @return
	 * 		returns description of Log object
	 */
	public String getDescription() {
		return description;
	}


	/**	Sets the description of the Log Object
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return log_id+"    "+log_time+"    "+description;
	}

	
	
}
