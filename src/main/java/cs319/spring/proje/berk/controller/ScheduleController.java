package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.Activity;
import cs319.spring.proje.berk.entity.Schedule;
import cs319.spring.proje.berk.service.ActivityService;
import cs319.spring.proje.berk.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final ActivityService activityService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService, ActivityService activityService) {
        this.scheduleService = scheduleService;
        this.activityService = activityService;
    }

    @GetMapping
    public List<Schedule> listSchedules() {
        return scheduleService.listSchedules();
    }

    @GetMapping(path = "{scheduleId}")
    public Schedule getSchedule(@PathVariable("scheduleId") Long id) {
        return scheduleService.getSchedule(id);
    }

    @PutMapping
    public void addNewSchedule(@RequestBody Schedule schedule) {
        scheduleService.addNewSchedule(schedule);
    }

    @DeleteMapping(path = "{scheduleId}")
    public void deleteSchedule(@PathVariable("scheduleId") Long id) {
        scheduleService.deleteSchedule(id);
    }

    @PutMapping(path = "addActivityToSchedule/{activityId}/{scheduleId}")
    public void addActivityToSchedule(@PathVariable("activityId") Long activityId,
                                      @PathVariable("scheduleId") Long scheduleId) {
        Activity activity = activityService.getActivity(activityId);
        Schedule schedule = scheduleService.getSchedule(scheduleId);
        scheduleService.addActivityToSchedule(activity, schedule);
        activityService.addScheduleToActivity(activity, schedule);
    }
}

