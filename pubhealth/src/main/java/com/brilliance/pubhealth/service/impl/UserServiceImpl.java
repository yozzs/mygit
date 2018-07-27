package com.brilliance.pubhealth.service.impl;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;

import com.brilliance.pubhealth.dao.IUserDao;
import com.brilliance.pubhealth.pojo.User;
import com.brilliance.pubhealth.service.IUserService;
 
  
@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private IUserDao userDao;  
    
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
    }

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return this.userDao.insert(record);
	}  
    
}