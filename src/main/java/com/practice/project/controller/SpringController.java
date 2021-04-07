package com.practice.project.controller;

import com.practice.project.dao.ItemDao;
import com.practice.project.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/poll")
public class SpringController {
    private ItemDao itemDao;

    @Autowired
    public SpringController(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @GetMapping()
    public String test() {
        return "general";
    }

    @GetMapping("/questions/{number}")
    public String start(@PathVariable int number, Model model) {
        model.addAttribute("item", itemDao.show(number));
        return "questions";
    }

    @GetMapping("/questions")
    public String start() {
        return "general";
    }

    @PostMapping()
    public String selectItem(@ModelAttribute("item") Item item) {
        itemDao.saveIntoFile(item);

        int number = item.getNumber() + 1;

        if (number == itemDao.getItemsLength() + 1) {
            return "redirect:poll/result";
        }

        return "redirect:/poll/questions/" + number;
    }

    @GetMapping("/{number}")
    public String showQuestion(@PathVariable int number, Model model) {
        model.addAttribute("item", itemDao.show(1));
        return "present";
    }

    @GetMapping("/result")
    public String result(Model model) {

        model.addAttribute("result", itemDao.getResult());
//        model.addAttribute("answers", itemDao.getResultAnswers());
        return "result";
    }

    @GetMapping("show")
    public String showElements(Model model) {
        model.addAttribute("item", itemDao.show(1));
        return "present";
    }
}
