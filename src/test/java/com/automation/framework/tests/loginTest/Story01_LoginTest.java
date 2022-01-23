package com.automation.framework.tests.loginTest;

import com.automation.framework.tools.Base;
import org.testng.annotations.Test;

    public class Story01_LoginTest extends Base{

    @Test
    public void tc01_LoginTest(){
            loginPage.login();

    }

}
