package rj.dao;

import java.util.List;

import rj.pojo.Product;

public interface ProductDao {
	public List getProductList();
	public Product getProduct(Product paramProduct);
}
