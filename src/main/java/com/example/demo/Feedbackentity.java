package com.example.demo;

public class Feedbackentity {

	///id, feedback,user_email,date///
        private long ID;
        private String name;
        private String feedback;
        private String date;
		public long getID() {
			return ID;
		}
		public void setID(long iD) {
			ID = iD;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFeedback() {
			return feedback;
		}
		public void setFeedback(String feedback) {
			this.feedback = feedback;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		@Override
		public String toString() {
			return "EProductEntity [ID=" + ID + ", name=" + name + ", feedback=" + feedback + ", date=" + date + "]";
		}  
        
        
        
}