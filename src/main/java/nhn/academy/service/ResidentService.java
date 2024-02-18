package nhn.academy.service;

import nhn.academy.dto.ResidentNameOnly;
import nhn.academy.repository.ResidentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ResidentService {

    private final ResidentRepository residentRepository;

    public ResidentService(ResidentRepository residentRepository){
        this.residentRepository = residentRepository;
    }

    public void delete(Integer residentSerialNumber){
        //Todo 일단 돌려보고 관련 삭제가 안되면 삭제 하는걸로 잊지마세요 홍충표씨!
        residentRepository.deleteById(residentSerialNumber);
    }

    public Page<ResidentNameOnly> getAllBy(Pageable pageable){
        return residentRepository.getAllBy(pageable);
    }





}
