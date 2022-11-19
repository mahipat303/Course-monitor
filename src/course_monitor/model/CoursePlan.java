package course_monitor.model;

public class CoursePlan {

	private int planId;
	private String batchId;
	private int dayNumber;
	private String topic;
	private String status;

	public CoursePlan() {
		// TODO Auto-generated constructor stub
	}

	public CoursePlan(int planId, String batchId, int dayNumber, String topic, String status) {
		super();
		this.planId = planId;
		this.batchId = batchId;
		this.dayNumber = dayNumber;
		this.topic = topic;
		this.status = status;
	}

	public CoursePlan(String batchId, int dayNumber, String topic) {
		super();
		this.batchId = batchId;
		this.dayNumber = dayNumber;
		this.topic = topic;
		
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "==> batchId=" + batchId + ",  day=" + dayNumber + ",  topic=" + topic
				+ ",  status=" + status;
	}

}
