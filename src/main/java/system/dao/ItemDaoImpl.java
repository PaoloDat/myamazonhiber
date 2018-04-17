package system.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.model.Item;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("itemDao")
public class ItemDaoImpl implements ItemDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Item getItemById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
//        Item item = (Item) session.get(Item.class, new Integer(id));
        Query query = session.createQuery("from Item i where i.id = :id ");
        query.setParameter("id", id);
        Item item = (Item) query.uniqueResult();
        return item;
    }

    public List<Item> getItemList() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Item").list();
    }
}
