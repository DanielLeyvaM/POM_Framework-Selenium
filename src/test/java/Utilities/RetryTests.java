package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTests implements IRetryAnalyzer {
    int attempts= 0;
    int maxAttempts= 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(attempts< maxAttempts){
            attempts++;
            return true;
        }
        return false;
    }
}
