package com.api.prontuario.config.web;


import com.api.prontuario.entities.Doctors;
import com.api.prontuario.repositories.DoctorRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final DoctorRepository doctorRepository;

    public CustomUserDetailsService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Doctors user = doctorRepository.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + name));

        return new UserDetailsImpl(user.getName(), user.role().name());
    }
}
