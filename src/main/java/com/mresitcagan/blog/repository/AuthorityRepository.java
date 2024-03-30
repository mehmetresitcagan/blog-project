package com.mresitcagan.blog.repository;

import com.mresitcagan.blog.model.Account;
import com.mresitcagan.blog.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
