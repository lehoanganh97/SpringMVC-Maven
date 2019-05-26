package com.servicingportal.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.OrderServiceDAO;
import com.servicingportal.entity.OrderService;

@Transactional
public class OrderServiceDAOImpl implements OrderServiceDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderService> listOrderService() {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<OrderService> list = session.createQuery("from OrderService").list();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean createOrderServce(OrderService orderService) {
		// TODO Auto-generated method stub
		System.out.println("Hello0\n");
		Transaction transaction = null;
		try {
			System.out.println("Hello1\n");
			Session session = this.sessionFactory.getCurrentSession();
			transaction  = session.beginTransaction();
			session.persist(orderService);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			System.out.println("Exception here: " + e.getMessage());
			return false;
		}
	}

	@Override
	public int getMaxOrderServiceID() {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(os.orderID) from OrderService os ";
			Query query = session.createQuery(sql);
			Integer orderID = (Integer) query.uniqueResult();
			if (orderID == null) {
				return -1;
			}
			return orderID;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public OrderService getOrderServicebyID(int iorderID) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			OrderService order = (OrderService) session.get(OrderService.class, iorderID);
			return order;
		} catch (Exception e) {
			return null;
		}
	}

	// Đã check
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderService> getOrderServicebyPartnerID(int partnerID) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select * from orderservice os left join servicepost sp on os.ServicePostID = sp.ServicePostID where sp.PartnerID = "
					+ partnerID;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(OrderService.class);
			List<OrderService> list = query.list();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	// Đã check
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderService> getOrderServiceInAcceptbyPartnerID(int partnerID) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select * from orderservice os left join servicepost sp on os.ServicePostID = sp.ServicePostID where sp.PartnerID = "
					+ partnerID + " and os.IsAccept = " + 0;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(OrderService.class);
			List<OrderService> list = query.list();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	// đã check
	@Override
	public int acceptOrderService(int orderServiceID) {
		try {
			Session session = this.sessionFactory.getCurrentSession();

			String sql = "UPDATE orderservice set IsAccept = 1, OrderStatus = 1, AcceptDate = '" + LocalDateTime.now().toString()
					+ "'WHERE OrderID = " + orderServiceID;
			SQLQuery query = session.createSQLQuery(sql);
			int result = query.executeUpdate();

			if (result <= 0) {
				return -1;
			}
			return result;
		} catch (Exception e) {
			return -1;
		}
	}

	// đã check
	// nếu không có partnerid hay customerid thì truyền 0 cho tham số đó.
	// Bắt buộc phải có một trong hai tham số partnerid hoặc customerid
	@Override
	public int deleteOrderService(int orderServiceID, int partnerID, int customerID) {
		try {
			String reason = "";
			if (partnerID == 0){
				reason = "partner";
			} else if (customerID == 0) {
				reason = "customer";
			}
			
			if (reason.length() == 0) return -1;
			
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "UPDATE orderservice set isDelete = 1, DeleteDate = '" + LocalDateTime.now().toString()
					+ "',OrderStatus = -1" // Khi deleteOrder thì stastus chuyển sang bị hủy
					+ ", DeleteNote = '" + reason + "' WHERE orderID = " + orderServiceID;
			SQLQuery query = session.createSQLQuery(sql);;
			@SuppressWarnings("unused")
			int result ;
			// Loc edit 21/01/2019
			// Check status order trước khi thực hiện deleteOrder
			//Trường hợp đơn hàng dã hoàn thành
			if (checkOrderStatus(orderServiceID) == 3) {
				return -10; // Không cho hủy
			}
			
			//Trường hợp khách hàng đã thanh toán
			if (checkOrderStatus(orderServiceID) == 2) {  
				// Nếu thanh toán online - trả = internet banking - thì bên mình chịu phí
				if(reason=="customer") {
					result = query.executeUpdate();
					return -9;// Khách hàng hủy đơn 
				}else { 
					result = query.executeUpdate();
					return -8;// Đối tác hủy đơn
				}
			} 
			
			//Trường hợp đối tác đã xác nhận đơn hàng
			if(checkOrderStatus(orderServiceID) == 1) {
				result = query.executeUpdate();
				return -7;
			}
			return -1;
		} catch (Exception e) {
			return -1;
		}
	}

	// Đã check
	// false là IsAccept = 0 - đơn hàng chưa xác nhận
	// true là IsAccept = 1 - đơn hàng đã xác nhận
	@Override
	public boolean checkOrderIsAccept(int iorderServiceID) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "SELECT os.IsAccept FROM orderservice os WHERE os.OrderID = " + iorderServiceID;
			SQLQuery query = session.createSQLQuery(sql);
			boolean result = (boolean) query.uniqueResult();
			return result; 						
		} catch (Exception e) {
			return false;
		}
	}

	// Đã check
	// false là isDelete = 0 - đơn hàng không bị hủy
	// true là isDelete = 1 - đơn hàng đã bị hủy
	@Override
	public boolean checkOrderIsDelete(int iorderServiceID) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "SELECT os.IsDelete FROM orderservice os WHERE os.OrderID = " + iorderServiceID;
			SQLQuery query = session.createSQLQuery(sql);
			boolean result = (boolean) query.uniqueResult();
			return result;
		} catch (Exception e) {
			return false;
		}
	}

	//Đã check
	// result = -1 -> order đã bị hủy
	// result =  0 -> chờ accept
	// result =  1 -> đã accept (chờ thanh toán)
	// result =  2 -> đã thanh toán
	// result =  3 -> đơn hàng đã hoàn thành
	@Override
	public int checkOrderStatus(int iorderServiceID) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "SELECT os.OrderStatus FROM orderservice os WHERE os.OrderID = " + iorderServiceID;
			SQLQuery query = session.createSQLQuery(sql);
			int result = (int) query.uniqueResult();
			return result; 
		} catch (Exception e) {
			return -1;
		}
	}
}
