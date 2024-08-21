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

String baseDir = System.getProperty('user.dir')

void hideElements() {
	WebUI.executeJavaScript("document.querySelector('.account-header').style.display='none'", null)
	WebUI.executeJavaScript("document.querySelector('.button-container').style.display='none'", null)
}

void showElements() {
	WebUI.executeJavaScript("document.querySelector('.account-header').style.display=''", null)
	WebUI.executeJavaScript("document.querySelector('.button-container').style.display=''", null)
}

void takeFullPageScreenshot(String path) {
	WebUI.takeFullPageScreenshot(path, FailureHandling.STOP_ON_FAILURE)
}

void handleField(String field, String description, String screenshotName, String tab) {
	String baseDir = System.getProperty('user.dir')
	WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "//checker-field[@field='" + field + "']//input/following-sibling::span"]), 0)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//checker-field[@field='" + field + "']//input/following-sibling::span"]))
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "//textarea[@id='description']"]), pendingMessage + ' ' + description)
	WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + tab + '/' + screenshotName, FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Simpan']"]))
}

void handleFieldCategory(String category, String description, String screenshotName, Integer index, String tab) {
	String baseDir = System.getProperty('user.dir')
	WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "(//checker-field[@category='$category']//input/following-sibling::span)[$index]"]), 0)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "(//checker-field[@category='$category']//input/following-sibling::span)[$index]"]))
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "//textarea[@id='description']"]), pendingMessage + ' ' + description)
	WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + tab + '/' + screenshotName, FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Simpan']"]))
}

void handleFieldCustom(String category, String description, String text, String screenshotName) {
	String baseDir = System.getProperty('user.dir')
	WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "//checker-field[@category='$category']//span[text()='$text']/following-sibling::div//input"]), 0)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//checker-field[@category='$category']//span[text()='$text']/following-sibling::div//input"]))
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "//textarea[@id='description']"]), pendingMessage + ' ' + description)
	WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + tab + '/' + screenshotName, FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Simpan']"]))
}

void handleFieldLabel(String label, String description, String screenshotName, Integer index, String tab) {
	String baseDir = System.getProperty('user.dir')
	WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath': "(//checker-field[@label='" + label + "']//input/following-sibling::span)['" + index + "']"]), 0)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "(//checker-field[@label='" + label + "']//input/following-sibling::span)['" + index + "']"]))
	WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "//textarea[@id='description']"]), pendingMessage + ' ' + description)
	WebUI.takeScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + tab + '/' + screenshotName, FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//button[text()='Simpan']"]))
}

// Edit Sandi Lahir, Alamat dan Kode POS
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "//*[@formcontrolname='sandiLahir']//span[@class='ng-arrow-wrapper']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "(//ng-dropdown-panel//div)[4]"]), sandiLahirEdit)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath': "(//ng-dropdown-panel)[1]"]))

WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath': "//textarea[@formcontrolname='alamat']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "//textarea[@formcontrolname='alamat']"]), 'ALAMAT SUDAH DIEDIT')

WebUI.clearText(findTestObject('Object Repository/xpath', ['xpath': "//input[@formcontrolname='kodePos']"]))
WebUI.setText(findTestObject('Object Repository/xpath', ['xpath': "//input[@formcontrolname='kodePos']"]), kodePosEdit)

hideElements()
takeFullPageScreenshot(baseDir + GlobalVariable.screenshotPathChecker + '/' + konsumen + '/' + 'Pending' + '/' + 'Tab Konsumen' + '/' + '8 Edit Sandi, Alamat dan Kode Pos.png')

// 1) Tab Konsumen
handleFieldCustom('pekerjaan', 'SIUP', 'SIUP', '9. Pending Foto SIUP')
handleFieldCustom('kepemilikan_rekening', 'MUTASI REKENING', 'MUTASI REKENING', '10. Pending Foto MUTASI REKENING')
handleFieldCustom('kartu_keluarga', 'KK', 'KK', '11. Pending Foto KK')
handleFieldCustom('kartu_keluarga', 'PBB', 'PBB', '12. Pending Foto PBB')