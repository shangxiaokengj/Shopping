package rj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj.pojo.ContactInfo;
import rj.pojo.OrderLine;
import rj.pojo.Orders;
import rj.pojo.PayWay;
import rj.pojo.Product;
import rj.pojo.User;
import rj.service.ContactInfoService;
import rj.service.OrderLineService;
import rj.service.OrderService;
import rj.service.PayWayService;
import rj.service.ProductDetailService;
import rj.service.UserService;
import rj.service.impl.ContactInfoServiceImpl;
import rj.service.impl.OrderLineServiceImpl;
import rj.service.impl.OrderServiceImpl;
import rj.service.impl.PayWayServiceImpl;
import rj.service.impl.ProductDetailServiceImpl;
import rj.service.impl.UserServiceImpl;

public class OrderDetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		List orderLineList = (List)req.getAttribute("orderLineList");
		PayWay payway = (PayWay)req.getAttribute("payway");
		ContactInfo contactinfo = (ContactInfo)req.getAttribute("contactinfo");
		User user = (User)req.getAttribute("user");
		Orders order = (Orders)req.getAttribute("order");

		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>达内电子商务门户</title>");
		out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		out.println("		<meta name=\"description\" content=\"达内电子商务门户\">");
		out.println("		<link href=\"css/tarena.css\" rel=stylesheet>");
		out.println("	</head>");
		out.println("	<body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");
		out.println("");
		out.println("<!-- Header Start -->");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">");
		out.println("			<tr>");
		out.println("				<td align=\"left\" width=\"7%\" background=\"images/top_bg.gif\"><img src=\"images/logo.gif\" width=\"286\" height=\"58\"></td>");
		out.println("				<td width=\"62%\" background=\"images/top_bg.gif\">　</td>");
		out.println("				<td width=\"31%\" background=\"images/top_bg.gif\" align=\"right\"><img src=\"images/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		out.println("");
		out.println("			<tr>");
		out.println("				<td background=\"images/dh_bg.gif\" align=\"left\" height=\"12\">");
		out.println("					<table width=\"100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("						<tr>");
		out.println("							<td width=\"5%\"></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"doProductList.PHP\"><img name=\"Image1\" border=\"0\" src=\"images/index.gif\" width=\"90\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"UserManage.PHP\"><img name=\"Image2\" border=\"0\" src=\"images/reg.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"ShoppingCart.PHP\"><img name=\"Image4\" border=\"0\" src=\"images/cart.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"Order.PHP\"><img name=\"Image5\" border=\"0\" src=\"images/order.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"ProductList.PHP\"><img name=\"Image6\" border=\"0\" src=\"images/exit.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("						</tr>");
		out.println("					</table>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">");
		out.println("			<tr>");
		out.println("				<td width=\"65%\"><br>");
		out.println("");
		out.println("					>> 欢迎访问 <b>达内电子商务门户</b>");
		out.println("				</td>");
		out.println("				<td width=\"35%\" align=\"right\">");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("<!-- Header End -->");
		out.println("<!-- Body Start -->");
		out.println("");
		out.println("<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder2\">");
		out.println("			<tr>");
		out.println("				<td height=\"25\" valign=\"middle\">");
		out.println("					<img src=\"images/Forum_nav.gif\" align=\"absmiddle\">");
		out.println("					<a href=\"ProductList.PHP\">达内电子商务门户</a> → <a href=\"Order\">定单列表</a>  → <b>定单明细</b>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<br>");
		out.println("		");
		out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
		out.println("			<tr>");
		out.println("				<td colspan=\"2\" valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"8%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>用户信息</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("			");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>用户名：</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			"+user.getUserid()+"");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>联系地址：</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			"+contactinfo.getStreet1()+"");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>邮编：</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			"+contactinfo.getZip()+"");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>家庭电话：</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			"+contactinfo.getHomephone()+"");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>办公室电话：</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			"+contactinfo.getOfficephone()+"");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>手机：</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			"+contactinfo.getCellphone()+"");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					<b>Email地址：</b>");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			"+contactinfo.getEmail()+"");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("			");
		out.println("		</table>");
		out.println("		<br>");
		out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
		out.println("			<tr>");
		out.println("				<td colspan=\"2\" valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"8%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>付款方式</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("			");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">");
		out.println("					");
		out.println("				</td>");
		out.println("				");
		out.println("    			<td class=tablebody1 valign=\"middle\" width=\"60%\"> ");
		out.println("    			"+payway.getPaystyle()+"");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("		");
		out.println("		</table>");
		out.println("		<br>");
		out.println("		");
		out.println("		");
		out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
		out.println("		<tr>");
		out.println("				<td colspan=\"5\" valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"8%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>商品购物清单</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("			");
		
		double totalCost = 0;
		
		System.out.println(orderLineList.size());
		
		ProductDetailService productdetailservice = new ProductDetailServiceImpl();
		for(int i = 0; i< orderLineList.size();i++){
			
			OrderLine orderline = (OrderLine)orderLineList.get(i);
			
			String productid  = Integer.toString(orderline.getProductid());
			
			System.out.println(productid);
			
			Product product = productdetailservice.getProduct(productid);
			
			//System.out.println(product.getName()+"asdsa0000");
			
			out.println("			<tr>");
			out.println("				<td class=tablebody2 valign=\"middle\"  align=\"center\" width=\"3%\">");
			out.println("					"+ (i+1) +"");
			out.println("				</td>");
			out.println("				");
			out.println("    			<td class=tablebody1 valign=\"middle\" width=\"50%\"> ");
			out.println("    			&nbsp&nbsp"+product.getName()+"");
			out.println("    			</td>");
			out.println("    			<td class=tablebody2 valign=\"middle\" align=\"center\" width=\"18%\"> ");
			out.println("    			价格："+product.getBasePrice()+"");
			out.println("    			</td>");
			out.println("    			<td class=tablebody1 valign=\"middle\" align=\"center\" width=\"14%\"> ");
			out.println("    			数量："+orderline.getAmount()+"");
			out.println("    			</td>");
			out.println("    			<td class=tablebody2 valign=\"middle\" width=\"25%\"> ");
			out.println("    			小计：￥"+orderline.getAmount() * product.getBasePrice()+"");
			
			totalCost += orderline.getAmount() * product.getBasePrice();
			
			out.println("    			</td>");
			out.println("			</tr>");
		}
		
		out.println("			");
		out.println("			<tr>");
		out.println("			<td colspan=\"4\" class=tablebody1 valign=\"middle\" width=\"75%\">");
		out.println("			");
		out.println("				</td>");
		out.println("			<td class=tablebody1 valign=\"middle\" width=\"25%\"> ");
		out.println("    			合计：<font color=\"red\"><b>￥"+order.getCost()+"</b><font>");
		out.println("    			</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<br>");
		out.println("		<br>");
		out.println("		");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("<!-- Body End -->");
		out.println("<!-- Footer Start -->");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">");
		out.println("			<tr>");
		out.println("				<td height=\"17\" background=\"images/bot_bg.gif\">");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("			<tr>");
		out.println("				<td bgcolor=\"#f1f1f6\" height=\"53\" valign=\"center\">");
		out.println("					<p align=\"center\">");
		out.println("						Copyright &copy;2004 - 2005 <a href=\"http://www.tarena.com.cn\"><b>Tarena</b><font color=\"red\">.com.cn</font></a>");
		out.println("					</p>");
		out.println("				</td>");
		out.println("");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("<!-- Footer End -->");
		out.println("	</body>");
		out.println("</html>");

		out.close();
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doGet(req, resp);
	}
}
