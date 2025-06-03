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
String pengajuanPemohonPath = "${userDir}${GlobalVariable.pengajuanPemohonPath}".replace("/", "\\")
String selfiePath = "${userDir}${GlobalVariable.selfiePath}".replace("/", "\\")
String ktpPath = "${userDir}${GlobalVariable.ktpPath}".replace("/", "\\")
String bpkbPath = "${userDir}${GlobalVariable.bpkbPath}".replace("/", "\\")
String kkPath = "${userDir}${GlobalVariable.kkPath}".replace("/", "\\")
String baseDir = System.getProperty('user.dir')
WebDriver driver = DriverFactory.getWebDriver()

// TAB Konsumen
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//a//*[text()='Konsumen']"]));

// --- Data Konsumen ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[1]"]));
WebUI.waitForElementClickable(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@id='formSelfieKonsumen']//document-preview[@id='selfieKonsumen'])[1]"]), 0, FailureHandling.STOP_ON_FAILURE)

// --- Selfie Konsumen ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@id='formSelfieKonsumen']//document-preview[@id='selfieKonsumen'])[1]"]), FailureHandling.OPTIONAL);
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[contains(text(),'Upload File')]/preceding-sibling::input[@type='file']"]), selfiePath, FailureHandling.OPTIONAL);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//button[text()='Verifikasi'])[1]"]), FailureHandling.OPTIONAL);

// --- Selfie Padangan ---
//if (K_Status == 'Married') {
//	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@id='formSelfieKonsumen']//document-preview[@id='selfieKonsumen'])[2]"]), FailureHandling.OPTIONAL);
//	WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[contains(text(),'Upload File')]/preceding-sibling::input[@type='file']"]), selfiePath, FailureHandling.OPTIONAL);
//	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//button[text()='Verifikasi'])[1]"]), FailureHandling.OPTIONAL);
//}

// --- Upload NPWP ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='NPWP']//div[contains(@class, 'document-preview')]"]), FailureHandling.OPTIONAL);
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), npwpPath, FailureHandling.OPTIONAL);

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='npwpNomor']"]), K_nomorNPWP);

switch(K_NpwpMilik) {
	case 'konsumen':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@value='konsumen']/following-sibling::span"]));
		break;
	case 'pasangan':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@value='pasangan']/following-sibling::span"]));
		break;
}

WebUI.delay(3);

// --- Pengajuan Pemohon ---
if (K_PengajuanPemohon == 'Yes') {
	WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//label[normalize-space()='Ya']"]));
	WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//label[normalize-space()='Ya']"]), 0);
	WebUI.delay(2);
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//img[@alt='Tambah Dokumen']"]), FailureHandling.STOP_ON_FAILURE);
	WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='capture-option']//input[@type='file']"]), pengajuanPemohonPath, FailureHandling.STOP_ON_FAILURE);
	WebUI.delay(5)
}

// --- Pekerjaan/Usaha ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//body/app-root/app-protected-layout[@class='ng-star-inserted']/app-form-input-pengajuan[@class='ng-star-inserted']/div[@class='mobile-container']/div[@class='fixed-top-container']/div[@class='tabset-container-overflow ng-star-inserted']/tabset[@type='pills']/div[@class='tab-content']/tab[@id='tab_konsumen']/div[@class='pengajuan-content overflow-auto']/app-tab-konsumen[@class='ng-star-inserted']/div[@class='container overflow-auto mb-6']/bcaf-accordion[@class='ng-star-inserted']/div[@class='bcaf-accordion-container theme-bcaf single-open']/ac-group[2]/div[1]/div[1]"]));
WebUI.delay(1);

// --- Upload Slip Gaji ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='document-preview half ng-star-inserted'])[3]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPath);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//option[@value='${K_TipeDokumen}']"]), FailureHandling.OPTIONAL);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Simpan']"]));
WebUI.delay(2)

// --- Pekerjaan Konsumen ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='pekerjaan']"]), FailureHandling.OPTIONAL);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//strong[text()='$K_Pekerjaan'])"]), FailureHandling.OPTIONAL);

WebUI.delay(2)
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='lamaBekerja']//input[@name='lamaTahunBekerja']"]), K_lamaTahunBekerja);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='lamaBekerja']//input[@name='lamaBulanBekerja']"]), K_lamaBulanBekerja);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//textarea[@id='deskripsiPekerjaan']"]), K_deskripsiPekerjaan);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='totalPenghasilan'])[1]"]), K_TotalPenghasilan);

// --- Kode Ekonomi ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[text()='Kode Ekonomi'])[1]"]));
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='searchInput']"]), K_KodeEkonomi);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//strong)[1]"]));

def UMKM = K_umkm

switch(K_Pekerjaan) {
	case 'Wiraswasta':
	case 'Karyawan':
	case 'ABRI':
	case 'Pengacara':
	case 'Lainnya':
	if(K_Pekerjaan == 'Wiraswasta') {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//label[@class='rb-container text-muted w-50'][normalize-space()='$UMKM']"]));
	}
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='namaPerusahaan']"]), K_NamaPerusahaan);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='jabatanProfesi']"]), K_Jabatan);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='tahunPerusahaanDidirikan']"]), K_TahunBerdiri);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='jenisUsaha']"]), K_JenisUsaha);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//textarea[@id='alamat'])[1]"]), K_alamatPerusahaan);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='kodePos'])[1]"]), K_kodePosPerusahaan);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nomorTelepon'])[1]"]), K_noTlpnPerusahaan);
		break;
	default:
		break;
}


// --- Data Pekerjaan Pasangan ---
if(K_Status == 'Married') {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[text()='Pekerjaan'])[2]"]));
	WebUI.delay(2);
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//strong[text()='$K_PekerjaanPasangan'])"]));
	
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='lamaBekerjaPasangan']//input[@name='lamaTahunBekerja']"]), K_lamaTahunBekerjaPasangan);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='lamaBekerjaPasangan']//input[@name='lamaBulanBekerja']"]), K_lamaBulanBekerjaPasnagan);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='totalPenghasilanPasangan'])[1]"]), K_TotalPenghasilanPasangan);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//textarea[@id='deskripsiPekerjaanPasangan']"]), K_deskripsiPekerjaanPasangan);
	
	switch(K_PekerjaanPasangan) {
		case 'Wiraswasta':
		case 'Karyawan':
		case 'ABRI':
		case 'Pengacara':
		case 'Lainnya':
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='namaPerusahaanPasangan'])[1]"]), K_NamaPerusahaanPasangan);
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='jabatanProfesiPasangan'])[1]"]), K_JabatanPasangan);
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tahunPerusahaanDidirikanPasangan'])[1]"]), K_TahunPerusahaanPasangan);
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='jenisUsahaPasangan'])[1]"]), K_JenisUsahaPasangan);
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//textarea[@id='alamatPasangan'])[1]"]), K_alamatPerusahaan);
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='kodePosPasangan'])[1]"]), K_KodePosPasangan);
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nomorTeleponPasangan'])[1]"]), K_NomorTeleponPasangan);
			break;
		default:
			break;
	}
}
WebUI.delay(1);

// --- KK & Tabungan ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[2]"]));

// --- Uplaod KK ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-data-kk//img[@class='img-placeholder'])[1]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), kkPath);
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//option[@value='${K_TipeKK}']"]), FailureHandling.OPTIONAL);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Simpan']"]));

// --- Pendidikan Terakhir ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Pendidikan Terakhir Konsumen']"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//strong[text()='$K_PendidikanTerakhir'])"]));

// --- Kepemilikan Rekening Bank ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[contains(text(),'Foto Kepemilikan Rekening Bank')]/following::div[contains(@class,'document-preview')][1]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), kkPath);
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//option[@value='${K_TipeBank}']"]), FailureHandling.OPTIONAL);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Simpan']"]));

// --- Input No.Rek ---
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='noRekening'])[1]"]), K_NoRek);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='rekeningAtasNama'])[1]"]), K_NamaRek);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='pembayaran']"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//strong[text()='$K_Pembayaran'])"]));
WebUI.delay(2)

// --- Auto Debet ---
if(K_Pembayaran == 'Auto Debet' && K_AutoDebetOrangLain == 'y') {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Autodebet ke rekening lain']"]));
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='noRekeningAutodebet'])[1]"]), K_RekAutoDebet, FailureHandling.CONTINUE_ON_FAILURE);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='namaAutodebet'])[1]"]), K_NamaAutoDebet, FailureHandling.CONTINUE_ON_FAILURE);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nikAutodebet'])[1]"]), K_NikAutoDebet, FailureHandling.CONTINUE_ON_FAILURE);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='hubunganDenganKonsumen'])[1]"]), K_HubAutoDebet, FailureHandling.CONTINUE_ON_FAILURE);
}

// --- Data Mutasi Rekening ---
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='totalMutasiDebit']"]), K_totalMutasiDebit);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='totalMutasiKredit']"]), K_totalMutasiKredit);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='saldoMengendap']"]), K_saldoMengendap);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Cek Validasi Rekening ']"]));
WebUI.delay(5);

// --- Bukti Tempat Tinggal ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[3]"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Status Rumah']"]));
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${K_StatusKepemilikanRumah}']"]));
WebUI.delay(3);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='luasTanah']"]), K_luasTanah);
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='luasBangunan']"]), K_luasBangunan);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-data-kepemilikan//img[@class='img-placeholder'])[1]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPath);
WebUI.delay(3);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//option[@value='${K_StatusRumah}']"]), FailureHandling.OPTIONAL);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Simpan']"]));
WebUI.delay(2);


//------------Screenshot------------
// --- Section Data Konsumen ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[1]"]));
WebUI.delay(5)
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//a//*[text()='Konsumen']"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '8. Tab Konsumen' + '/' + 'Konsumen (1)') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='NPWP']//div[contains(@class, 'document-preview')]"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '8. Tab Konsumen' + '/' + 'Konsumen (2)') + '.png', FailureHandling.STOP_ON_FAILURE)

// --- Section Pekerjaan ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[1]"]));
WebUI.delay(5)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '8. Tab Konsumen' + '/' + 'Konsumen (3)') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='jabatanProfesi']"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '8. Tab Konsumen' + '/' + 'Konsumen (4)') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nomorTelepon'])[1]"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '8. Tab Konsumen' + '/' + 'Konsumen (5)') + '.png', FailureHandling.STOP_ON_FAILURE)

// --- Section KK dan Tabungan ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[2]"]));
WebUI.delay(5)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '8. Tab Konsumen' + '/' + 'Konsumen (6)') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='rekeningAtasNama'])[1]"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '8. Tab Konsumen' + '/' + 'Konsumen (7)') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='saldoMengendap']"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '8. Tab Konsumen' + '/' + 'Konsumen (8)') + '.png', FailureHandling.STOP_ON_FAILURE)
 
// --- Section Bukti Tempat Tinggal ---
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='ac-title'])[3]"]));
WebUI.delay(5)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '8. Tab Konsumen' + '/' + 'Konsumen (9)') + '.png', FailureHandling.STOP_ON_FAILURE)

// --- Selanjutnya ---
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[contains(text(),'Selanjutnya')]"]));
WebUI.delay(3)

