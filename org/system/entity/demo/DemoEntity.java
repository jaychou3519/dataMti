package system.entity.demo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DemoEntity implements java.io.Serializable {
	private static final long serialVersionUID = -8229822600176869420L;
	private String id;
	private String name;
	private Date time;
	private String mark;

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
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
}
