package com.dao;

import com.dto.AdminDTO;
import com.dto.DoctorDTO;

public interface AdminDAO {
	  void createAdminTable();
	  String addAdmin(AdminDTO admindto);
      String changeName(String newName);
      String changePassword(String newPass);
      String varifyAdmin(String username , String password, String phone);
      
}
