package nhn.academy.repository;


import nhn.academy.dto.ResidentDto;
import nhn.academy.dto.ResidentNameOnly;
import nhn.academy.entity.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResidentRepository extends JpaRepository<Resident,Integer> {

    List<Resident> findByResidentSerialNumber(Integer serialNumber);

    @Query("SELECT r FROM Resident r WHERE r.residentSerialNumber = :serialNumber")
    List<ResidentDto.ResidentBirthDto> findBirthDetailsByResidentSerialNumber(Integer serialNumber);

    @Query("SELECT r FROM Resident r WHERE r.residentSerialNumber = :serialNumber")
    List<ResidentDto.ResidentDeathDto> findDeathDetailsByResidentSerialNumber(Integer serialNumber);

    Page<ResidentNameOnly> getAllBy(Pageable pageable);
}
