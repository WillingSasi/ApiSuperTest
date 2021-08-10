package com.example.ApiSuperTest.listener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

//public class ListenerVerify implements IInvokedMethodListener {
public class ListenerVerify {
//    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // TODO Auto-generated method stub
        if (method.isTestMethod()) {
            Verify.tearDown();
        }
    }

//    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    }
}
