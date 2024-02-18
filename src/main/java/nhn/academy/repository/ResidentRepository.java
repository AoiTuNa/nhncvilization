package nhn.academy.repository;


import nhn.academy.dto.ResidentDto;
import nhn.academy.dto.ResidentNameOnly;
import nhn.academy.entity.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResidentRepository extends JpaRepository<Resident,Integer> {

    Page<ResidentNameOnly> getAllBy(Pageable pageable);

}
