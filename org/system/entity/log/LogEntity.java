package system.entity.log;

import java.util.Date;

public class LogEntity {
	
	private String id;//   ID
	private String userid;//   用户ID
	private String username;//   用户名称
	private String ip;//   用户IP
	private Integer operation_type;//   操作类型(1：新增，2：修改，3：更新，4：删除，5：查询)
	private String tablename;//   操作表名
	private String tableid;//   操作主键
	private String comment;//   备注
	private Date ctime;//   操作时间
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getOperation_type() {
		return operation_type;
	}
	public void setOperation_type(Integer operation_type) {
		this.operation_type = operation_type;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getTableid() {
		return tableid;
	}
	public void setTableid(String tableid) {
		this.tableid = tableid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	
	
}
