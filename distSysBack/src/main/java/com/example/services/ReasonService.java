package com.example.services;

import com.example.models.Reason;
import com.example.repositories.ReasonRepo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/reason")
public class ReasonService {

    @Resource
    ReasonRepo reasonRepo;

    @GetMapping("/all")
    public List<Reason> getAllReason()
    {
        return reasonRepo.getAllReason();
    }

    @GetMapping("/{id}")
    public Reason getReason(@PathVariable("id") Integer id)
    {
        return reasonRepo.getReason(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public String createReason(@RequestBody Reason reason)
    {
        return reasonRepo.createReason(reason);
    }

    @PutMapping("/update")
    @ResponseBody
    public String updateReason(@RequestBody Reason reason)
    {
        return reasonRepo.updateReason(reason);
    }

    @DeleteMapping("/delete")
    public String deleteReason(@RequestBody Reason reason)
    {
        return reasonRepo.deleteReason(reason);
    }
}
