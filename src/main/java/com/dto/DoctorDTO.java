package com.dto;

public class DoctorDTO {
     private String doctor_name;
     private byte[] photo_bytes;
     private String specialization;
     private String qualifications;
     private String license_no;
     private String phone_no;
     private int cabin_no;
     private int salary;
     private int consultation_fee;
     
     public DoctorDTO() {
    	 
     }
     public DoctorDTO(String name ,byte[] photo_bytes, String sprecialization,String qualifications, String license_no, String phone_no,
    		 int cabin_no, int salary,int consultation_fee) {
    	     this.doctor_name=name;
    	     this.photo_bytes=photo_bytes;
    	     this.specialization=sprecialization;
    	     this.qualifications=qualifications;
    	     this.license_no=license_no;
    	    this.phone_no=phone_no;
    	    this.cabin_no=cabin_no;
    	    this.salary=salary;
    	    this.consultation_fee=consultation_fee;
     }
     
     public int getCabin_no() {
		return cabin_no;
	}
     
     public int getConsultation_fee() {
		return consultation_fee;
	}
     
     public byte[] getPhotoBytes() {
		return photo_bytes;
	}
     
     public String getDoctor_name() {
		return doctor_name;
	}
     
     public String getLicense_no() {
		return license_no;
	}
     
     public String getPhone_no() {
		return phone_no;
	}
     
    public String getQualifications() {
		return qualifications;
	}
    
    public int getSalary() {
		return salary;
	}
    
    public String getSpecialization() {
		return specialization;
	}
	public byte[] getPhoto_bytes() {
		return photo_bytes;
	}
	
	public void setPhoto_bytes(byte[] photo_bytes) {
		this.photo_bytes = photo_bytes;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public void setLicense_no(String license_no) {
		this.license_no = license_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public void setCabin_no(int cabin_no) {
		this.cabin_no = cabin_no;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setConsultation_fee(int consultation_fee) {
		this.consultation_fee = consultation_fee;
	}
    
}
