package exam;

import java.util.List;

public class PaginationHelper<I> {
	private List<I> collection;
	private int itemsPerPage;
	private int sum;
	private int pageCounts;
	private int currentElements;
	private int pageIndex;

    /**
     * 构造函数包含
     * 1）数组collection，表示需要分页的所有元素
     * 2）数字itemsPerPage，表示每页的元素个数
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
    	this.collection=collection;
    	this.itemsPerPage=itemsPerPage;
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount() {
        sum=collection.size();
        return sum;    
    }

    /**
     * 返回页数
     */
    public int pageCount() {
        if(itemCount() % itemsPerPage == 0)
        	pageCounts=itemCount()/ itemsPerPage;
        else
        	pageCounts=itemCount()/ itemsPerPage+1;
        return pageCounts;
    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {
        if(pageIndex<pageCount())
        {
        	if((pageIndex+1)*itemsPerPage>itemCount())
        		currentElements=itemCount()-(pageIndex)*itemsPerPage;
        	else
        		currentElements=itemsPerPage;
        }
        else
        	currentElements=-1;
        return currentElements;
    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex < 0 || itemIndex > itemCount())
        	pageIndex = -1;
        else {
        	if(itemIndex/itemsPerPage==0)
        		pageIndex = itemIndex / itemsPerPage;
        	else
        		pageIndex = itemIndex / itemsPerPage;
        } 
        return pageIndex;
    }
}