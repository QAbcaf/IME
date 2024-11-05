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
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
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

// ---------------- Pengajuan ----------	----------
// Tab Konsumen
Map<String, Object> variableMap1 = [
	'konsumen': konsumen,
	'status': K_Status,
	'tipe_dokumen': K_TipeDokumen,
	'pekerjaan_k': K_Pekerjaan,
	'kode_ekonomi': K_KodeEkonomi,
	'nama_perusahaan': K_NamaPerusahaan,
	'jabatan': K_Jabatan,
	'tahun_berdiri': K_TahunBerdiri,
	'jenis_usaha': K_JenisUsaha,
	'total_penghasilan_k': K_TotalPenghasilan,
	'pekerjaan_pasangan': K_PekerjaanPasangan,
	'total_penghasilan_pasangan': K_TotalPenghasilanPasangan,
	'tipe_kk': K_TipeKK,
	'pendidikan_terakhir': K_PendidikanTerakhir,
	'tipe_bank': K_TipeBank,
	'no_rek': K_NoRek,
	'nama_rek': K_NamaRek,
	'pembayaran': K_Pembayaran,
	'autodebet_orglain': K_AutoDebetOrangLain,
	'rek_autodebet': K_RekAutoDebet,
	'nama_autodebet': K_NamaAutoDebet,
	'nik_autodebet': K_NikAutoDebet,
	'hubungan_autodebet': K_HubAutoDebet,
	'statusKepemilikanRumah': K_StatusKepemilikanRumah,
	'status_rumah': K_StatusRumah,
	'NPWP_Nomor' : K_nomorNPWP,
	'BaruNPWPMilik' : K_NpwpMilik,
]

List<String> variablesToPass1 = []
for (String columnHeader : variableMap1.keySet()) {
	Object value = variableMap1.get(columnHeader)
	if (value != null) {
		variablesToPass1.add(columnHeader)
	}
}

Map<String, Object> variables1 = [:]
for (String variableName : variablesToPass1) {
	variables1.put(variableName, variableMap1.get(variableName))
}

Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Sprint 2 (Aplikasi Baru)/Simulasi/Simulasi Konsumen (Sprint 2 - Skenario 14)'), variables1, FailureHandling.CONTINUE_ON_FAILURE)

// Tab FAP
Map<String, Object> variableMap2 = [
	'konsumen': konsumen,
	'nama_ibu_kandung': F_NamaIbuKandung,
	'lama_tahun': F_LamaTahun,
	'lama_bulan': F_LamaBulan,
	'jumlah_tanggungan': F_JumlahTanggungan,
	'kode_area': F_KodeArea,
	'nomor_telepon': F_NomorTelepon,
	'namaSID' : F_NamaSID,
	'emailSama' : F_EmailSama,
	'tujuanPembiayaan' : F_tujuanPembiayaan,
]

List<String> variablesToPass2 = []
for (String columnHeader : variableMap2.keySet()) {
	Object value = variableMap2.get(columnHeader)
	if (value != null) {
		variablesToPass2.add(columnHeader)
	}
}

Map<String, Object> variables2 = [:]
for (String variableName : variablesToPass2) {
	variables2.put(variableName, variableMap2.get(variableName))
}

Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Sprint 2 (Aplikasi Baru)/Simulasi/Simulasi FAP (Sprint 2 - Skenario 15)'), variables2, FailureHandling.CONTINUE_ON_FAILURE)

// Tab CP
Map<String, Object> variableMap3 = [
	'konsumen': konsumen,
	'CP_Nama': CP_Nama,
	'CP_HubKonsumen': CP_HubKonsumen,
	'CP_KodePos': CP_KodePos,
	'CP_NoHp': CP_NoHp,
	'CP_Prefix': CP_Prefix,
	'CP_Alamat': CP_Alamat,
	'CP_Kota': CP_Kota,
	'CP_isPenjamin': CP_isPenjamin,
	'CP_PenjaminHubDebitur': CP_PenjaminHubDebitur,
	'CP_IdentitasPasanganPenjamin': CP_IdentitasPasanganPenjamin,
	'CP_PasanganPenjaminNama': CP_PasanganPenjaminNama,
	'CP_PasanganPenjaminNIK': CP_PasanganPenjaminNIK,
	'CP_PasanganPenjaminDOB': CP_PasanganPenjaminDOB,
	'CP_Showroom': CP_Showroom,
]

List<String> variablesToPass3 = []
for (String columnHeader : variableMap3.keySet()) {
	Object value = variableMap3.get(columnHeader)
	if (value != null) {
		variablesToPass3.add(columnHeader)
	}
}

Map<String, Object> variables3 = [:]
for (String variableName : variablesToPass3) {
	variables3.put(variableName, variableMap3.get(variableName))
}

Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Sprint 2 (Aplikasi Baru)/Simulasi/Simulasi Contact Person (Skenario 2)'), variables3, FailureHandling.CONTINUE_ON_FAILURE)

// Tab Matching Result
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//li//*[text()='Matching Result']"]))
WebUI.delay(10)
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotPathAplBaru)) + '/' + konsumen  + '/' + 'Tab Matching Result') + '.png', FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='matchingPenjamin']//following-sibling::span"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '17 Tab Matching Result Penjamin') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='matchingPasanganPenjamin']//following-sibling::span"]))
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + '18(2) Tab Matching Result Pasangan Konsumen - Penjamin') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-tab-matching-result//button[text()=' Selanjutnya ']"]))

// Tab Collateral
Map<String, Object> variableMap4 = [
	'konsumen': konsumen,
	'Cl_Branch': Cl_Branch,
	'Cl_BpkbNo': Cl_BpkbNo,
	'Cl_NoMesin': Cl_NoMesin,
	'Cl_NoRangka': Cl_NoRangka,
	'Cl_Merk': Cl_Merk,
	'Cl_Model': Cl_Model,
	'Cl_Tipe': Cl_Tipe,
	'Cl_PeruntukanKendaraan': Cl_PeruntukanKendaraan,
	'Cl_Tahun': Cl_Tahun,
	'Cl_Warna': Cl_Warna,
	'Cl_NamaKepemilikan': Cl_NamaKepemilikan,
	'isNamaSelainKonsumen': isNamaSelainKonsumen,
	'Cl_NIKDebitur': Cl_NIKDebitur,
	'Cl_HubDebitur': Cl_HubDebitur,
]

List<String> variablesToPass4 = []
for (String columnHeader : variableMap4.keySet()) {
	Object value = variableMap4.get(columnHeader)
	if (value != null) {
		variablesToPass4.add(columnHeader)
	}
}

Map<String, Object> variables4 = [:]
for (String variableName : variablesToPass4) {
	variables4.put(variableName, variableMap4.get(variableName))
}

Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Sprint 2 (Aplikasi Baru)/Simulasi/Simulasi Collateral (Skenario 4)'), variables4, FailureHandling.CONTINUE_ON_FAILURE)


// Tab Loan Data
Map<String, Object> variableMap5 = [ 
	'konsumen': konsumen,
	'L_DetailTipeAsuransiAll': L_DetailTipeAsuransiAll,
	'L_DetailTJHAll': L_DetailTJHAll,
	'L_DetailAsuransiNominalDeductionPersen': L_DetailAsuransiNominalDeductionPersen,
	'L_DetailAsuransiNominalDeduction': L_DetailAsuransiNominalDeduction,
	'L_DetailAsuransiLoanType': L_DetailAsuransiLoanType,
	'L_PaketDP': L_PaketDP,
	'L_CarInsuranceCorp': L_CarInsuranceCorp,
	'L_CarInsuranceBranch': L_CarInsuranceBranch,
	'L_MaskapaiAsuransi': L_MaskapaiAsuransi,
	'L_Branch': L_Branch,
	'JenisPengajuan': JenisPengajuan,
	'L_BaruPaket': L_BaruPaket,
	'L_BaruOTR': L_BaruOTR,
	'L_BaruPersenDP': L_BaruPersenDP,
	'L_BaruResidual': L_BaruResidual,
	'L_BaruTenor': L_BaruTenor,
	'L_BaruFlatRate': L_BaruFlatRate,
	'L_BaruEffRate': L_BaruEffRate,
	'L_BaruBiayaAdmin': L_BaruBiayaAdmin,
	'L_BaruBiayaProvisi': L_BaruBiayaProvisi,
	'L_BaruLoanType': L_BaruLoanType,
	'L_BaruBiayaAdminType': L_BaruBiayaAdminType,
	'L_BaruBiayaProvisiType': L_BaruBiayaProvisiType,
	'L_BaruTipeAsuransi': L_BaruTipeAsuransi,
	'L_BaruDetailAsuransiCheck': L_BaruDetailAsuransiCheck,
	'L_BaruNominalDeduction': L_BaruNominalDeduction,
	'L_BaruDetailOTR': L_BaruDetailOTR,
	'L_BaruDetailLoanType': L_BaruDetailLoanType,
	'L_BaruAsuransiLainnyaType': L_BaruAsuransiLainnyaType,
	'L_BaruAsuransiLainnyaMaskapai': L_BaruAsuransiLainnyaMaskapai,
	'L_BaruAsuransiLainnyaPertanggungan': L_BaruAsuransiLainnyaPertanggungan,
	'L_BaruAsuransiLainnyaLoanType': L_BaruAsuransiLainnyaLoanType,
	'L_BaruBiayaLainnyaFee': L_BaruBiayaLainnyaFee,
	'L_BaruBiayaLainnyaType': L_BaruBiayaLainnyaType,
	'L_AsuransiLainnyaTenor': L_AsuransiLainnyaTenor,
	'L_TJH': L_TJH,
	'L_AsuransiLainnyaTenor': L_AsuransiLainnyaTenor,
]

List<String> variablesToPass5 = []
for (String columnHeader : variableMap5.keySet()) {
	Object value = variableMap5.get(columnHeader)
	if (value != null) {
		variablesToPass5.add(columnHeader)
	}
}

Map<String, Object> variables5 = [:]
for (String variableName : variablesToPass5) {
	variables5.put(variableName, variableMap5.get(variableName))
}

Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Sprint 2 (Aplikasi Baru)/Simulasi/Simulasi Loan Data (Skenario 6)'), variables5, FailureHandling.CONTINUE_ON_FAILURE)

// Tab Penyimpangan
Map<String, Object> variableMap6 = [
	'konsumen': konsumen,
	'P_Penyimpangan': P_Penyimpangan,
	'P_Jabatan': P_Jabatan,
	'P_PenyimpanganTambahanDescription': P_PenyimpanganTambahanDescription,
	'P_KeteranganCMO': P_KeteranganCMO,
]

List<String> variablesToPass6 = []
for (String columnHeader : variableMap6.keySet()) {
	Object value = variableMap6.get(columnHeader)
	if (value != null) {
		variablesToPass6.add(columnHeader)
	}
}

Map<String, Object> variables6 = [:]
for (String variableName : variablesToPass6) {
	variables6.put(variableName, variableMap6.get(variableName))
}

Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Sprint 2 (Aplikasi Baru)/Simulasi/Simulasi Penyimpangan (Skenario 8)'), variables6, FailureHandling.CONTINUE_ON_FAILURE)


// Tab Summary
Map<String, Object> variableMap7 = [
	'konsumen': konsumen,
]

List<String> variablesToPass7 = []
for (String columnHeader : variableMap7.keySet()) {
	Object value = variableMap7.get(columnHeader)
	if (value != null) {
		variablesToPass7.add(columnHeader)
	}
}

Map<String, Object> variables7 = [:]
for (String variableName : variablesToPass7) {
	variables7.put(variableName, variableMap7.get(variableName))
}

Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Sprint 2 (Aplikasi Baru)/Simulasi/Simulasi Summary (Skenario 10)'), variables7, FailureHandling.CONTINUE_ON_FAILURE)

/*
// Edit
Map<String, Object> variableMap8 = [
	'konsumen': konsumen,
	'CP_EditPekerjaan': CP_EditPekerjaan,
	'CP_EditStatusRumah': CP_EditStatusRumah,
	'CP_EditKodePos': CP_EditKodePos,
	'CP_EditHubunganDebitur': CP_EditHubunganDebitur,
	'Cl_EditDealer': Cl_EditDealer,
	'L_EditTJH': L_EditTJH,
	'L_EditMaskapaiAsuransi': L_EditMaskapaiAsuransi,
	'P_TambahJabatan': P_TambahJabatan,
	'P_EditPenyimpanganTambahanDescription': P_EditPenyimpanganTambahanDescription,
	'K_TipeDokumen': K_TipeDokumenEdit,
]

List<String> variablesToPass8 = []
for (String columnHeader : variableMap8.keySet()) {
	Object value = variableMap8.get(columnHeader)
	if (value != null) {
		variablesToPass8.add(columnHeader)
	}
}

Map<String, Object> variables8 = [:]
for (String variableName : variablesToPass8) {
	variables8.put(variableName, variableMap8.get(variableName))
}

Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Sprint 2 (Aplikasi Baru)/Simulasi/Simulasi Edit Summary'), variables8, FailureHandling.CONTINUE_ON_FAILURE)

// Submit Pengajuan ke CMO
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Submit Pengajuan ']"]))
WebUI.delay(1)
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Konfirmasi Submit Pengajuan') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Lanjutkan Submit']"]))
WebUI.delay(1)
WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Submit Berhasil') + '.png', FailureHandling.STOP_ON_FAILURE);
WebUI.delay(1)

*/