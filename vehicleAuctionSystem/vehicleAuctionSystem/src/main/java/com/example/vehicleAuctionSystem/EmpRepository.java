package com.example.vehicleAuctionSystem;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<emp,Integer>{

//    @Query(
//            value = "SELECT * FROM USERS u WHERE u.status = 1",
//            nativeQuery = true)
//    Collection<User> findAllActiveUsersNative();

}
