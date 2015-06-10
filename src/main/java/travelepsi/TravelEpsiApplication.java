package travelepsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import travelepsi.Utils.CorsFilter;

import java.util.ArrayList;
import java.util.Collection;


@Configuration
@ComponentScan
@EnableAutoConfiguration
public class TravelEpsiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TravelEpsiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    /**
     * Cors Filter
     */
    @Bean
    public FilterRegistrationBean corsFilterRegistrationBean() {
        CorsFilter corsFilter = new CorsFilter();

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(corsFilter);

        Collection<String> urls = new ArrayList<String>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }

    private static Class<TravelEpsiApplication> applicationClass = TravelEpsiApplication.class;

}
