package nhn.academy.repository;

import nhn.academy.entity.CertificateIssue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateIssueRepository extends JpaRepository<CertificateIssue,Long> {
    List<CertificateIssue> findByCertificateConfirmationNumber(Long certificateConfirmationNumber);
}
