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

void hideElements() {
	WebUI.executeJavaScript("document.querySelector('.account-header').style.display='none'", null)
	WebUI.executeJavaScript("document.querySelector('.button-container').style.display='none'", null)
}

void showElements() {
	WebUI.executeJavaScript("document.querySelector('.account-header').style.display=''", null)
	WebUI.executeJavaScript("document.querySelector('.button-container').style.display=''", null)
}

void takeFullPageScreenshot(String path) {
	WebUI.takeFullPageScreenshot(path, FailureHandling.STOP_ON_FAILURE)
}

void handleField(String field, String description, String screenshotName, String tab) {
	String baseDir = System.getProperty('user.dir')
	WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "//checker-field[@field='" + field + "']//input/following-sibling::span"]), 0)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//checker-field[@field='" + field + "']//input/following-sibling::span"]))
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "//textarea[@id='description']"]), pendingMessage + ' ' + description)
	WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + tab + '/' + screenshotName, FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Simpan']"]))
}

void handleFieldCategory(String category, String description, String screenshotName, Integer index, String tab) {
	String baseDir = System.getProperty('user.dir')
	WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "(//checker-field[@category='$category']//input/following-sibling::span)[$index]"]), 0)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "(//checker-field[@category='$category']//input/following-sibling::span)[$index]"]))
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "//textarea[@id='description']"]), pendingMessage + ' ' + description)
	WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + tab + '/' + screenshotName, FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Simpan']"]))
}

void handleFieldCustom(String field, String description, String screenshotName, String tab, Integer index) {
	String baseDir = System.getProperty('user.dir')
	WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "(//checker-custom-note[@field='" + field + "']//input/following-sibling::span)['" + index + "']"]), 0)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "(//checker-custom-note[@field='" + field + "']//input/following-sibling::span)['" + index + "']"]))
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "//textarea[@id='description']"]), pendingMessage + ' ' + description)
	WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + tab + '/' + screenshotName, FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Simpan']"]))
}

void handleFieldLabel(String label, String description, String screenshotName, Integer index, String tab) {
	String baseDir = System.getProperty('user.dir')
	WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "(//checker-field[@label='" + label + "']//input/following-sibling::span)['" + index + "']"]), 0)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "(//checker-field[@label='" + label + "']//input/following-sibling::span)['" + index + "']"]))
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "//textarea[@id='description']"]), pendingMessage + ' ' + description)
	WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + tab + '/' + screenshotName, FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Simpan']"]))
}

// 1) Tab Konsumen
// -- KTP Konsumen
handleField('email', 'email', '1 Pending Email.png', 'Tab Konsumen')
handleField('pekerjaan', 'pekerjaan', '2 Pending Pekerjaan.png', 'Tab Konsumen')
handleField('noRekening', 'noRekening', '3 Pending noRekening.png', 'Tab Konsumen')
handleField('pendidikanTerakhirKonsumen', 'pendidikanTerakhirKonsumen', '4 Pending pendidikanTerakhirKonsumen.png', 'Tab Konsumen')
handleField('alamat', 'alamat', '5 Pending alamat.png', 'Tab Konsumen')
handleFieldCategory('deviasi', 'deviasi', '6 Pending deviasi.png', 1, 'Tab Konsumen')
handleFieldCategory('deviasi', 'deviasi', '7 Pending Penyimpangan Tambahan.png', 1, 'Tab Konsumen')

hideElements()
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Konsumen' + '/' + '8 Halaman KTP Konsumen.png')

// -- Selfie Konsumen
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//a[text()='Selfie Konsumen']"]))
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Konsumen' + '/' + '9 Halaman Selfie Konsumen.png')

// -- NPWP
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//a[text()='NPWP']"]))
handleField('npwp', 'npwp', '10 Pending npwp.png', 'Tab Konsumen')
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Konsumen' + '/' + '11 Halaman NPWP Konsumen.png')
showElements()

// 2) Tab FAP
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//div[text()='FAP']"]))
handleFieldCustom('alamat', 'alamat', '1 Pending Mail Address.png', 'Tab FAP', 2)
handleFieldCustom('alamat', 'alamat', '2 Pending Alamat Domisili ECN.png', 'Tab FAP', 3)
handleFieldCustom('alamat', 'alamat', '3 Pending Alamat Domisili Penjamin.png', 'Tab FAP', 4)

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "(//checker-field)[5]"]), 0)

hideElements()
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Konsumen' + '/' + '12 Halaman FAP 1.png')
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "(//*[text()='Provinsi'])[2]"]), 0)
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Konsumen' + '/' + '12 Halaman FAP 2.png')
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "(//*[text()='Kode POS'])[3]"]), 0)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/xpath', ['xpath': "//*[text()='NAMA PASANGAN PENJAMIN']"]), 0)) {
    WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "//*[text()='NAMA PASANGAN PENJAMIN']"]), 0)
    takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Konsumen' + '/' + '12 Halaman FAP 3.png')
}

showElements()
 
// 3) Tab Matching Result
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//div[text()='MATCHING RESULT']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "(//checker-field)[2]//span"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "//textarea[@id='description']"]), '1 Pending Matching Penjamin')
WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Matching Result' + '/' + '13 Pending Penjamin.png', FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Simpan']"]))

hideElements()
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Matching Result' + '/' + '14 Halaman Matching Penjamin.png')
showElements()

// 4) Collateral
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//div[text()='COLLATERAL']"]))
handleFieldLabel('No. BPKB', 'No. BPKB', '15 Pending No. BPKB.png', 1, 'Tab Collateral')
handleField('bpkbNomorRangka', 'bpkbNomorRangka', '16 Pending bpkbNomorRangka.png', 'Tab Collateral')

hideElements()
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Collateral' + '/' + '17 Halaman Collateral - BPKB.png')

WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//a[text()=' STNK - Tampak Depan ']"]))
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Collateral' + '/' + '18 Halaman Collateral - STNK Belakang.png')

WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//a[text()=' STNK - Tampak Belakang ']"]))
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Collateral' + '/' + '19 Halaman Collateral - STNK Belakang.png')
showElements()

// 5) Loan Data
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//div[text()='LOAN DATA']"]))
handleFieldLabel('Paket', 'Paket', '20 Pending Paket.png', 1, 'Tab Loan Data')
handleFieldLabel('Paket DP', 'Paket DP', '21 Pending Paket DP.png', 1, 'Tab Loan Data')
handleFieldLabel('Payment', 'Payment', '22 Pending Payment.png', 1, 'Tab Loan Data')
handleFieldLabel('OTR', 'OTR', '23 Pending OTR.png', 1, 'Tab Loan Data')
handleFieldLabel('O/S PH Manual', 'O/S PH Manual', '24 Pending OS PH Manual.png', 1, 'Tab Loan Data')
handleFieldLabel('Asuransi Mobil', 'Asuransi Mobil', '25 Pending Asuransi Mobil.png', 1, 'Tab Loan Data')
handleFieldLabel('Perusahaan', 'Perusahaan', '26 Pending Perusahaan.png', 1, 'Tab Loan Data')
handleFieldCategory('other_insurance', 'other_insurance', '27 Pending other_insurance.png', 1, 'Tab Loan Data')

hideElements()
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Loan Data' + '/' + '28 Halaman Loan Data.png')
showElements()

// Button Pending
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Pending']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "//textarea[@id='keterangan']"]), 'Pending Keterangan Keseluruhan')
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Loan Data' + '/' + '29 Submit Pending.png')
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Submit Pending']"]))

