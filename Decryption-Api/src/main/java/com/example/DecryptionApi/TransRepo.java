package com.example.DecryptionApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransRepo extends JpaRepository<Transaction, Integer>{

}
