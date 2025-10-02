package com.daejinproject;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class testController {

    private final testService testService;

    // Thymeleaf 화면용
    @GetMapping("/board")
    public String list(Model model) {
        model.addAttribute("boards", testService.getAllBoard());
        return "board/list";
    }

    @GetMapping("/board/new")
    public String newForm() {
        return "board/form";
    }

    @PostMapping("/board")
    public String create(@ModelAttribute testEntity board) {
        testService.addBoard(board);
        return "redirect:/board";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("board", testService.getBoard(id));
        return "board/detail";
    }

    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable Long id) {
        testService.deleteBoard(id);
        return "redirect:/board";
    }

    // REST API용 (JSON)
    @GetMapping("/api/v1/board")
    @ResponseBody
    public List<testEntity> getAllBoard(){
        return testService.getAllBoard();
    }

    @GetMapping("/api/v1/board/{id}")
    @ResponseBody
    public testEntity getBoard(@PathVariable Long id){
        return testService.getBoard(id);
    }

    @PostMapping("/api/v1/board")
    @ResponseBody
    public testEntity addBoard(@RequestBody testEntity board){
        return testService.addBoard(board);
    }

    @PutMapping("/api/v1/board/{id}")
    @ResponseBody
    public testEntity updateBoard(@PathVariable Long id, @RequestBody testEntity board){
        return testService.updateBoard(id, board);
    }

    @DeleteMapping("/api/v1/board/{id}")
    @ResponseBody
    public void deleteBoard(@PathVariable Long id){
        testService.deleteBoard(id);
    }

}
