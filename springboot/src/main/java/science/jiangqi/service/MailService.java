package science.jiangqi.service;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Chong AiZhen on 17-12-31,下午6:37.
 */

//需要javax.mail.jar和javax.mail-api.jar
@Service
public class MailService {

    private String sender = "";

    public void sendMail(String mail, String subject, Map kvs, String velocityName) throws MessagingException {
        JavaMailSenderImpl javaMailSender = configSender();
//        SimpleMailMessage mail = new SimpleMailMessage();
//        mail.setTo("admin@thundersoft.com");//收件人邮箱地址
//        mail.setFrom("noreply@cloud.thundersoft.com");//收件人
//        mail.setSubject("spring自带javamail发送的邮件");//主题
//        mail.setText("hello this mail is from spring javaMail ");//正文
//        javaMailSender.send(mail);
        MimeMessage mimeMessage =  javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setFrom(sender);
        helper.setTo(mail);
        helper.setSubject(subject);

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty(Velocity.ENCODING_DEFAULT,"UTF-8");
        velocityEngine.setProperty(Velocity.INPUT_ENCODING,"UTF-8");
        velocityEngine.setProperty(Velocity.OUTPUT_ENCODING,"UTF-8");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        if (kvs == null) kvs = new HashMap<String,String>();
        String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, velocityName, "UTF-8", kvs);
        helper.setText(text,true);
        javaMailSender.send(mimeMessage);
    }

    public JavaMailSenderImpl configSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", true);
        javaMailSender.setHost("");
        javaMailSender.setPort(123);
        javaMailSender.setUsername("");
        javaMailSender.setPassword("");
        javaMailSender.setJavaMailProperties(javaMailProperties);
        return javaMailSender;
    }
}