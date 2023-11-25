package web.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("web")
public class WebConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/pages/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setContentType("text/html; charset=UTF-8");

    }
}
//    Этот фрагмент кода является примером конфигурации Spring MVC с использованием Thymeleaf как представления. Он объявляет класс WebConfig, который реализует интерфейс WebMvcConfigurer, и объявляет несколько бинов (beans), которые настраивают различные аспекты веб-приложения.
//
//        Аннотация @Configuration указывает, что это класс конфигурации Spring. Аннотация @EnableWebMvc активирует функционал Spring MVC (Model-View-Controller) для данного компонента. Аннотация @ComponentScan указывает пакет (в данном случае “web”), в котором Spring должен искать компоненты, которые нужно внедрить.
//
//        Bean applicationContext является экземпляром ApplicationContext, который содержит все необходимые зависимости и конфигурации для веб-приложения. Конструктор класса принимает этот ApplicationContext в качестве аргумента.
//
//        В классе объявлены следующие бины:
//
//        SpringResourceTemplateResolver - это шаблонный resolver, который используется для обработки шаблонов Thymeleaf.
//        SpringTemplateEngine - это движок шаблонов, который обрабатывает шаблоны Thymeleaf, созданные с помощью resolver.
//        ThymeleafViewResolver - это resolver представлений, который преобразует имена представлений в реальные объекты представлений.