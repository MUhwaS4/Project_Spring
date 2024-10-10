package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 스프링 설정 클래스
@EnableWebSecurity // 보안 설정
public class SecurityConfig {
	
	// 로그인 인증 처리를 위한 필터 체인
	// 필터 체인을 커스텀하여 생성하고 빈으로 등록
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// 메뉴별 접근 권한 설정
		// 회원 가입: 아무나 접근 가능
		// 화면 리소스: 아무나 접근 가능
		// 메인 화면: 로그인한 사람만 가능
		// 게시물 관리와 댓글: ADMIN 또는 USER 권한을 가지고 있는 사람
		// 회원 관리: ADMIN 권한을 가지고 있는 사람
		http.authorizeRequests() // 사용은 가능하되 유지보수가 안 되기에 경고가 뜸
			.requestMatchers("/register").permitAll() // 회원가입 = 누구나 가능
			.requestMatchers("/assets/*", "/css/*", "/js/*").permitAll() // 누구나 접근 가능한 프론트엔드 코드
			.requestMatchers("/").authenticated()
			.requestMatchers("/board").hasAnyRole("ADMIN", "USER")
			.requestMatchers("/comment").hasAnyRole("ADMIN", "USER")
			.requestMatchers("/member").hasAnyRole("ADMIN"); // 회원 목록 = 관리자만 열람 가능
		
		// 로그인 폼 화면 설정
//		http.formLogin();
		// +
		// 로그인 화면과 로그인 처리 주소 설정
		// 로그인 성공 시 이동할 주소 설정
		http.formLogin()
						.loginPage("/customlogin") // 로그인 시 이동할 화면
						.loginProcessingUrl("/login") // 로그인 처리 주소
						.successHandler((request, response, authentication)->{
						// successHandler의 경우 람다식 함수로 처리
						// 함수 내 매개변수는 successHandler > AuthenticationSuccessHandler로 이동 후 인터페이스 함수 사용
							// 로그인 성공 시 설정한 주소(=메인 화면)으로 이동
							response.sendRedirect("/");
						});
		
		// 로그아웃 설정
		http.logout();
		
		// csrf 설정 (get 외에 post, put, delete 허용)
		http.csrf().disable();
		
		return http.build();
		
	}

    // 회원 가입 시 사용자 패스워드를 암호화하는데 사용할 인코더
    // BCrypt: 암호와 알고리즘 종류
    // 빈을 생성하여 컨테이너에 저장
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	

}

// 1_ 폼 데이터에서 패스워드를 꺼냄 (1234)
// 2_ 패스워드 암호화 (BCryptPasswordEncoder)
//    1234 -> xxxxxx
// 3_ 암호화된 패스워드와 테이블의 실제 패스워드가 같은지 확인
//    xxxxxx == xxxxxx
// 4_ 일치하면 로그인 성공
// => 스프링 시큐리티가 사용하는 인코더와 회원가입 시 사용한 인코드가 동일해야 함