package com.example.trackdata;

import com.example.trackdata.jwtfilter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class TrackdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackdataApplication.class, args);
	}


	@Bean
	public FilterRegistrationBean filterUrl()
	{
		FilterRegistrationBean frb=new FilterRegistrationBean();
		frb.setFilter(new JwtFilter());

		//"http://localhost:6666/track-app/get-all-tracks"
		//"http://localhost:6666/track-app/get-track-by-id/{trackId}"
		//"http://localhost:6666/track-app/admin/add-new-track"
		//"http://localhost:6666/track-app/admin/update-track"
		//"http://localhost:6666/track-app/admin/delete-product/{productId}"
		//http://localhost:6666/track-app/"/get-user-details"
		//http://localhost:6666/track-app/add-track-to-user"
		//"http://localhost:6666/track-app/delete-track-by-user"



		frb.addUrlPatterns(
				"/track-app/get-track-by-id",
				"/track-app/add-track-to-user",
				"/track-app/admin/add-new-track",
				"/track-app/admin/update-track",
				"/track-app/admin/delete-track/",
				"/track-app/delete-track-by-user");
		return frb;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean()
	{
		final CorsConfiguration config= new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:4200");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",config);
		FilterRegistrationBean bean=new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}























}
