package jpabook.mingle.EmailTest;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("")
    public ResponseEntity<Void> authEmail(@RequestBody @Valid EmailRequest request) {
        emailService.authEmail(request);
        return ResponseEntity.ok().build();
    }
}
