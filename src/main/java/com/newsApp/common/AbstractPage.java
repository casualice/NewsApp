package com.newsApp.common;

import java.util.*;


public abstract class AbstractPage<E> implements Page<E> {

    public static final int DEFAULT_FIRST_PAGE_NUM = 1;
    public static final int DEFAULT_PAGE_SIZE = 10;

    protected int pageSize = DEFAULT_PAGE_SIZE;
    protected int pageNum = DEFAULT_FIRST_PAGE_NUM;
    
    protected int itemsTotalCount = 0;//总记录数
    protected int pageTotalCount = 0;//总页数
    protected List<E> items;
    protected boolean firstPage;//是否是第一页
    protected boolean lastPage;//是否是最后一页
    protected int startIndex;

    @Override
    public int getFirstPageNum() {
        return DEFAULT_FIRST_PAGE_NUM;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if (pageNum < DEFAULT_FIRST_PAGE_NUM) {
            pageNum = DEFAULT_FIRST_PAGE_NUM;
        }
        this.pageNum = pageNum;
    }

    @Override
    public List<E> getItems() {
        return items;
    }

    public void setItems(Collection<E> items) {
        if (items == null) items = Collections.emptyList();
        this.items = new ArrayList<E>(items);
        this.lastPage = this.pageNum == this.pageTotalCount;
        this.firstPage = this.pageNum == DEFAULT_FIRST_PAGE_NUM;
    }

    @Override
    public boolean isFirstPage() {
    	firstPage = (getPageNum() <= getFirstPageNum());
    	return firstPage;
    }

    @Override
    public boolean isLastPage() {
        lastPage=(getPageNum()>=getLastPageNum());
        return lastPage;
    }

    public int getPrePageNum() {
        return isFirstPage() ? getFirstPageNum() : getPageNum() - 1;
    }

    public int getNextPageNum() {
        return isLastPage() ? getPageNum() : getPageNum() + 1;
    }

    @Override
    public Iterator<E> iterator() {
        return this.items.iterator();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

	public void setItemsTotalCount(int itemsTotalCount) {
		this.itemsTotalCount = itemsTotalCount;
		if(itemsTotalCount % this.pageSize == 0){
			this.pageTotalCount = itemsTotalCount/this.pageSize;
		}else{
			this.pageTotalCount = itemsTotalCount/this.pageSize + 1;
		}
		if(this.pageNum > this.pageTotalCount){
			this.pageNum = DEFAULT_FIRST_PAGE_NUM;
		}
		if(this.itemsTotalCount <= this.pageSize){
			this.firstPage = true;
			this.lastPage = true;
		}
	}
	
	@Override
	public int getItemsTotalCount() {
		return itemsTotalCount;
	}
    
	@Override
	public int getLastPageNum() {
		return pageTotalCount;
	}
	
	public int getStartIndex() {
		this.startIndex = (this.pageNum - 1) * this.pageSize;
		if(this.startIndex <= 0){
			this.startIndex = 0;
		}
		return this.startIndex;
	}


	@Override
    public String toString() {
        return "Page[" + this.getPageNum() + "]:" + items.toString();
    }

	
}
