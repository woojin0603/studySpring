package hello.proxy.config.v6_aop;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import hello.proxy.config.v6_aop.aspect.LogTraceAspect;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {

    /*
    * 조인 포인트(Join Point): 어드바이스가 적용될 수 있는 위치, 추상적인 개념, AOP를 적용할 수 있는 모든 지점(메서드 실행 지점으로 제한)(스프링 AOP의 경우)
    * 포인트컷(Pointcut): 조인 포인트 중에서 어드바이스가 적용될 위치를 선별하는 기능, 주로 AspectJ 표현식을 사용해서 지정
    * 타겟(Target): 어드바이스를 받는 객체, 포인트컷으로 결정
    * 어드바이스(Advice): 부가 기능, 특정 조인 포인트에서 Aspect에 의해 취해지는 조치(Around(주변), Befor(전), After(후)와 같은 다양한 어드바이스 존재)
    * 에스펙터(Aspect): 어드바이스 + 포인트컷을 모듈화한 것(@Aspect), 여러 어드바이스와 포인트컷이 함께 존재 가능
    * 어드바이저(Advisor): 하나의 어드바이스와 하나의 포인트컷으로 구성(스프링 AOP에서만 사용하는 특별한 용어)
    * 위빙(Weaving): 포인트컷으로 결정한 타겟의 조인 포인트에 어드바이스를 적용하는 것, 위빙을 통해 핵심 기능 코드에 영향주지 않고 부가 기능 추가 가능
    * AOP 프록시: AOP 기능을 구현하기 위해 만든 프록시 객체, 스프링에서 AOP 프록시는 JDK 동적 프록시, CGLIB 프록시임
    *
    * */


    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace) {
        return new LogTraceAspect(logTrace);
    }
}
