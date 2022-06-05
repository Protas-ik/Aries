package com.example.aries.repos;

import com.example.aries.domain.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepo extends JpaRepository<Employer, Long> {
    //List<Employer> findEmployersByBrigadeId(Long brigadeId);
    //Employer findEmployerByBrigadeId(Long )

}
