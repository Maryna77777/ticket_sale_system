//package com.example.tickets.security;
//
//import org.springframework.security.access.expression.SecurityExpressionRoot;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//public class SecurityEvaluationContextExtension extends EvaluationContextExtensionSupport {
//
//    @Override
//    public String getExtensionId() {
//        return "security";
//    }
//
//    @Override
//    public SecurityExpressionRoot getRootObject() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return new SecurityExpressionRoot(authentication) {};
//    }
//}
