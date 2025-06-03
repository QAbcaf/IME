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
String kkPath = "${userDir}${GlobalVariable.kkPath}".replace("/", "\\")
String ktpPathSingle = "${userDir}${GlobalVariable.ktpPathSingle}".replace("/", "\\")
String baseDir = System.getProperty('user.dir')

// TAB CONTACT PERSON
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='ECN & Penjamin']"]))

// Data Entrys
def CPData = [
	['nama', CP_Nama],
	['hubunganDenganKonsumen', CP_HubKonsumen],
//	['nomor', CP_NoHp],
//	['kodePos', CP_KodePos],
]

for (data in CPData) {
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//app-tab-cp-penjamin//input[@id='${data[0]}'])[1]"]), data[1])
}

WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//app-tab-cp-penjamin//input[@id='kodePos'])"]), CP_KodePos)
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//app-tab-cp-penjamin//input[@name='nomor'])"]), CP_NoHp)
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "(//app-tab-cp-penjamin//input[@name='extension'])"]), CP_Prefix)
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//app-tab-cp-penjamin//textarea[@name='alamat']"]), CP_Alamat)

/*
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-tab-cp-penjamin//*[text()='Kota/Kabupaten']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='searchInput']"]), CP_Kota);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//strong[text()='${CP_Kota}']"]))
*/
def clickPrevious() {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='‹']"]))
}

switch(CP_isPenjamin) {
	case 'yes':
	case 'y':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='d-flex']/label[1]"]))
		
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//app-form-penjamin//*[@class='img-placeholder'])[1]"]))
		WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPathPasangan);
		WebUI.delay(5)
		
		def PenjaminData = [
			['hubunganDenganDebitur', CP_PenjaminHubDebitur],
		]
		
		for (data in PenjaminData) {
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='${data[0]}']"]), data[1])
		}
		
//		WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='penjamin_kodePos']"]), CP_KodePos)
		
		WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-penjamin//*[@class='img-placeholder']"]))
		WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), kkPath);
		
		// Pasangan Penjamin
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Pilih Identitas Pasangan Penjamin']"]))
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[@class='slide-up show']//*[text()='$CP_IdentitasPasanganPenjamin']"]))
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-pasangan-penjamin//*[@class='img-placeholder']"]))
			WebUI.uploadFile(findTestObject('Object Repository/xpath', ['xpath' : "//span[text()='Upload File']/preceding-sibling::input"]), ktpPathSingle);
			WebUI.delay(10)
			
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-pasangan-penjamin//strong[text()='Alamat sama dengan Penjamin']"]))
			WebUI.delay(5)
			
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-pasangan-penjamin//*[@id='nama']"]))
			WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-pasangan-penjamin//*[@id='nama']"]))
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-pasangan-penjamin//*[@id='nama']"]), CP_PasanganPenjaminNama)
			
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-pasangan-penjamin//*[@id='nomorIdentitas']"]))
			WebUI.delay(1)
			WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-pasangan-penjamin//*[@id='nomorIdentitas']"]))
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-pasangan-penjamin//*[@id='nomorIdentitas']"]), CP_PasanganPenjaminNIK)
			
			WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-pasangan-penjamin//*[@id='tanggalLahir']"]))
			WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-pasangan-penjamin//*[@id='tanggalLahir']"]))
			WebUI.setText(findTestObject('Object Repository/xpath', ['xpath' : "//app-form-pasangan-penjamin//*[@id='tanggalLahir']"]), CP_PasanganPenjaminDOB)
		break;
	case 'no':
	case 'n':
		WebUI.check(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='d-flex']/label[2]"]))
		break;
}


//---------Screenshot---------
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[contains(text(),'Data ECN')]"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '11. Tab ECN' + '/' + 'ECN (1)') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='d-flex']/label[1]"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '11. Tab ECN' + '/' + 'ECN (2)') + '.png', FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "(//input[@id='kodePos'])[5]"]),0);
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '11. Tab ECN' + '/' + 'ECN (3)') + '.png', FailureHandling.STOP_ON_FAILURE)

if(K_Status == 'Married') {
	WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//strong[contains(text(),'Pasangan Penjamin')]"]),0);
	WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '11. Tab ECN' + '/' + 'ECN (4)') + '.png', FailureHandling.STOP_ON_FAILURE)
	
	WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "(//div[@formgroupname='alamat']//textarea[@id='alamat' and @name='alamat' and @formcontrolname='alamat'])[3]"]),0);
	WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '11. Tab ECN' + '/' + 'ECN (5)') + '.png', FailureHandling.STOP_ON_FAILURE)
}

// --- Selanjutnya ---
WebUI.delay(2)
WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//app-tab-cp-penjamin//button[text()=' Selanjutnya ']"]), 0)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-tab-cp-penjamin//button[text()=' Selanjutnya ']"]))
