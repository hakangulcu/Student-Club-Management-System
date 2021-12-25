package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.VisualElement;
import cs319.spring.proje.berk.service.VisualElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "visualElements")
public class VisualElementController {
    private final VisualElementService visualElementService;

    @Autowired
    public VisualElementController(VisualElementService visualElementService) {
        this.visualElementService = visualElementService;
    }

    @GetMapping
    public List<VisualElement> listVisualElements() {
        return visualElementService.listVisualElements();
    }

    @GetMapping(path = "getVisualElement/{visualElementId}")
    public VisualElement getVisualElement(@PathVariable("visualElementId") Long visualElementId) {
        return visualElementService.getVisualElement(visualElementId);
    }

    @PutMapping(path = "addVisualElement")
    public void addVisualElement(@RequestBody VisualElement visualElement) {
        visualElementService.addVisualElement(visualElement);
    }

    @DeleteMapping(path = "{visualElementId}")
    public void deleteVisualElement(@PathVariable("visualElementId") Long id) {
        visualElementService.deleteVisualElement(id);
    }
}
