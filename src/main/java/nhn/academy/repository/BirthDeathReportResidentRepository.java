package nhn.academy.repository;

import nhn.academy.dto.BirthDeathReportResidentDto;
import nhn.academy.dto.ResidentDto;
import nhn.academy.entity.BirthDeathReportResident;
import nhn.academy.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BirthDeathReportResidentRepository extends JpaRepository<BirthDeathReportResident,BirthDeathReportResident.Pk> {

    List<BirthDeathReportResident> findByResident(Resident resident);

    @Query("SELECT bdr FROM BirthDeathReportResident bdr WHERE bdr.resident = :serialNumber")
    List<BirthDeathReportResidentDto.BirthReportResidentDto> findBirthDetailsByResidentSerialNumber(Integer serialNumber);

    @Query("SELECT bdr FROM BirthDeathReportResident bdr WHERE bdr.resident = :serialNumber")
    List<BirthDeathReportResidentDto.DeathReportResidentDto> findDeathDetailsByResidentSerialNumber(Integer serialNumber);


}
