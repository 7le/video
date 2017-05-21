package com.shine.video.bean;

import java.io.Serializable;
import java.util.List;

public class Page2<T> implements Serializable {
    private static final long serialVersionUID = -5112397111963176643L;

    private List<T> rows;
    private int page;//当前页面数
//    private int pageSize;//一个页面几天记录
    private int pageTotal;//总页数
    private int total;//总记录数
    public Page2(){};

    /**
     *
     * @param rows
     * @param page 第几页
     * @param total 总记录数
     * @param pageTotal 总页数
     */
    public Page2(List<T> rows, int page, int pageTotal, int total) {
        this.rows = rows;
        this.page = page;
        this.pageTotal = pageTotal;
        this.total = total;

    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }
}
