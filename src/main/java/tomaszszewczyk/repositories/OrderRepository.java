package tomaszszewczyk.repositories;

import org.springframework.stereotype.Repository;
import tomaszszewczyk.entities.Order;

import java.util.List;

@Repository
public class OrderRepository extends BaseRepository<Order> {

    public int count() {
       return (Integer) entityManager.createQuery("select count(x) from Order x").getSingleResult();
    }

    public List<Order> findAll() {
        return query("select x from Order x");
    }

    public List<Order> findSlice(int start, int end) {
        return entityManager
                .createQuery("select x from Order x")
                .setFirstResult(start)
                .setMaxResults(end - start)
                .getResultList();
    }

    public Order findByID(int id) {
        return entityManager.find(Order.class, id);
    }

    public Order save(Order order) {
        entityManager.persist(order);
        return order;
    }

    public void delete(int id) {
        entityManager.remove(findByID(id));
    }
}
