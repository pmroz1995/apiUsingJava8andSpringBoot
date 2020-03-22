package com.eversis.recruitmenttask.services;

import com.eversis.recruitmenttask.dao.entity.Mission;

public interface MissionService {
    Mission save(Mission mission);

    Mission findMissionByName(String name);

    void editMission(Mission mission, long missionId);

    void deleteByName(String name);
}
