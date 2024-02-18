package nhn.academy.controller;

import lombok.extern.slf4j.Slf4j;
import nhn.academy.dto.CertificateStatus;
import nhn.academy.dto.ResidentNameOnly;
import nhn.academy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("resident")
public class ResidentController implements BaseController{

    private final ResidentService residentService;

    private final BirthCertificateService birthCertificateService;
    private final DeathCertificateService deathCertificateService;
    private final FamilyRelationshipService familyRelationshipService;
    private final IDCardService idCardService;

    public ResidentController(ResidentService residentService
                            ,BirthCertificateService birthCertificateService,
                              DeathCertificateService deathCertificateService,
                              FamilyRelationshipService familyRelationshipService,
                              IDCardService idCardService){
        this.residentService = residentService;
        this.birthCertificateService = birthCertificateService;
        this.deathCertificateService = deathCertificateService;
        this.familyRelationshipService = familyRelationshipService;
        this.idCardService = idCardService;
    }

    @GetMapping("/list")
    public String list(Model model, Pageable pageable){
        Page<ResidentNameOnly> page = residentService.getAllBy(pageable);
        Map<Integer, CertificateStatus> certificateStatusMap = new HashMap<>();
        for (ResidentNameOnly resident : page.getContent()) {
            // 각 주민별로 증명서 유무 확인
            CertificateStatus status = new CertificateStatus(
                    birthCertificateService.isBirthCertificateByResidentSerialNumber(resident.getResidentSerialNumber()),
                    deathCertificateService.isDeathCertificateByResidentSerialNumber(resident.getResidentSerialNumber()),
                    familyRelationshipService.isFamilyRelationshipByResidentSerialNumber(resident.getResidentSerialNumber()),
                    idCardService.isIdCardByResidentSerialNumber(resident.getResidentSerialNumber())
            );
            certificateStatusMap.put(resident.getResidentSerialNumber(), status);
        }
        model.addAttribute("residents",page.getContent());
        model.addAttribute("page",page);
        model.addAttribute("certificateStatusMap",certificateStatusMap);

        return "resident/list";
    }
}
