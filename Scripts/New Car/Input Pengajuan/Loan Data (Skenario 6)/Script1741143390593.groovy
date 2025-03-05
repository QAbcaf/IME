import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.sql.Driver

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

import org.junit.runner.notification.Failure
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebElement as Keys

String userDir = RunConfiguration.getProjectDir()
String selfiePath = "${userDir}${GlobalVariable.selfiePath}".replace("/", "\\")
String ktpPath = "${userDir}${GlobalVariable.ktpPath}".replace("/", "\\")
String bpkbPath = "${userDir}${GlobalVariable.bpkbPath}".replace("/", "\\")
String baseDir = System.getProperty('user.dir')

// TAB Collateral
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Loan Data']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@id='loanpacket']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//input[@id='searchInput']"]), L_LoanPacket)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up-content']/div[1]//strong[@class='ng-star-inserted'][1]"]))

def LoanData = [
	['tenor', L_Tenor],
	['OTR', L_OTR],
	['uangMukaPersen', L_PersenDP],
//	['uangMuka', L_DP],
	['residual', L_Residual],
	['flatRate', L_FlatRate],
	['effectiveRate', L_EffRate],
	['biayaAdmin', L_BiayaAdmin],
	['provisiPersen', L_PersenProvisi],
//	['biayaProvisi', L_BiayaProvisi],
]

WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-input-pengajuan-loan//input[@id='uangMukaPersen']"]), FailureHandling.OPTIONAL)

for (data in LoanData) {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-input-pengajuan-loan//input[@id='${data[0]}']"]), data[1])
}

switch(L_LoanType) {
	case 'In Advance':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='loanType' and @value='A']"]))
		break;
	case 'In Arrear':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='loanType' and @value='R']"]))
		break;
}

switch(L_RateType) {
	case 'Prepaid':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentTypeBiayaAdmin' and @value='0']"]))
		break;
	case 'On Loan':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentTypeBiayaAdmin' and @value='1']"]))
		break;
}

switch(L_ProvisiType) {
	case 'Prepaid':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentTypeProvisi' and @value='0']"]))
		break;
	case 'On Loan':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentTypeProvisi' and @value='1']"]))
		break;
}

// Asuransi Mobil
def AsuransiMobil = [
	['Car Insurance Corp', L_InsuranceCorp],
	['Car Insurance Branch', L_InsuranceBranch],
]

for (data in AsuransiMobil) {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='label is-required' and text()='${data[0]}']"]))
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//input[@id='searchInput']"]), data[1])
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up-content']/div[1]//strong[@class='ng-star-inserted' and text()='${data[1]}'][1]"]))
}

// Detail Asuransi Mobil
// All
def AllDetailAsuransiMobil = [
	['Tipe Asuransi', L_DetailTipeAsuransiAll],
	['TJH', L_DetailTJHAll],
]

for (data in AllDetailAsuransiMobil) {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='tab-content']/tab[1][@_ngcontent-ng-c681861567='']//*[text()='${data[0]}']"]))
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[@class='slide-up-content']//strong[text()='${data[1]}'])[2]"]))
}

def AllDetailAsuransiMobil2 = [
	['nominalDeduction', L_DetailAsuransiNominalDeductionPersen],
	['OTR', L_DetailAsuransiNominalDeduction],
]

for (data in AllDetailAsuransiMobil2) {
	WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='tab-content']/tab[1][@_ngcontent-ng-c681861567='']//input[@id='${data[0]}']"]), FailureHandling.OPTIONAL)
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='tab-content']/tab[1][@_ngcontent-ng-c681861567='']//input[@id='${data[0]}']"]), data[1])
}

WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()=' RSCC']"]))
WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()=' RSMB']"]))

switch(L_DetailAsuransiLoanType) {
	case 'Prepaid':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentType' and @value='0']"]))
		break;
	case 'On Loan':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentType' and @value='1']"]))
		break;
}

// Credit Protection
def CreditProtection = [
	['Maskapai Asuransi', L_MaskapaiAsuransi],
	['Branch', L_Branch],
]

for (data in CreditProtection) {
	 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='label is-required' and text()='${data[0]}']"]))
	 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up-content']//*[text()='${data[1]}']"]))
}

// Asuransi Lainnya
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-other-insurance//strong[text()='Asuransi Lainnya']/following-sibling::img"]))
def AsuransiLainnya = [
	['Asuransi Lainnya', L_AsuransiLainnya],
	['Maskapai', L_AsuransiLainnyaMaskapai],
	['Pertanggungan', L_AsuransiLainnyaPertanggungan],
]

for (data in AsuransiLainnya) {
	 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='modal-body']//*[@class='label is-required' and text()='${data[0]}']"]))
	 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='drawer-select show']//*[text()='${data[1]}']"]))
}

switch(L_AsuransiLainnyaLoanType) {
	case 'Prepaid':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='modal-body']//label[text()=' Prepaid ']"]))
		break;
	case 'On Loan':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='modal-body']//label[text()=' On Loan ']"]))
		break;
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='modal-body']//button[text()='Simpan']"]))
WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-other-insurance//input[@id='persenDeduction']"]), FailureHandling.OPTIONAL)
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-other-insurance//input[@id='persenDeduction']"]), L_AsuransiLainnyaPersenDeduction)
WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-other-insurance//input[@id='nominalDeduction']"]), FailureHandling.OPTIONAL)
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-other-insurance//input[@id='nominalDeduction']"]), L_AsuransiLainnyaNominalDeduction)

// Biaya Lainnya
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-other-fee//strong[text()='Biaya Lainnya']/following-sibling::img"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='modal-body']//div[text()='Fee']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='drawer-select show']//*[text()='${L_BiayaLainnyaFee}']"]))
switch(L_BiayaLainnyaLoanType) {
	case 'Prepaid':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='modal-body']//label[text()=' Prepaid ']"]))
		break;
	case 'On Loan':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='modal-body']//label[text()=' On Loan ']"]))
		break;
}
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='modal-body']//button[text()='Simpan']"]))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Hitung']"]))
WebUI.delay(4)

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Selanjutnya ' and @_ngcontent-ng-c2294179180='']"]))