package com.prog.entity;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String authority;
	
	
	public Authority() {
		super();
	}


	public Authority(String authority) {
		super();
		this.authority = authority;
	}


	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}


	@Override
	public String toString() {
		return "Authority [authority=" + authority + "]";
	}
	
	
	
}
