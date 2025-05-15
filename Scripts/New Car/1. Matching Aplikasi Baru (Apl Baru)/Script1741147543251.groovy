import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.sql.Driver
import java.util.concurrent.ConcurrentHashMap.KeySetView

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
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

import org.junit.runner.notification.Failure
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String userDir = RunConfiguration.getProjectDir()
String ktpPath = "${userDir}${GlobalVariable.ktpPath}".replace("/", "\\")

// (Skenario 3)
String baseDir = System.getProperty('user.dir')
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//img[@alt='aplikasi-baru-global']"]))

// Upload Foto
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='document-preview ng-star-inserted']"]), FailureHandling.OPTIONAL);
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@type='file' and contains(@class, 'hidden-upload')])[2]"]), ktpPath,FailureHandling.STOP_ON_FAILURE);

WebUI.delay(10)

// Input matching RO
def ROData = [
	['nama', ROName],
	['nomorIdentitas', RONik],
	['kodeNoHp', ROHandphoneNumberPrefix],
	['nomor', ROHandphoneNumber],
]


for (data in ROData) {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//modal-container//input[@formcontrolname='${data[0]}']"]), data[1])
}

//DateFunction
def clickPrevious() {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='‹']"]))
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//modal-container//input[@name='tanggalLahir']/following-sibling::a"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//bs-datepicker-navigation-view//*[@class='current']"]))

String[] monthNames = ["", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"]
String[] dobComponents = RODob.split("/")
String day = dobComponents[0]
int monthInteger = Integer.parseInt(dobComponents[1]) 
int year = Integer.parseInt(dobComponents[2].trim())
String month = monthNames[monthInteger]
 
int currentYear = Calendar.getInstance().get(Calendar.YEAR);
int difference = currentYear - year;
double boxesToGoBack = (double) difference / 16;
int decimalPart = (int) ((boxesToGoBack - (int) boxesToGoBack) * 10);
 
if (decimalPart <= 4) {
	boxesToGoBack = Math.floor(boxesToGoBack);
} else {
	boxesToGoBack = Math.ceil(boxesToGoBack);
}
 
for (int i = 0; i < boxesToGoBack; i++) {
	clickPrevious();
}
 
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='" + year + "']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='" + month + "']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='" + day + "']"]))
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Input RO') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

// Click Matching Button
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Matching']"]))

// Hasil Matching
WebUI.delay(10)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Hasil Matching Existing') + '.png', FailureHandling.STOP_ON_FAILURE)