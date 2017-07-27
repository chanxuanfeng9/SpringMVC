package util;

import java.io.Serializable;

public class ResultData implements Serializable{
	private static final long serialVersionUID = 5292724523112170637L;
	private String msg;
	private Integer flag;
	private Object data;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}	
}
