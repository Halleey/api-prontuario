package com.api.prontuario.services.doctors;

import com.api.prontuario.dtos.DoctorDTO;
import com.api.prontuario.entities.Doctors;
import com.api.prontuario.repositories.DoctorRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DoctorImpl implements  DoctorsService{
    private final BCryptPasswordEncoder passwordEncoder;
    private final DoctorRepository doctorRepository;

    public DoctorImpl(BCryptPasswordEncoder passwordEncoder, DoctorRepository doctorRepository) {
        this.passwordEncoder = passwordEncoder;
        this.doctorRepository = doctorRepository;
    }
    @Override
    public void saveDoctor(DoctorDTO doctorDTO) {
        Doctors doctors = new Doctors();
        String encripted = passwordEncoder.encode(doctorDTO.getPassword());

        doctors.setName(doctorDTO.getName());
        doctors.setCrm(doctorDTO.getCrm());
        doctors.setPassword(encripted);
        doctors.setExpertise(doctorDTO.getExpertise());
        doctorRepository.save(doctors);
    }

}
