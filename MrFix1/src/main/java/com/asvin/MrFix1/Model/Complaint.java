package com.asvin.MrFix1.Model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="complaint")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complaint {
	 
		@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="compid")
		private int complaintId;
		public int getComplaintId() {
			return complaintId;
		}

		public void setComplaintId(int complaintId) {
			this.complaintId = complaintId;
		}
		@Column(name="Complainant")
        private String Complainant;
		@Column(name="sub")
        private String sub;
        @Column(name="location")
        private String location;
        @Column(name="issues")
        
        private String issues;
        @Lob
        @Column(name = "imagedata")
        private byte imageData[];
        
	    public byte[] getImageData() {
			return imageData;
		}

		public void setImageData(byte[] imageData) {
			this.imageData = imageData;
		}

		public String getComplainant() {
			return Complainant;
		}
        
		public void setComplainant(String complainant) {
			Complainant = complainant;
		}
		public String getSub() {
			return sub;
		}
		public void setSub(String sub) {
			this.sub = sub;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getIssues() {
			return issues;
		}
		public void setIssues(String issues) {
			this.issues = issues;
		}
		   @Override
		public String toString() {
			return "Complaint [complaintId=" + complaintId + ", Complainant=" + Complainant + ", sub=" + sub
					+ ", location=" + location + ", issues=" + issues + ", imageData=" + Arrays.toString(imageData)
					+ "]";
		}

		public static Object builder() {
			// TODO Auto-generated method stub
			return null;
		}

			
        
}
