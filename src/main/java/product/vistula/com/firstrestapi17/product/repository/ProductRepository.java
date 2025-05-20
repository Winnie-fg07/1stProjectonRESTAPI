package product.vistula.com.firstrestapi17.product.repository;

import org.springframework.stereotype.Repository;
import product.vistula.com.firstrestapi17.product.domain.Product;

import java.util.*;

@Repository
    public class ProductRepository {

        protected final Map<Long, Product> map = new HashMap<>();
        protected long counter = 1;

        public Product save(Product entity) {
            setId(entity);
            return entity;
        }
        private Product setId(Product entity) {
            if(entity.getId() != null){
                map.put(entity.getId(),entity);
            }
                else
                {entity.setId(counter);
                    map.put(counter, entity);
            counter++;
        }
        return entity;}

        public Optional<Product> findById(long id) {
            return Optional.ofNullable(map.get(id));
        }

        public List<Product> findAll() {
            return new ArrayList<>(map.values());
        }

        public void deleteById(long id) {
            map.remove(id);
        }


    }



