package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.Activity;
import cs319.spring.proje.berk.entity.EvaluationBar;
import cs319.spring.proje.berk.repository.EvaluationBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class EvaluationBarService {
    private final EvaluationBarRepository evaluationBarRepository;

    @Autowired
    public EvaluationBarService(EvaluationBarRepository evaluationBarRepository) {
        this.evaluationBarRepository = evaluationBarRepository;
    }

    public List<EvaluationBar> listEvaluationBars() {
        return evaluationBarRepository.findAll();
    }

    public EvaluationBar getEvaluationBar(Long evaluationBarId) {
        EvaluationBar evaluationBar = evaluationBarRepository.findById(evaluationBarId).orElse(null);

        if(evaluationBar == null)
            throw new IllegalStateException("evaluationBar does not exist");

        return evaluationBar;
    }

    @Transactional
    public void addNewEvaluationBar(EvaluationBar evaluationBar) {
        EvaluationBar evaluationBarById = null;

        if(evaluationBar.getId() != null)
            evaluationBarById = evaluationBarRepository.findById(evaluationBar.getId()).orElse(null);

        // evaluation bar already exists in the repo
        if(evaluationBarById != null) {
            evaluationBarById.setActivity(evaluationBar.getActivity());
            evaluationBarById.setRate(evaluationBar.getRate());
            evaluationBarById.setStudent(evaluationBar.getStudent());
        }

        // evaluation bar does not exist in the repo
        else {
            evaluationBarRepository.save(evaluationBar);
        }
    }

    public void deleteEvaluationBar(Long evaluationBarId) {
        EvaluationBar evaluationBarById = evaluationBarRepository.findById(evaluationBarId).orElse(null);

        if(evaluationBarById == null)
            throw new IllegalStateException("evaluation bar does not exist");

        evaluationBarRepository.deleteById(evaluationBarId);
    }

    @Transactional
    public void addActivityToEvaluation(Activity activity, EvaluationBar evaluationBar) {
        List<EvaluationBar> evaluationList = activity.getEvaluationList();

        // if evaluation is in activity's evaluation list, add activity to that evaluation
        for (EvaluationBar bar : evaluationList) {
            if (Objects.equals(bar.getId(), evaluationBar.getId())) {
                evaluationBar.setActivity(activity);
                return;
            }
        }

        throw new IllegalStateException("no activity has the specified evaluation bar");
    }
}
