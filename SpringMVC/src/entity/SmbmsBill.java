package entity;

import java.io.Serializable;
import java.util.Date;

public class SmbmsBill implements Serializable{
	private static final long serialVersionUID = -2090969047970580619L;
	private Integer id;
	private String billCode;
	private String productName;
	private String productDesc;
	private String productUnit;
	private Double productCount;
	private Double totalPrice;
	private Integer isPayment;
	private Integer createdBy;
	private Date creationDate;
	private Integer modifyBy;
	private Date modifyDate;
	private SmbmsProvider providerId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public Double getProductCount() {
		return productCount;
	}
	public void setProductCount(Double productCount) {
		this.productCount = productCount;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(Integer isPayment) {
		this.isPayment = isPayment;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public SmbmsProvider getProviderId() {
		return providerId;
	}
	public void setProviderId(SmbmsProvider providerId) {
		this.providerId = providerId;
	}
	@Override
	public String toString() {
		return "SmbmsBill [id=" + id + ", billCode=" + billCode
				+ ", productName=" + productName + ", productDesc="
				+ productDesc + ", productUnit=" + productUnit
				+ ", productCount=" + productCount + ", totalPrice="
				+ totalPrice + ", isPayment=" + isPayment + ", createdBy="
				+ createdBy + ", creationDate=" + creationDate + ", modifyBy="
				+ modifyBy + ", modifyDate=" + modifyDate + ", providerId="
				+ providerId + "]";
	}		
}
