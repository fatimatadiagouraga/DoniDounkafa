package com.example.doni.reserver.controller;


import com.example.doni.reserver.Reserver;
import com.example.doni.reserver.service.ReserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class ReserverController {
    @Autowired
    ReserverService reserverService;

    @GetMapping("AllReserver")
    public List<Reserver> AllReserver(){
        return reserverService.AllReserver();
    }
    @GetMapping("ReserverById/{id}")
    public Reserver ReserverById(@PathVariable("id") Long id){
        return  reserverService.ReserverById(id);
    }
    @PutMapping("UpdateReserver/{id}")
    public Reserver UpdateReserver(@RequestBody Reserver reserver, @PathVariable("id") Long id){
        return reserverService.UpdateReserver(reserver,id);
    }
    @PostMapping("AddReserver")
    public Reserver AddReserver(@RequestBody Reserver reserver){
        return reserverService.AddReserver(reserver);
    }
    @DeleteMapping("DeleteReserver/{id}")
    public void DeleteReserver(Long id){
        reserverService.DeleteReserver(id);
    }
}
