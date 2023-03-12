package com.train.ctrip.groovytest;

import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.MethodCallExpression;
import org.codehaus.groovy.control.customizers.SecureASTCustomizer;

/**
 * @author xbguo
 * @createTime 2023年03月12日 22:03:00
 */
public class NoSupportClassTest implements SecureASTCustomizer.ExpressionChecker {
    @Override
    public boolean isAuthorized(Expression expression) {
        if (expression instanceof MethodCallExpression) {
            MethodCallExpression mc = (MethodCallExpression) expression;
            String className = mc.getReceiver().getText();
            String method = mc.getMethodAsString();

            System.out.println("=====>"+className + "." + method);

        }
        return true;
    }
}
