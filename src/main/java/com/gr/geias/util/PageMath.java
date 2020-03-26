package com.gr.geias.util;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-02-16 09:20
 */
public class PageMath {
    /**
     * 将前端的pageNum 页码 转换为 Dao层理解的 行数
     * @param pageNum 页码
     * @param pageSize 每一页的大小
     * @return 行数
     */
    public static int pageNumtoRowIndex(int pageNum,int pageSize){
        return pageNum>0?(pageNum-1)*pageSize:0;
    }

}
