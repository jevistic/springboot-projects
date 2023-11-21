package com.example.demo.service;
import com.example.demo.model.Author;
import com.example.demo.model.LibraryStaff;
import com.example.demo.repository.LibraryStaffRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibraryStaffService extends BaseService<LibraryStaff, Integer> {

    @Autowired
    private LibraryStaffRepository libraryStaffRepository;

    public LibraryStaff updateLibraryStaff(Integer id, LibraryStaff updatedLibraryStaff){
        LibraryStaff existingLibraryStaff = libraryStaffRepository.findById(id).
                orElseThrow(()-> new RuntimeException("LibraryStaff does not exist with id " + id));
        
        existingLibraryStaff.setEmail(updatedLibraryStaff.getEmail());
        existingLibraryStaff.setName(updatedLibraryStaff.getName());
        existingLibraryStaff.setPhone(updatedLibraryStaff.getPhone());
        existingLibraryStaff.setStaffID(updatedLibraryStaff.getStaffID());
        existingLibraryStaff.setRole(updatedLibraryStaff.getRole());
        existingLibraryStaff.setUsername(updatedLibraryStaff.getUsername());
        existingLibraryStaff.setPassword(updatedLibraryStaff.getPassword());


        return libraryStaffRepository.save(existingLibraryStaff);
    }

}
