//用于用户的登录注册
//实现方式选择spring-security

/**
 * 认证
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class AuthController extends BaseController {

    @Autowired
    private JwtTokenFactory tokenFactory;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserService userService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/auth/user", method = RequestMethod.GET)

    public User getUser() throws ThingsboardException {
        try {
            SecurityUser securityUser = getCurrentUser();
            return userService.findUserById(securityUser.getId());
        } catch (Exception e) {
            throw handleException(e);
        }
    }
}
