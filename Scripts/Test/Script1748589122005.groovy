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

//WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@name='namaIbuKandung']"]), "IBU SAYA", FailureHandling.CONTINUE_ON_FAILURE);

import com.kms.katalon.core.configuration.RunConfiguration

String userDir = RunConfiguration.getProjectDir()
String baseDir = System.getProperty('user.dir')


	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//span[normalize-space()='Cover Mundur']"]))
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
		
		
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='" + yearEnd + "']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='" + monthEnd + "']"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//td[not(contains(@class,'is-other-month'))]//span[normalize-space()='" + dayEnd + "']"]))
	}



//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@id='undefined'])[4]"]))
//	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='searchInput'])[3]"]), L_TJH);
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@class='slide-up show']//strong)[1]"]));

//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[contains(text(),'Foto Kepemilikan Rekening Bank')]/following::div[contains(@class,'document-preview')][1]"]));
//WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), kkPath);
//WebUI.delay(1)

//WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[contains(text(),'Foto Dokumen FAP')]"]),0);
//WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '9. Tab FAP' + '/' + 'FAP (1)') + '.png', FailureHandling.STOP_ON_FAILURE)
//
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@id='tujuanPembiayaan']"]));
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='$F_tujuanPembiayaan'])"]));

//WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@formcontrolname='extension'])[2]"]), "0897");

//WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[contains(text(),'Foto Dokumen FAP')]"]),0);
//WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '9. Tab FAP  ' /' + FAP (1)') + '.png', FailureHandling.OPTIONAL)
//
//WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '15. Tab Summary/Summary' + '/' + 'Tab Summary') + '.png', FailureHandling.STOP_ON_FAILURE)
//if (tujuanPembiayaan == 'Investasi') {
//	WebUI.delay(2)
//	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//strong[text()='Investasi'])[1]"]));
//	WebUI.delay(5)
//} else if (tujuanPembiayaan == 'Modal Kerja') {
//	WebUI.delay(2)
//	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//strong[text()='Modal Kerja'])[1]"]));
//} else if (tujuanPembiayaan == 'Konsumsi') {
//	WebUI.delay(2)
//	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//strong[text()='Konsumsi'])[1]"]));
//} else if (tujuanPembiayaan == 'Lainnya') {
//	WebUI.delay(2)
//	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//strong[text()='Lainnya'])[1]"]));
//}

//WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='namaSID']"]), namaSID);
//
//WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@formcontrolname='alamatUtamaKTP']/following-sibling::span"]));
//WebUI.delay(3)
//
//WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@name='lamaTinggalTahun'])[1]"]), lama_tahun);
//WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@name='lamaTinggalBulan'])[1]"]), lama_bulan);
//WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='jumlahPertanggungan'])[1]"]), jumlah_tanggungan);
//WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='extension'])[1]"]), kode_area);
//WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='nomor'])[1]"]), nomor_telepon);
//
//switch(emailSama) {
//	case 'KTP':
//		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='mailKTP'])[1]/following-sibling::span"]));
//		break;
//	case 'Domisili':
//		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='mailD'])[1]/following-sibling::span"]));
//		break;
//	case 'Other':
//		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='mailO'])[1]/following-sibling::span"]));
//		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@formgroupname='alamatMail']//textarea[@id='alamat']"]), 'test', FailureHandling.CONTINUE_ON_FAILURE);
//		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@formgroupname='alamatMail']//input[@name='kodePos']"]), '12430', FailureHandling.CONTINUE_ON_FAILURE);
//		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@formgroupname='alamatMail']//textarea[@id='alamat']"]), FailureHandling.CONTINUE_ON_FAILURE);
//		break;
//	case 'Kantor':
//		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='mailKantor'])[1]/following-sibling::span"]));
//		break;
//}
//
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()=' WhatsApp sama dengan No. Handphone']"]));
//WebUI.delay(1)