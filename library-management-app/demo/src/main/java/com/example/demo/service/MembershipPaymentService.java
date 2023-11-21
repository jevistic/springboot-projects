package com.example.demo.service;

import com.example.demo.model.AuthorBook;
import com.example.demo.model.MembershipPayment;
import com.example.demo.repository.MembershipPaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MembershipPaymentService extends BaseService<MembershipPayment, Integer> {
    @Autowired
    private MembershipPaymentRepository membershipPaymentRepository;

    public MembershipPayment updateMembershipPayment (Integer id, MembershipPayment updatedMembershipPayment) {
        MembershipPayment existingMembershipPayment = membershipPaymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AuthorBook not found with id: " + id));

        existingMembershipPayment.setPaymentDate(updatedMembershipPayment.getPaymentDate());
        existingMembershipPayment.setMembershipPeriod(updatedMembershipPayment.getMembershipPeriod());
        existingMembershipPayment.setPaymentMethod(updatedMembershipPayment.getPaymentMethod());
        existingMembershipPayment.setAmount(updatedMembershipPayment.getAmount());
        existingMembershipPayment.setFeeID(updatedMembershipPayment.getFeeID());
        existingMembershipPayment.setLibraryStaff(updatedMembershipPayment.getLibraryStaff());
        existingMembershipPayment.setMemberID(updatedMembershipPayment.getMemberID());

        return membershipPaymentRepository.save(existingMembershipPayment);
    }
}
