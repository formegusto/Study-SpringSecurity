package com.study.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.study.entity.Member;

public interface MemberRepository extends CrudRepository<Member, String> {
	Optional<Member> findByUemail(String userEmail);
}
