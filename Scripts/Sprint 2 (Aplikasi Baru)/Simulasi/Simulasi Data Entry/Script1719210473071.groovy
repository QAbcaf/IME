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

// (Skenario 3)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='top-main-menu']//*[text()='Simulasi']"]))

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Paket']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//strong[text()='$SimulasiPaket']"]))

def SimulasiData = [
	['OTR', SimulasiOTR],
	['uangMukaPersen', SimulasiPersenDP],
	['residual', SimulasiResidual],
	['tenor', SimulasiTenor],
	['flatRate', SimulasiFlatRate],
	['effectiveRate', SimulasiEffRate],
	['biayaAdmin', SimulasiBiayaAdmin],
	['biayaProvisi', SimulasiBiayaProvisi],
]

for (data in SimulasiData) {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='${data[0]}'])[1]"]), data[1])
}

switch(SimulasiLoanType) {
	case 'In Advance':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='loanType' and @value='A']"]))
		break;
	case 'In Arrear':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='loanType' and @value='R']"]))
		break;
}

switch(SimulasiBiayaAdminType) {
	case 'Prepaid':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentTypeBiayaAdmin' and @value='0']"]))
		break;
	case 'On Loan':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentTypeBiayaAdmin' and @value='1']"]))
		break;
}

switch(SimulasiBiayaProvisiType) {
	case 'Prepaid':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentTypeProvisi' and @value='0']"]))
		break;
	case 'On Loan':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentTypeProvisi' and @value='1']"]))
		break;
}

// Data Kendaraan
def SimulasiDataKendaraan = [
	['Merk', SimulasiMerkMobil],
	['Model', SimulasiModelMobil],
	['Tipe', SimulasiTipeMobil],
]

for(data in SimulasiDataKendaraan) {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='${data[0]}']"]))
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='searchInput'])[2]"]), data[1])
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//*[@class='slide-up-content']//*[text()='${data[1]}']"]))
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Purpose']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//*[@class='slide-up-content']/div//*[text()='$SimulasiPurposeMobil']"]))

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='tahun']"]), SimulasiTahunMobil)

// Detail Asuransi Mobil
// All
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='Tipe Asuransi'])[1]"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//*[@class='slide-up-content']/div//strong[text()='$SimulasiTipeAsuransi']"]))
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='TJH'])[1]"]))
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-car-detail-insurance//*[text()='TJH'])[1]"]))

switch(DetailAsuransiCheck) {
	case 'RSCC':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='rscc']/following-sibling::span)[1]"]))
		break;
	case 'RSMB':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='rsmb']/following-sibling::span)[1]"]))
		break;
	case 'RSCC + RSMB':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='rscc']/following-sibling::span)[1]"]))
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='rsmb']/following-sibling::span)[1]"]))
		break;
	default:
		break;
}

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nominalDeduction'])[1]"]), SimulasiNominalDeduction)
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='OTR'])[2]"]), SimulasiDetailOTR)

switch(SimulasiDetailLoanType) {
	case 'Prepaid':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='paymentType' and @value='0'])[1]"]))
		break;
	case 'On Loan':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='paymentType' and @value='1'])[1]"]))
		break;
}

// Asuransi Lainnya
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-other-insurance//img)[1]"]))
def AsuransiLainnya = [
	['Asuransi Lainnya', SimulasiAsuransiLainnyaType],
	['Maskapai', SimulasiAsuransiLainnyaMaskapai],
//	['Tenor (Bulan)', SimulasiAsuransiLainnyaTenor],
	['Pertanggungan', SimulasiAsuransiLainnyaPertanggungan],
]

for(data in AsuransiLainnya) {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='modal-body']//*[text()='${data[0]}']"]))
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='drawer-select show']//*[text()='${data[1]}']"]))
}

switch(SimulasiAsuransiLainnyaLoanType) {
	case 'Prepaid':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='other-insurance-prepaid']"]))
		break;
	case 'On Loan':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='other-insurance-onloan']"]))
		break;
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Simpan']"]))

// Biaya Lainnya
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-other-fee//img)[1]"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='modal-body']//*[text()='Fee']"]))
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='drawer-select show']//*[text()='$SimulasiBiayaLainnyaFee']"]))

switch(SimulasiBiayaLainnyaType) {
	case 'Prepaid':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentType' and @value='prepaid']"]))
		break;
	case 'On Loan':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentType' and @value='onloan']"]))
		break;
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Simpan']"]))

// Screenshot Hasil Simulasi
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Hasil Input Simulasi') + '.png', FailureHandling.STOP_ON_FAILURE)


// Hitung Sekarang
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button//*[text()='Hitung Sekarang']"]))
WebUI.delay(3)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Hasil Simulasi') + '.png', FailureHandling.STOP_ON_FAILURE)

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
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'input RO Simulasi') + '.png', FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Matching']"]))
WebUI.delay(10)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Hasil Matching RO') + '.png', FailureHandling.STOP_ON_FAILURE)

//if (!WebUI.verifyElementPresent(findTestObject('Object Repository/xpath', ['xpath':"//*[text()='Input Pengajuan Baru']"]), 1, FailureHandling.OPTIONAL)) {
//    switch (hasilMatching) {
//        case 'existing':
//			WebUI.callTestCase(findTestCase('Test Cases/Sprint 1/ROMatched/Existing'), ['konsumen': konsumen, 'isExistingMatch': isExistingMatch, 'isBatal' : isBatal], FailureHandling.STOP_ON_FAILURE)
//            break;
//		case 'in_progress':
//		case 'pengajuan':
//	    case 'inProgress':
//			WebUI.callTestCase(findTestCase('Test Cases/Sprint 1/ROMatched/Pengajuan'), ['konsumen' : konsumen, 'isPengajuanMatch' : isPengajuanMatch, 'isBatal' : isBatal], FailureHandling.STOP_ON_FAILURE)
//            break;
//        case 'reject':
//			WebUI.callTestCase(findTestCase('Test Cases/Sprint 1/ROMatched/Reject'), ['konsumen' : konsumen, 'isRejectMatch' : isRejectMatch, 'isBatal' : isBatal], FailureHandling.STOP_ON_FAILURE)
//			break;
//		default:
//			break;
//    }
//    return
//}


//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@name='matching']/following-sibling::span"]), FailureHandling.OPTIONAL);
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Lanjutkan']"]), FailureHandling.OPTIONAL);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Hasil Matching RO') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Input Pengajuan Baru']"]), FailureHandling.OPTIONAL)
WebUI.delay(1)

//if (SimulasiRekomendasiBM == 'yes') {
//	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Input Pengajuan Baru']"]))
//	WebUI.delay(1)
//} else {
//	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Data RO Tidak Ditemukan']/following-sibling::div[2]/button[1]"]))
//	WebUI.delay(1)
//}


// Input Pengajuan
def inputData = [
	['tempatLahir', SimulasiTempatLahir],
	['kodePos', SimulasiKodePos],
	['email', SimulasiEmail]
]

def searchData = [
	['Sandi Lahir', SimulasiSandiLahir],
	['Sandi Dati', SimulasiSandiDati],
	['Status Pernikahan', SimulasiStatus]
]

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

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='email'])[1]"]), SimulasiEmail);
WebUI.delay(1);

stat = WebUI.getText(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='statusPerkawinan']/div[@class='value']"]));
println(stat);

status = stat;
println(status);

if (stat == 'Married') {	
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Pilih Jenis Identitas']"]));
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${SimulasiJenisIdentitasPasangan}']"]));
	WebUI.delay(2);
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='doc-img-container ng-star-inserted'])[3]"]));
	WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPathPasangan);
	
	// Jika kode pos dan kabupaten belum terisi
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='relative-container mb-2']//input[@id='kodePos']"]), SimulasiKodePos);
	
	if(SimulasiAlamatSama == 'yes') {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='alamatSesuaiKonsumen']/following-sibling::span"]));
	}
	
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='email'])[2]"]), SimulasiEmailPasangan);
	
	String hp = SimulasiHandphonePasangan;
	String prefix = hp.substring(0, 4);
	String no_hp = hp.substring(4);
	
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='extension'])[2]"]), prefix);
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='noHp'])[2]"]), no_hp);
	
//	WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSprint3)) + '/' + konsumen  + '/' + 'input_data_pasangan') + '.png', FailureHandling.STOP_ON_FAILURE)
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

WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Input Pengajuan') + '.png', FailureHandling.STOP_ON_FAILURE)

// Setelah Pre Screening
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Pre-Screening']"]));
WebUI.delay(3)
//WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Hasil Pre-Screening') + '.png', FailureHandling.STOP_ON_FAILURE)

// Simpan atau Reject
switch(SimulasiRekomendasiBM) {
	case 'yes':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Simpan ']"]));
		WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Simpan Hasil') + '.png', FailureHandling.STOP_ON_FAILURE)
		break;
	case 'no':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Simpan ']"]));
		WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Simpan Hasil') + '.png', FailureHandling.STOP_ON_FAILURE)
		break;
	case 'reject':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Usulkan Reject ']"]));
		WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Reject Hasil') + '.png', FailureHandling.STOP_ON_FAILURE)
		break;
}


//WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Pre-Screening']"]), 5)
//
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Minta Rekomendasi BM ']"]))
//WebUI.back()
//WebUI.waitForElementClickable(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Input Pengajuan Sekarang ']"]), 0)
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Input Pengajuan Sekarang ']"]))