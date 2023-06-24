package com.asvin.MrFix1.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@Table(name="admin")
public class Admin {
	    
		@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int admin_id;
	    @Column(name="admin_name")
        private String admin_name;
	    @Column(name="admin_pass")
		private String admin_pass;
		@Column(name="admin_email")
        private String admin_email;
		@Column(name="admin_enable")
		public boolean isEnabled;
		public Admin() {
			this.isEnabled=false;
		}
		 @Column(name = "verification_code", length = 64,updatable=false)
		    private String verificationCode;
		     
		public String getVerificationCode() {
			return verificationCode;
		}
		public void setVerificationCode(String verificationCode) {
			this.verificationCode = verificationCode;
		}
		public int getAdmin_id() {
			return admin_id;
		}
		public void setAdmin_id(int admin_id) {
			this.admin_id = admin_id;
		}
		public boolean isEnabled() {
			return isEnabled;
		}
		public void setEnabled(boolean isEnabled) {
			this.isEnabled = isEnabled;
		}
		
		
        public String getAdmin_name() {
			return admin_name;
		}
		public void setAdmin_name(String admin_name) {
			this.admin_name = admin_name;
		}
		public String getAdmin_pass() {
			return admin_pass;
		}
		public void setAdmin_pass(String admin_pass) {
			this.admin_pass = admin_pass;
		}
		public String getAdmin_email() {
			return admin_email;
		}
		public void setAdmin_email(String admin_email) {
			this.admin_email = admin_email;
		}
		  @Override
		public String toString() {
			return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_pass=" + admin_pass
					+ ", admin_email=" + admin_email + ", isEnabled=" + isEnabled + ", verificationCode="
					+ verificationCode + "]";
		}
		
        
}
