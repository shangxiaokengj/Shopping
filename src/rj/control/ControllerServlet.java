package rj.control;

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
import rj.util.ServiceFactory;

public class ControllerServlet extends HttpServlet {

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String path = req.getServletPath();

		String suffix = "." + path.split("\\.")[1];

		getServletContext().setAttribute("suffix", suffix);

		path = path.split("\\.")[0];

		System.out.println("" + path);

		if ("/Order".equals(path)) {
			try {
				OrderService orderService = ServiceFactory.getOrderService();

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

				if (name == null) {
					req.setAttribute("message", "please choose an order!");
					getServletContext().getRequestDispatcher("/error").forward(
							req, resp);
					return;
				}

				// get one order
				OrderService orderService = ServiceFactory.getOrderService();
				Orders paramOrder = new Orders();
				paramOrder.setOrderid(Integer.parseInt(name));
				Orders order = orderService.getOrder(paramOrder);

				// get the orderlinelist according to the orderid
				OrderLineService productdetailService = ServiceFactory
						.getOrderLineService();
				List orderLineList = productdetailService
						.getOrderLineList(name);

				String userid = null;
				int paywayid = 0;

				if (order != null) {
					userid = order.getUserid();
					paywayid = order.getPaywayid();
				}

				UserService userSerivce = ServiceFactory.getUserService();
				User paramUser = new User();
				paramUser.setUserid(userid);
				User user = userSerivce.getUser(paramUser);

				ContactInfoService contactinfoservice = ServiceFactory
						.getContactInfoService();
				ContactInfo contactinfo = contactinfoservice
						.getContactInfo(paramUser);

				PayWayService paywayservice = ServiceFactory.getPaywayService();
				PayWay paramPayway = new PayWay();
				paramPayway.setPaywayid(order.getPaywayid());
				PayWay payway = paywayservice.getPayWay(paramPayway);

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
		} else if ("/toProductList".equals(path)) {
			getServletContext().getRequestDispatcher("/ProductList").forward(
					req, resp);
			req.getSession().removeAttribute("message");
		}
		if ("/doProductList".equals(path)) {
			try {
				ProductService productService = ServiceFactory
						.getProductService();
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

				if (id == null) {
					req.setAttribute("message", "please chose a product!");
					getServletContext().getRequestDispatcher("/error").forward(
							req, resp);
					return;
				}

				ProductService productdService = ServiceFactory
						.getProductService();
				Product paramProduct = new Product();
				paramProduct.setProductid(id);
				Product product = productdService.getProduct(paramProduct);
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

		} else if ("/toLogin".equals(path)) {

			getServletContext().getRequestDispatcher("/Login").forward(req,
					resp);
			req.getSession().removeAttribute("message");

		} else if ("/doLogin".equals(path)) {

			String userName = req.getParameter("userName");

			String password = req.getParameter("password");

			User paramUser = new User();

			paramUser.setUserid(userName);
			paramUser.setPassword(password);

			req.getSession().setAttribute("paramUser", paramUser);

			UserService userService = ServiceFactory.getUserService();

			User user = userService.getUser(paramUser);

			if (user != null) {
				req.getSession().setAttribute("IS_LOGIN", "1");
				req.setAttribute("user", user);

				getServletContext().getRequestDispatcher("/ProductList.PHP")
						.forward(req, resp);
			} else {
				req.getSession().setAttribute("message",
						"The user was not found!");

				resp.sendRedirect(getServletContext().getContextPath()
						+ "/toLogin" + suffix);
			}

		} else if ("/UserManage".equals(path)) {

			try {
				UserService userService = ServiceFactory.getUserService();

				List userList = userService.getUserList();

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
				ContactInfoService contactInfoService = ServiceFactory
						.getContactInfoService();
				String userid = req.getParameter("id");

				ContactInfo paramContactinfo = new ContactInfo();
				User paramUser = new User();
				paramUser.setUserid(userid);
				ContactInfo contactinfo = contactInfoService
						.getContactInfo(paramUser);

				req.setAttribute("contactinfo", contactinfo);

				getServletContext().getRequestDispatcher("/UserModify")
						.forward(req, resp);

			} catch (Exception e) {
				req.setAttribute("message", e.getMessage());

				getServletContext().getRequestDispatcher("/error").forward(req,
						resp);
			}

		} else if ("/toRegister".equals(path)) {
			getServletContext().getRequestDispatcher("/UserRegister").forward(
					req, resp);
		} else if ("/doRegister".equals(path)) {

			String userName = req.getParameter("userid");
			String password = req.getParameter("password");
			String password2 = req.getParameter("password2");
			String country = req.getParameter("country");
			String province = req.getParameter("province");
			String city = req.getParameter("city");
			String street1 = req.getParameter("street1");
			String street2 = req.getParameter("street2");
			String zip = req.getParameter("zip");
			String homephone = req.getParameter("homephone");
			String officephone = req.getParameter("officephone");
			String cellphone = req.getParameter("cellphone");
			String email = req.getParameter("email");

			User paramUser = new User();
			paramUser.setUserid(userName);

			if (password.equals(password2)) {
				paramUser.setPassword(password);
			} else {
				System.out.println("密码与密码确认不一致");
				return;
			}

			ContactInfo paramContactinfo = new ContactInfo();
			paramContactinfo.setCellphone(cellphone);
			paramContactinfo.setCity(city);
			paramContactinfo.setCountry(country);
			paramContactinfo.setEmail(email);
			paramContactinfo.setHomephone(homephone);
			paramContactinfo.setOfficephone(officephone);
			paramContactinfo.setProvince(province);
			paramContactinfo.setStreet1(street1);
			paramContactinfo.setStreet2(street2);
			paramContactinfo.setUserid(userName);
			paramContactinfo.setZip(zip);

			paramContactinfo.setCellphone(cellphone);

			req.getSession().setAttribute("paramContactinfo", paramContactinfo);

			UserService userService = ServiceFactory.getUserService();
			User user = userService.getUserByUserid(userName);

			ContactInfoService contactInfoService = ServiceFactory
					.getContactInfoService();
			ContactInfo contactinfo = contactInfoService
					.getContactInfo(paramUser);
			if (user != null) {

				req.getSession().setAttribute("message",
						"The user has existed!");

				resp.sendRedirect(getServletContext().getContextPath()
						+ "/toRegister" + suffix);

			} else {
				req.setAttribute("user", user);
				req.setAttribute("contactinfo", contactinfo);

				getServletContext().getRequestDispatcher("/Login.PHP").forward(
						req, resp);
			}

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