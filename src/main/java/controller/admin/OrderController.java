package controller.admin;

import java.util.List;

import org.hibernate.Query;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.NhanVien;
import entity.PhieuDat;


@Transactional
@Controller
@RequestMapping("/admin")
public class OrderController {
	@Autowired
	SessionFactory factory;
	
	public List<PhieuDat> getWaitingOrder() {
		Session session = factory.getCurrentSession();
		String hql = "FROM PhieuDat";
		Query query = session.createQuery(hql);
		List<PhieuDat> list = query.list();
		return list;
}
	
	@RequestMapping(value="/manager_order")
	public String managerOrder(ModelMap model) {
		model.addAttribute("waitingOrder", this.getWaitingOrder());
		return "admin/order-manager/orderManager";
	}
	
//	@RequestMapping(value="/confirmedOrder")
//	public String confirmedOrder(ModelMap model) {
//		model.addAttribute("confirmedOrder", orderService.getConfirmedOrders());
//		return "order_manager/confirmedOrder";
//	}
//	
//	@RequestMapping(value="/denyOrder")
//	public String denyOrder(ModelMap model) {
//		model.addAttribute("denyOrder", orderService.getDenyOrders());
//		return "order_manager/denyOrder";
//	}
	
//	@RequestMapping(value="/orderDetails/{id}")
//	public String orderDetails(ModelMap model, @PathVariable("id") int id, HttpServletRequest request) {
//		
//		Session session = factory.getCurrentSession();
//		String hql = "FROM orderDetails WHERE order_id LIKE '" + id + "'";
//		Query query = session.createQuery(hql);
//		@SuppressWarnings("unchecked")
//		List<orderDetails> od = query.list();
//		model.addAttribute("od", od);
//		model.addAttribute("id", id);
//		model.addAttribute("size", od.size());
//		Order order = (Order) session.get(Order.class, id);
//		model.addAttribute("total", order.getTotal());
//		return "order_manager/orderDetails";
//	}
//	
//	
//	@RequestMapping(value="accept/{order_id}")
//	public String accept(ModelMap model, @PathVariable("order_id") int order_id) {
//		Session session = factory.openSession();
//		Transaction t = session.beginTransaction();
//		Order order = (Order) session.get(Order.class, order_id);
//		order.setOrder_status("1");
//		try {
//			session.update(order);
//			t.commit();
//			model.addAttribute("message", "Cập nhật thành công!");
//		}
//		catch(Exception e){
//			t.rollback();
//			model.addAttribute("message", "Cập nhật thất bại");
//		}
//		finally {
//			session.close();
//		}
//		return "redirect:/admin/manager_order.htm";
//	}
//	
//	
//	@RequestMapping(value="deny/{order_id}")
//	public String deny(ModelMap model, @PathVariable("order_id") int order_id) {
//		Session session = factory.openSession();
//		Transaction t = session.beginTransaction();
//		Order order = (Order) session.get(Order.class, order_id);
//		order.setOrder_status("0");
//		try {
//			session.update(order);
//			t.commit();
//			model.addAttribute("message", "Cập nhật thành công!");
//		}
//		catch(Exception e){
//			t.rollback();
//			model.addAttribute("message", "Cập nhật thất bại");
//		}
//		finally {
//			session.close();
//		}
//		return "redirect:/admin/manager_order.htm";
//	}
}
