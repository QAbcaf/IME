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
String ktpPathPasangan = "${userDir}${GlobalVariable.ktpPathPasangan}".replace("/", "\\")
String bpkbPath = "${userDir}${GlobalVariable.bpkbPath}".replace("/", "\\")
String baseDir = System.getProperty('user.dir')

WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Ajukan Sekarang ']"]))

// Input Matching RO
def ROData = [
	['nama', Nama],
	['nomorIdentitas', SimulasiNIK],
	['kodeNoHp', SimulasiKodeHandphone],
	['nomor', SimulasiHandphone],
]

for (data in ROData) {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//modal-container//input[@formcontrolname='${data[0]}']"]), data[1])
}

//DateFunction
def clickPrevious() {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='‹']"]))
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//modal-container//input[@name='tanggalLahir']/following-sibling::a"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//bs-datepicker-navigation-view//*[@class='current']"]))

String[] monthNames = ["", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"]
String[] dobComponents = SimulasiTglLahir.split("/")
String day = dobComponents[0]
int monthInteger = Integer.parseInt(dobComponents[1])
int year = Integer.parseInt(dobComponents[2].trim())
String month = monthNames[monthInteger]
 
int currentYear = Calendar.getInstance().get(Calendar.YEAR);
int difference = currentYear - year;
double boxesToGoBack = (double) difference / 16;
int decimalPart = (int) ((boxesToGoBack - (int) boxesToGoBack) * 10);
 
if (decimalPart <= 4) {
	boxesToGoBack = Math.floor(boxesToGoBack);
} else {
	boxesToGoBack = Math.ceil(boxesToGoBack);
}
 
for (int i = 0; i < boxesToGoBack; i++) {
	clickPrevious();
}
 
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='" + year + "']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='" + month + "']"]))
if(day=='1') {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='" + day + "'])[1]"]))
} else {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='" + day + "'])[1]"]))
}
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '3 input RO Simulasi') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Matching']"]))
WebUI.delay(10)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '4 Matching RO') + '.png', FailureHandling.STOP_ON_FAILURE)

switch (MatchingRO) {
        case 'Pengajuan':
        	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-ro//*[text()=' Pengajuan ']"]))
        	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-matching-ro//input[@name='matching'])[1]"]))
			WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '5 Hasil Matching RO Pengajuan') + '.png', FailureHandling.STOP_ON_FAILURE)
        	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-ro//button[text()='Lanjutkan']"]))
            break;
		case 'Existing':
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-ro//*[text()=' Existing ']"]))
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-matching-ro//input[@name='matching'])[1]"]))
			WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '5 Hasil Matching RO Existing') + '.png', FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-ro//button[text()='Lanjutkan']"]))
            break;
        case 'Not Match':
        	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-matching-ro//*[@class='checkmark'])[1]"]))
			WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '5 Hasil Matching RO Not Match') + '.png', FailureHandling.STOP_ON_FAILURE)
        	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-ro//button[text()='Lanjutkan']"]))
			break;
		default:
			WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '5 Hasil Matching Non RO') + '.png', FailureHandling.STOP_ON_FAILURE)
			break;
}

// Input Pengajuan
switch(SimulasiTLKonsumen) {
	case 'Dalam Negeri':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='tempatLahirLuarNegeri'])[1]"]))
		break;
	case 'Luar Negeri':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='tempatLahirLuarNegeri'])[2]"]))
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='negaraLahir'])[1]"]), SimulasiNegaraLahir)
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tempatLahir'])[1]"]))
		WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tempatLahir'])[1]"]))
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tempatLahir'])[2]"]), SimulasiKotaLahir)
		break;
}

def inputData = [
	['tempatLahir', SimulasiTempatLahir],
	['kodePos', SimulasiKodePos],
	['email', SimulasiEmail]
]

for(data in inputData) {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='${data[0]}'])[1]"]));
	WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='${data[0]}'])[1]"]));
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='${data[0]}'])[1]"]), data[1]);
}

def searchData = [
	['Sandi Lahir', SimulasiSandiLahir],
	['Sandi Dati', SimulasiSandiDati],
	['Status Pernikahan', SimulasiStatus]
]

WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//*[@formcontrolname='jenisKelamin' and @value='L'])[1]"]));
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//textarea[@id='alamat']"]), 'JALAN DIMANA NO 100');

String stat = '';
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='doc-img-container ng-star-inserted'])[1]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPath);

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

WebUI.delay(1);

stat = WebUI.getText(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='statusPerkawinan']/div[@class='value']"]));
status = stat;
println(status);

if (stat == 'Married') {	
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Pilih Jenis Identitas']"]));
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${SimulasiJenisIdentitasPasangan}']"]));
	
	WebUI.delay(1);
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='doc-img-container ng-star-inserted'])[3]"]));
	WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPathPasangan);
	
	WebUI.delay(1);
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nama'])[2]"]));
	WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nama'])[2]"]));
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nama'])[2]"]), SimulasiNamaPasangan);
	
	WebUI.delay(1);
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nomorIdentitas'])[2]"]));
	WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nomorIdentitas'])[2]"]));
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nomorIdentitas'])[2]"]), SimulasiNikPasangan);
	
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@name='tanggalLahirPasangan']/following-sibling::a"]))
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//bs-datepicker-navigation-view//*[@class='current']"]))
	
	String[] dobComponents2 = SimulasiTglLahirPasangan.split("/")
	String day2 = dobComponents2[0]
	int monthInteger2 = Integer.parseInt(dobComponents2[1])
	int year2 = Integer.parseInt(dobComponents2[2].trim())
	String month2 = monthNames[monthInteger2]
	 
	int currentYear2 = Calendar.getInstance().get(Calendar.YEAR);
	int difference2 = currentYear2 - year2;
	double boxesToGoBack2 = (double) difference2 / 16;
	int decimalPart2 = (int) ((boxesToGoBack2 - (int) boxesToGoBack2) * 10);
	 
	if (decimalPart2 <= 4) {
		boxesToGoBack2 = Math.floor(boxesToGoBack2);
	} else {
		boxesToGoBack2 = Math.ceil(boxesToGoBack2);
	}
	 
	for (int i = 0; i < boxesToGoBack2; i++) {
		clickPrevious();
	}
	 
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='" + year2 + "']"]))
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='" + month2 + "']"]))
	
	if( day2 == '1') {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='" + day2 + "'])[1]"]))
	} else {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='" + day2 + "'])[1]"]))
	}
	
	if(SimulasiAlamatSama == 'yes') {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='alamatSesuaiKonsumen']/following-sibling::span"]));
	}
	
	switch(SimulasiTLPasangan) {
		case 'Dalam Negeri':
			WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='tempatLahirLuarNegeri'])[3]"]))
			break;
		case 'Luar Negeri':
			WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='tempatLahirLuarNegeri'])[4]"]))
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='negaraLahir'])"]), SimulasiNegaraLahirPasangan)
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tempatLahir'])"]))
			WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tempatLahir'])"]))
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tempatLahir'])"]), SimulasiKotaLahirPasangan)
			break;
	}
	
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//textarea[@id='alamat']"]), 'JALAN DIMANA NO 100');
	
	// Jika kode pos dan kabupaten belum terisi
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='relative-container mb-2']//input[@id='kodePos']"]), SimulasiKodePos, FailureHandling.OPTIONAL);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='email'])[2]"]), SimulasiEmailPasangan);
	String hp = SimulasiHandphonePasangan;
	String prefix = hp.substring(0, 4);
	String no_hp = hp.substring(4);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='extension'])[2]"]), prefix);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='noHp'])[2]"]), no_hp);
}
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='kodePos'])[1]"]), SimulasiKodePosKTP);

// Input Loan Data
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='dp']"]), SimulasiLoanDataDP);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Purpose']"]));
switch(SimulasiPurpose) {
	case 'Operasional':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='Operasional'])[1]"]));
		break;
	case 'Personal':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='Personal'])[2]"]));
		break;
	case 'Rental':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='Rental'])[1]"]));
		break;
}

switch(SimulasiLoanType) {
	case 'In Arrear':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()=' In Arrear ']"]));
		break;
	case 'In Advance':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()=' In Advance ']"]));
		break;
}

WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '6 Input Pengajuan') + '.png', FailureHandling.STOP_ON_FAILURE)

// Setelah Pre Screening
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Matching Pasangan']"]));
WebUI.delay(7)
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '7 Hasil Matching Pasangan Existing') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//*[text()=' Pengajuan ']"]));
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '8 Hasil Matching Pasangan Pengajuan') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//*[text()=' Reject ']"]));
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '9 Hasil Matching Pasangan Reject') + '.png', FailureHandling.STOP_ON_FAILURE)

switch(MatchingPasangan) {
	case 'Existing':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//*[text()=' Existing ']"]));
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//input[@value='pasangan_0']"]));
		break;
	case 'Pengajuan':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//*[text()=' Pengajuan ']"]));
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//input[@value='pasangan_0']"]));
		break;
}
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//button[text()='Pre-Screening']"]));