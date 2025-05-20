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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String userDir = RunConfiguration.getProjectDir()
String selfiePath = "${userDir}${GlobalVariable.selfiePath}".replace("/", "\\")
String ktpPath = "${userDir}${GlobalVariable.ktpPath}".replace("/", "\\")
String bpkbPath = "${userDir}${GlobalVariable.bpkbPath}".replace("/", "\\")
String loanDataPath = "${userDir}${GlobalVariable.loanDataPath}".replace("/", "\\")
String baseDir = System.getProperty('user.dir')

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.Date

//DateFunction
def clickPrevious() {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='‹']"]))
}

// TAB LOAN DATA
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Loan Data']"]))

switch(JenisPengajuan) {
	case 'Aplikasi Baru':
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Paket']"]))
		 WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='searchInput']"]), L_BaruPaket)
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//strong[text()='$L_BaruPaket']"]), FailureHandling.OPTIONAL)
		 
		 // Paket DP
		 WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='paketDp']"]), L_PaketDP)
		 
		 def SimulasiData = [
			 ['otr', L_BaruOTR],
			 ['uangMukaPersen', L_BaruPersenDP],
			 ['residual', L_BaruResidual],
			 ['tenor', L_BaruTenor],
			 ['flatRate', L_BaruFlatRate],
//			 ['effectiveRate', L_BaruEffRate],
			 ['biayaAdmin', L_BaruBiayaAdmin],
			 ['biayaProvisi', L_BaruBiayaProvisi],
		 ]
		 
		 for (data in SimulasiData) {
			 WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='${data[0]}'])[1]"]), data[1],FailureHandling.OPTIONAL)
		 }
		 WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@name='effectiveRate'])[1]"]), L_BaruEffRate)
		 
		 switch(L_BaruLoanType) {
			 case 'In Advance':
				 WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='loanType' and @value='A']"]))
				 break;
			 case 'In Arrear':
				 WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='loanType' and @value='R']"]))
				 break;
		 }
		 
		 switch(L_BaruBiayaAdminType) {
			 case 'Prepaid':
				 WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentTypeBiayaAdmin' and @value='0']"]))
				 break;
			 case 'On Loan':
				 WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentTypeBiayaAdmin' and @value='1']"]))
				 break;
		 }
		 
		 switch(L_BaruBiayaProvisiType) {
			 case 'Prepaid':
				 WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentTypeProvisi' and @value='0']"]))
				 break;
			 case 'On Loan':
				 WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='paymentTypeProvisi' and @value='1']"]))
				 break;
		 }

if(L_SelfCover == 'No') {
	// Asuransi Mobil
	WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Car Insurance Corp']"]), 0)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Car Insurance Corp']"]))
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up show']//*[text()='$L_CarInsuranceCorp']"]))
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Car Insurance Branch']"]))
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//strong)[1]"]));
	
	// Detail Asuransi Mobil
	// All
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='Tipe Asuransi'])[1]"]))
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//*[@class='slide-up-content']/div//strong[text()='$L_BaruTipeAsuransi']"]))

	switch(L_BaruDetailAsuransiCheck) {
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
	
	//--- TJH ---
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='TJH']"]))
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='searchInput'])[3]"]), L_TJH);
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//strong)[1]"]));
	
	// --- Nominal Deduction ---
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='nominalDeduction']"]), L_BaruDetailOTR)
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='percentDeduction']"]), L_BaruNominalDeduction)
	
	switch(L_BaruDetailLoanType) {
		case 'Prepaid':
			WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='paymentType' and @value='0'])[1]"]))
			break;
		case 'On Loan':
			WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='paymentType' and @value='1'])[1]"]))
			break;
	}
	
	//TLP ditambahkan pop up
	if (WebUI.verifyElementPresent(findTestObject('Object Repository/xpath', ['xpath': "//button[contains(text(),'OK')]"]), 10, FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[contains(text(),'OK')]"]))
	}

		
	// --- Cover Mundur ---
	if(L_CoverMundur == 'Yes') {
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[normalize-space()='Cover Mundur']"]))
		WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='periodeStart']"]), 0)
		if(!L_PeriodeStartCoverMundur && L_PeriodeEndCoverMundur == '') {
			// Auto set tanggal dari app
		} else {
			// Periode Start
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='periodeStart']"]))
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[normalize-space()='2025']"]))
			
			String[] monthNames = ["", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"]
			String[] DOBComponents = L_PeriodeStartCoverMundur.split("/")
			String day = DOBComponents[0]
			int monthInteger = Integer.parseInt(DOBComponents[1])
			int year = Integer.parseInt(DOBComponents[2].trim())
			String month = monthNames[monthInteger]
			//String xpathTanggal = "//td[not(contains(@class,'is-other-month'))]//span[normalize-space()='" + day + "']"
			
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
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//td[not(contains(@class,'is-other-month'))]//span[normalize-space()='" + day + "']"]))
			
			// Periode End
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='periodeEnd']"]))
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[normalize-space()='2025']"]))
			
			String[] DOBEndComponents = L_PeriodeEndCoverMundur.split("/")
			String dayEnd = DOBEndComponents[0]
			int monthIntegerEnd = Integer.parseInt(DOBEndComponents[1])
			int yearEnd = Integer.parseInt(DOBEndComponents[2].trim())
			String monthEnd = monthNames[monthIntegerEnd]
			
			int currentYearEnd = Calendar.getInstance().get(Calendar.YEAR);
			int differenceEnd = currentYearEnd - yearEnd;
			double boxesToGoBackEnd = (double) differenceEnd / 16;
			int decimalPartEnd = (int) ((boxesToGoBackEnd - (int) boxesToGoBackEnd) * 10)
			
			if (decimalPartEnd <= 4) {
				boxesToGoBackEnd = Math.floor(boxesToGoBackEnd);
			} else {
				boxesToGoBackEnd = Math.ceil(boxesToGoBackEnd);
			}
			
			for (int i = 0; i < boxesToGoBackEnd; i++) {
				clickPrevious();
			}
			
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='" + yearEnd + "']"]))
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='" + monthEnd + "']"]))
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//td[not(contains(@class,'is-other-month'))]//span[normalize-space()='" + dayEnd + "']"]))
		}
	}
} 
		 
	// Credit Protection
	// --- Maskapai Asuransi ---
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Maskapai Asuransi']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up show']//*[text()='$L_MaskapaiAsuransi']"]))
		  
	// --- Branch ---
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Branch']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//*[text()='$L_Branch'])[1]"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='capture-option']"]))
		WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), bpkbPath);
		  
		  /*
		  // Sudah ada datanya
		  WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-credit-protection//*[@role='button']/img"]), bpkbPath, FailureHandling.OPTIONAL)
		  */
		  
		 // Asuransi Lainnya
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-other-insurance//img)[1]"]))
		 
		 switch(L_BaruAsuransiLainnyaType) {
			 case 'TLP MOTOR':
				 def AsuransiLainnya = [
					 ['Asuransi Lainnya', L_BaruAsuransiLainnyaType],
					 ['Maskapai', L_BaruAsuransiLainnyaMaskapai],
					  ['Tenor (Bulan)', L_AsuransiLainnyaTenor],
					 ['Pertanggungan', L_BaruAsuransiLainnyaPertanggungan],
				 ]
				 
				 for(data in AsuransiLainnya) {
					 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='modal-body']//*[text()='${data[0]}']"]))
					 WebUI.delay(1)
					 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='modal-body']//*[text()='${data[0]}']"]))
					 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='drawer-select show']//*[text()='${data[1]}']"]))
					 WebUI.delay(2)
				 }
			 break;
			 default:
				 def AsuransiLainnya = [
					 ['Asuransi Lainnya', L_BaruAsuransiLainnyaType],
					 ['Pertanggungan', L_BaruAsuransiLainnyaPertanggungan],
				 ]
				 
				 for(data in AsuransiLainnya) {
					 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='modal-body']//*[text()='${data[0]}']"]))
					 WebUI.delay(1)
					 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='modal-body']//*[text()='${data[0]}']"]))
					 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='drawer-select show']//*[text()='${data[1]}']"]))
					 WebUI.delay(2)
				 }
			 break;
		 }
		 
		
		 
		 if(L_BaruAsuransiLainnyaType == 'TLP') {
			 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='modal-body']//*[text()='Upload File']"]))
			 WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), bpkbPath);
		 }
		 
		 switch(L_BaruAsuransiLainnyaLoanType) {
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
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='drawer-select show']//*[text()='$L_BaruBiayaLainnyaFee']"]))
		 
		 switch(L_BaruBiayaLainnyaType) {
			 case 'Prepaid':
				 WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='paymentType' and @value='0']/following-sibling::span)[4]"]))
				 break;
			 case 'On Loan':
				 WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='paymentType' and @value='1']/following-sibling::span)[4]"]))
				 break;
		 }
		 
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Simpan']"]))
		 WebUI.delay(1)
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Hitung']"]))
		 WebUI.delay(15)
		 
		 // --- Lampiran Loan Data ---
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='d-flex justify-content-between']//button[@class='btn-img ng-star-inserted']//img"]))
		 WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='capture-option']//input[@type='file']"]), loanDataPath ,FailureHandling.STOP_ON_FAILURE);
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[normalize-space()='Simpan']"]))
		 WebUI.delay(5)
		 

		 // OS PH Manual
		 String L_OSPH = WebUI.getText(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='O/S PH Sistem']/following-sibling::div"]))
		 WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='osphManual']"]), L_OSPH)
		 
		 WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '18 Tab Loan Data') + '.png', FailureHandling.STOP_ON_FAILURE);
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-loan//button[text()=' Selanjutnya ']"]))
		 WebUI.delay(3)
		 WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '18 Tab Loan Data Selanjutnya') + '.png', FailureHandling.STOP_ON_FAILURE);
		
		break;
	case 'Simulasi':
		// Paket DP
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='paketDp']"]), L_PaketDP)
		
		// Asuransi Mobil
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Car Insurance Corp']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up show']//*[text()='$L_CarInsuranceCorp']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Car Insurance Branch']"]))
//		WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//*[text()='$L_CarInsuranceBranch'])"]), 0)
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//*[text()='$L_CarInsuranceBranch'])"]))
		
		if (WebUI.verifyElementPresent(findTestObject('Object Repository/xpath', ['xpath': "//button[contains(text(),'OK')]"]), 10, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[contains(text(),'OK')]"]))
			WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen  + '/' + '36. Tab Loan Data - pop up tlp') + '.png', FailureHandling.OPTIONAL)
		}
		
		
		// Credit Protection
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Maskapai Asuransi']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up show']//*[text()='$L_MaskapaiAsuransi']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Branch']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//*[text()='$L_Branch'])[3]"]))
		WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='creditProtectionFile']"]), bpkbPath)
		
		// OS PH Manual
		String L_OSPH = WebUI.getText(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='O/S PH Sistem']/following-sibling::div"]))
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='osphManual']"]), L_OSPH)                                                       
		
		//--------Screenshot--------
		WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[contains(text(),'Data Pengajuan')]"]),0);
		WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen  + '/' + '13. Tab Loan Data + '/' + Loan Data (1)') + '.png', FailureHandling.OPTIONAL)
		
		WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='biayaAdmin']"]),0);
		WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen  + '/' + '13. Tab Loan Data + '/' + Loan Data (2)') + '.png', FailureHandling.OPTIONAL)
		
		WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[contains(text(),'Detail Asuransi Mobil')]"]),0);
		WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen  + '/' + '13. Tab Loan Data + '/' + Loan Data (3)') + '.png', FailureHandling.OPTIONAL)
		
		WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[contains(text(),'Asuransi Lainnya')]"]),0);
		WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen  + '/' + '13. Tab Loan Data + '/' + Loan Data (4)') + '.png', FailureHandling.OPTIONAL)
		
		WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[contains(text(),'Hasil Simulasi')]"]),0);
		WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen  + '/' + '13. Tab Loan Data + '/' + Loan Data (5)') + '.png', FailureHandling.OPTIONAL)
		
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-loan//button[text()=' Selanjutnya ']"]))
		WebUI.delay(3)
		break;
}



