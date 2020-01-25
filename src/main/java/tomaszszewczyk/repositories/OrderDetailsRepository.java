package tomaszszewczyk.repositories;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import tomaszszewczyk.entities.OrderDetail;

import java.util.List;

@Repository
public class OrderDetailsRepository extends BaseRepository<OrderDetail> {
    public List<OrderDetail> findAll() {
        return query("select x from OrderDetail x");
    }

    public List<OrderDetail> findByOrder(int id) {
        return entityManager
                .createNativeQuery(String.format("{\"OrderID\": %d}", id), OrderDetail.class)
                .getResultList();
    }

    public OrderDetail findByID(ObjectId id) {
        return entityManager.find(OrderDetail.class, id);
    }

    public OrderDetail save(OrderDetail order) {
        entityManager.persist(order);
        return order;
    }

    public void delete(ObjectId id) {
        entityManager.remove(findByID(id));
    }
}
