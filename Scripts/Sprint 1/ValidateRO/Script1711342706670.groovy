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

WebUI.callTestCase(findTestCase('Test Cases/Login'), [('konsumen') : konsumen], FailureHandling.STOP_ON_FAILURE)

// (Skenario 3)
String baseDir = System.getProperty('user.dir')
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[@class='top-main-menu']//*[text()='Aplikasi Baru']"]))

// Input matching RO
def ROData = [
	['nama', ROName],
	['nomorIdentitas', RONik],
	['kodeNoHp', ROHandphoneNumberPrefix],
	['nomor', ROHandphoneNumber],
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
String[] dobComponents = RODob.split("/")
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
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='" + day + "'])[3]"]))
} else {
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "(//*[text()='" + day + "'])[1]"]))
}
WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotSprint3)) + '/' + konsumen  + '/' + 'Aplikasi Baru') + '.png', FailureHandling.STOP_ON_FAILURE)

// Click Matching Button
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Matching']"]))

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

// Skenario 8
if (isInputPengajuanBaru == 'yes') {
//	WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'skenario-8-nonRO') + '.png', FailureHandling.STOP_ON_FAILURE)
    WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//*[text()='Input Pengajuan Baru']"]))
	WebUI.delay(1)
//	WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'skenario-setelah-nonROInputPengajuanBaru') + '.png', FailureHandling.STOP_ON_FAILURE)
} else {
//	WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'skenario-8-chooseBatal-nonRO') + '.png', FailureHandling.STOP_ON_FAILURE)
	// Button Batal
    WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Data RO Tidak Ditemukan']/following-sibling::div[2]/button[1]"]))
	WebUI.delay(1)
//	WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'skenario-setelah-buttonBatal-nonRO') + '.png', FailureHandling.STOP_ON_FAILURE)
}
	