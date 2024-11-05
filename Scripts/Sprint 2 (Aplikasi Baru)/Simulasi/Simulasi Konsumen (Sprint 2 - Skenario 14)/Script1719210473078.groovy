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
String npwpPath = "${userDir}${GlobalVariable.npwpPath}".replace("/", "\\")
String selfiePath = "${userDir}${GlobalVariable.selfiePath}".replace("/", "\\")
String ktpPath = "${userDir}${GlobalVariable.ktpPath}".replace("/", "\\")
String bpkbPath = "${userDir}${GlobalVariable.bpkbPath}".replace("/", "\\")
String kkPath = "${userDir}${GlobalVariable.kkPath}".replace("/", "\\")
String baseDir = System.getProperty('user.dir')
WebDriver driver = DriverFactory.getWebDriver()

// TAB Konsumen
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//a//*[text()='Konsumen']"]));

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[1]"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-data-konsumen//img[@class='img-placeholder'])[1]"]), FailureHandling.OPTIONAL);
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), selfiePath, FailureHandling.OPTIONAL);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//button[text()='Verifikasi'])[1]"]), FailureHandling.OPTIONAL);

if (status == 'Married') {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-data-konsumen//img[@class='img-placeholder'])[1]"]), FailureHandling.OPTIONAL);
	WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), selfiePath, FailureHandling.OPTIONAL);
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//button[text()='Verifikasi'])[1]"]), FailureHandling.OPTIONAL);
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-data-konsumen//img[@class='img-placeholder'])[1]"]), FailureHandling.OPTIONAL);
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), npwpPath, FailureHandling.OPTIONAL);

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='npwpNomor']"]), NPWP_Nomor);

switch(BaruNPWPMilik) {
	case 'konsumen':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@value='konsumen']/following-sibling::span"]));
		break;
	case 'pasangan':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@value='pasangan']/following-sibling::span"]));
		break;
}

WebUI.delay(1);
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '15 Tab Konsumen'  + '/' + 'Data Konsumen') + '.png', FailureHandling.STOP_ON_FAILURE)

// Pekerjaan
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[1]"]));
WebUI.delay(1);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-data-pekerjaan//img[@class='img-placeholder'])[1]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPath);
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//select)"]), FailureHandling.OPTIONAL);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//option[@value='${tipe_dokumen}']"]), FailureHandling.OPTIONAL);
//WebUI.selectOptionByValue(findTestObject('Object Repository/xpath', ['xpath' : "//select"]), tipe_dokumen, false);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Simpan']"]));

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[text()='Pekerjaan'])[1]"]));
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${pekerjaan_k}']"]), 0);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${pekerjaan_k}']"]));

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[text()='Kode Ekonomi'])[1]"]));
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='searchInput']"]), kode_ekonomi);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[contains(text(), '${kode_ekonomi}')]"]));

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='namaPerusahaan']"]), nama_perusahaan);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='jabatanProfesi']"]), jabatan);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='tahunPerusahaanDidirikan']"]), tahun_berdiri);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='jenisUsaha']"]), jenis_usaha);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='totalPenghasilan'])[1]"]), total_penghasilan_k);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//textarea[@id='alamat'])[1]"]), alamat_perusahaan);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='kodePos'])[1]"]), kodePos_perusahaan);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nomorTelepon'])[1]"]), kodePos_noTelp);

if(status == 'Married') {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[text()='Pekerjaan'])[2]"]));
	WebUI.delay(2);
	WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${pekerjaan_pasangan}']"]), 0);
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${pekerjaan_pasangan}']"]));
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='totalPenghasilanPasangan'])[1]"]), total_penghasilan_pasangan);
	
	switch(pekerjaan_pasangan) {
		case 'Karyawan':
		case 'ABRI':
		case 'Pengacara':
		case 'Lainnya':
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='namaPerusahaanPasangan'])[1]"]), namaPerusahaan_pasangan);
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='jabatanProfesiPasangan'])[1]"]), jabatan_pasangan);
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tahunPerusahaanDidirikanPasangan'])[1]"]), tahunPerusahaan_pasangan);
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='jenisUsahaPasangan'])[1]"]), jenisUsaha_pasangan);
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//textarea[@id='alamatPasangan'])[1]"]), alamatPerusahaan_pasangan);
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='kodePosPasangan'])[1]"]), kodePos_pasangan);
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nomorTeleponPasangan'])[1]"]), nomorTelepon_pasangan);
			break;
		default:
			break;
	}
}
WebUI.delay(1);
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '15 Tab Konsumen'  + '/' + 'Pekerjaan') + '.png', FailureHandling.STOP_ON_FAILURE)

// KK, Tabungan, dan Kartu Nama
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[2]"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-data-kk//img[@class='img-placeholder'])[1]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), kkPath);
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//option[@value='${tipe_kk}']"]), FailureHandling.OPTIONAL);
//WebUI.selectOptionByValue(findTestObject('Object Repository/xpath', ['xpath' : "//select"]), tipe_kk, false);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Simpan']"]));

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Pendidikan Terakhir Konsumen']"]));
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${pendidikan_terakhir}']"]), 0);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${pendidikan_terakhir}']"]));

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-data-kk//img[@class='img-placeholder'])[1]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), kkPath);
WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//option[@value='${tipe_bank}']"]), FailureHandling.OPTIONAL);
//WebUI.selectOptionByValue(findTestObject('Object Repository/xpath', ['xpath' : "//select"]), tipe_bank, false);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Simpan']"]));

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='noRekening'])[1]"]), no_rek);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='rekeningAtasNama'])[1]"]), nama_rek);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Pembayaran']"]));
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${pembayaran}']"]), 0);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${pembayaran}']"]));

if(pembayaran == 'Auto Debet' && autodebet_orglain == 'y') {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Autodebet ke rekening lain']"]));
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='noRekeningAutodebet'])[1]"]), rek_autodebet);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='namaAutodebet'])[1]"]), nama_autodebet);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nikAutodebet'])[1]"]), nik_autodebet);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='hubunganDenganKonsumen'])[1]"]), hubungan_autodebet);
}
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Cek Validasi Rekening ']"]));
WebUI.delay(1);
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '15 Tab Konsumen'  + '/' + 'KK Tabungan dan Kartu Nama') + '.png', FailureHandling.STOP_ON_FAILURE)

// Bukti Tempat Tinggal
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[3]"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Status Rumah']"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='$statusKepemilikanRumah'])[1]"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-data-kepemilikan//img[@class='img-placeholder'])[1]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPath);
WebUI.delay(1);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//option[@value='${status_rumah}']"]), FailureHandling.OPTIONAL);
WebUI.selectOptionByValue(findTestObject('Object Repository/xpath', ['xpath' : "//select"]), status_rumah, false);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Simpan']"]));
WebUI.delay(1);
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '15 Tab Konsumen'  + '/' + 'Bukti Tempat Tinggal') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-tab-konsumen//button[text()=' Selanjutnya ']"]));
WebUI.delay(3)
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '15 Tab Konsumen'  + '/' + 'Konsumen Selanjutnya') + '.png', FailureHandling.STOP_ON_FAILURE)

