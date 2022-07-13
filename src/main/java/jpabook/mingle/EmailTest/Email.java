package jpabook.mingle.EmailTest;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
@RequiredArgsConstructor
public class Email implements ApplicationRunner {


    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private  String from;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        MimeMessage m = mailSender.createMimeMessage();
        MimeMessageHelper h = new MimeMessageHelper(m, "UTF-8");
        h.setFrom(from);
        h.setTo("leojung0909@gmail.com");
        h.setSubject("test");
        h.setText("verification");
        mailSender.send(m);
    }
}
