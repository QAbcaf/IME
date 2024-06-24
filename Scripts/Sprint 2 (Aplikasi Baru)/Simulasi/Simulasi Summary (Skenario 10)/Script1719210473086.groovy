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

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import ru.yandex.qatools.ashot.shooting.ShootingStrategies
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import javax.imageio.ImageIO
import java.io.File

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
WebDriver driver = DriverFactory.getWebDriver()

// TAB Summary
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Summary']"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '19 Tab Summary' + '/' + 'Tab Summary') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.delay(1)

// Pre Screening
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[1]/div"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '19 Tab Summary' + '/' + 'Pre Screening') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[1]//*[@class='ac-title display']"]))

// Konsumen
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[2]/div"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '19 Tab Summary' + '/' + 'Konsumen') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[2]//*[@class='ac-title display']"]))

// FAP
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[3]/div"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '19 Tab Summary' + '/' + 'FAP') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[3]//*[@class='ac-title display']"]))

// Contact Person dan Penjamin
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[4]/div"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '19 Tab Summary' + '/' + 'CP') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[4]//*[@class='ac-title display']"]))

// Matching Result
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[5]/div"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '19 Tab Summary' + '/' + 'Matching Result') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[5]//*[@class='ac-title display']"]))

// Collateral
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[6]/div"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '19 Tab Summary' + '/' + 'Collateral') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[6]//*[@class='ac-title display']"]))

// Loan Data
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[7]/div"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '19 Tab Summary' + '/' + 'Loan Data') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[7]//*[@class='ac-title display']"]))

// Penyimpangan
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[8]/div"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '19 Tab Summary' + '/' + 'Penyimpangan') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[8]//*[@class='ac-title display']"]))

// Submit Pengajuan
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Submit Pengajuan ']"]))
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//button[@_ngcontent-ng-c2833372923=''])[2]"]))

// Submit Berhasil