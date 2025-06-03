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
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Summary' + '/' + 'Tab Summary') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

// Pre Screening
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[1]/div"]))
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Pre Screening' + '/' + 'Pre Screening') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[1]//*[@class='ac-title display']"]))

// Konsumen
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[2]/div"]))
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Konsumen' + '/' + 'Konsumen (1)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//display-data[@class='ng-star-inserted']//div[@class='label-title'][normalize-space()='Tempat Lahir']"]), 0)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Konsumen' + '/' + 'Konsumen (2)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='pekerjaan']//div[@class='doc-img-container ng-star-inserted']"]), 0)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Konsumen' + '/' + 'Konsumen (3)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='kartuKeluarga']//div[@class='doc-img-container ng-star-inserted']"]), 0)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Konsumen' + '/' + 'Konsumen (4)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='kepemilikanRekening']//div[@class='label-title'][normalize-space()='NIK']"]), 0)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Konsumen' + '/' + 'Konsumen (5)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[2]//*[@class='ac-title display']"]))

// FAP
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[3]/div"]))
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/FAP' + '/' + 'FAP (1)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='mt-3']//div[@class='label-title'][normalize-space()='Kode Pos']"]), 0)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/FAP' + '/' + 'FAP (2)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[3]//*[@class='ac-title display']"]))

// General
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[4]/div"]))
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/General' + '/' + 'General (1)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[4]//*[@class='ac-title display']"]))

// Contact Person dan Penjamin
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[5]/div"]))
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/ECN' + '/' + 'ECN (1)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='row mb-3 row-gap-2 ng-star-inserted']//div[@class='label-title'][normalize-space()='Kecamatan']"]), 0)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/ECN' + '/' + 'ECN (2)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[5]//*[@class='ac-title display']"]))

// Matching Result
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[6]/div"]))
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Matching' + '/' + 'Matching Result (1)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[6]//*[@class='ac-title display']"]))

// Collateral
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[7]/div"]))
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Collateral' + '/' + 'Collateral (1)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[contains(text(),'Pengajuan Chasis & Karoseri')]"]), 0)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Collateral' + '/' + 'Collateral (2)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[7]//*[@class='ac-title display']"]))

// Loan Data
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[8]/div"]))
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Loan Dara' + '/' + 'Loan Data (1)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//tab[@class='active tab-pane']//div[@class='label-title'][normalize-space()='Tipe Asuransi']"]), 0)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Loan Data' + '/' + 'Loan Data (2)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[normalize-space()='Nominal Biaya']"]), 0)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Loan Data' + '/' + 'Loan Data (3)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[8]//*[@class='ac-title display']"]))

// Penyimpangan
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[9]/div"]))
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '16. Tab Summary/Penyimpangan' + '/' + 'Penyimpangan (1)') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[9]//*[@class='ac-title display']"]))

// Submit Pengajuan
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Submit Pengajuan ']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//button[@_ngcontent-ng-c2833372923=''])[2]"]))

// Submit Berhasil