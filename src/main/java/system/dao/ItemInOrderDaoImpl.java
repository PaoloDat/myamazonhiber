package system.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.model.Cart;
import system.model.ItemInOrder;

import javax.annotation.Resource;

@Transactional
@Repository("itemInOrderDao")
public class ItemInOrderDaoImpl implements ItemInOrdertDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addtoDb(ItemInOrder itemInOrder) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(itemInOrder);


    }
}
