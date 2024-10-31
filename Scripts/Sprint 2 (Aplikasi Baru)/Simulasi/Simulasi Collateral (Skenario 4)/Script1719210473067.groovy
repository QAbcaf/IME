import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebElement as Keys

String userDir = RunConfiguration.getProjectDir()
String selfiePath = "${userDir}${GlobalVariable.selfiePath}".replace("/", "\\")
String ktpPath = "${userDir}${GlobalVariable.ktpPath}".replace("/", "\\")
String bpkbPath = "${userDir}${GlobalVariable.bpkbPath}".replace("/", "\\")
String stnkPath = "${userDir}${GlobalVariable.stnkPath}".replace("/", "\\")
String fakturPath = "${userDir}${GlobalVariable.fakturPath}".replace("/", "\\")
String formAPath = "${userDir}${GlobalVariable.formAPath}".replace("/", "\\")
String baseDir = System.getProperty('user.dir')

// TAB Collateral
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Collateral']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Branch Dealer']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='dealersearchInput']"]), Cl_Branch)
WebUI.delay(7)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//strong)[1]"]))

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//tab[@class='tab-pane active']//div[@class='row']//img"]))
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), bpkbPath);

// BPKB
def CPData = [
	['bpkbNomor', Cl_BpkbNo],
	['bpkbNomorMesin', Cl_NoMesin], 
	['bpkbNomorRangka', Cl_NoRangka], 
	['nomorPolisi', 'AB 123 CDE'], 
]

for (data in CPData) {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='${data[0]}']"]), data[1])
}


WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Matching ']"]), FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Lihat Hasil Matching ']"]), FailureHandling.OPTIONAL)
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Refresh']"]), FailureHandling.OPTIONAL)
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '19 Tab Collateral (Hasil Matching)') + '.png', FailureHandling.STOP_ON_FAILURE);
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@id='prescreeningKendaraanModal']//a)[1]"]))

// STNK
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='d-flex gap-2 w-100']/div[1]//img)[1]"]))
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), stnkPath);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='d-flex gap-2 w-100']/div[2]//img)[1]"]))
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), stnkPath);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='d-flex gap-2 w-100']/div[1]//img)[3]"]))
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), formAPath);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='d-flex gap-2 w-100']/div[2]//img)[3]"]))
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), fakturPath);

def ColateralDataSelect = [
	['Merk', Cl_Merk],
	['Model', Cl_Model],
	['Tipe', Cl_Tipe],
	['Peruntukan Kendaraan', Cl_PeruntukanKendaraan],
]

for (data in ColateralDataSelect) {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='label is-required' and text()='${data[0]}']"]))
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up show']//*[text()='${data[1]}']"]))
}

WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@value='produktif']/following-sibling::span"]))

def ColateralData = [
	['tahun', Cl_Tahun],
	['bpkbWarna', Cl_Warna],
	['bpkbNamaKepemilikan', Cl_NamaKepemilikan],
]

for (data in ColateralData) {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='${data[0]}']"]), data[1])
}

switch(isNamaSelainKonsumen) {
	case 'yes':
	case 'y':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Menggunakan nama selain konsumen']"]))
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='nomorIdentitasDebitur']"]), Cl_NIKDebitur)
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//form//input[@id='hubunganDenganDebitur'])[2]"]), Cl_HubDebitur)
		break;
	case 'no':
	case 'n':
	case '':
		break;
	default:
		break;
}

WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '19 Tab Collateral') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-collateral//button[text()=' Selanjutnya ']"]))
WebUI.delay(3)
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '19 Tab Collateral Selanjutnya') + '.png', FailureHandling.STOP_ON_FAILURE);