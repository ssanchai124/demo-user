package com.example.user_api.repository;

import com.example.user_api.model.UserInfomation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInfomation, Integer> {
    @Query("select b from UserInfomation b where b.referenceCode = :referenceCode")
    List<UserInfomation> findAllByReferenceCode(@Param("referenceCode") String referenceCode);

}