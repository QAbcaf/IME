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

String baseDir = System.getProperty('user.dir')

// (Skenario 4)
WebUI.delay(1)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'skenario-4-hasilMatching') + '.png', FailureHandling.STOP_ON_FAILURE)
// (Skenario 6)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()=' Pengajuan ']"]))
 if(isBatal == 'no') {
	 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='mb-5 matching-content ng-star-inserted']/div[1]//*[@class='match-detail-btn']"]))
	 switch(isPengajuanMatch) {
		 case "yes":
			WebUI.delay(2)
			WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'skenario-6-pengajuan-match') + '.png', FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Lanjutkan']"]))
			WebUI.delay(1)
			WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'skenario-setelah-pengajuanButtonLanjutkan-match') + '.png', FailureHandling.STOP_ON_FAILURE)
			break;
		 case "no":
		 case "-":
		 case null:
		 	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//label/*[@value='none']"]))
			WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'skenario-6-pengajuan-noMatch') + '.png', FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Lanjutkan']"]))
			WebUI.delay(1)
			WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'skenario-setelah-pengajuanButtonLanjutkan-noMatch') + '.png', FailureHandling.STOP_ON_FAILURE)
			break;
	 }
 } else {
	 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div/following-sibling::div[2]/button[1]"]))
	 WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'skenario-setelah-pengajuan-directBatal') + '.png', FailureHandling.STOP_ON_FAILURE)
 }