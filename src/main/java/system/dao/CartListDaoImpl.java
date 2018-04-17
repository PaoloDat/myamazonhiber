package system.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.model.CartList;

import javax.annotation.Resource;

@Transactional
@Repository("CartListDao")
public class CartListDaoImpl implements CartListDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CartList addCart(CartList cartList) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartList);
        return cartList;
    }

    public int getLastId() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("select cartlist.id FROM CartList cartlist ORDER BY cartlist.id DESC ");
        query.setMaxResults(1);
        return  (Integer)query.uniqueResult();
    }
}
