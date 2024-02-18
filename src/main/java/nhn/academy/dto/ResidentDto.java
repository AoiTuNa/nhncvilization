package nhn.academy.dto;

import java.time.LocalDateTime;
import java.util.List;

public interface ResidentDto {
    Integer getResidentSerialNumber();
    String getName();
    String getResidentRegistrationNumber();
    String getGenderCode();

    List<ResidentBirthDto> getResidentBirthDto();

    List<ResidentDeathDto> getResidentDeathDto();

    interface ResidentBirthDto{
        LocalDateTime getBirthDate();
        String getBirthPlaceCode();
        String getRegistrationBaseAddress();
    }

    interface ResidentDeathDto{
        LocalDateTime getDeathDate();
        String getDeathPlaceCode();
        String getDeathPlaceAddress();

    }
}
