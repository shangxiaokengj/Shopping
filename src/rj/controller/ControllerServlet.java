package rj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj.pojo.ContactInfo;
import rj.pojo.Orders;
import rj.pojo.PayWay;
import rj.pojo.Product;
import rj.pojo.User;
import rj.service.ContactInfoService;
import rj.service.OrderLineService;
import rj.service.OrderService;
import rj.service.PayWayService;
import rj.service.ProductDetailService;
import rj.service.ProductService;
import rj.service.UserService;
import rj.service.impl.ContactInfoServiceImpl;
import rj.service.impl.OrderLineServiceImpl;
import rj.service.impl.OrderServiceImpl;
import rj.service.impl.PayWayServiceImpl;
import rj.service.impl.ProductDetailServiceImpl;
import rj.service.impl.ProductServiceImpl;
import rj.service.impl.UserServiceImpl;

public class ControllerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String path = req.getServletPath();
System.out.println(path);
		path = path.substring(0, path.indexOf("."));

System.out.println(path);

		if ("/Order".equals(path)) {
			try {
				OrderService orderService = new OrderServiceImpl();
				List orderList = orderService.getOrderList();
				req.setAttribute("orderList", orderList);
				getServletContext().getRequestDispatcher("/Order").forward(req,
						resp);

			} catch (Exception e) {
				req.setAttribute("message", e.getMessage());
				getServletContext().getRequestDispatcher("/error").forward(req,
						resp);
			}
		} else if (path.contains("OrderDetail")) {
			try {
				String name = req.getParameter("id");
		System.out.println(req.getParameter("id") + "didi");
		
				if(name == null){
					req.setAttribute("message", "please choose an order!");
					getServletContext().getRequestDispatcher("/error").forward(req,
							resp);
					return;
				}
		
				// get one order
				OrderService orderService = new OrderServiceImpl();
				Orders order = orderService.getOrder(Integer.parseInt(name));

				// get the orderlinelist according to the orderid
				OrderLineService productdetailService = new OrderLineServiceImpl();
				List orderLineList = productdetailService
						.getOrderLineList(name);

				String userid = null;
				int paywayid = 0;

				if (order != null) {
					userid = order.getUserid();
					paywayid = order.getPaywayid();
				}

				UserService userSerivce = new UserServiceImpl();
				User user = userSerivce.getUser(userid);

				ContactInfoService contactinfoservice = new ContactInfoServiceImpl();
				ContactInfo contactinfo = contactinfoservice
						.getContactInfo(userid);

				PayWayService paywayservice = new PayWayServiceImpl();
				PayWay payway = paywayservice.getPayWay(paywayid);

				req.setAttribute("orderLineList", orderLineList);
				req.setAttribute("user", user);
				req.setAttribute("contactinfo", contactinfo);
				req.setAttribute("payway", payway);
				req.setAttribute("order", order);

				getServletContext().getRequestDispatcher("/OrderDetail")
						.forward(req, resp);

			} catch (Exception e) {

				req.setAttribute("message", e.getMessage());
				getServletContext().getRequestDispatcher("/error").forward(req,
						resp);
				
			}
		} else if ("/ProductList".equals(path)) {
			try {
				ProductService productService = new ProductServiceImpl();
				List productList = productService.getProductList();
				req.setAttribute("productlist", productList);
				getServletContext().getRequestDispatcher("/ProductList")
						.forward(req, resp);

			} catch (Exception e) {
				req.setAttribute("message", e.getMessage());
				getServletContext().getRequestDispatcher("/error").forward(req,
						resp);
			}
		} else if ("/ProductDetail".equals(path)) {

			try {
				String id = req.getParameter("id");
				
				if(id == null){
					req.setAttribute("message", "please chose a product!");
					getServletContext().getRequestDispatcher("/error").forward(req,
							resp);
					return;
				}
				
				ProductDetailService productdetailService = new ProductDetailServiceImpl();
				Product product = productdetailService.getProduct(id);
				req.setAttribute("product", product);
				getServletContext().getRequestDispatcher("/ProductDetail")
						.forward(req, resp);
			} catch (Exception e) {
				req.setAttribute("message", e.getMessage());
				getServletContext().getRequestDispatcher("/error").forward(req,
						resp);
			}

		} else if ("/ShoppingCart".equals(path)) {

			getServletContext().getRequestDispatcher("/ShoppingCart").forward(
					req, resp);

		} else if ("/OrderConfirm".equals(path)) {

			getServletContext().getRequestDispatcher("/OrderConfirm").forward(
					req, resp);

		} else if ("/Login".equals(path)) {

			getServletContext().getRequestDispatcher("/Login").forward(req,
					resp);
		} else if ("/UserManage".equals(path)) {

			try {
				UserService studentService = new UserServiceImpl();
				List userList = studentService.getUserList();
				req.setAttribute("userList", userList);
				getServletContext().getRequestDispatcher("/UserManage")
						.forward(req, resp);

			} catch (Exception e) {
				req.setAttribute("message", e.getMessage());
				getServletContext().getRequestDispatcher("/error").forward(req,
						resp);
			}
		} else if ("/UserModify".equals(path)) {

			try {
				ContactInfoService contactInfoService = new ContactInfoServiceImpl();
				String userid = req.getParameter("id");
				ContactInfo contactinfo = contactInfoService
						.getContactInfo(userid);

				req.setAttribute("contactinfo", contactinfo);

				getServletContext().getRequestDispatcher("/UserModify")
						.forward(req, resp);

			} catch (Exception e) {
				req.setAttribute("message", e.getMessage());

				getServletContext().getRequestDispatcher("/error").forward(req,
						resp);
			}

		} else if ("/UserRegister".equals(path)) {
			getServletContext().getRequestDispatcher("/UserRegister").forward(
					req, resp);
		} else {

			resp.sendError(500);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}