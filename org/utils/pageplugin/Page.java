package utils.pageplugin;

public class Page {  
    private int rows = 10; //每页显示记录数  
    private float totalResult;    //总记录数  
    private int page = 1;    //当前页  
    private int currentResult;  //当前记录起始索引  
    private boolean entityOrField;  //true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性  
    
    public float getTotalPage() {
    	return (float) Math.ceil(totalResult/rows);
	}
     
    public float getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(float totalResult) {
		this.totalResult = totalResult;
	}

	public int getPage() {  
        return page;  
    }  
    public void setPage(int page) {  
        this.page = page;  
        
    }  
    public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCurrentResult() {  
        currentResult = (page-1) * rows;  
        return currentResult;  
    }  
    public void setCurrentResult(int currentResult) {  
        this.currentResult = currentResult;  
    }  
    public boolean isEntityOrField() {  
        return entityOrField;  
    }  
    public void setEntityOrField(boolean entityOrField) {  
        this.entityOrField = entityOrField;  
    }
}

