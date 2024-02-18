package nhn.academy.repository;

import nhn.academy.entity.CertificateIssue;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CertificateIssueRepositoryCustom {
    List<CertificateIssue> findCertificatesByFamilyRelationshipByResidentSerialNumber(Integer residentSerialNumber);
    List<CertificateIssue> findCertificatesByIdCardByResidentSerialNumber(Integer residentSerialNumber);
    List<CertificateIssue> findCertificatesByBirthCertificateByResidentSerialNumber(Integer residentSerialNumber);
    List<CertificateIssue> findCertificatesByDeathCertificateByResidentSerialNumber(Integer residentSerialNumber);
}
