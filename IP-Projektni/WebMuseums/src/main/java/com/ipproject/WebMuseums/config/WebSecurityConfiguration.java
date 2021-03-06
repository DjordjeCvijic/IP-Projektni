package com.ipproject.WebMuseums.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration  extends WebSecurityConfigurerAdapter{

	
	@Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    JwtRequestFilter jwtRequestFilter;
    

  String[] adminPermissionsList = {"/user-info"};
  String[] userAndAminPermissionsList = {"/museum/**","/virtual-tour/**"};
  String[] swaggerPermissionsList = {"/swagger-ui/*", "/swagger-ui.html", "/webjars/**", "/v2/**", "/swagger-resources/**"};
  String[] permissionsForAllList = {"/auth/**","/user-info/change-password","/user-info/**","/virtual-tour-ticket/**"};

  // authentication
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
  }
  
  
  // authorization
  @Override
  protected void configure(HttpSecurity http) throws Exception {
      // @formatter:off

      http
              .csrf().disable()
              .authorizeRequests()
              .antMatchers(permissionsForAllList).permitAll()
//              .antMatchers("/swagger-resources/**").permitAll()
              .antMatchers(swaggerPermissionsList).permitAll()
              .antMatchers(adminPermissionsList).hasRole("ADMIN")
              .antMatchers(userAndAminPermissionsList).hasAnyRole("USER", "ADMIN")
              .anyRequest().authenticated()
              .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      http
              .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
      
      

      // @formatter:on
  }
  @Override
  public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/v2/api-docs",
                                 "/configuration/ui",
                                 "/swagger-resources/**",
                                 "/configuration/security",
                                 "/swagger-ui.html",
                                 "/webjars/**");
  }
  
  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
  }

  @Bean
  public PasswordEncoder encoder() {
      return new BCryptPasswordEncoder(11);
  }
}
