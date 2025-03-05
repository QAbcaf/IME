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
String ktpPathPasangan = "${userDir}${GlobalVariable.ktpPathPasangan}".replace("/", "\\")
String ktpPathSingle = "${userDir}${GlobalVariable.ktpPathSingle}".replace("/", "\\")
String selfieEdit = "${userDir}${GlobalVariable.selfieEdit}".replace("/", "\\")
String bpkbPath = "${userDir}${GlobalVariable.bpkbPath}".replace("/", "\\")
String stnkPath = "${userDir}${GlobalVariable.stnkPath}".replace("/", "\\")
String FAPPath = "${userDir}${GlobalVariable.FAPPath}".replace("/", "\\")
String baseDir = System.getProperty('user.dir')

/*
// Edit Konsumen
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[2]/div"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-summary-konsumen//*[text()='Edit Data'])[1]"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[1]"]));

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[1]"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@id='pekerjaanEkonomiCode']"]));
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@id='searchInput']"]), CP_EditPekerjaan);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[contains(text(), '${CP_EditPekerjaan}')]"]));
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Edit' + '/' + 'Tab Konsumen'  + '/' + 'Pekerjaan') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[2]"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-data-kk//*[@class='doc-action-button'])[1]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//*[@id='formDataKartuKeluargaslideUpActions']//input"]), bpkbPath);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-document-type-form//select"]));
WebUI.delay(2)
WebUI.selectOptionByValue(findTestObject('Object Repository/xpath', ['xpath' : "//select"]), K_TipeDokumen, false);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Simpan']"]));

WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Edit' + '/' + 'Tab Konsumen'  + '/' + 'KK Tabungan') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[3]"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-data-kepemilikan//*[text()='Status Rumah']"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[@class='slide-up show']//*[text()='$CP_EditStatusRumah'])[1]"]));
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Edit' + '/' + 'Tab Konsumen'  + '/' + 'Bukti Tempat Tinggal') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-tab-konsumen//*[text()=' Selanjutnya ']"]));
*/

// Edit FAP
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Summary']"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[3]/div"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-summary-fap//*[text()='Edit Data'])"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-fap//document-preview)[1]//img"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='formFAPslideUpActions']//*[@class='slide-up-content']/div[2]/input"]), bpkbPath);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-fap//document-preview)[2]//img"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='formFAPslideUpActions']//*[@class='slide-up-content']/div[2]/input"]), bpkbPath);
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Edit' + '/' + 'Tab FAP' ) + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-fap//button[text()=' Selanjutnya ']"]));

// Edit CP
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Summary']"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[4]/div"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-summary-cp-penjamin//*[text()='Edit Data'])"]))
WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-contact-person//*[@id='kodePos']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-contact-person//*[@id='kodePos']"]), CP_EditKodePos)
WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@id='hubunganDenganDebitur']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@id='hubunganDenganDebitur']"]), CP_EditHubunganDebitur)
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Edit' + '/' + 'Tab CP' ) + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-tab-cp-penjamin//button[text()=' Selanjutnya ']"]))


// Edit Collateral
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Summary']"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[6]/div"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-summary-collateral//*[text()='Edit Data'])"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-collateral//*[text()='Branch Dealer']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//*[text()='${Cl_EditDealer}']"]))

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-collateral//document-preview)[1]//img"]))
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='formCollateralslideUpActions']//*[@class='slide-up-content']/div[2]/input"]), bpkbPath);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-collateral//document-preview)[2]//img"]))
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='formCollateralslideUpActions']//*[@class='slide-up-content']/div[2]/input"]), stnkPath);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-collateral//document-preview)[3]//img"]))
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='formCollateralslideUpActions']//*[@class='slide-up-content']/div[2]/input"]), stnkPath);
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Edit' + '/' + 'Tab Collateral' ) + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-collateral//button[text()=' Selanjutnya ']"]))

// Edit Loan Data
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Summary']"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[7]/div"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-summary-loan//*[text()='Edit Data'])"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-car-detail-insurance//*[text()='TJH'])[1]"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//*[text()='$L_EditTJH']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-credit-protection//*[text()='Maskapai Asuransi']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//*[text()='$L_EditMaskapaiAsuransi']"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Edit' + '/' + 'Tab Loan Data' ) + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-loan//button[text()=' Selanjutnya ']"]))

// Edit Penyimpangan
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Summary']"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='bcaf-accordion-container single-open']/ac-group[8]/div"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-summary-penyimpangan//*[text()='Edit Data'])"]))
// -- Hapus Penyimpangan
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-penyimpangan//*[@class='close-btn-container ng-star-inserted'])[1]"]))

// -- Tambah Penyimpangan Tambahan
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[@alt='tambah penyimpangan'])[1]"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='penyimpanganTambahan']//*[@formcontrolname='jabatan']"]))
WebDriver driver = DriverFactory.getWebDriver()
WebElement element = driver.findElement(By.xpath("//div[@id='penyimpanganTambahan']//*[@formcontrolname='jabatan']"))
element.click();

switch(P_TambahJabatan) {
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

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//textarea[@id='description']"]), P_EditPenyimpanganTambahanDescription)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//button[text()=' Simpan ']"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Edit' + '/' + 'Tab Penyimpangan' ) + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-penyimpangan//button[text()=' Selanjutnya ']"]))