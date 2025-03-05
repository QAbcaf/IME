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
String baseDir = System.getProperty('user.dir')

// TAB CONTACT PERSON
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Contact Person & Penjamin']"]))

// Data Entrys
def CPData = [
	['nama', CP_Nama],
	['hubunganDenganKonsumen', CP_HubKonsumen],
]

for (data in CPData) {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='${data[0]}']"]), data[1])
}

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='extension' and @class = 'form-control ng-untouched ng-pristine ng-invalid has-value']"]), CP_Prefix)
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='nomor' and @class = 'form-control ng-untouched ng-pristine ng-invalid has-value']"]), CP_NoHp)
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='kodePos' and @class = 'form-control ng-untouched ng-pristine ng-valid']"]), CP_KodePos)
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//form[@class='ng-dirty ng-touched ng-valid']//textarea[@id='alamat']"]), CP_Alamat)

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Kota/Kabupaten']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='searchInput']"]), CP_Kota);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${CP_Kota}']"]))

def clickPrevious() {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='‹']"]))
}

switch(CP_isPenjamin) {
	case 'yes':
	case 'y':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='d-flex']/label[1]"]))
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//form[@class='ng-untouched ng-pristine ng-invalid ng-star-inserted']//input[@id='nama']"]), CP_PenjaminNama)
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='tempatLahir' and not(@disabled)]"]), CP_PenjaminTL)
		
		def PenjaminData = [
			['nomorIdentitas', CP_PenjaminNIK],
			['hubunganDenganDebitur', CP_PenjaminHubDebitur],
		]
		
		for (data in PenjaminData) {
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='${data[0]}']"]), data[1])
		}
		
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='kodePos' and @class='form-control ng-untouched ng-pristine ng-valid']"]), CP_PenjaminKodePos)
		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//*[@formgroupname='alamat']//textarea[@id='alamat']"]), CP_PenjaminAlamat)
		WebUI.delay(1)
		
		// DOB Penjamin
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='tanggalLahir']/following-sibling::a"]))
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//bs-datepicker-navigation-view//*[@class='current']"]))
		
		String[] monthNames = ["", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"]
		String[] dobComponents = CP_PenjaminDOB.split("/")
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
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='" + day + "']"]))
		
		 // Jenis Kelamin
		 switch(CP_PenjaminJenisKelamin) {
			case 'Laki-Laki':
				WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='JKKonsumenL']"]))
			 	break;
			case 'Perempuan':
				WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='JKKonsumenP']"]))
				break;
		 }
		 
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Tipe Identitas']"]))
		 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up-content']//*[text()='$CP_PenjaminTipeIdentitas']"]))
		 
		 def PenjaminDataSelect = [
			 ['Pekerjaan', CP_PenjaminPekerjaan],
			 ['Agama', CP_PenjaminAgama],
		 ]
		 
		 for (data in PenjaminDataSelect) {
			 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='label' and text()='${data[0]}']"]))
			 WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='slide-up-content']//*[text()='${data[1]}']"]))
		 }
		 
		break;
	case 'no':
	case 'n':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='d-flex']/label[2]"]))
		break;
}

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Selanjutnya ' and @_ngcontent-ng-c1108347619='']"]))

