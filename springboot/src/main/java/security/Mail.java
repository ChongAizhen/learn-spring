/**
 * Created by Chong AiZhen on 17-12-31,下午6:37.
 */

//需要javax.mail.jar和javax.mail-api.jar
@Service
public class MailService {

    @Autowired
    private CuMailSettingMapper cuMailSettingMapper;

    public void sendMail(CmsUser user,int number, HttpSession session) throws MessagingException {
        JavaMailSenderImpl javaMailSender = configSender(session);
        //发送普通邮件
//        SimpleMailMessage mail = new SimpleMailMessage();
//        mail.setTo("xxx@163.com");//收件人邮箱地址
//        mail.setFrom("noreply@test.com");//收件人
//        mail.setSubject("spring自带javamail发送的邮件");//主题
//        mail.setText("hello this mail is from spring javaMail ");//正文
//        javaMailSender.send(mail);
        
        //发送模板邮件
        MimeMessage mimeMessage =  javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("noreply@test.com");
        helper.setTo("xxx@163.com");
        helper.setSubject("123");

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        Map<String, Object> model = new HashMap<>();
        model.put("username","test");
        String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,"resource/test.vm", "UTF-8", model);
        helper.setText(text,true);
        System.out.println("22222222");
        javaMailSender.send(mimeMessage);

    public JavaMailSenderImpl configSender(HttpSession session){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", true);
//        CuMailSetting cuMailSetting = getCuMailSetting(session);
//        javaMailSender.setHost(cuMailSetting.getMailhost());
//        javaMailSender.setPort(cuMailSetting.getMailport());
//        javaMailSender.setUsername(cuMailSetting.getMailusername());
//        javaMailSender.setPassword(cuMailSetting.getMailpassword());
        javaMailSender.setHost("smtpdm.xxx.com");
        javaMailSender.setPort(25);
        javaMailSender.setUsername("noreply@test.com");
        javaMailSender.setPassword("NoReply");
        javaMailSender.setJavaMailProperties(javaMailProperties);
        return javaMailSender;
    }

    public CuMailSetting getCuMailSetting(HttpSession session) {
        CuMailSetting cuMailSetting = new CuMailSetting();
        if (session.getAttribute("mailSetting")==null) {
            cuMailSetting = cuMailSettingMapper.select().get(0);
            session.setAttribute("mailSetting", cuMailSetting);
        } else {
            cuMailSetting = (CuMailSetting) session.getAttribute("mailSetting");
        }
        return cuMailSetting;
    }
}
