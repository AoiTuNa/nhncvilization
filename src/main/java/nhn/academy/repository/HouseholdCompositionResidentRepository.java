package nhn.academy.repository;

import nhn.academy.entity.HouseholdCompositionResident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseholdCompositionResidentRepository extends JpaRepository<HouseholdCompositionResident,HouseholdCompositionResident.Pk> {

    List<HouseholdCompositionResident> findByPk_Household_HouseholdSerialNumber(Integer householdSerialNumber);

    List<HouseholdCompositionResident> findByPk_Resident_ResidentSerialNumber(Integer residentSerialNumber);

}
