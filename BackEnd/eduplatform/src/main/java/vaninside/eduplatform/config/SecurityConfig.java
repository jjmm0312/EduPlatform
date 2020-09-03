package vaninside.eduplatform.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.AllArgsConstructor;
import vaninside.eduplatform.security.JwtAuthenticationEntryPoint;
import vaninside.eduplatform.security.JwtAuthenticationFilter;
import vaninside.eduplatform.security.JwtTokenProvider;
import vaninside.eduplatform.security.MyUserDetailService;
import vaninside.eduplatform.service.MemberService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    MyUserDetailService customUserDetailsService;	
	
	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
	
	@Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    // �츮 �������� ���� ����
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    	.csrf().disable()
        .exceptionHandling()
            .authenticationEntryPoint(unauthorizedHandler)
            .and()
        .authorizeRequests()
            .antMatchers( // ���� ������ ���
                "/favicon.ico",
                "/**/*.png",
                "/**/*.gif",
                "/**/*.svg",
                "/**/*.jpg",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js")
                .permitAll()
            .antMatchers("/signup")
                .permitAll()
            .antMatchers("/signin")
                .permitAll()
            .antMatchers("/**")
                //.hasRole("STUDENT")
            .permitAll() // ���� �׽�Ʈ �ܰ��̹Ƿ� ��� �㰡�մϴ�.
            .anyRequest()
                .authenticated();

		// Add our custom JWT security filter
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    
    @Override // ignore check swagger resource
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**",
                "/swagger-ui.html", "/webjars/**", "/swagger/**");
    }
	
    
/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests() // ���ٰ���
        .antMatchers("/").permitAll() // / ��û�� ��� �㰡
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/private").hasRole("USER")
        //.anyRequest().authenticated() // ��� ��û�� ���� �䱸
        .and()
        //.httpBasic();
        .formLogin();//.disable(); // form ��� �α��� ��Ȱ��ȭ

    	

    	http.authorizeRequests()
                //.antMatchers("/admin/**").hasRole("ADMIN")
                //.antMatchers("/user/myinfo").hasRole("MEMBER")
                .antMatchers("/member/").permitAll()
                .and() // �α��� ����
                .httpBasic();
                //.formLogin();
                 
                 */
                /*
                .loginPage("/user/login")
                .defaultSuccessUrl("/user/login/result")
                .permitAll()
                .and() // �α׾ƿ� ����
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/logout/result")
                .invalidateHttpSession(true)
                .and()
                // 403 ����ó�� �ڵ鸵
                .exceptionHandling().accessDeniedPage("/user/denied");
                
                
    }*/
    
   

/*
    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // static ���͸��� ���� ���� ����� ���� ���� ( = �׻���� )
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // ������ ���� ����
                                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/myinfo").hasRole("MEMBER")
                .antMatchers("/**").permitAll()
            .and() // �α��� ����
                                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/user/login/result")
                .permitAll()
            .and() // �α׾ƿ� ����
                               .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/logout/result")
                .invalidateHttpSession(true)
            .and()
                // 403 ����ó�� �ڵ鸵
                               .exceptionHandling().accessDeniedPage("/user/denied");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }
    */
}
