package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.*;
import cs319.spring.proje.berk.service.ActivityService;
import cs319.spring.proje.berk.service.CommentService;
import cs319.spring.proje.berk.service.DescriptionService;
import cs319.spring.proje.berk.service.EvaluationBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "activities")
public class ActivityController {
    private final ActivityService activityService;
    private final DescriptionService descriptionService;
    private final EvaluationBarService evaluationBarService;
    private final CommentService commentService;

    @Autowired
    public ActivityController(ActivityService activityService, DescriptionService descriptionService, EvaluationBarService evaluationBarService, CommentService commentService) {
        this.activityService = activityService;
        this.descriptionService = descriptionService;
        this.evaluationBarService = evaluationBarService;
        this.commentService = commentService;
    }

    @GetMapping(path = "getActivityIdByName/{activityName}")
    public Long getActivityIdByName(@PathVariable("activityName") String activityName) {
        return activityService.getActivityIdByName(activityName);
    }

    @GetMapping(path = "listActivities")
    public List<Activity> listActivities() {
        return activityService.listActivities();
    }

    @GetMapping(path = "getActivity/{activityId}")
    public Activity getActivity(@PathVariable("activityId") Long id) {
        return activityService.getActivity(id);
    }

    @PutMapping(path = "addNewActivity")
    public void addNewActivity(@RequestBody Activity activity) {
        activityService.addNewActivity(activity);
    }

    // TODO: reimplement the method
    @DeleteMapping(path = "deleteActivity/{activityId}")
    public void deleteActivity(@PathVariable("activityId") Long id) {
        activityService.deleteActivity(id);
    }

    @PutMapping(path = "addDescriptionToActivity/{activityId}")
    public void addDescriptionToActivity(@PathVariable("activityId") Long activityId,
                                         @RequestBody Description description) {
        descriptionService.addNewDescription(description);

        Activity activity = activityService.getActivity(activityId);
        descriptionService.addActivityToDescription(activity, description);
        activityService.addDescriptionToActivity(description, activityId);
    }

    @PutMapping(path = "addEvaluationToActivity/{activityId}")
    public void addEvaluationToActivity(@PathVariable("activityId") Long activityId,
                                        @RequestBody EvaluationBar evaluationBar) {
        evaluationBarService.addNewEvaluationBar(evaluationBar);

        Activity activity = activityService.getActivity(activityId);
        activityService.addEvaluationToActivity(activity, evaluationBar);
        evaluationBarService.addActivityToEvaluation(activity, evaluationBar);
    }

    @PutMapping(path = "addCommentToActivity/{activityId}")
    public void addCommentToActivity(@PathVariable("activityId") Long activityId,
                                     @RequestBody Comment comment) {
        commentService.addNewComment(comment);

        Activity activity = activityService.getActivity(activityId);
        activityService.addCommentToActivity(activity, comment);
        commentService.addActivityToComment(activity, comment);
    }

    @GetMapping(path = "getParticipantList/{activityId}")
    public List<Student> getParticipantList(@PathVariable("activityId") Long activityId) {
        return activityService.getParticipantList(activityId);
    }
}