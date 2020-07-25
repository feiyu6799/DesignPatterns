package com.feiyu.cor;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
 * @author feiyu
 *
 */
public class Main {
	public static void main(String[] args) {
		Msg msg=new Msg();
		msg.setMsg("大家好:)，<链接地址>请点击搜索，996");
		
		FilterChain fc=new FilterChain();
		fc.add(new HtmlFilter()).add(new SensitiveFilter());//往链条中添加筛选条件
		
		FilterChain fc2=new FilterChain();
		fc2.add(new FaceFilter()).add(new URLFilter());//往链条中添加筛选条件
		
		fc.add(fc2);
		
		fc.doFilter(msg);
		
		System.out.println(msg);
	}

}

class Msg{
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Msg [msg=" + msg + ", getMsg()=" + getMsg() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}

/**
 * 类似于策略模式的基类
 * 
 * @author feiyu
 *
 */
interface Filter{
	boolean doFilter(Msg m);
}
/**
 * 针对不同的过滤条件 类1
 * @author feiyu
 *
 */
class SensitiveFilter implements Filter{

	@Override
	public boolean doFilter(Msg m) {
		String r=m.getMsg();
		r=r.replace("996", "955");
		m.setMsg(r);
		return false;
	}
	
}
/**
 * 针对不同的过滤条件 类2
 * @author feiyu
 *
 */
class FaceFilter implements Filter{

	@Override
	public boolean doFilter(Msg m) {
		String r=m.getMsg();
		r=r.replace(":)", "^v^");
		m.setMsg(r);
		return true;
	}
	
}
/**
 * 针对不同的过滤条件 类3
 * @author feiyu
 *
 */
class URLFilter implements Filter{

	@Override
	public boolean doFilter(Msg m) {
		String r=m.getMsg();
		r=r.replace("链接地址", "www.baidu.com");
		m.setMsg(r);
		return true;
	}
	
}
/**
 * 针对不同的过滤条件 类4
 * @author feiyu
 *
 */
class HtmlFilter implements Filter{

	@Override
	public boolean doFilter(Msg m) {
		String r=m.getMsg();
		r=r.replace("<", "[");
		r=r.replace(">", "]");
		m.setMsg(r);
		return true;
	}
	
}
/**
 * 把所有的过滤条件类串成链条
 * 责任链模式
 * @author feiyu
 *
 */
class FilterChain implements Filter{
	List<Filter> filters=new ArrayList<Filter>();
	
	/**
	 * 添加过滤条件类
	 * @param f
	 * @return
	 */
	public FilterChain add(Filter f){
		filters.add(f);
		return this;
	}
	
	@Override
	public boolean doFilter(Msg m) {
		for(Filter f:filters){
			
			if(!f.doFilter(m))
				return false;
			
		}
		return false;
	}
	
}