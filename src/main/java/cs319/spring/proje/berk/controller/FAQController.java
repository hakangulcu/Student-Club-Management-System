package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.FAQ;
import cs319.spring.proje.berk.service.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "faqs")
public class FAQController {
    private final FAQService faqService;

    @Autowired
    public FAQController(FAQService faqService) {
        this.faqService = faqService;
    }

    @GetMapping
    public List<FAQ> listFAQs() {
        return faqService.listFAQs();
    }

    @GetMapping(path = "{faqId}")
    public FAQ getFAQ(@PathVariable("faq") Long id) {
        return faqService.getFAQ(id);
    }

    @PutMapping
    public void addFAQ(@RequestBody FAQ faq) {
        faqService.addFAQ(faq);
    }

    @DeleteMapping(path = "{faqId}")
    public void deleteFAQ(@PathVariable("faqId") Long id) {
        faqService.deleteFAQ(id);
    }
}
