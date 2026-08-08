package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnviromentCheck {

    private final Environment env;

    public EnviromentCheck(Environment env) {
        this.env = env;
    }

    // 자바 옵션 인수보다, command option 인수가 우선권을 가진다.(실행 시 원하는 값을 줄 수 있는(더 유연한)게 우선권을 가짐)
    // 범위가 넓은 것보다 좁은 것이(면밀한 것이) 우선권을 가짐
    @PostConstruct
    public void init() {
        String url = env.getProperty("url");
        String username = env.getProperty("username");
        String password = env.getProperty("password");
        log.info("env url={}", url);
        log.info("env username={}", username);
        log.info("env password={}", password);
    }
}
