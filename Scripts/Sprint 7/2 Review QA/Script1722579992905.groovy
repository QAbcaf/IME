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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

String baseDir = System.getProperty('user.dir')

void hideElements() {
    WebUI.executeJavaScript("document.querySelector('.account-header').style.display='none'", null)
    WebUI.executeJavaScript("document.querySelector('.button-container').style.display='none'", null)
}

void showElements() {
    WebUI.executeJavaScript("document.querySelector('.account-header').style.display=''", null)
    WebUI.executeJavaScript("document.querySelector('.button-container').style.display=''", null)
}

void takeFullPageScreenshot(String path) {
    WebUI.takeFullPageScreenshot(path, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//*[text()='Search Application']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "//input[@id='mobileId']"]), MID)
WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '1 Search MID.png', FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Get Application']"]))
WebUI.delay(5)

// Tab Konsumen
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '2 Tab Konsumen (Button).png')
hideElements()
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '2 Tab Konsumen.png')
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "(//*[text()='Lihat Detail'])[1]"]))
showElements()
WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '3 Detail KYC.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Tutup']"]))

WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "(//*[text()='Lihat Detail'])[2]"]))
WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '4 KYC Wajah.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Tutup']"]))

hideElements()
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//*[text()='Selfie Konsumen']"]))
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '5 Tab Konsumen - Selfie Konsumen.png')

WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//*[text()='NPWP']"]))
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '6 Tab Konsumen - NPWP.png')
showElements()

// Tab FAP
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//*[@class='checker-tab']/*[text()='FAP']"]))
WebUI.delay(3)
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '7 Tab FAP (Button).png')

hideElements()
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '7 Tab FAP [1].png')
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "(//*[text()='Provinsi'])[2]"]), 0)
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '7 Tab FAP [2].png')
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "(//*[text()='Kode POS'])[3]"]), 0)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/xpath', ['xpath': "//*[text()='NAMA PASANGAN PENJAMIN']"]), 0)) {
    WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "//*[text()='NAMA PASANGAN PENJAMIN']"]), 0)
    takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '7 Tab FAP [3].png')
}

showElements()

// Tab Matching Result
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//*[@class='checker-tab']/*[text()='MATCHING RESULT']"]))
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '8 Tab Matching Result (Button).png')
hideElements()
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '8 Tab Matching Result [1].png')
showElements()

// Tab Collateral
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//*[text()='COLLATERAL']"]))
WebUI.delay(5)
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '9 Tab Collateral (Button).png')

WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "(//a[text()='Lihat Detail'])[1]"]))
WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '10 Asset Registry.png', FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Tutup']"]))

WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "(//a[text()='Lihat Detail'])[2]"]), FailureHandling.OPTIONAL)
WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '11 Sigma Approva.png', FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Tutup']"]))

hideElements()
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '12 Tab Collateral - BPKB.png')

WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//*[text()=' STNK - Tampak Depan ']"]))
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '13 Tab Collateral - STNK Depan.png')

WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//*[text()=' STNK - Tampak Belakang ']"]))
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '14 Tab Collateral - STNK Belakang.png')
showElements()

// Tab Loan Data
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//*[text()='LOAN DATA']"]))
WebUI.delay(5)
WebUI.check(findTestObject('Object Repository/xpath', ['xpath': "//input[@value='self']/following-sibling::span"]))
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '15 Tab Loan Data (Button).png')
hideElements()
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + '15 Tab Loan Data [1].png')
showElements()