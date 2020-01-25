package tomaszszewczyk.repositories;

import org.springframework.stereotype.Repository;
import tomaszszewczyk.entities.Shipper;

import java.util.List;

@Repository
public class ShipperRepository extends BaseRepository<Shipper> {

    public List<Shipper> findAll() {
        return query("select x from Shipper x");
    }

    public Shipper findByID(int id) {
        return entityManager.find(Shipper.class, id);
    }

    public Shipper save(Shipper shipper) {
        entityManager.persist(shipper);
        return shipper;
    }

    public void delete(int id) {
        entityManager.remove(findByID(id));
    }
}
