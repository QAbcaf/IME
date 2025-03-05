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

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='d-flex gap-1']//img[@class='img-placeholder'])[1]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), bpkbPath);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='d-flex gap-1']//img[@class='img-placeholder'])[1]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), bpkbPath);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='tujuanPembiayaan']"]));
switch(tujuanPembiayaan) {
	case 'Investasi':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//strong[text()='Investasi'])[1]"]));
	break;
	case 'Modal Kerja':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//strong[text()='Modal Kerja'])[1]"]));
	break;
	case 'Konsumsi':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//strong[text()='Konsumsi'])[1]"]));
	break;
	case 'Lainnya':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//strong[text()='Lainnya'])[2]"]));
	break;
}

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='namaIbuKandung'])[1]"]), nama_ibu_kandung);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='namaSID'])[1]"]), namaSID);

WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='alamatUtamaKTP']/following-sibling::span"]));

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@name='lamaTinggalTahun'])[1]"]), lama_tahun);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@name='lamaTinggalBulan'])[1]"]), lama_bulan);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='jumlahPertanggungan'])[1]"]), jumlah_tanggungan);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='extension'])[1]"]), kode_area);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nomor'])[1]"]), nomor_telepon);

switch(emailSama) {
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

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()=' WhatsApp sama dengan No. Handphone']"]));
WebUI.delay(1)
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Tab FAP') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-fap//button[text()=' Selanjutnya ']"]));
WebUI.delay(3)
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Tab FAP Selanjutnya') + '.png', FailureHandling.STOP_ON_FAILURE);
