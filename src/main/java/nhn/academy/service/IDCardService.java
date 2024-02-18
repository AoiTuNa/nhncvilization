package nhn.academy.service;

import nhn.academy.repository.*;
import nhn.academy.repository.impl.CertificateIssueRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class IDCardService {
    private final HouseholdMovementAddressRepository householdMovementAddressRepository;
    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;
    private final HouseholdRepository householdRepository;
    private final ResidentRepository residentRepository;
    private final CertificateIssueRepositoryCustom certificateIssueRepositoryCustom;

    public IDCardService(HouseholdCompositionResidentRepository householdCompositionResidentRepository
                        ,HouseholdRepository householdRepository
                        ,HouseholdMovementAddressRepository householdMovementAddressRepository
                        ,ResidentRepository residentRepository){
        this.householdMovementAddressRepository = householdMovementAddressRepository;
        this.householdCompositionResidentRepository = householdCompositionResidentRepository;
        this.householdRepository = householdRepository;
        this.residentRepository = residentRepository;
        certificateIssueRepositoryCustom = new CertificateIssueRepositoryImpl();
    }

    public boolean isIdCardByResidentSerialNumber(Integer serialNumber){
        return !certificateIssueRepositoryCustom.findCertificatesByIdCardByResidentSerialNumber(serialNumber).isEmpty();
    }

}
