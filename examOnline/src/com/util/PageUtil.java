package com.util;

public class PageUtil {
	
	public static Page createPage(int everyPage,int totalCount,int currentPage){
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrenPage(currentPage);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		int totalPage = getTotalPage(everyPage, totalCount);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage, beginIndex, hasPrePage, hasNextPage);
	}
	public static int getEveryPage(int everyPage){
		//获得每页的显示记录数
		return everyPage ==0?10:everyPage;//默认为10
	}
	public static int getCurrenPage(int currenPage){
		//获取当前页
		return currenPage==0?1:currenPage;//默认为1
	}
	public static int getTotalPage(int everyPage,int totalCount){
		int totalPage=0;
		if(totalCount!=0&&totalCount%everyPage==0){
			totalPage = totalCount/everyPage;
		}else {
			totalPage = totalCount/everyPage+1;//页码+1
		}
		return totalPage;
	}
	/**
	 * 获取该分页的第一个索引
	 * @param everyPage
	 * @param currentPage
	 * @return
	 */
	public static int getBeginIndex(int everyPage,int currentPage){
		return (currentPage -1)*everyPage;
	}
	public static boolean getHasPrePage(int currentPage){
		return currentPage==1? false:true;//如果当前页为1的话，就没有前一页
	}
	public static boolean getHasNextPage(int totalPage,int currentPage){
		return currentPage==totalPage||totalPage==0?false:true;
	}
}
