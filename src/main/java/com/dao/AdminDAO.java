package com.dao;

public interface AdminDAO {
	  void createAdminTable();
      void setAdminPassword();
      void setAdminName();
      void changeName();
      void changePassword();
      boolean varifyAdmin(String password);
}
