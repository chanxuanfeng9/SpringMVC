package util;

import java.io.Serializable;

public class Page implements Serializable{
	private static final long serialVersionUID = -6514016915411014494L;
	private Integer n; //ҳ��
	private Integer size; //ÿҳ��ʾ�ļ�¼��
	private Integer totalSize; //�ܼ�¼��
	private Integer totalPage; //��ҳ��
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
