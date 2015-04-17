package system.comm.base;

import java.io.Serializable;

public class TreeEntity implements Serializable{
	
	/**
	 * 树结构
	 * @author zhouq
	 * @create 2014年8月13日 上午11:05:03
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String pId;
	private String name;
	private Boolean open;
	private Boolean nocheck;
	private Boolean checked;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public Boolean getNocheck() {
		return nocheck;
	}
	public void setNocheck(Boolean nocheck) {
		this.nocheck = nocheck;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
	
}
