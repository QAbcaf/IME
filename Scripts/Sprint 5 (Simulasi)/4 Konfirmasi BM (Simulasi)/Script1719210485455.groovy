import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// login sebagai BM
String baseDir = System.getProperty('user.dir')
String login_role = GlobalVariable.loginRoleBM

switch (login_role) {
	case "cmo":
		username = GlobalVariable.usernameCMO
		break;
	case "bm":
		username = GlobalVariable.BMusername
		break;
	case "checker":
		username = GlobalVariable.usernameChecker
		break;
}

String password = GlobalVariable.password

WebUI.openBrowser(GlobalVariable.IMEUrl)
WebUI.maximizeWindow()
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//form//input[@formcontrolname='userid']"]), username)
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//form//input[@formcontrolname='password']"]), password)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Login BM') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//form//button[@type='submit']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Mengerti']"]))

// Dashboard
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='list-app-item'][3]"]))
WebUI.refresh();
WebUI.refresh();
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'BM Dashboard') + '.png', FailureHandling.STOP_ON_FAILURE)

// Approval BM
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Approval']"]))
