package team.foura.backend.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.foura.backend.model.dto.AdminDTO;
import team.foura.backend.model.request.AdminCreationRequest;
import team.foura.backend.service.AdminService;

import static team.foura.backend.controller.Endpoint.ADMIN;
import static team.foura.backend.controller.Endpoint.SIGNUP;

@RestController
@RequestMapping(value = ADMIN)
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(value = SIGNUP)
    public ResponseEntity<?> signUp(@Valid @RequestBody AdminCreationRequest creationRequest) {
            adminService.save(AdminDTO.initDTOFromRequest(creationRequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(creationRequest);
    }
}