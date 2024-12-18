package ait.cohort49.shop.controller;

import ait.cohort49.shop.model.dto.ProductDTO;
import ait.cohort49.shop.model.entity.Role;
import ait.cohort49.shop.model.entity.User;
import ait.cohort49.shop.repository.RoleRepository;
import ait.cohort49.shop.repository.UserRepository;
import ait.cohort49.shop.security.dto.LoginRequestDTO;
import ait.cohort49.shop.security.dto.TokenResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductControllerTest {

    @LocalServerPort //Запоминает сервер на котором был запущен
    private int port;

    private TestRestTemplate template;
    private HttpHeaders headers;

    private ProductDTO testProduct;

    @Autowired // Junit поэтому @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    private String adminAccessToken;
    private String userAccessToken;

    private static final String TEST_PRODUCT_TITLE = "Test Product";
    private static final int TEST_PRODUCT_PRICE = 777;
    private static final String TEST_ADMIN_NAME = "Test Admin";
    private static final String ROLE_ADMIN_TITLE = "ROLE_ADMIN";
    private static final String ROLE_USER_TITLE = "ROLE_USER";
    private static final String TEST_USER_NAME = "Test User";
    private static final String TEST_PASSWORD = "Test password";

    private static final String URL_PREFIX = "http://localhost:";
    private static final String AUTH_RESOURCE = "/api/auth";
    private static final String PRODUCTS_RESOURCE = "/api/products";
    private static final String LOGIN_ENDPOINT = "/login";

    private static final String BEARER_PREFIX = "Bearer ";

    @BeforeEach
    public void setUp() {
        template = new TestRestTemplate();
        headers = new HttpHeaders();
        //Тестовый продукт
        testProduct = new ProductDTO();
        testProduct.setTitle(TEST_PRODUCT_TITLE);
        testProduct.setPrice(new BigDecimal(TEST_PRODUCT_PRICE));

        Role roleAdmin;
        Role roleUser = null;

        User admin = userRepository.findByUsername(TEST_ADMIN_NAME).orElse(null);
        User user = userRepository.findByUsername(TEST_USER_NAME).orElse(null);

        if (admin == null) {
            roleAdmin = roleRepository.findRoleByTitle(ROLE_ADMIN_TITLE)
                    .orElseThrow(() -> new RuntimeException("Role Admin Not Found"));
            roleUser = roleRepository.findRoleByTitle(ROLE_USER_TITLE)
                    .orElseThrow(() -> new RuntimeException("Role User Not Found"));

            admin = new User();
            admin.setUsername(TEST_ADMIN_NAME);
            admin.setPassword(encoder.encode(TEST_PASSWORD));
            admin.setRoles(Set.of(roleAdmin, roleUser));

            userRepository.save(admin);
        }

        if (user == null) {
            roleUser = (roleUser == null) ? roleRepository.findRoleByTitle(ROLE_USER_TITLE)
                    .orElseThrow(() -> new RuntimeException("")) : roleUser;

            user = new User();
            user.setUsername(TEST_USER_NAME);
            user.setPassword(encoder.encode(TEST_PASSWORD));
            user.setRoles(Set.of(roleUser));

            userRepository.save(user);
        }

        //POST http://localport:8~~~~8/auth/login
        LoginRequestDTO loginAdminDto = new LoginRequestDTO(TEST_ADMIN_NAME, TEST_PASSWORD);
        LoginRequestDTO loginUserDto = new LoginRequestDTO(TEST_USER_NAME, TEST_PASSWORD);

        String authUrl = URL_PREFIX + port + AUTH_RESOURCE + LOGIN_ENDPOINT;

        HttpEntity<LoginRequestDTO> adminRequest = new HttpEntity<>(loginAdminDto);
        ResponseEntity<TokenResponseDTO> response = template.exchange(authUrl, HttpMethod.POST, adminRequest, TokenResponseDTO.class);

        assertTrue(response.hasBody(), "Authorization response body for admin is empty");

        TokenResponseDTO tokenResponseDTO = response.getBody();
        adminAccessToken = BEARER_PREFIX + tokenResponseDTO.getAccessToken();

        System.out.println(adminAccessToken);

        HttpEntity<LoginRequestDTO> userRequest = new HttpEntity<>(loginUserDto);
        ResponseEntity<TokenResponseDTO> userResponse = template.exchange(authUrl, HttpMethod.POST, userRequest, TokenResponseDTO.class);

        assertTrue(userResponse.hasBody(), "Authorization response body for user is empty");

        TokenResponseDTO userTokenResponseDTO = userResponse.getBody();
        userAccessToken = BEARER_PREFIX + userTokenResponseDTO.getAccessToken();

        System.out.println(userAccessToken);

    }

    @Test
    public void test() {
        // пустой


    }


}