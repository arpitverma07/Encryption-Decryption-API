package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Transaction.Transaction;

@Repository
public interface RepositoryTrans extends JpaRepository<Transaction, Integer>{

}
