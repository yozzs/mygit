package com.brilliance.pubhealth.service;


import com.brilliance.pubhealth.pojo.User;  
  
public interface IUserService {  
    public User getUserById(int userId); 
    public int insert(User record);
}
