package nhn.academy.repository;

import nhn.academy.entity.FamilyRelationship;
import nhn.academy.entity.Resident;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface FamilyRelationshipRepositoryCustom {
    List<FamilyRelationship> findFamilyRelationshipBySerialNumber(Resident resident);
}
