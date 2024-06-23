package gestao_vagas.modules.company.controllers;

import gestao_vagas.modules.company.dto.CreateJobDTO;
import gestao_vagas.modules.company.entities.JobEntity;
import gestao_vagas.modules.company.useCases.CreateJobsUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/company/job")
public class JobController {
    @Autowired
    private CreateJobsUseCase createJobsUseCase;

    @PostMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    public JobEntity create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
        var companyId = request.getAttribute("company_id");
        var jobEntity = JobEntity.builder()
                .benefits(createJobDTO.getBenefits())
                .companyId(UUID.fromString(companyId.toString()))
                .description(createJobDTO.getDescription())
                .level(createJobDTO.getLevel())
                .build();
        return createJobsUseCase.execute(jobEntity);
    }
}
