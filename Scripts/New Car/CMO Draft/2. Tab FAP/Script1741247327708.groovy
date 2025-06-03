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
WebDriver driver = DriverFactory.getWebDriver()

// TAB FAP
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//a//*[text()='FAP']"]));
WebUI.delay(3)

// --- Foto Dokumen FAP ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='FAP_TAMPAK_DEPAN']//div[contains(@class, 'document-preview')]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), bpkbPath);
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='FAP_TAMPAK_BELAKANG']//div[contains(@class, 'document-preview')]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), bpkbPath);
WebUI.delay(5)

// --- Foto Dokumen Persetujuan Konsumen ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='PERSETUJUAN_TAMPAK_DEPAN']//div[contains(@class, 'document-preview')]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), bpkbPath);
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='PERSETUJUAN_TAMPAK_BELAKANG']//div[contains(@class, 'document-preview')]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), bpkbPath);
WebUI.delay(5)

// --- Tujuan Pembiayaan ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='tujuanPembiayaan']"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//strong[text()='$F_tujuanPembiayaan'])"]));

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@name='namaIbuKandung']"]), F_NamaIbuKandung, FailureHandling.CONTINUE_ON_FAILURE);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='namaSID']"]), F_NamaSID);

WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='alamatUtamaKTP']/following-sibling::span"]));
WebUI.delay(3)

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@name='lamaTinggalTahun'])[1]"]), F_LamaTahun);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@name='lamaTinggalBulan'])[1]"]), F_LamaBulan);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='jumlahPertanggungan'])[1]"]), F_JumlahTanggungan);

// --- Prefix ---
String currentPrefix = WebUI.getAttribute(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='extension'])[2]"]), 'value')
if (currentPrefix == null || currentPrefix.trim() == '') {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='extension'])[2]"]), F_Prefix)
}

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='extension'])[1]"]), F_KodeArea);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nomor'])[1]"]), F_NomorTelepon);

// --- No HP ---
String currentNoHP = WebUI.getAttribute(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='nomor'])[2]"]), 'value')
if (currentNoHP == null || currentNoHP.trim() == '') {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='nomor'])[2]"]), F_NoHP)
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()=' WhatsApp sama dengan No. Handphone']"]));
WebUI.delay(1)

// --- Email ---
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='email']"]), F_Email);

switch(F_EmailSama) {
	case 'KTP':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='mailKTP'])[1]/following-sibling::span"]));
		break;
	case 'Domisili':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='mailD'])[1]/following-sibling::span"]));
		break;
	case 'Other':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='mailO'])[1]/following-sibling::span"]));
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@formgroupname='alamatMail']//textarea[@id='alamat']"]), 'test', FailureHandling.CONTINUE_ON_FAILURE);
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@formgroupname='alamatMail']//input[@name='kodePos']"]), '12430', FailureHandling.CONTINUE_ON_FAILURE);
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@formgroupname='alamatMail']//textarea[@id='alamat']"]), FailureHandling.CONTINUE_ON_FAILURE);
		break;
	case 'Kantor':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='mailKantor'])[1]/following-sibling::span"]));
		break;
}

WebUI.delay(1)

//---------Screenshot---------

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[contains(text(),'Foto Dokumen FAP')]"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '9. Tab FAP' + '/' + 'FAP (1)') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='extension'])[1]"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '9. Tab FAP' + '/' + 'FAP (2)') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='jumlahPertanggungan'])[1]"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '9. Tab FAP' + '/' + 'FAP (3)') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@id='kabupaten'])[2]//div[@class='value']"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '9. Tab FAP' + '/' + 'FAP (4)') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//button[text()=' Selanjutnya '])[2]"]));
WebUI.delay(3)