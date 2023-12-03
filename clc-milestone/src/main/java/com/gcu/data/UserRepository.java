// package com.gcu.data;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;

// import com.gcu.data.entity.OrderEntity;
// @Repository
// public interface OrdersRepository extends CrudRepository<UserEntity, Long>{

// 	@Override
// 	@Query("SELECT * FROM orders")
// 	public UserEntity findByUsername();
// }