package com.eversis.recruitmenttask.controllers;

import com.eversis.recruitmenttask.dao.entity.Mission;
import com.eversis.recruitmenttask.exceptions.SupportingRuntimeError;
import com.eversis.recruitmenttask.services.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.eversis.recruitmenttask.exceptions.MessegeLibrary.INVALID_MISSION_NAME;
import static com.eversis.recruitmenttask.exceptions.MessegeLibrary.MISSION_ALREADY_EXISTS;

@RestController
@RequestMapping("/missionController")
public class MissionController {

    private MissionService missionService;

    @Autowired
    public MissionController(MissionService missionService){
        this.missionService = missionService;
    }


    @PostMapping("/postMission")
    public void postMission(@RequestBody Mission mission){
        try {
            missionService.save(mission);
        }catch (RuntimeException e){
            throw new SupportingRuntimeError(MISSION_ALREADY_EXISTS.format());
        }
    }

    @GetMapping("/getMission/{name}")
    public Mission getMission(@PathVariable String name){
        try {
            return missionService.findMissionByName(name);
        }catch (RuntimeException e){
             throw new SupportingRuntimeError(INVALID_MISSION_NAME.format());
        }
    }
    @PutMapping("/editMission/{missionId}")
    public void editMission(@RequestBody Mission mission, @PathVariable long missionId){
       try {
           missionService.editMission(mission,missionId);
       }catch (RuntimeException e){
           throw new SupportingRuntimeError(MISSION_ALREADY_EXISTS.format());
       }
    }


    @DeleteMapping("/delete/{name}")
    public void deleteMission(@PathVariable String name){
        missionService.deleteByName(name);
    }





}
