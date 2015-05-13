package com.hundsun.fund.provider.redis.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/** 用户实体对象定义 */
public class User implements Serializable {

	private static final long serialVersionUID = 7289036533757178921L;

	/** 用户编号*/
	private int id;

	/** 邮箱*/
	private String email;

	/** 姓名*/
	private String name;

	/** 昵称*/
	private String nick;

	/** 性别*/
	private Integer sex;

	@Override
	public String toString() {
		return "User ["+this.id+"],["+this.name+"],["+this.nick+"],["+this.email+"]";
	}

	public byte [] coder(){

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		byte [] email = this.email.getBytes();
		buffer.putInt(email.length);
		buffer.put(email);
		
		byte [] name =this.name.getBytes();
		buffer.putInt(name.length);
		buffer.put(name);
		
		byte [] nick = this.nick.getBytes();
		buffer.putInt(nick.length);
		buffer.put(nick);
		
		buffer.putInt(this.sex);
		buffer.putInt(this.id);
		
		buffer.flip();
		byte[] result = new byte[buffer.remaining()];
		buffer.get(result);
		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

}
