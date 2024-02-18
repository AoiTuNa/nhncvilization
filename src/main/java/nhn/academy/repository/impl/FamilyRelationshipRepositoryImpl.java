package nhn.academy.repository.impl;

import nhn.academy.entity.FamilyRelationship;
import nhn.academy.entity.QFamilyRelationship;
import nhn.academy.entity.QResident;
import nhn.academy.entity.Resident;
import nhn.academy.repository.FamilyRelationshipRepositoryCustom;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
public class FamilyRelationshipRepositoryImpl extends QuerydslRepositorySupport implements FamilyRelationshipRepositoryCustom {
    public FamilyRelationshipRepositoryImpl() {
        super(FamilyRelationship.class);
    }

    @Override
    public List<FamilyRelationship> findFamilyRelationshipBySerialNumber(Resident resident) {
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;

        return from(familyRelationship)
                .where(familyRelationship.pk.baseResidentSerialNumber.eq(resident))
                .fetch();

    }
}
