package com.study.repository;

import org.springframework.data.repository.CrudRepository;

import com.study.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Long>  {}
