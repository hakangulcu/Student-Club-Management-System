package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.Description;
import cs319.spring.proje.berk.entity.VisualElement;
import cs319.spring.proje.berk.repository.VisualElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class VisualElementService {
    private final VisualElementRepository visualElementRepository;

    @Autowired
    public VisualElementService(VisualElementRepository visualElementRepository) {
        this.visualElementRepository = visualElementRepository;
    }

    public List<VisualElement> listVisualElements() {
        return visualElementRepository.findAll();
    }

    @Transactional
    public void addVisualElement(VisualElement visualElement) {
        VisualElement visualElementById = visualElementRepository.findById(visualElement.getId()).orElse(null);

        // the visual element does not exist in the repo
        if(visualElementById == null) {
            visualElementRepository.save(visualElementById);
        }

        else {
            visualElementById.setElementPath(visualElement.getElementPath());
            visualElementById.setElementDescription(visualElement.getElementDescription());
            visualElementById.setDescription(visualElement.getDescription());
        }
    }

    public void deleteVisualElement(Long id) {
        VisualElement visualElementById = visualElementRepository.findById(id).orElse(null);

        if(visualElementById == null)
            throw new IllegalStateException("visual element does not exist");

        visualElementRepository.deleteById(id);
    }

    public VisualElement getVisualElement(Long visualElementId) {
        VisualElement visualElement = visualElementRepository.findById(visualElementId).orElse(null);

        if(visualElement == null)
            throw new IllegalStateException("visual element does not exist");

        return visualElement;
    }

    @Transactional
    public void addDescriptionToVisualElement(Description description, Long visualElementId) {
        List<VisualElement> visualElementList = description.getVisualElementsList();

        for(VisualElement visualElement : visualElementList) {
            if(Objects.equals(visualElement.getId(), visualElementId)) {
                visualElement.setDescription(description);
                return;
            }
        }

        throw new IllegalStateException("description does not have visual element");
    }
}
