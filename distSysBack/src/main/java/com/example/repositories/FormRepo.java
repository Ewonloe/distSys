package com.example.repositories;

import com.example.models.Form;

import java.util.List;

public interface FormRepo {
    public List<Form> getAllForm();
    public Form getLatestForm();
    public String createForm(Form form);
    public Form getForm(Integer id);
    public String updateForm(Form form);
    public String deleteForm(Form form);
}
