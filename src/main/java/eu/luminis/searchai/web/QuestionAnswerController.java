package eu.luminis.searchai.web;

import eu.luminis.searchai.service.QuestionAnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class QuestionAnswerController {

    private final QuestionAnswerService questionAnswerService;

    public QuestionAnswerController(QuestionAnswerService questionAnswerService) {
        this.questionAnswerService = questionAnswerService;
    }

    @GetMapping
    public String getChatPage(QuestionForm questionForm, Model model) {
        model.addAttribute("messages", this.questionAnswerService.getConversationHistory());
        return "qna";
    }

    @PostMapping
    public String postChatMessage(QuestionForm questionForm, Model model) {
        this.questionAnswerService.answerQuestion(questionForm.getMessageText());
        questionForm.setMessageText("");
        model.addAttribute("messages", this.questionAnswerService.getConversationHistory());
        return "redirect:/qna";
    }

}

