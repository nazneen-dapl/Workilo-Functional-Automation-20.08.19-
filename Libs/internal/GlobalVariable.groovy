package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object chromePath
     
    /**
     * <p></p>
     */
    public static Object screenshots
     
    /**
     * <p></p>
     */
    public static Object imagePath
     
    /**
     * <p></p>
     */
    public static Object orderId
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            chromePath = selectedVariables['chromePath']
            screenshots = selectedVariables['screenshots']
            imagePath = selectedVariables['imagePath']
            orderId = selectedVariables['orderId']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
