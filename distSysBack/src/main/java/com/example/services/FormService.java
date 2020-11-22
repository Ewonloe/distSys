package com.example.services;

import com.example.models.Form;
import com.example.repositories.FormRepo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/form")
public class FormService {

    @Resource
    FormRepo formRepo;

    @GetMapping("/all")
    public List<Form> getAllForm()
    {
        return formRepo.getAllForm();
    }

    @GetMapping("/{id}")
    public Form getForm(@PathVariable("id") Integer id)
    {
        return formRepo.getForm(id);
    }

    @GetMapping("/latest")
    public Form getLatestForm()
    {
        return formRepo.getLatestForm();
    }

    @PostMapping("/add")
    @ResponseBody
    public String createForm(@RequestBody Form form)
    {
        return formRepo.createForm(form);
    }

    @PutMapping("/update")
    @ResponseBody
    public String updateForm(@RequestBody Form form)
    {
        return formRepo.updateForm(form);
    }

    @DeleteMapping("/delete")
    public String deleteForm(@RequestBody Form form)
    {
        return formRepo.deleteForm(form);
    }
}
