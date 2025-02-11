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

// Random path
String userDir = RunConfiguration.getProjectDir()
String selfiePath = "${userDir}${GlobalVariable.selfiePath}".replace("/", "\\")
String ktpPath = "${userDir}${GlobalVariable.ktpPath}".replace("/", "\\")
String ktpPathPasangan = "${userDir}${GlobalVariable.ktpPathPasangan}".replace("/", "\\")
String npwpPath = "${userDir}${GlobalVariable.npwpPath}".replace("/", "\\")
String bpkbPath = "${userDir}${GlobalVariable.bpkbPath}".replace("/", "\\")
String baseDir = System.getProperty('user.dir')

// Input Pengajuan
def inputData = [
	['tempatLahir', BaruTempatLahir],
	['kodePos', BaruKodePos],
	['email', BaruEmail]
]

def searchData = [
	['Sandi Lahir', BaruSandiLahir],
	['Sandi Dati', BaruSandiDati],
	['Status Pernikahan', BaruStatus]
]

void hideElements() {
	WebUI.executeJavaScript("document.querySelector('.title-header').style.display='none'", null)
}

void showElements() {
	WebUI.executeJavaScript("document.querySelector('.title-header').style.display=''", null)
}

String stat = '';

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div//img[@class='img-placeholder']"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPath);
WebUI.delay(15)

for (data1 in searchData){
	WebUI.delay(1);
	if (data1[1]) {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[text()='${data1[0]}'])[1]"]));
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='searchInput']"]), data1[1]);
		WebUI.delay(2);
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[contains(text(), '${data1[1]}')]"]));
	}
	else {
		continue;
	}
}

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='email'])[1]"]), BaruEmail);
WebUI.delay(1);

stat = WebUI.getText(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='statusPerkawinan']/div[@class='value']"]));
println(stat);

status = stat;
println(status);

if (stat == 'Married') {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Pilih Jenis Identitas']"]));
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${BaruJenisIdentitasPasangan}']"]));
	WebUI.delay(2);
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div//img[@class='img-placeholder'])"]));
	WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPathPasangan);
	
	if(BaruAlamatSama == 'yes') {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='alamatSamaDenganKonsumen']/following-sibling::span"]));
	}
	
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='pasangan_nama']"]), BaruNamaPasangan);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='pasangan_nomorIdentitas']"]), BaruNIKPasangan);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='pasangan_tanggalLahir']"]), BaruPasanganDOB);
	
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='email'])[2]"]), BaruEmailPasangan);
	
	String hp = BaruHandphonePasangan;
	String prefix = hp.substring(0, 4);
	String no_hp = hp.substring(4);
	
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='extension'])[2]"]), prefix);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='noHp'])[2]"]), no_hp);
	
//	WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSprint3)) + '/' + konsumen  + '/' + 'input_data_pasangan') + '.png', FailureHandling.STOP_ON_FAILURE)
}

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='kodePos'])[1]"]), BaruKodePosKTP);

// Input Loan Data
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='dp']"]), BaruLoanDataDP);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Purpose']"]));
WebUI.delay(1);
switch(BaruPurpose) {
	case 'Operasional':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up show']//strong[text()='Operasional']"]));
		break;
	case 'Personal':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up show']//strong[text()='Personal']"]));
		break;
	case 'Komersial':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up show']//strong[text()='Komersial']"]));
		break;
}

switch(BaruLoanType) {
	case 'In Arrear':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@value='R']/following-sibling::span"]));
		break;
	case 'In Advance':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@value='A']/following-sibling::span"]));
		break;
}

hideElements();
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Input Pengajuan') + '.png', FailureHandling.STOP_ON_FAILURE)
showElements();

/*
// Setelah Pre Screening
if(BaruStatus == 'Married') {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Matching Pasangan']"]));
} else WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Pre-Screening']"]));
WebUI.delay(3)
*/
//WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Hasil Pre-Screening') + '.png', FailureHandling.STOP_ON_FAILURE)