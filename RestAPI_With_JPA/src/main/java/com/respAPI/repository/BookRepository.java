package com.respAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.respAPI.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	

}
