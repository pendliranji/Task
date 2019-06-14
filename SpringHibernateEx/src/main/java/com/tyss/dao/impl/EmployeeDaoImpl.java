package com.tyss.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tyss.dao.IEmployeeDao;
import com.tyss.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	private HibernateTemplate ht;

	@Autowired
	private SessionFactory sf;

	public Integer saveEmp(Employee e) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(e);
	}

	@Override
	public void deleteEmp(Integer id) {
		Employee e = new Employee();
		e.setEmpId(id);
		ht.delete(e);
	}

	@Override
	public Employee getoneemployee(Integer id) {
		return ht.get(Employee.class, id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return ht.loadAll(Employee.class);
	}

	public void updateEmp(Employee e) {
		ht.update(e);
	}

	public Employee getEmpByEmail(String usermail) {
		String hql = "  from com.tyss.model.Employee where empMail=?";

		Query q = sf.getCurrentSession().createQuery(hql);
		q.setParameter(0, usermail);
		Employee li = (Employee) q.uniqueResult();

		return li;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isEmailExists(String email) {

		List<Long> count = (List<Long>) ht.findByCriteria(DetachedCriteria.forClass(Employee.class)
				.setProjection(Projections.rowCount()).add(Restrictions.eq("empMail", email)));

		boolean c = count.get(0) != 0 ? true : false;
		return c;

	}

	@Override
	public boolean checking(String mail, String pass) {

		// boolean decision=false;

		List<Long> count = (List<Long>) ht
				.findByCriteria(DetachedCriteria.forClass(Employee.class).setProjection(Projections.rowCount())
						.add(Restrictions.and(Restrictions.eq("empMail", mail), Restrictions.eq("empPwd", pass))));

		boolean c = count.get(0) != 0 ? true : false;

		return c;
	}

}
