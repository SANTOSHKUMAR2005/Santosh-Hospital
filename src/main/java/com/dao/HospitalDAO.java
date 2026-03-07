package com.dao;

import com.dto.DoctorDTO;

public interface HospitalDAO {
        void createDoctorsTable();
        void createPatientTable();
        String addDoctor(DoctorDTO docInfo);
        String deleteDoctor(int doctorId);
        String addClient();
}
