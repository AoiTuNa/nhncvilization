package nhn.academy.repository;

import nhn.academy.entity.Household;
import nhn.academy.entity.HouseholdMovementAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseholdRepository extends JpaRepository<Household,Integer> {
    List<Household> findByHouseholdSerialNumberLike(Integer householdSerialNumber);

}
