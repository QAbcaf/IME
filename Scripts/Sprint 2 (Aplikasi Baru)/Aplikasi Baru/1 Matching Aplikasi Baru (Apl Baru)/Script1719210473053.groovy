import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.console.ui.Console
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebElement as Keys

String userDir = RunConfiguration.getProjectDir()
String baseDir = System.getProperty('user.dir')
String ktpPath = "${userDir}${GlobalVariable.ktpPath}".replace("/", "\\")


WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//img[@alt='aplikasi-baru-global']"]))

// Input matching RO
def ROData = [
	['kodeNoHp', ROHandphoneNumberPrefix],
	['nomor', ROHandphoneNumber],
]

WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div//img[@class='img-placeholder']"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPath);
WebUI.delay(10)

for (data in ROData) {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//modal-container//input[@formcontrolname='${data[0]}']"]), data[1])
}

//Click Car Condition
switch(ROCarCondition) {
	case 'New Car':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-simulasi-pengajuan//label[1]"]));
		break;
	case 'Used Car':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-simulasi-pengajuan//label[2]"]));
		break;
}


WebUI.delay(5)

WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCar)) + '/' + konsumen  + '/' + '1. Input Matching RO') + '.png', FailureHandling.STOP_ON_FAILURE)

// Click Matching Button
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Matching']"]))

// Hasil Matching
WebUI.delay(15)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCar)) + '/' + konsumen  + '/' + '2. Hasil Matching Existing') + '.png', FailureHandling.STOP_ON_FAILURE)