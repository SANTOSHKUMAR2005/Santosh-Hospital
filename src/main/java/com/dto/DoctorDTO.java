package com.dto;

import java.io.InputStream;

public class DoctorDTO {
	private int doctor_id;
     private String doctor_name;
     private InputStream photo_inputStream;
     private String specialization;
     private String qualifications;
     private String license_no;
     private String phone_no;
     private int cabin_no;
     private int salary;
     private int consultation_fee;
     
     public DoctorDTO() {
    	 
     }
     public DoctorDTO(String name ,InputStream photo_inputStream, String sprecialization,String qualifications, String license_no, String phone_no,
    		 int cabin_no, int salary,int consultation_fee) {
    	     this.doctor_name=name;
    	     this.photo_inputStream=photo_inputStream;
    	     this.specialization=sprecialization;
    	     this.qualifications=qualifications;
    	     this.license_no=license_no;
    	    this.phone_no=phone_no;
    	    this.cabin_no=cabin_no;
    	    this.salary=salary;
    	    this.consultation_fee=consultation_fee;
     }
     
     
	 public int getDoctor_id() {
		return doctor_id;
	}
	 public void setDoctor_id(int doctor_id) {
		 this.doctor_id = doctor_id;
	 }
	 public String getDoctor_name() {
		 return doctor_name;
	 }
	 public void setDoctor_name(String doctor_name) {
		 this.doctor_name = doctor_name;
	 }
	 public InputStream getPhoto_inputStream() {
		 return photo_inputStream;
	 }
	 public void setPhoto_inputStream(InputStream blob) {
		 this.photo_inputStream =  blob;
	 }
	 public String getSpecialization() {
		 return specialization;
	 }
	 public void setSpecialization(String specialization) {
		 this.specialization = specialization;
	 }
	 public String getQualifications() {
		 return qualifications;
	 }
	 public void setQualifications(String qualifications) {
		 this.qualifications = qualifications;
	 }
	 public String getLicense_no() {
		 return license_no;
	 }
	 public void setLicense_no(String license_no) {
		 this.license_no = license_no;
	 }
	 public String getPhone_no() {
		 return phone_no;
	 }
	 public void setPhone_no(String phone_no) {
		 this.phone_no = phone_no;
	 }
	 public int getCabin_no() {
		 return cabin_no;
	 }
	 public void setCabin_no(int cabin_no) {
		 this.cabin_no = cabin_no;
	 }
	 public int getSalary() {
		 return salary;
	 }
	 public void setSalary(int salary) {
		 this.salary = salary;
	 }
	 public int getConsultation_fee() {
		 return consultation_fee;
	 }
	 public void setConsultation_fee(int consultation_fee) {
		 this.consultation_fee = consultation_fee;
	 }
	 @Override
	 public String toString() {
		return "DoctorDTO [doctor_id=" + doctor_id + ", doctor_name=" + doctor_name + ", photo_inputStream="
				+ photo_inputStream + ", specialization=" + specialization + ", qualifications=" + qualifications
				+ ", license_no=" + license_no + ", phone_no=" + phone_no + ", cabin_no=" + cabin_no + ", salary="
				+ salary + ", consultation_fee=" + consultation_fee + "]";
	 }
     
     
     
}