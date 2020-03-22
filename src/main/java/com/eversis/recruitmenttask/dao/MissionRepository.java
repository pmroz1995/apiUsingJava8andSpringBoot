package com.eversis.recruitmenttask.dao;

import com.eversis.recruitmenttask.dao.entity.Mission;
import com.eversis.recruitmenttask.dao.enums.ImageryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MissionRepository extends JpaRepository<Mission,Long> {

    @Query("SELECT u FROM Mission u WHERE u.missionName = ?1")
    Optional<Mission> findMissionByName(String missionName);

    @Query("SELECT u FROM Mission u WHERE u.imageryType = ?1")
    List<Mission> findMissionByImargeryType(ImageryType imageryType);

}
