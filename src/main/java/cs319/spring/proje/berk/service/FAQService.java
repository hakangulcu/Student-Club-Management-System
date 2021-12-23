package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.Club;
import cs319.spring.proje.berk.entity.FAQ;
import cs319.spring.proje.berk.repository.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class FAQService {
    private final FAQRepository faqRepository;

    @Autowired
    public FAQService(FAQRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    public List<FAQ> listFAQs() {
        return faqRepository.findAll();
    }

    public FAQ getFAQ(Long id) {
        FAQ faqById = faqRepository.findById(id).orElse(null);

        if(faqById == null) {
            throw new IllegalStateException("faq with id " + id + " does not exist");
        }

        else {
            return faqById;
        }
    }

    @Transactional
    public void addFAQ(FAQ faq) {
        FAQ faqById = faqRepository.findById(faq.getId()).orElse(null);

        if(faqById == null) {
            faqRepository.save(faq);
        }

        else {
            faqById.setQuestion(faq.getQuestion());
            faqById.setAnswer(faq.getAnswer());
        }
    }

    public void deleteFAQ(Long id) {
        FAQ faqById = faqRepository.findById(id).orElse(null);

        if(faqById == null) {
            throw new IllegalStateException("faq with id " + id + " does not exist");
        }

        else {
            faqRepository.deleteById(id);
        }
    }

    @Transactional
    public void addClubToFaq(Club club, FAQ faq) {
        for(int i = 0; i < club.getFaqList().size(); i++) {
            if(Objects.equals(club.getFaqList().get(i).getId(), faq.getId())) {
                faq.setClub(club);
                return;
            }
        }

        throw new IllegalStateException("club does not have the specified faq");
    }
}
