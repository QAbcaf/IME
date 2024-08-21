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
String npwpPath = "${userDir}${GlobalVariable.npwpPath}".replace("/", "\\")
String ktpPath = "${userDir}${GlobalVariable.ktpPath}".replace("/", "\\")
String ktpPathPasangan = "${userDir}${GlobalVariable.ktpPathPasangan}".replace("/", "\\")
String bpkbPath = "${userDir}${GlobalVariable.bpkbPath}".replace("/", "\\")
String baseDir = System.getProperty('user.dir')
/*
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Simulasi']"]))
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

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='TJH'])[1]"]))
WebUI.delay(1)
switch(SimulasiTJH) {
	case '10 Juta':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[@class='slide-up show']//*[text()='10 Juta'])[1]"]))
		break;
	case '25 Juta':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[@class='slide-up show']//*[text()='25 Juta'])[1]"]))
		break;
	case '50 Juta':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[@class='slide-up show']//*[text()='50 Juta'])[1]"]))
		break;
	case '0':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[@class='slide-up show']//*[text()='0'])[1]"]))
		break;
	default:
		break;
}

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='percentDeduction'])[1]"]), SimulasiPercentDeduction)
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nominalDeduction'])[1]"]), SimulasiNominalDeduction)

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
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='modal-body']//input[@formcontrolname='paymentType' and @value='0']"]))
		break;
	case 'On Loan':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='modal-body']//input[@formcontrolname='paymentType' and @value='1']"]))
		break;
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Simpan']"]))

// Screenshot Hasil Simulasi
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '1 Hasil Input Simulasi') + '.png', FailureHandling.STOP_ON_FAILURE)


// Hitung Sekarang
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button//*[text()='Hitung Sekarang']"]))
WebUI.delay(3)
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '2 Hasil Simulasi') + '.png', FailureHandling.STOP_ON_FAILURE)

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
        	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-matching-ro//input[@value='none'])[1]"]))
			WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '5 Hasil Matching RO Not Match') + '.png', FailureHandling.STOP_ON_FAILURE)
        	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-ro//button[text()='Lanjutkan']"]))
			break;
		default:
			WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '5 Hasil Matching Non RO') + '.png', FailureHandling.STOP_ON_FAILURE)
			break;
}
*/
// Input Pengajuan
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='doc-img-container pointer ng-star-inserted'])[1]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPath);
WebUI.delay(10)

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='doc-img-container pointer ng-star-inserted'])[1]"]));
WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), npwpPath);
WebUI.delay(10)

switch(SimulasiTLKonsumen) {
	case 'Dalam Negeri':
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tempatLahir'])[1]"]));
		WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tempatLahir'])[1]"]));
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tempatLahir'])[1]"]), SimulasiTempatLahir);
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='tempatLahirLuarNegeri'])[1]"]))
		break;
	case 'Luar Negeri':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='tempatLahirLuarNegeri'])[2]"]))
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='negaraLahir'])[1]"]), SimulasiNegaraLahir)
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tempatLahir'])[1]"]))
		WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tempatLahir'])[1]"]))
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='tempatLahir'])[1]"]), SimulasiKotaLahir)
		break;
}

def inputData = [
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

WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@value='konsumen']"]));

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

//DateFunction
def clickPrevious2() {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='‹']"]))
}

stat = WebUI.getText(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='statusPerkawinan']/div[@class='value']"]));
status = stat;
println(status);

if (stat == 'Married') {	
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Pilih Jenis Identitas']"]));
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${SimulasiJenisIdentitasPasangan}']"]));
	
	WebUI.delay(1);
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='doc-img-container pointer ng-star-inserted'])[1]"]));
	WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPathPasangan);
	

	WebUI.delay(2);
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='pasangan_nama'])"]));
	WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='pasangan_nama'])"]));
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='pasangan_nama'])"]), SimulasiNamaPasangan);
	
	WebUI.delay(1);
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='pasangan_nomorIdentitas'])"]));
	WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='pasangan_nomorIdentitas'])"]));
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='pasangan_nomorIdentitas'])"]), SimulasiNikPasangan);
	
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@name='tanggalLahirPasangan']/following-sibling::a"]))
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//bs-datepicker-navigation-view//*[@class='current']"]))
	
	String[] monthNames2 = ["", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"]
	String[] dobComponents2 = SimulasiTglLahirPasangan.split("/")
	String day2 = dobComponents2[0]
	int monthInteger2 = Integer.parseInt(dobComponents2[1])
	int year2 = Integer.parseInt(dobComponents2[2].trim())
	String month2 = monthNames2[monthInteger2]
	 
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
		clickPrevious2();
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
			WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='tempatLahirLuarNegeri'])[3]/following-sibling::span"]))
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='pasangan_tempatLahir']"]), 'Jakarta')
			break;
		case 'Luar Negeri':
			WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='tempatLahirLuarNegeri'])[4]/following-sibling::span"]))
			if(SimulasiTLKonsumen == 'Dalam Negeri') {
				WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='negaraLahir'])"]), SimulasiNegaraLahirPasangan)
				WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='pasangan_tempatLahir'])"]))
				WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='pasangan_tempatLahir'])"]))
				WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='pasangan_tempatLahir'])"]), SimulasiKotaLahirPasangan)
			} else if (SimulasiTLKonsumen == 'Luar Negeri') {
				WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='negaraLahir'])[2]"]), SimulasiNegaraLahirPasangan)
				WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='pasangan_tempatLahir'])"]))
				WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='pasangan_tempatLahir'])"]))
				WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='pasangan_tempatLahir'])"]), SimulasiKotaLahirPasangan)
				
			}
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
//WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='dp']"]), SimulasiLoanDataDP);
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
if(SimulasiStatus == 'Single') {
	WebUI.delay(10)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Pre-Screening']"]));
	WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '7 Hasil Pre Screening') + '.png', FailureHandling.STOP_ON_FAILURE)
} else if (SimulasiStatus == 'Married') {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Matching Pasangan']"]));
	WebUI.delay(7)
	switch (MatchingPasangan) {
		case 'Existing':
			WebUI.delay(7)
			WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '7 Hasil Matching Pasangan Existing') + '.png', FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//*[text()=' Pengajuan ']"]));
			WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '8 Hasil Matching Pasangan Pengajuan') + '.png', FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//*[text()=' Reject ']"]));
			WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '9 Hasil Matching Pasangan Reject') + '.png', FailureHandling.STOP_ON_FAILURE)
			
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//*[text()=' Existing ']"]));
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//input[@value='pasangan_0']/following-sibling::span"]));
			break;
		case 'Pengajuan':
			WebUI.delay(7)
			WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '7 Hasil Matching Pasangan Existing') + '.png', FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//*[text()=' Pengajuan ']"]));
			WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '8 Hasil Matching Pasangan Pengajuan') + '.png', FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//*[text()=' Reject ']"]));
			WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '9 Hasil Matching Pasangan Reject') + '.png', FailureHandling.STOP_ON_FAILURE)
			
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//*[text()=' Pengajuan ']"]));
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//input[@value='pasangan_0']/following-sibling::span"]));
			break;
		case 'Not Match':
			WebUI.delay(7)
			WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '7 Hasil Matching Pasangan Existing') + '.png', FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//*[text()=' Pengajuan ']"]));
			WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '8 Hasil Matching Pasangan Pengajuan') + '.png', FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-matching-pasangan//*[text()=' Reject ']"]));
			WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '9 Hasil Matching Pasangan Reject') + '.png', FailureHandling.STOP_ON_FAILURE)
			break;
		case 'Non RO':
		default:
			WebUI.delay(7)
			WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '7 Hasil Pre Screening Matching Pasangan') + '.png', FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Pre-Screening']"]));
			break;
	}
}

// masuk ke halaman pre-screening