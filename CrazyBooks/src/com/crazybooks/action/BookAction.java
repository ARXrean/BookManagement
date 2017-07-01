package com.crazybooks.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.crazybooks.biz.impl.BookBizImpl;
import com.crazybooks.etity.Books;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class BookAction extends ActionSupport implements ModelDriven<Books>{
	BookBizImpl bookService;
	Integer coid;
	public void setCoid(Integer coid) {
		this.coid = coid;
	}
	public Integer getCoid() {
		return coid;
	}
	Integer cid;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	private String result; //json 娴肩姴锟介惃鍕綁闁诧拷
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setBookService(BookBizImpl bookService) {
		this.bookService = bookService;
	}
	
	Books book=new Books();
	
	public String findBooksByCid()
	{
		System.out.println("----------------------------------------------------"+cid);
		List bList=bookService.findBooksByCid(cid);
		ActionContext.getContext().getValueStack().set("bList", bList);
		return "bookListPage";
	}
	public String findboosByCoid()
	{
		List bList=bookService.findBooksByCoid(coid);
		ActionContext.getContext().getValueStack().set("bList", bList);
		return "bookListPage";
		
	}
	@Override
	public Books getModel() {
		// TODO Auto-generated method stub
		return book;
	}
	
	//閼惧嘲褰囬崶鍙ュ姛閻ㄥ嫯顕涚紒鍡曚繆閹拷
	public String getBookInfo(){
		Books bookReal=bookService.searchBook(book);
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("id", bookReal.getId());
		map.put("name", bookReal.getName());
		map.put("picture", bookReal.getPicture());
		map.put("intro", bookReal.getIntro());
		map.put("author", bookReal.getAuthor());
		map.put("pubHouse", bookReal.getPubHouse());
		map.put("price", bookReal.getPrice());
		map.put("btime", bookReal.getBtime());
		map.put("categorytwo", bookReal.getCategorytwo());
		map.put("state", bookReal.getState());
		JSONObject json=null;
		try {
			json=JSONObject.fromObject(map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		result=json.toString();
		return "bookInfo";
	}
	
	//閼惧嘲褰囬崶鍙ュ姛閻ㄥ嫯鐦庢禒锟�	
	public String getBookComments(){
		List comments=bookService.getComments(book);
		return "comments";
	}
}
