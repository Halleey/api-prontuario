package com.api.prontuario.services.doctors;

import com.api.prontuario.dtos.DoctorDTO;
import com.api.prontuario.entities.Doctors;
import com.api.prontuario.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorImpl implements  DoctorsService{

    private final DoctorRepository doctorRepository;

    public DoctorImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    @Override
    public void saveDoctor(DoctorDTO doctorDTO) {
        Doctors doctors = new Doctors();
        doctors.setName(doctorDTO.getName());
        doctors.setCrm(doctorDTO.getCrm());
        doctors.setPassword(doctorDTO.getPassword());
        doctors.setExpertise(doctorDTO.getExpertise());
        doctorRepository.save(doctors);
    }

}
