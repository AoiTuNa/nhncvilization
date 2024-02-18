package nhn.academy.dto;

import nhn.academy.entity.BirthDeathReportResident;
import nhn.academy.entity.Resident;

import java.time.LocalDateTime;
import java.util.List;

public interface BirthDeathReportResidentDto {
    BirthDeathReportResident.Pk getPk();

    Resident getResident();

    LocalDateTime getBirthDeathReportDate();

    String getEmailAddress();

    String getPhoneNumber();

    List<BirthReportResidentDto> getBirthReportResidentDto();

    List<DeathReportResidentDto> getDeathReportResidentDto();

    interface BirthReportResidentDto{
        String getBirthReportQualificationsCode();

    }
    interface DeathReportResidentDto{
        String getDeathReportQualificationsCode();

    }
}
