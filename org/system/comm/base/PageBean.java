package system.comm.base;

import java.io.Serializable;
import java.util.List;
import utils.pageplugin.Page;

public class PageBean<E> implements Serializable{
	
	private static final long serialVersionUID = -3937366987768512979L;
	/**
	 * 表格数据
	 */
	private List<E> griddata; 
	/**
	 * 总页数
	 */
	private Integer total;  
	/**
	 * 当前页
	 */
	private Integer currpage;
	/**
	 * 总记录数
	 */
	private Float records;
	
	
	public PageBean(List list,Page page) {
		setGriddata(list);
		setRecords(page.getTotalResult());
		setCurrpage(page.getPage());
		setTotal((int) page.getTotalPage());
	}


	public List<E> getGriddata() {
		return griddata;
	}


	public void setGriddata(List<E> griddata) {
		this.griddata = griddata;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	public Integer getCurrpage() {
		return currpage;
	}


	public void setCurrpage(Integer currpage) {
		this.currpage = currpage;
	}


	public Float getRecords() {
		return records;
	}


	public void setRecords(Float records) {
		this.records = records;
	}

}
