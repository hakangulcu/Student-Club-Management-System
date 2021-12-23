package cs319.spring.proje.berk.repository;

import cs319.spring.proje.berk.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    public Activity findActivityByActivityName(String activityName);
}
