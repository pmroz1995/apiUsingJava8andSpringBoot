package com.eversis.recruitmenttask.services;

import com.eversis.recruitmenttask.dao.MissionRepository;
import com.eversis.recruitmenttask.dao.entity.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MissionServiceImpl implements MissionService{

    private MissionRepository missionRepository;

    @Autowired
    public MissionServiceImpl(MissionRepository missionRepository){
        this.missionRepository = missionRepository;
    }

    @Override
    public Mission save(Mission mission) {

        if(missionRepository.findMissionByName(mission.getMissionName()).isPresent()){
            throw new NoSuchElementException();
        }else {
            return missionRepository.save(mission);
        }
    }

    @Override
    public Mission findMissionByName(String name) {
        return missionRepository.findMissionByName(name).orElseThrow(RuntimeException::new);
    }

    @Override
    public void editMission(Mission mission, long missionId) {

        if(missionRepository.findById(missionId).isPresent()){

           Mission foundMission = Mission.fluentBuild()
                    .id(missionId)
                    .missionName(mission.getMissionName())
                    .imageryType(mission.getImageryType())
                    .startDate(mission.getStartDate())
                    .finishDate(mission.getFinishDate())
                    .products(mission.getProducts());

           missionRepository.save(foundMission);
        }else {
            throw new RuntimeException();
        }

    }

    @Override
    public void deleteByName(String name) {

       missionRepository.delete(missionRepository.findMissionByName(name)
               .orElseThrow(RuntimeException::new));

    }

}
