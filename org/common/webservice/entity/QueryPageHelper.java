package common.webservice.entity;


/**
 * EasyUI 分页帮助类
 * 
 * @author 孙宇
 * 
 */
public class QueryPageHelper implements java.io.Serializable {

	/**
	 * @author zhouq
	 * @create 2014年7月16日 下午3:19:50
	 */
	private static final long serialVersionUID = 1L;
	private String status;//   状态(y:有效,n:无效,未审核:0,审核未通过:1,审核通过:2)
	protected String placeOfDeparture;//   启运地
	protected String destination;//   目的地
	
	private int currentPage = 1;// 当前页
	private int pageSize = 10;// 每页显示记录数
	private String sort;// 排序字段
	private String order;// asc/desc
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPlaceOfDeparture() {
		return placeOfDeparture;
	}
	public void setPlaceOfDeparture(String placeOfDeparture) {
		this.placeOfDeparture = placeOfDeparture;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}

	
}
