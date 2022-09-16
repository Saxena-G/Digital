package com.application.rerpository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.model.Author;

@Repository
public interface AuthorListRepository extends JpaRepository<Author, Integer>{

}

