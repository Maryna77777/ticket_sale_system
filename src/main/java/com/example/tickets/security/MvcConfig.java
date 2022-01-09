//package com.example.tickets.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.MethodParameter;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;
//import org.springframework.web.bind.support.WebDataBinderFactory;
//import org.springframework.web.context.request.NativeWebRequest;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.method.support.ModelAndViewContainer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.lang.annotation.Annotation;
//import java.util.List;
//
//
//@Configuration
//public class MvcConfig extends WebMvcConfigurerAdapter {
//    @Bean
//    public AuthenticationPrincipalArgumentResolver authenticationPrincipalArgumentResolver(){
//        return new AuthenticationPrincipalArgumentResolver();
//    }
//
////    @Override
////    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
////        argumentResolvers.add(authenticationPrincipalArgumentResolver());
////    }
//
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(new HandlerMethodArgumentResolver() {
//
//            public boolean supportsParameter(MethodParameter parameter) {
//                return findMethodAnnotation(CurrentUser.class, parameter) != null;
//            }
//
//            public Object resolveArgument(
//                    MethodParameter parameter,
//                    ModelAndViewContainer mavContainer,
//                    NativeWebRequest webRequest,
//                    WebDataBinderFactory binderFactory) throws Exception
//            {
//                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//                Object principal = authentication.getPrincipal();
//
//                if(principal != null && !parameter.getParameterType().isAssignableFrom(principal.getClass()))
//                    throw new ClassCastException(principal + " is not assignable to " + parameter.getParameterType());
//
//                return principal;
//            }
//
//            <T extends Annotation> T findMethodAnnotation(Class<T> annotationClass, MethodParameter parameter) {
//                T annotation = parameter.getParameterAnnotation(annotationClass);
//                if(annotation != null) {
//                    return annotation;
//                }
//                Annotation[] annotationsToSearch = parameter.getParameterAnnotations();
//                for(Annotation toSearch : annotationsToSearch) {
//                    annotation = AnnotationUtils.findAnnotation(toSearch.annotationType(), annotationClass);
//                    if(annotation != null) {
//                        return annotation;
//                    }
//                }
//                return null;
//            }
//        });
//    }
//}
//
//
//
