//package guevara.demo.model;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/css/**", "/js/**", "/img/**", "/vendor/**", "/fonts/**").permitAll()
//                .antMatchers("/")
//                .access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .httpBasic();
//
//
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//
//        auth.inMemoryAuthentication().
//                withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("newuser").password("newuserpa$$").roles("ADMIN");
//        //to add additional accounts, remove the semicolon at
//        //the end of the previous command and add an additional user like below:
//        //  .and()
//        //  .withUser("dave").password("begreat").roles("USER");
//    }
//
//
//}
