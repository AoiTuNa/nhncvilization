package nhn.academy.repository.impl;

import nhn.academy.entity.CertificateIssue;
import nhn.academy.entity.QCertificateIssue;
import nhn.academy.entity.QResident;
import nhn.academy.repository.CertificateIssueRepositoryCustom;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@EnableJpaRepositories
public class CertificateIssueRepositoryImpl extends QuerydslRepositorySupport implements CertificateIssueRepositoryCustom {

    public CertificateIssueRepositoryImpl() {
        super(CertificateIssue.class);
    }

    @Override
    public List<CertificateIssue> findCertificatesByFamilyRelationshipByResidentSerialNumber(Integer residentSerialNumber) {
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;

        return from(certificateIssue)
                .where(certificateIssue.residentSerialNumber.eq(residentSerialNumber)
                        .and(certificateIssue.certificateTypeCode.eq("가족관계증명서")))
                .fetch();
    }

    @Override
    public List<CertificateIssue> findCertificatesByIdCardByResidentSerialNumber(Integer residentSerialNumber) {
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;

        return from(certificateIssue)
                .where(certificateIssue.residentSerialNumber.eq(residentSerialNumber)
                        .and(certificateIssue.certificateTypeCode.eq("주민등록등본")))
                .fetch();
    }

    @Override
    public List<CertificateIssue> findCertificatesByBirthCertificateByResidentSerialNumber(Integer residentSerialNumber) {
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;

        return from(certificateIssue)
                .where(certificateIssue.residentSerialNumber.eq(residentSerialNumber)
                        .and(certificateIssue.certificateTypeCode.eq("출생신고서")))
                .fetch();
    }

    @Override
    public List<CertificateIssue> findCertificatesByDeathCertificateByResidentSerialNumber(Integer residentSerialNumber) {
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;

        return from(certificateIssue)
                .where(certificateIssue.residentSerialNumber.eq(residentSerialNumber)
                        .and(certificateIssue.certificateTypeCode.eq("사망신고서")))
                .fetch();
    }
}
