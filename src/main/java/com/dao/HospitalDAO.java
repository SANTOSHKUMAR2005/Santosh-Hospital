package com.dao;

import java.util.ArrayList;

import com.dto.DocBasicInfo;
import com.dto.DoctorDTO;

public interface HospitalDAO {
        void createDoctorsTable();
        void createClientTable();
        String addDoctor(DoctorDTO docInfo);
        String deleteDoctor(int doctorId);
        String bookAppointment();
        ArrayList<DocBasicInfo> getRelatedDoctors(String doctorType);
}
