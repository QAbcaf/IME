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
import org.openqa.selenium.Keys as Keys

String userDir = RunConfiguration.getProjectDir()
String selfiePath = "${userDir}${GlobalVariable.selfiePath}".replace("/", "\\")
String ktpPath = "${userDir}${GlobalVariable.ktpPath}".replace("/", "\\")
String bpkbPath = "${userDir}${GlobalVariable.bpkbPath}".replace("/", "\\")
String baseDir = System.getProperty('user.dir')

// TAB Penyimpangan
String firstValue = P_Penyimpangan.split("\\+")[0].trim()
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Penyimpangan']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='list-penimpangan-btn d-flex w-100 mb-2']/img"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@id='search']"]), firstValue)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up-items']/div[1]//span[@class='checkmark']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Pilih ']"]))

if (P_Penyimpangan.contains('+')) {
    String[] items = P_Penyimpangan.split("\\+")
    for (int i = 1; i < items.length; i++) {
        String trimmedItem = items[i].trim()
        WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='list-penimpangan-btn d-flex w-100 mb-2']/img"]))
        WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@id='search']"]))
        WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@id='search']"]), trimmedItem)
        WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up-items']/div[1]//span[@class='checkmark']"]))
        WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Pilih ']"]))
    }
} else {
	
}


// Penyimpangan Tambahan
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()=' Penyimpangan Tambahan ']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='penyimpanganTambahan']//*[@formcontrolname='jabatan']"]))
WebDriver driver = DriverFactory.getWebDriver()
WebElement element = driver.findElement(By.xpath("//div[@id='penyimpanganTambahan']//*[@formcontrolname='jabatan']"))
element.click();

switch(P_Jabatan) {
	case 'BM':
		for (int i = 0; i < 1; i++) {
			element.sendKeys(Keys.ARROW_DOWN)
			WebUI.delay(1)
		}
		break;
	case 'RM':
		for (int i = 0; i < 2; i++) {
			element.sendKeys(Keys.ARROW_DOWN)
			WebUI.delay(1)
		}
		break;
	case 'DD':
		for (int i = 0; i < 3; i++) {
			element.sendKeys(Keys.ARROW_DOWN)
			WebUI.delay(1)
		}
		break;
	case 'D1':
		for (int i = 0; i < 4; i++) {
			element.sendKeys(Keys.ARROW_DOWN)
			WebUI.delay(1)
		}
		break;
	case 'D2':
		for (int i = 0; i < 5; i++) {
			element.sendKeys(Keys.ARROW_DOWN)
			WebUI.delay(1)
		}
		break;
}

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//textarea[@id='description']"]), P_PenyimpanganTambahanDescription)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//button[text()=' Simpan ']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()=' Keterangan CMO ']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//textarea[@id='keterangan']"]), P_KeteranganCMO)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//button[text()=' Simpan ']"]))


// Selanjutnya
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Tab Penyimpangan') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//button[text()=' Selanjutnya '])[3]"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Tab Penyimpangan Selanjutnya') + '.png', FailureHandling.STOP_ON_FAILURE);