package com.dao;

import com.dto.DoctorDTO;

public interface HospitalDAO {
        void createDoctorsTable();
        void createPatientTable();
        
        void addDoctor(DoctorDTO docInfo);
        void deleteDoctor();
        void addClient();
}
