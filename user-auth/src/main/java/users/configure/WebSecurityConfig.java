/*
 * package users.configure;
 * 
 * import java.util.Arrays; import java.util.Collections;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.AuthenticationProvider; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.crypto.password.NoOpPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter; import
 * org.springframework.web.cors.CorsConfiguration; import
 * org.springframework.web.cors.CorsConfigurationSource;
 * 
 * @EnableWebSecurity
 * 
 * public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 * 
 * @Autowired AuthenticationProvider authenticationProvider;
 * 
 * @Autowired JWTTockenValidatorFilter jWTTockenValidatorFilter;
 * 
 * @Autowired JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
 * 
 * @Autowired JWTTockenGeneratorFilter jWTTockenGeneratorFilter;
 * 
 * @Override public void configure(HttpSecurity http) throws Exception {
 * 
 * http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
 * STATELESS).and().cors()
 * 
 * .configurationSource(new CorsConfigurationSource() {
 * 
 * @Override public CorsConfiguration getCorsConfiguration(HttpServletRequest
 * request) { CorsConfiguration config = new CorsConfiguration();
 * config.setAllowedOrigins(Collections.singletonList("http://localhost:8080"));
 * config.setAllowedMethods(Collections.singletonList("*"));
 * config.setAllowedHeaders(Collections.singletonList("*"));
 * config.setExposedHeaders(Arrays.asList("Authorization"));
 * config.setMaxAge(36000l); return config; }
 * }).and().authorizeRequests().antMatchers("/college-quiz/login").permitAll().
 * anyRequest().authenticated()
 * .and().exceptionHandling().authenticationEntryPoint(
 * jwtAuthenticationEntryPoint);
 * 
 * //http.addFilterBefore(jWTTockenValidatorFilter,
 * UsernamePasswordAuthenticationFilter.class);
 * //http.addFilterAfter(jWTTockenGeneratorFilter,
 * UsernamePasswordAuthenticationFilter.class); http.csrf().disable(); }
 * 
 * @Bean
 * 
 * @Override public AuthenticationManager authenticationManagerBean() throws
 * Exception { return super.authenticationManagerBean(); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return
 * NoOpPasswordEncoder.getInstance(); }
 * 
 * }
 */