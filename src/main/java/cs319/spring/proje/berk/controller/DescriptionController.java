package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.Description;
import cs319.spring.proje.berk.service.DescriptionService;
import cs319.spring.proje.berk.service.VisualElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "descriptions")
public class DescriptionController {
    private final DescriptionService descriptionService;
    private final VisualElementService visualElementService;

    @Autowired
    public DescriptionController(DescriptionService descriptionService, VisualElementService visualElementService) {
        this.descriptionService = descriptionService;
        this.visualElementService = visualElementService;
    }

    @GetMapping
    public List<Description> listDescriptions() {
        return descriptionService.listDescriptions();
    }

    @GetMapping(path = "{descriptionId}")
    public Description getDescription(@PathVariable("descriptionLayoutId") Long id) {
        return descriptionService.getDescription(id);
    }

    @PutMapping
    public void addNewDescription(@RequestBody Description description) {
        descriptionService.addNewDescription(description);
    }

    @DeleteMapping(path = "{descriptionId}")
    public void deleteDescription(
            @PathVariable("descriptionId") Long id) {
        descriptionService.deleteDescription(id);
    }

    @PutMapping(path = "addVisualElementToDescription/{visualElementId}/{descriptionId}")
    public void addVisualElementToDescription(@PathVariable("visualElementId") Long visualElementId,
                                              @PathVariable("descriptionId") Long descriptionId) {
        descriptionService.addVisualElementToDescription(visualElementId, descriptionId);
        Description description = descriptionService.getDescription(descriptionId);
        visualElementService.addDescriptionToVisualElement(description, visualElementId);
    }
}
