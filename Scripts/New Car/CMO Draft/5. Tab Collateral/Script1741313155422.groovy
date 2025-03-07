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

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='dealerMain']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='dealersearchInput']"]), Cl_DealerName)
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//strong)[1]"]))

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Branch Dealer']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='dealersearchInput']"]), Cl_Branch)
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//strong)[1]"]))

def ColateralDataSelect = [
	['Merk', Cl_Merk],
	['Model', Cl_Model],
	['Tipe', Cl_Tipe],
	//['Peruntukan Kendaraan', Cl_PeruntukanKendaraan],
]

for (data in ColateralDataSelect) {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='label is-required' and text()='${data[0]}']"]))
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up show']//*[text()='${data[1]}']"]))
}

WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@value='produktif']/following-sibling::span"]))

def ColateralData = [
	//['tahun', Cl_Tahun],
	['bpkbWarna', Cl_Warna],
	['bpkbNamaKepemilikan', Cl_NamaKepemilikan],
]

for (data in ColateralData) {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='${data[0]}']"]), data[1])
}

if(Cl_TujuanPenggunaan == 'Produktif') {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='tujuanPenggunaan']/label[1]"]))
}else WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='tujuanPenggunaan']/label[2]"]))

	
switch(isNamaSelainKonsumen) {
	case 'yes':
	case 'y':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Menggunakan nama selain konsumen']"]))
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='nomorIdentitasDebitur']"]), Cl_NIKDebitur)
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='hubunganDenganDebitur']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//slide-up//strong[text()='${Cl_HubDebitur}'])[2]"]))
		break;
	case 'no':
	case 'n':
	case '':
		break;
	default:
		break;
}

//------Screenshot------

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[contains(text(),'Showroom')]"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCar)) + '/' + konsumen  + '/' + '28. Tab Collateral') + '.png', FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='Tipe']"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCar)) + '/' + konsumen  + '/' + '29. Tab Collateral') + '.png', FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-collateral//button[text()=' Selanjutnya ']"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCar)) + '/' + konsumen  + '/' + '30. Tab Collateral') + '.png', FailureHandling.OPTIONAL)

//------Screenshot------

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-collateral//button[text()=' Selanjutnya ']"]))
WebUI.delay(3)