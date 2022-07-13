package jpabook.mingle.EmailTest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final RedisUtil redisUtil;

    @Value("${spring.mail.username}")
    private  String from;

    /**
     * 이메일 전송
     */

    @Transactional
    public void authEmail(EmailRequest request) {

        Random random = new Random();
        String authKey = String.valueOf(random.nextInt(888888) + 111111);
        sendAuthEmail(request.getEmail(), authKey);
    }




    private void sendAuthEmail(String email, String authKey) {
        String subject = "title";
        String text = "인증번호는" + authKey + "입니다.";

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(text, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        redisUtil.setDataExpire(authKey, email, 60*5L);
    }
}

