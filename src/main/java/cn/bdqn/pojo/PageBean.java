package cn.bdqn.pojo;

import java.util.List;

public class PageBean<T> {
    private int currPageNo;
    private int pageSize;
    private int totalCount;
    private int totalPageCount;
    private List<T> listc;

    public int getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<T> getListc() {
        return listc;
    }

    public void setListc(List<T> listc) {
        this.listc = listc;
    }
}
