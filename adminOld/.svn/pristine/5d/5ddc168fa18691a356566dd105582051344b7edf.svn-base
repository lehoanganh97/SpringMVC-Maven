package com.blackhole.dao;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.Query;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.blackhole.entities.EmployeeAccount;
import com.blackhole.entities.FieldService;
import com.blackhole.entities.Role;

@Repository
public class AdminActionDAOImpl implements AdminActionDAO {
	@Autowired
	private SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeAccount> getStaffs(){
		//get the current hibernate session
		Session session = factory.getCurrentSession();
		  
		// create a query to select all orders
		String sql="FROM EmployeeAccount";
		Query theQuery = session.createQuery(sql);
		   
		// execute query and get result list
//		List<EmployeeAccount> staffs = theQuery.getResultList();
		  
		// return the result
		
		return theQuery.list();
	}
	@Override
	public void saveStaff(EmployeeAccount employeeAccount) {
		// get the current hibernate session
		Session session = factory.getCurrentSession();
		
		// create/update  the EmployeeAccount object to the database table
		session.saveOrUpdate(employeeAccount);
	}
	
	@Override
	public EmployeeAccount getStaff(int theId) {
		// get the current hibernate session
	    Session session = factory.getCurrentSession();
	    
	    // get the staff using the passed empId (primary key)
	    return session.get(EmployeeAccount.class, theId);
	}
	
	@Override
    public void deleteStaff(int theId) {
		// get the current hibernate session
	    Session session = factory.getCurrentSession();
	    
	    // delete the order using the passed id (primary key)
	    Query theQuery = session.createQuery("delete from EmployeeAccount where empId=:Id");
	    theQuery.setParameter("Id", theId);
	    theQuery.executeUpdate();
	}
	
	
	// GET ONLY ID AND NAME OF LIST ROLE ENTITY TO VIEW
	@Override
	public List<Role> getAllRolesToCreateAccount(){
		Session session = factory.getCurrentSession();
		String sql = "Select R.roleId, R.roleName From Role R";
		
		List<Object[]> roles = (List<Object[]>) session.createQuery(sql).list();
		List<Role> rolesResult = new ArrayList();
		
		for(Object[] role : roles) {
			Role r = new Role();
			r.setRoleId((Integer) role[0]);
			r.setRoleName((String) role[1]);
			rolesResult.add(r);
		}
		
		return rolesResult;
	}

	
	// GET ONLY ID AND NAME OF LIST FIELD ENTITY TO VIEW
	@Override
	public List<FieldService> getAllFieldsToCreateAccount(){
		Session session = factory.getCurrentSession();
		String sql = "Select F.fserviceId, F.fserviceName From FieldService F";
		
		List<Object[]> fields = (List<Object[]>) session.createQuery(sql).list();
		List<FieldService> rolesResult = new ArrayList();
		
		for(Object[] field : fields) {
			FieldService f = new FieldService();
			f.setFserviceId((Integer) field[0]);
			f.setFserviceName((String) field[1]);
			rolesResult.add(f);
		}
		return rolesResult;
	}
	
	
	//get role of staff
	@Override
	public Role getRole(int theId) {
		// get the current hibernate session
	    Session session = factory.getCurrentSession();
	    
	    return session.get(Role.class, theId);
	}
	
//	//get role of staff to view
//	@Override
//	public Role getRoleToView(int theId) {
//		// get the current hibernate session
//	    Session session = factory.getCurrentSession();
//	    String sql = "Select R.roleId, R.roleName From Role R Where R.roleId = :theId";
//	    
//	    SQLQuery query = session.createSQLQuery(sql);
//	    
//	    query.setParameter("theId", theId);
//	    
//	    return query.list().get(0);
//	}
	
}
