/**
 * Program  : User.java
 * Author   : zhouq
 * Create   : 2014年7月2日 上午9:46:27
 *
 * Copyright 2014 by jt56 Technologies Ltd.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of jt56 Technologies Ltd.("Confidential Information").  
 * You shall not disclose such Confidential Information and shall 
 * use it only in accordance with the terms of the license agreement 
 * you entered into with jt56 Technologies Ltd.
 *
 */

package common.webservice.entity;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author zhouq
 * @version 1.0.0
 * @2014年7月2日 上午9:46:27
 */
@XmlRootElement(name = "UserInfo")
public class User  implements java.io.Serializable {
    /**
	 * @author zhouq
	 * @create 2014年7月7日 下午3:59:38
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @author zhouq
	 * @create 2014年7月7日 下午3:59:25
	 */
	private int id;
    private String name;
    private String email;
    private String address;
    
   
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
    public String toString() {
        return this.id + "#" + this.name + "#" + this.email + "#" + this.address;
    }
}

