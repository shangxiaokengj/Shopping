package rj.pojo;

public class OrderLine {
	private int lineid;
	private int orderid;
	private int productid;
	private double amount;

	public int getLineid() {
		return lineid;
	}

	public void setLineid(int lineid) {
		this.lineid = lineid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
