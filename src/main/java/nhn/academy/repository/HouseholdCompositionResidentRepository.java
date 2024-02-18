package nhn.academy.repository;

import nhn.academy.entity.HouseholdCompositionResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdCompositionResidentRepository extends JpaRepository<HouseholdCompositionResident,HouseholdCompositionResident.Pk> {
}
