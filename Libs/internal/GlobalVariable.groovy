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
    public static Object usernameCMO
     
    /**
     * <p></p>
     */
    public static Object usernameChecker
     
    /**
     * <p></p>
     */
    public static Object usernameBM
     
    /**
     * <p></p>
     */
    public static Object loginRole
     
    /**
     * <p></p>
     */
    public static Object password
     
    /**
     * <p></p>
     */
    public static Object IMEUrl
     
    /**
     * <p></p>
     */
    public static Object screenshotPathAplBaru
     
    /**
     * <p></p>
     */
    public static Object ss2
     
    /**
     * <p></p>
     */
    public static Object screenshotSprint3
     
    /**
     * <p></p>
     */
    public static Object ktpPath
     
    /**
     * <p></p>
     */
    public static Object selfiePath
     
    /**
     * <p></p>
     */
    public static Object selfie1Path
     
    /**
     * <p></p>
     */
    public static Object selfie2Path
     
    /**
     * <p></p>
     */
    public static Object bpkbPath
     
    /**
     * <p></p>
     */
    public static Object screenshotSimulasi
     
    /**
     * <p></p>
     */
    public static Object ktpPathPasangan
     
    /**
     * <p></p>
     */
    public static Object ktpPathSingle
     
    /**
     * <p></p>
     */
    public static Object selfieEdit
     
    /**
     * <p></p>
     */
    public static Object FAPPath
     
    /**
     * <p></p>
     */
    public static Object stnkPath
     
    /**
     * <p></p>
     */
    public static Object npwpPath
     
    /**
     * <p></p>
     */
    public static Object kkPath
     
    /**
     * <p></p>
     */
    public static Object loginRoleBM
     
    /**
     * <p></p>
     */
    public static Object BMusername
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters(), selectedVariables)
    
            usernameCMO = selectedVariables['usernameCMO']
            usernameChecker = selectedVariables['usernameChecker']
            usernameBM = selectedVariables['usernameBM']
            loginRole = selectedVariables['loginRole']
            password = selectedVariables['password']
            IMEUrl = selectedVariables['IMEUrl']
            screenshotPathAplBaru = selectedVariables['screenshotPathAplBaru']
            ss2 = selectedVariables['ss2']
            screenshotSprint3 = selectedVariables['screenshotSprint3']
            ktpPath = selectedVariables['ktpPath']
            selfiePath = selectedVariables['selfiePath']
            selfie1Path = selectedVariables['selfie1Path']
            selfie2Path = selectedVariables['selfie2Path']
            bpkbPath = selectedVariables['bpkbPath']
            screenshotSimulasi = selectedVariables['screenshotSimulasi']
            ktpPathPasangan = selectedVariables['ktpPathPasangan']
            ktpPathSingle = selectedVariables['ktpPathSingle']
            selfieEdit = selectedVariables['selfieEdit']
            FAPPath = selectedVariables['FAPPath']
            stnkPath = selectedVariables['stnkPath']
            npwpPath = selectedVariables['npwpPath']
            kkPath = selectedVariables['kkPath']
            loginRoleBM = selectedVariables['loginRoleBM']
            BMusername = selectedVariables['BMusername']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
