package nhn.academy.service;

import nhn.academy.repository.BirthDeathReportResidentRepository;
import nhn.academy.repository.CertificateIssueRepositoryCustom;
import nhn.academy.repository.FamilyRelationshipRepositoryCustom;
import nhn.academy.repository.ResidentRepository;
import nhn.academy.repository.impl.CertificateIssueRepositoryImpl;
import nhn.academy.repository.impl.FamilyRelationshipRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class DeathCertificateService {
    private final CertificateIssueRepositoryCustom certificateIssueRepositoryCustom;
    private final FamilyRelationshipRepositoryCustom familyRelationshipRepositoryCustom;
    private final ResidentRepository residentRepository;
    private final BirthDeathReportResidentRepository birthDeathReportResidentRepository;

    public DeathCertificateService(ResidentRepository residentRepository
                                    ,BirthDeathReportResidentRepository birthDeathReportResidentRepository){
        certificateIssueRepositoryCustom = new CertificateIssueRepositoryImpl();
        familyRelationshipRepositoryCustom = new FamilyRelationshipRepositoryImpl();
        this.residentRepository = residentRepository;
        this.birthDeathReportResidentRepository = birthDeathReportResidentRepository;
    }
    public boolean isDeathCertificateByResidentSerialNumber(Integer serialNumber){
        return !certificateIssueRepositoryCustom.findCertificatesByDeathCertificateByResidentSerialNumber(serialNumber).isEmpty();
    }
}
