package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.Activity;
import cs319.spring.proje.berk.entity.Club;
import cs319.spring.proje.berk.entity.Description;
import cs319.spring.proje.berk.repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class DescriptionService {
    private final DescriptionRepository descriptionRepository;
    private final VisualElementService visualElementService;

    @Autowired
    public DescriptionService(DescriptionRepository descriptionRepository, VisualElementService visualElementService) {
        this.descriptionRepository = descriptionRepository;
        this.visualElementService = visualElementService;
    }

    public List<Description> listDescriptions() {
        return descriptionRepository.findAll();
    }

    @Transactional
    public void addNewDescription(Description description) {
        Description descriptionById = null;

        if(description.getId() != null)
            descriptionById = descriptionRepository.findById(description.getId()).orElse(null);

        if(descriptionById != null) {
            descriptionById.setTextDescription(description.getTextDescription());
            descriptionById.setActivity(description.getActivity());
            descriptionById.setClub(description.getClub());
            descriptionById.setVisualElementsList(description.getVisualElementsList());
        }

        else
            descriptionRepository.save(description);
    }

    public void deleteDescription(Long id) {
        Description descriptionById = descriptionRepository.findById(id).orElse(null);

        if(descriptionById != null) {
            descriptionRepository.deleteById(id);
        }

        else {
            throw new IllegalStateException("description with id " + id + " does not exist");
        }
    }

    public Description getDescription(Long id) {
        Description descriptionById = descriptionRepository.findById(id).orElse(null);

        if(descriptionById == null) {
            throw new IllegalStateException("description with id " + id + " does not exist");
        }

        else {
            return descriptionById;
        }
    }

    public void addVisualElementToDescription(Long visualElementId, Long descriptionId) {
        Description description = descriptionRepository.findById(descriptionId).orElse(null);

        if(description == null)
            throw new IllegalStateException("description does not exist");
        description.getVisualElementsList().add(visualElementService.getVisualElement(visualElementId));
    }

    /*
    @Transactional
    public void addActivityToDescription(Activity activity, Description description) {
        if(activity.getActivityDescription() == description)
            description.setActivity(activity);
        else
            throw new IllegalStateException("activity description does not match description");
    }

     */

    /*
    @Transactional
    public void addClubToDescription(Description description, Club club) {
        if(Objects.equals(club.getClubDescription().getId(), description.getId())) {
            description.setClub(club);
        }

        throw new IllegalStateException("club does not have the specified description");
    }
     */
}
