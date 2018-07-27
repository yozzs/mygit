package com.youzi.web.form;

import java.util.HashMap;
import java.util.Map;

public class RegisterForm {

	private String username;
	private String password;
	private String password2;
	private String email;
	private String nickname;
	private String checkcode;
	private Map errors;

	public RegisterForm() {
		errors = new HashMap();
	}

	public Map getErrors() {
		return errors;
	}

	public void setErrors(Map errors) {
		this.errors = errors;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public boolean volidate() {
		boolean isOK = true;
		if (username == null || username.trim().equals("")) {
			isOK = false;
			errors.put("username", "用户名不能为空");
		} else if (!username.matches("[a-zA-Z1-9]{3,12}")) {
			isOK = false;
			errors.put("username", "用户名必须是三到十二位字母或数字");
		}
		if (password == null || password.trim().equals("")) {
			isOK = false;
			errors.put("password", "密码不能为空");
		} else if (!password.matches("[a-zA-Z1-9]{3,16}")) {
			isOK = false;
			errors.put("password", "密码必须是三到十六位字母或数字");
		}
		if (password2 == null || password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "确认密码不能为空");
		} else if (!password2.equals(password)) {
			isOK = false;
			errors.put("password2", "两次输入的密码不一致");
		}
		if (email == null || email.trim().equals("")) {
			isOK = false;
			errors.put("email", "邮箱不能为空");
		} else if (!email.matches("\\w+@\\w+(\\.\\w+)+")) {
			isOK = false;
			errors.put("email", "邮箱格式不正确");
		}
		if (nickname == null || nickname.trim().equals("")) {
			isOK = false;
			errors.put("nickname", "昵称不能为空");
		} else if (!nickname.matches("[A-Za-z1-9一-龥]{2,8}")) {
			isOK = false;
			errors.put("nickname", "昵称必须是三到八位字母或数字或汉字");
		}
		return isOK;
	}
}
