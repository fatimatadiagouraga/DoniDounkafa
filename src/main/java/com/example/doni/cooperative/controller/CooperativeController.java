package com.example.doni.cooperative.controller;

import com.example.doni.cooperative.Cooperative;
import com.example.doni.cooperative.service.CooperativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class CooperativeController {
    @Autowired
    CooperativeService cooperativeService;

    @GetMapping("AllCooperative")
    public List<Cooperative> AllCooperative(){
        return cooperativeService.AllCooperative();
    }
    @GetMapping("CooperativeById/{id}")
    public Cooperative CooperativeById(@PathVariable("id") Long id){
        return cooperativeService.CooprativeById(id);
    }
    @PostMapping("AddCooperative")
    public Cooperative AddCooperative(@RequestBody Cooperative cooperative){
        return cooperativeService.AddCooperative(cooperative);
    }
    @PutMapping("UpdateCooperative/{id}")
    public Cooperative UpdateCooperative(@RequestBody Cooperative cooperative,@PathVariable("id") Long id){
        return cooperativeService.UpdateCooperative(cooperative,id);
    }
    @DeleteMapping("DeleteCooperative/{id}")
    public void DeleteCooperative(Long id){
        cooperativeService.DeleteCooperative(id);
    }
}
