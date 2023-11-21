package com.example.demo.service;
import com.example.demo.model.Author;
import com.example.demo.model.LibraryMember;
import com.example.demo.repository.LibraryMemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibraryMemberService extends BaseService<LibraryMember, Integer>{
    
    @Autowired
    private LibraryMemberRepository libraryMemberRepository;

    public LibraryMember updateLibraryMember(Integer id, LibraryMember updatedLibraryMember){
        LibraryMember existingLibraryMember = libraryMemberRepository.findById(id).
                orElseThrow(()-> new RuntimeException("LibraryMember does not exist with id " + id));

        existingLibraryMember.setMemberID(updatedLibraryMember.getMemberID());
        existingLibraryMember.setAddress(updatedLibraryMember.getAddress());
        existingLibraryMember.setEmail(updatedLibraryMember.getEmail());
        existingLibraryMember.setName(updatedLibraryMember.getName());
        existingLibraryMember.setPhone(updatedLibraryMember.getPhone());
        existingLibraryMember.setMembershipType(updatedLibraryMember.getMembershipType());
        existingLibraryMember.setRegistrationDate(updatedLibraryMember.getRegistrationDate());

        return libraryMemberRepository.save(existingLibraryMember);
    }

}
