package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.Activity;
import cs319.spring.proje.berk.entity.Club;
import cs319.spring.proje.berk.entity.Schedule;
import cs319.spring.proje.berk.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> listSchedules() {
        return scheduleRepository.findAll();
    }

    @Transactional
    public void addNewSchedule(Schedule schedule) {
        Schedule scheduleById = scheduleRepository.findById(schedule.getId()).orElse(null);

        if(scheduleById == null) {
            scheduleRepository.save(schedule);
        }

        else {
            // update properties of schedule
        }
    }

    public void deleteSchedule(Long id) {
        Schedule scheduleById = scheduleRepository.findById(id).orElse(null);

        if(scheduleById == null) {
            throw new IllegalStateException("schedule with id " + id + " does not exist");
        }

        else {
            scheduleRepository.deleteById(id);
        }
    }

    public Schedule getSchedule(Long id) {
        Schedule scheduleById = scheduleRepository.findById(id).orElse(null);

        if(scheduleById == null) {
            throw new IllegalStateException("schedule with id " + id + " does not exist");
        }

        else {
            return scheduleById;
        }
    }

    @Transactional
    public void addActivityToSchedule(Activity activity, Schedule schedule) {
        schedule.getActivityList().add(activity);
    }
}
