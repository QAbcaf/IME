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

switch(JenisPengajuan) {
	case 'Aplikasi Baru':
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Paket']"]))
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//strong[text()='$L_BaruPaket']"]))
		 
		 // Paket DP
		 WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='paketDp']"]), L_PaketDP)
		 
		 def SimulasiData = [
			 ['OTR', L_BaruOTR],
			 ['uangMukaPersen', L_BaruPersenDP],
			 ['residual', L_BaruResidual],
			 ['tenor', L_BaruTenor],
			 ['flatRate', L_BaruFlatRate],
			 ['effectiveRate', L_BaruEffRate],
			 ['biayaAdmin', L_BaruBiayaAdmin],
			 ['biayaProvisi', L_BaruBiayaProvisi],
		 ]
		 
		 for (data in SimulasiData) {
			 WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='${data[0]}'])[1]"]), data[1])
		 }
		 
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
		 
		 // Asuransi Mobil
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Car Insurance Corp']"]))
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up show']//*[text()='$L_CarInsuranceCorp']"]))
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Car Insurance Branch']"]))
		 WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//*[text()='$L_CarInsuranceBranch'])"]), 0)
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//*[text()='$L_CarInsuranceBranch'])"]))
		 
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
		 
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='TJH']"]))
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//*[text()='$L_TJH']"]))
		 WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='percentDeduction'])[1]"]), L_BaruNominalDeduction)
		 WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nominalDeduction'])[1]"]), L_BaruDetailOTR)
		 
		 switch(L_BaruDetailLoanType) {
			 case 'Prepaid':
				 WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='paymentType' and @value='0'])[1]"]))
				 break;
			 case 'On Loan':
				 WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='paymentType' and @value='1'])[1]"]))
				 break;
		 }
		 
		  // Credit Protection
		  WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Maskapai Asuransi']"]))
		  WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up show']//*[text()='$L_MaskapaiAsuransi']"]))
		  WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Branch']"]))
		  
		  // Kalau dari awal belum ada datanya
		  WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//*[text()='$L_Branch'])[3]"]))
		  WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='creditProtectionFile']"]), bpkbPath, FailureHandling.OPTIONAL)
		  
		  /*
		  // Sudah ada datanya
		  //WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-credit-protection//*[@role='button']/img"]), bpkbPath, FailureHandling.OPTIONAL)
		  */
		  
		 // Asuransi Lainnya
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-other-insurance//img)[1]"]))
		 def AsuransiLainnya = [
			 ['Asuransi Lainnya', L_BaruAsuransiLainnyaType],
			 ['Maskapai', L_BaruAsuransiLainnyaMaskapai],
		 //	['Tenor (Bulan)', SimulasiAsuransiLainnyaTenor],
			 ['Pertanggungan', L_BaruAsuransiLainnyaPertanggungan],
		 ]
		 
		 for(data in AsuransiLainnya) {
			 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='modal-body']//*[text()='${data[0]}']"]))
			 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='drawer-select show']//*[text()='${data[1]}']"]))
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
		 
		 // OS PH Manual
		 String L_OSPH = WebUI.getText(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='O/S PH Sistem']/following-sibling::div"]))
		 WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='osphManual']"]), L_OSPH)
		 
		 WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '18 Tab Loan Data') + '.png', FailureHandling.STOP_ON_FAILURE);
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-loan//button[text()=' Selanjutnya ']"]))
		 WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + '18 Tab Loan Data Selanjutnya') + '.png', FailureHandling.STOP_ON_FAILURE);
		break;
	case 'Simulasi':
		// Paket DP
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='paketDp']"]), L_PaketDP)
		
		// Asuransi Mobil
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Car Insurance Corp']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up show']//*[text()='$L_CarInsuranceCorp']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Car Insurance Branch']"]))
		WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//*[text()='$L_CarInsuranceBranch'])"]), 0)
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//*[text()='$L_CarInsuranceBranch'])"]))
		
		// Credit Protection
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Maskapai Asuransi']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up show']//*[text()='$L_MaskapaiAsuransi']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Branch']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//*[text()='$L_Branch'])[3]"]))
		WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='creditProtectionFile']"]), bpkbPath)
		
		// OS PH Manual
		String L_OSPH = WebUI.getText(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='O/S PH Sistem']/following-sibling::div"]))
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='osphManual']"]), L_OSPH)                                                       
		
		WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '18 Tab Loan Data') + '.png', FailureHandling.STOP_ON_FAILURE);
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-loan//button[text()=' Selanjutnya ']"]))
		WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '18 Tab Loan Data Selanjutnya') + '.png', FailureHandling.STOP_ON_FAILURE);
		break;
}
