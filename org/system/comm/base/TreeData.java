/**
 * Program  : TreeData.java
 * Author   : zhouq
 * Create   : 2014年8月14日 上午11:10:16
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

package system.comm.base;

import java.io.Serializable;

/**
 * 
 * @author zhouq
 * @version 1.0.0
 * @2014年8月14日 上午11:10:16
 */
public class TreeData implements Serializable{

	private String id;
    private String name;
    private String url;
    private Integer level = 0;
    private Boolean isLeaf = false;
    private String parent;
    private Boolean loaded = true;
    private Boolean expanded = false;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Boolean getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public Boolean getLoaded() {
		return loaded;
	}
	public void setLoaded(Boolean loaded) {
		this.loaded = loaded;
	}
	public Boolean getExpanded() {
		return expanded;
	}
	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}
	
    
}

