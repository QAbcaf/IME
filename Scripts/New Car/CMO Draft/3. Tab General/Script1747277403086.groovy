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
String baseDir = System.getProperty('user.dir')
WebDriver driver = DriverFactory.getWebDriver()
String buktiSegmentasiPath = "${userDir}${GlobalVariable.buktiSegmentasiPath}".replace("/", "\\")

// TAB GENERAL
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[normalize-space()='General']"]));

// --- Segmentasi ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//label[normalize-space()='$G_Segmentasi']"]));

// --- Membership ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//label[normalize-space()='${G_Membership}']"]));
	if (G_Membership == 'Solitaire' && G_Membership == 'Prioritas') {
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='lamaMembership']"]), G_LamaMembership);
	}
	
// --- Jenis Debitur ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//label[normalize-space()='${G_JenisDebitur}']"]));
	if (G_JenisDebitur != 'Non Debitur') {
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='plafondBca']"]), G_Plafond);
	}
	
// --- Sales Type ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='salesType']"]));
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='searchInput']"]), G_SalesType);
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//strong)[1]"]));

// --- Sales Office ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[contains(text(),'Sales Office')]"]));
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='searchInput']"]), G_SalesOffice);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//strong)[1]"]));

// --- Sales Agent
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[contains(text(),'Sales Agent')]"]));
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='searchInput']"]), G_SalesAgent);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//strong)[1]"]));

// --- Bukti Segmentasi
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='d-flex justify-content-between']//button[@class='btn-img ng-star-inserted']//img"]), FailureHandling.STOP_ON_FAILURE);
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='capture-option']//input[@type='file']"]), buktiSegmentasiPath ,FailureHandling.STOP_ON_FAILURE);

// --- Rekomendasi ---
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='namaPerekomendasi']"]), 0);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='namaPerekomendasi']"]), G_RekomendasiNama);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='jabatanPerekomendasi']"]), G_Jabatan);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='cabangPerekomendasi']"]), G_Cabang);

// --- Screeenshoot ---
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen  + '/' + '10. Tab General + '/' + General (1)') + '.png', FailureHandling.OPTIONAL)
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='namaPerekomendasi']"]), 0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen  + '/' + '10. Tab General + '/' + General (2)') + '.png', FailureHandling.OPTIONAL)

// --- Selanjutnya ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='pengajuan-content overflow-auto ng-star-inserted']//div[@class='col-8 pl-2']"]));

