package rj.service;

import java.util.List;

import rj.pojo.Product;

public interface ProductService {

	public List getProductList();

	public Product getProduct(Product paramProduct);
}
