package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.MembershipPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membershippayment")
public class MembershipPaymentController extends BaseController<MembershipPayment>{
    @Autowired
    private MembershipPaymentService membershipPaymentService;


    @GetMapping("/{id}")
    public MembershipPayment getMembershipPaymentById(@PathVariable Integer id){
        return membershipPaymentService.getById(id);
    }


    @PostMapping("/")
    public ResponseEntity<MembershipPayment> createMembershipPayment(@RequestBody MembershipPayment membershipPayment) {
        return create(membershipPayment);
    }

    @PutMapping("/{id}")
    public MembershipPayment updateMembershipPayment(@PathVariable int id, @RequestBody MembershipPayment membershipPayment) {
        return membershipPaymentService.updateMembershipPayment(id, membershipPayment);
    }

    @DeleteMapping("/{id}")
    public void deleteMembershipPayment(@PathVariable int id) {
        delete(id);
    }
    @GetMapping("/")
    public List<MembershipPayment> getAllMembershipPayments(){
        return membershipPaymentService.getAll();
    }
}
