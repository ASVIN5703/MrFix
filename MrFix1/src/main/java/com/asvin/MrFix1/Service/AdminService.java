package com.asvin.MrFix1.Service;

import com.asvin.MrFix1.Model.Admin;

public interface AdminService {

	Admin createAdmin(Admin adminlo);

	Admin verify(String admin_name);
   Admin check(String email);
   void activate(String code);
}
