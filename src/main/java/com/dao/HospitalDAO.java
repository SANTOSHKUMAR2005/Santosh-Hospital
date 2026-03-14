package com.dao;

import java.util.ArrayList;

import com.dto.ClientDTO;
import com.dto.DocBasicInfo;
import com.dto.DoctorDTO;

public interface HospitalDAO {
        void createDoctorsTable();
        void createClientTable();
        void createAppointmentTable();
        
        String addDoctor(DoctorDTO docInfo);
        String addClient(ClientDTO clientInfo);
        String usernameAvailbility(String username);
        String verifyClient(String username ,String password);
        String deleteDoctor(int doctorId);
        String bookAppointment(String username , int doctorId);
        ArrayList<DocBasicInfo> getRelatedDoctors(String doctorType);
}
