package com.project.marketplace.rest;


import com.google.gson.Gson;
import com.project.marketplace.entity.Complaint;
import com.project.marketplace.entity.Medecin;
import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Provider;
import com.project.marketplace.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/complaint")
public class ComplaintController {
    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }
    @PostMapping("/contactUs")
    public Complaint contactUs(@RequestParam("message") String message,@RequestParam("objet") String objet
            ,@RequestParam("email") String email,@RequestParam("name") String name){
        Complaint complaint = new Complaint();
        complaint.setName(name);
        complaint.setEmail(email);
        complaint.setMessage(message);
        complaint.setObjet(objet);
        complaint.setType(0);
        complaint.setDate(new Date());
        return this.complaintService.addComplaint(complaint);
    }
    @PutMapping("/setvue/{id}")
    public Complaint setVue(@PathVariable("id") long id){
        Complaint complaint = this.complaintService.getComplaint(id);
        complaint.setVue(true);
        return this.complaintService.addComplaint(complaint);
    }

    @PostMapping("/add")
    public Complaint addComplaint(@RequestParam("Complaint") String data){
        Complaint complaint = new Gson().fromJson(data, Complaint.class);
        complaint.setVue(false);
        complaint.setType(1);
        complaint.setDate(new Date());
        return this.complaintService.addComplaint(complaint);
    }

    @GetMapping("getAll")
    public List<Complaint> getAllComplaints() {
        return this.complaintService.getAllComplaints();
    }

    @GetMapping("getOwnedComplaint/{login}")
    public List<Complaint> getOwnedComplaint(@PathVariable("login") String login) {
        return this.complaintService.getOwnedComplaint(login);
    }

    @GetMapping("getSentComplaint/{login}")
    public List<Complaint> getSendComplaint(@PathVariable("login") String login) {
        return this.complaintService.getSentComplaint(login);
    }

    @GetMapping("get/{id}")
    public Complaint getComplaint(@PathVariable("id") long id) {
        return this.complaintService.getComplaint(id);
    }

    @GetMapping("getAllOf/{id}")
    public List<Complaint> getComplaintsOfProduct(@PathVariable("id") long id) {
        return this.complaintService.getComplaintOfProduct(id);
    }

    @DeleteMapping("deletecomplaint/{id}")
    public boolean deletecomplaint(@PathVariable("id") long id) {
        return this.complaintService.DeleteComplaint(id);
    }
}
