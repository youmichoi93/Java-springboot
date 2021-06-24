package com.example.demo.service;

import com.example.demo.repository.JpaMemberRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

    @Configuration
    public class SpringConfig {

        private final EntityManager em;
        @Autowired
        public SpringConfig(EntityManager em){
            this.em = em;
        }



        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository());
        }
        @Bean
        public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
// return new JdbcMemberRepository(dataSource);
// return new JdbcTemplateMemberRepository(dataSource);
            return new JpaMemberRepository(em) {
                @Override
                public void clearStore() {

                }
            };
        }
    }