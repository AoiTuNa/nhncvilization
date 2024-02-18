package nhn.academy.service;

import nhn.academy.repository.CertificateIssueRepositoryCustom;
import nhn.academy.repository.FamilyRelationshipRepository;
import nhn.academy.repository.FamilyRelationshipRepositoryCustom;
import nhn.academy.repository.ResidentRepository;
import nhn.academy.repository.impl.CertificateIssueRepositoryImpl;
import nhn.academy.repository.impl.FamilyRelationshipRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class FamilyRelationshipService {
    private final ResidentRepository residentRepository;
    private final FamilyRelationshipRepositoryCustom familyRelationshipRepositoryCustom;
    private final CertificateIssueRepositoryCustom certificateIssueRepositoryCustom;

    public FamilyRelationshipService(ResidentRepository residentRepository){
        this.residentRepository = residentRepository;
        familyRelationshipRepositoryCustom = new FamilyRelationshipRepositoryImpl();
        certificateIssueRepositoryCustom = new CertificateIssueRepositoryImpl();
    }
    public boolean isFamilyRelationshipByResidentSerialNumber(Integer serialNumber){
        return !certificateIssueRepositoryCustom.findCertificatesByIdCardByResidentSerialNumber(serialNumber).isEmpty();
    }


}
