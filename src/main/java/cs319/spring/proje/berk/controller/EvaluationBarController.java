package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.EvaluationBar;
import cs319.spring.proje.berk.service.EvaluationBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "evaluationBars")
public class EvaluationBarController {
    private final EvaluationBarService evaluationBarService;

    @Autowired
    public EvaluationBarController(EvaluationBarService evaluationBarService) {
        this.evaluationBarService = evaluationBarService;
    }

    @GetMapping(path = "listEvaluationBars")
    public List<EvaluationBar> listEvaluationBars() {
        return evaluationBarService.listEvaluationBars();
    }

    @GetMapping(path = "getEvaluationBar/{evaluationBarId}")
    public EvaluationBar getEvaluationBar(@PathVariable("evaluationBarId") Long evaluationBarId) {
        return evaluationBarService.getEvaluationBar(evaluationBarId);
    }

    @PutMapping(path = "addNewEvaluationBar")
    public void addNewEvaluationBar(@RequestBody EvaluationBar evaluationBar) {
        evaluationBarService.addNewEvaluationBar(evaluationBar);
    }

    @DeleteMapping(path = "deleteEvaluationBar/{evaluationBarId}")
    public void deleteEvaluationBar(@PathVariable("evaluationBarId") Long evaluationBarId) {
        evaluationBarService.deleteEvaluationBar(evaluationBarId);
    }
}
