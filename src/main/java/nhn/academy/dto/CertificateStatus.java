package nhn.academy.dto;

import lombok.Getter;

@Getter
public class CertificateStatus {
    private final boolean birthCertificate;
    private final boolean deathCertificate;
    private final boolean familyRelationship;
    private final boolean idCard;

    public CertificateStatus(boolean birthCertificate
                            ,boolean deathCertificate
                            ,boolean familyRelationship
                            ,boolean idCard){
        this.birthCertificate = birthCertificate;
        this.deathCertificate = deathCertificate;
        this.familyRelationship = familyRelationship;
        this.idCard = idCard;
    }
}
