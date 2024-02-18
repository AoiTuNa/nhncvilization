package nhn.academy.repository;

import nhn.academy.entity.HouseholdMovementAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseholdMovementAddressRepository extends JpaRepository<HouseholdMovementAddress,HouseholdMovementAddress.Pk> {

    List<HouseholdMovementAddress> findByPk_Household_HouseholdSerialNumber(Integer serialNumber);
}
