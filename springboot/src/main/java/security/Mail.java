@Service
public class MailService {

    @Autowired
    private CuMailSettingMapper cuMailSettingMapper;

    /**
     * 0:用户注册时通知管理员;
     * 1:下单、支付、取消/收货时提醒管理员;
     * 2:用户提交购买咨询时邮件提醒管理员;
     * 3:管理员回复时，给用户发邮件;
     */
    public void sendMail(CmsUser user,int number, HttpSession session) throws MessagingException {
        JavaMailSenderImpl javaMailSender = configSender(session);
//        SimpleMailMessage mail = new SimpleMailMessage();
//        mail.setTo("18363999928@163.com");//收件人邮箱地址
//        mail.setFrom("noreply@cloud.thundersoft.com");//收件人
//        mail.setSubject("spring自带javamail发送的邮件");//主题
//        mail.setText("hello this mail is from spring javaMail ");//正文
//        javaMailSender.send(mail);
        switch (number){
            case 0:
                MimeMessage mimeMessage =  javaMailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setFrom("noreply@cloud.thundersoft.com");
                helper.setTo("18363999928@163.com");
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
                break;
            case 1:

                break;
            case 2:

                break;
        }
    }

    public JavaMailSenderImpl configSender(HttpSession session){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", true);
//        CuMailSetting cuMailSetting = getCuMailSetting(session);
//        javaMailSender.setHost(cuMailSetting.getMailhost());
//        javaMailSender.setPort(cuMailSetting.getMailport());
//        javaMailSender.setUsername(cuMailSetting.getMailusername());
//        javaMailSender.setPassword(cuMailSetting.getMailpassword());
        javaMailSender.setHost("smtpdm.aliyun.com");
        javaMailSender.setPort(25);
        javaMailSender.setUsername("noreply@cloud.thundersoft.com");
        javaMailSender.setPassword("NoReply890");
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
