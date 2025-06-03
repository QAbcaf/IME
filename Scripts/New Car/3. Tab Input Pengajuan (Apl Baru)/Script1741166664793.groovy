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
String pengajuanPemohonPath = "${userDir}${GlobalVariable.pengajuanPemohonPath}".replace("/", "\\")
String ktpPathPasangan = "${userDir}${GlobalVariable.ktpPathPasangan}".replace("/", "\\")
String bpkbPath = "${userDir}${GlobalVariable.bpkbPath}".replace("/", "\\")
String baseDir = System.getProperty('user.dir')

// ---------------- Pengajuan ----------	----------
// Tab Konsumen
//Map<String, Object> variableMap1 = [
//	'konsumen': konsumen,
//	'K_Status': K_Status,
//	'K_TipeDokumen': K_TipeDokumen,
//	'K_Pekerjaan': K_Pekerjaan,
//	'K_KodeEkonomi': K_KodeEkonomi,
//	'K_NamaPerusahaan': K_NamaPerusahaan,
//	'K_Jabatan': K_Jabatan,
//	'K_TahunBerdiri': K_TahunBerdiri,
//	'K_JenisUsaha': K_JenisUsaha,
//	'K_TotalPenghasilan': K_TotalPenghasilan,
//	'K_PekerjaanPasangan': K_PekerjaanPasangan,
//	'K_TotalPenghasilanPasangan': K_TotalPenghasilanPasangan,
//	'K_TipeKK': K_TipeKK,
//	'K_PendidikanTerakhir': K_PendidikanTerakhir,
//	'K_TipeBank': K_TipeBank,
//	'K_NoRek': K_NoRek,
//	'K_NamaRek': K_NamaRek,
//	'K_Pembayaran': K_Pembayaran,
//	'K_AutoDebetOrangLain': K_AutoDebetOrangLain,
//	'K_RekAutoDebet': K_RekAutoDebet,
//	'K_NamaAutoDebet': K_NamaAutoDebet,
//	'K_NikAutoDebet': K_NikAutoDebet,
//	'K_HubAutoDebet': K_HubAutoDebet,
//	'K_StatusKepemilikanRumah': K_StatusKepemilikanRumah,
//	'K_StatusRumah': K_StatusRumah,
//	'K_nomorNPWP' : K_nomorNPWP,
//	'K_PengajuanPemohon' : K_PengajuanPemohon,
//	'K_NpwpMilik' : K_NpwpMilik,
//	'K_lamaTahunBekerja' : K_lamaTahunBekerja,
//	'K_lamaBulanBekerja' : K_lamaBulanBekerja,
//	'K_umkm' : K_umkm,
//	'K_lamaTahunBekerjaPasangan':K_lamaTahunBekerjaPasangan,
//	'K_lamaBulanBekerjaPasnagan':K_lamaBulanBekerjaPasnagan,
//	'K_totalMutasiDebit' : K_totalMutasiDebit,
//	'K_totalMutasiKredit' : K_totalMutasiKredit,
//	'K_saldoMengendap': K_saldoMengendap,
//	'K_luasTanah': K_luasTanah,
//	'K_luasBangunan': K_luasBangunan,
//	'K_deskripsiPekerjaan': K_deskripsiPekerjaan,
//	'K_deskripsiPekerjaanPasangan': K_deskripsiPekerjaanPasangan,
//	'K_alamatPerusahaan' : K_alamatPerusahaan,
//	'K_kodePosPerusahaan' : K_kodePosPerusahaan,
//	'K_noTlpnPerusahaan' : K_noTlpnPerusahaan,
//	'K_NamaPerusahaanPasangan' : K_NamaPerusahaanPasangan,
//	'K_JabatanPasangan' : K_JabatanPasangan,
//	'K_TahunPerusahaanPasangan' : K_TahunPerusahaanPasangan,
//	'K_JenisUsahaPasangan' : K_JenisUsahaPasangan,
//	'K_AlamatPerusahaanPasangan': K_AlamatPerusahaanPasangan,
//	'K_KodePosPasangan' : K_KodePosPasangan,
//	'K_NomorTeleponPasangan' : K_NomorTeleponPasangan,
//]
//
//List<String> variablesToPass1 = []
//for (String columnHeader : variableMap1.keySet()) {
//	Object value = variableMap1.get(columnHeader)
//	if (value != null) {
//		variablesToPass1.add(columnHeader)
//	}
//}
//
//Map<String, Object> variables1 = [:]
//for (String variableName : variablesToPass1) {
//	variables1.put(variableName, variableMap1.get(variableName))
//}
//
//Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/New Car/CMO Draft/1. Tab Konsumen'), variables1, FailureHandling.CONTINUE_ON_FAILURE)

//Tab FAP
//Map<String, Object> variableMap2 = [
//	'konsumen': konsumen,
//	'F_NamaIbuKandung': F_NamaIbuKandung,
//	'F_LamaTahun': F_LamaTahun,
//	'F_LamaBulan': F_LamaBulan,
//	'F_JumlahTanggungan': F_JumlahTanggungan,
//	'F_KodeArea': F_KodeArea,
//	'F_NomorTelepon': F_NomorTelepon,
//	'F_NamaSID' : F_NamaSID,
//	'F_Email' : F_Email,
//	'F_EmailSama' : F_EmailSama,
//	'F_tujuanPembiayaan' : F_tujuanPembiayaan,
//	'F_NoHP' : F_NoHP,
//	'F_Prefix' : F_Prefix,
//]
//
//List<String> variablesToPass2 = []
//for (String columnHeader : variableMap2.keySet()) {
//	Object value = variableMap2.get(columnHeader)
//	if (value != null) {
//		variablesToPass2.add(columnHeader)
//	}
//}
//
//Map<String, Object> variables2 = [:]
//for (String variableName : variablesToPass2) {
//	variables2.put(variableName, variableMap2.get(variableName))
//}
//
//Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/New Car/CMO Draft/2. Tab FAP'), variables2, FailureHandling.CONTINUE_ON_FAILURE)


// Tab General
//Map<String, Object> variableMap3 = [
//	'konsumen': konsumen,
//	'G_Segmentasi' : G_Segmentasi,
//	'G_Membership' : G_Membership,
//	'G_LamaMembership' : G_LamaMembership,
//	'G_JenisDebitur' : G_JenisDebitur,
//	'G_Plafond' : G_Plafond,
//	'G_SalesType' : G_SalesType,
//	'G_SalesOffice' : G_SalesOffice,
//	'G_SalesAgent' : G_SalesAgent,
//	'G_RekomendasiNama' : G_RekomendasiNama,
//	'G_Jabatan' : G_Jabatan,
//	'G_Cabang' : G_Cabang,
//]
//List<String> variablesToPass3 = []
//for (String columnHeader : variableMap3.keySet()) {
//	Object value = variableMap3.get(columnHeader)
//	if (value != null) {
//		variablesToPass3.add(columnHeader)
//	}
//}
//Map<String, Object> variables3 = [:]
//for (String variableName : variablesToPass3) {
//	variables3.put(variableName, variableMap3.get(variableName))
//}
//
//Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/New Car/CMO Draft/3. Tab General'), variables3, FailureHandling.CONTINUE_ON_FAILURE)

// Tab CP
//Map<String, Object> variableMap4 = [
//	'konsumen': konsumen,
//	'K_Status': K_Status,
//	'CP_Nama': CP_Nama,
//	'CP_HubKonsumen': CP_HubKonsumen,
//	'CP_KodePos': CP_KodePos,
//	'CP_NoHp': CP_NoHp,
//	'CP_Prefix': CP_Prefix,
//	'CP_Alamat': CP_Alamat,
//	'CP_Kota': CP_Kota,
//	'CP_isPenjamin': CP_isPenjamin,
//	'CP_PenjaminHubDebitur': CP_PenjaminHubDebitur,
//	'CP_IdentitasPasanganPenjamin': CP_IdentitasPasanganPenjamin,
//	'CP_PasanganPenjaminNama': CP_PasanganPenjaminNama,
//	'CP_PasanganPenjaminNIK': CP_PasanganPenjaminNIK,
//	'CP_PasanganPenjaminDOB': CP_PasanganPenjaminDOB,
//]
//
//List<String> variablesToPass4 = []
//for (String columnHeader : variableMap4.keySet()) {
//	Object value = variableMap4.get(columnHeader)
//	if (value != null) {
//		variablesToPass4.add(columnHeader)
//	}
//}
//
//Map<String, Object> variables4 = [:]
//for (String variableName : variablesToPass4) {
//	variables4.put(variableName, variableMap4.get(variableName))
//}
//
//Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/New Car/CMO Draft/4. Tab ECN dan Penjamin'), variables4, FailureHandling.CONTINUE_ON_FAILURE)

// Tab Matching Result
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//li//*[text()='Matching Result']"]))
//WebUI.delay(10)
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='matchingPenjamin']//following-sibling::span"], FailureHandling.CONTINUE_ON_FAILURE))
//WebUI.delay(1)
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//input[@id='matchingPasanganPenjamin']//following-sibling::span"], FailureHandling.CONTINUE_ON_FAILURE))
//WebUI.delay(10)
//WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '12. Tab Matching Result Pasangan Konsumen - Penjamin' + '/' + 'Matching (1)') + '.png', FailureHandling.STOP_ON_FAILURE)
//WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Penjamin']"]),0);
//
////WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//label[contains(.,'Not Match')]/preceding-sibling::input[@type='radio']"], FailureHandling.STOP_ON_FAILURE))
////WebUI.delay(5)
//WebUI.takeScreenshot((((baseDir + GlobalVariable.screenshotPathNewCarKKB)) + '/' + konsumen + '/' + '12. Tab Matching Result Pasangan Konsumen - Penjamin' + '/' + 'Matching (2)') + '.png', FailureHandling.STOP_ON_FAILURE)
//
//WebUI.scrollToElement(findTestObject('Object Repository/xpath', ['xpath' : "//div[text()='Pasangan Penjamin']"]),0);
//WebUI.delay(2)
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//app-tab-matching-result//button[text()=' Selanjutnya ']"], FailureHandling.CONTINUE_ON_FAILURE))


// Tab Collateral
//Map<String, Object> variableMap5 = [
//	'konsumen': konsumen,
//	'Cl_Branch': Cl_Branch,
//	'Cl_BpkbNo': Cl_BpkbNo,
//	'Cl_NoMesin': Cl_NoMesin,
//	'Cl_NoRangka': Cl_NoRangka,
//	'Cl_Merk': Cl_Merk,
//	'Cl_Model': Cl_Model,
//	'Cl_Tipe': Cl_Tipe,
//	'Cl_PeruntukanKendaraan': Cl_PeruntukanKendaraan,
//	'Cl_Tahun': Cl_Tahun,
//	'Cl_Warna': Cl_Warna,
//	'Cl_NamaKepemilikan': Cl_NamaKepemilikan,
//	'isNamaSelainKonsumen': isNamaSelainKonsumen,
//	'Cl_NIKDebitur': Cl_NIKDebitur,
//	'Cl_HubDebitur': Cl_HubDebitur,
//	'Cl_DealerName': Cl_DealerName,
//	'Cl_NamaDealerKaroseri' : Cl_NamaDealerKaroseri,
//	'Cl_CabangDealerKaroseri' : Cl_CabangDealerKaroseri,
//	'Cl_HargaKaroseri' : Cl_HargaKaroseri,
//	'pengajuanChassis' : pengajuanChassis,
//]
//
//List<String> variablesToPass5 = []
//for (String columnHeader : variableMap5.keySet()) {
//	Object value = variableMap5.get(columnHeader)
//	if (value != null) {
//		variablesToPass5.add(columnHeader)
//	}
//}
//
//Map<String, Object> variables5 = [:]
//for (String variableName : variablesToPass5) {
//	variables5.put(variableName, variableMap5.get(variableName))
//}
//
//Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/New Car/CMO Draft/5. Tab Collateral'), variables5, FailureHandling.CONTINUE_ON_FAILURE)

// Tab Loan Data
//Map<String, Object> variableMap6 = [ 
//	'konsumen': konsumen,
//	'L_DetailTipeAsuransiAll': L_DetailTipeAsuransiAll,
//	'L_DetailTJHAll': L_DetailTJHAll,
//	'L_DetailAsuransiNominalDeductionPersen': L_DetailAsuransiNominalDeductionPersen,
//	'L_DetailAsuransiNominalDeduction': L_DetailAsuransiNominalDeduction,
//	'L_DetailAsuransiLoanType': L_DetailAsuransiLoanType,
//	'L_PaketDP': L_PaketDP,
//	'L_CarInsuranceCorp': L_CarInsuranceCorp,
//	'L_CarInsuranceBranch': L_CarInsuranceBranch,
//	'L_MaskapaiAsuransi': L_MaskapaiAsuransi,
//	'L_Branch': L_Branch,
//	'JenisPengajuan': JenisPengajuan,
//	'L_BaruPaket': L_BaruPaket,
//	'L_BaruOTR': L_BaruOTR,
//	'L_BaruPersenDP': L_BaruPersenDP,
//	'L_BaruResidual': L_BaruResidual,
//	'L_BaruTenor': L_BaruTenor,
//	'L_BaruFlatRate': L_BaruFlatRate,
//	'L_BaruEffRate': L_BaruEffRate,
//	'L_BaruBiayaAdmin': L_BaruBiayaAdmin,
//	'L_BaruBiayaProvisi': L_BaruBiayaProvisi,
//	'L_BaruLoanType': L_BaruLoanType,
//	'L_BaruBiayaAdminType': L_BaruBiayaAdminType,
//	'L_BaruBiayaProvisiType': L_BaruBiayaProvisiType,
//	'L_BaruTipeAsuransi': L_BaruTipeAsuransi,
//	'L_BaruDetailAsuransiCheck': L_BaruDetailAsuransiCheck,
//	'L_BaruNominalDeduction': L_BaruNominalDeduction,
//	'L_BaruDetailOTR': L_BaruDetailOTR,
//	'L_BaruDetailLoanType': L_BaruDetailLoanType,
//	'L_BaruAsuransiLainnyaType': L_BaruAsuransiLainnyaType,
//	'L_BaruAsuransiLainnyaMaskapai': L_BaruAsuransiLainnyaMaskapai,
//	'L_BaruAsuransiLainnyaPertanggungan': L_BaruAsuransiLainnyaPertanggungan,
//	'L_BaruAsuransiLainnyaLoanType': L_BaruAsuransiLainnyaLoanType,
//	'L_BaruBiayaLainnyaFee': L_BaruBiayaLainnyaFee,
//	'L_BaruBiayaLainnyaType': L_BaruBiayaLainnyaType,
//	'L_AsuransiLainnyaTenor': L_AsuransiLainnyaTenor,
//	'L_TJH': L_TJH,
//	'L_AsuransiLainnyaTenor': L_AsuransiLainnyaTenor,
//	'L_SelfCover' : L_SelfCover,
//	'L_CoverMundur' : L_CoverMundur,
//	'L_PeriodeStartCoverMundur' : L_PeriodeStartCoverMundur,
//	'L_PeriodeEndCoverMundur' : L_PeriodeEndCoverMundur,
//]
//
//List<String> variablesToPass6 = []
//for (String columnHeader : variableMap6.keySet()) {
//	Object value = variableMap6.get(columnHeader)
//	if (value != null) {
//		variablesToPass6.add(columnHeader)
//	}
//}
//
//Map<String, Object> variables6 = [:]
//for (String variableName : variablesToPass6) {
//	variables6.put(variableName, variableMap6.get(variableName))
//}
//
//Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/New Car/CMO Draft/6. Tab Loan Data'), variables6, FailureHandling.CONTINUE_ON_FAILURE)

// Tab Penyimpangan
//Map<String, Object> variableMap7 = [
//	'konsumen': konsumen,
//	'P_Penyimpangan': P_Penyimpangan,
//	'P_Jabatan': P_Jabatan,
//	'P_PenyimpanganTambahanDescription': P_PenyimpanganTambahanDescription,
//	'P_KeteranganCMO': P_KeteranganCMO,
//]
//
//List<String> variablesToPass7 = []
//for (String columnHeader : variableMap7.keySet()) {
//	Object value = variableMap7.get(columnHeader)
//	if (value != null) {
//		variablesToPass7.add(columnHeader)
//	}
//}
//
//Map<String, Object> variables7 = [:]
//for (String variableName : variablesToPass7) {
//	variables7.put(variableName, variableMap7.get(variableName))
//}
//
//Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/New Car/CMO Draft/7. Tab Penyimpangan'), variables7, FailureHandling.CONTINUE_ON_FAILURE)


// Tab Summary
Map<String, Object> variableMap8 = [
	'konsumen': konsumen,
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

Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/New Car/CMO Draft/8. Tab Summary'), variables8, FailureHandling.CONTINUE_ON_FAILURE)


// Edit
//Map<String, Object> variableMap9 = [
//	'konsumen': konsumen,
//	'CP_EditPekerjaan': CP_EditPekerjaan,
//	'CP_EditStatusRumah': CP_EditStatusRumah,
//	'CP_EditKodePos': CP_EditKodePos,
//	'CP_EditHubunganDebitur': CP_EditHubunganDebitur,
//	'Cl_EditDealer': Cl_EditDealer,
//	'L_EditTJH': L_EditTJH,
//	'L_EditMaskapaiAsuransi': L_EditMaskapaiAsuransi,
//	'P_TambahJabatan': P_TambahJabatan,
//	'P_EditPenyimpanganTambahanDescription': P_EditPenyimpanganTambahanDescription,
//	'K_TipeDokumen': K_TipeDokumenEdit,
//]
//
//List<String> variablesToPass9 = []
//for (String columnHeader : variableMap9.keySet()) {
//	Object value = variableMap9.get(columnHeader)
//	if (value != null) {
//		variablesToPass9.add(columnHeader)
//	}
//}
//
//Map<String, Object> variables9 = [:]
//for (String variableName : variablesToPass9) {
//	variables9.put(variableName, variableMap9.get(variableName))
//}
//
//Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/New Car/CMO Draft/Simulasi Edit Summary'), variables9, FailureHandling.CONTINUE_ON_FAILURE)
//
//// Submit Pengajuan ke CMO
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()=' Submit Pengajuan ']"]))
//WebUI.delay(1)
//WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Konfirmasi Submit Pengajuan') + '.png', FailureHandling.STOP_ON_FAILURE);
//WebUI.delay(1)
//WebUI.click(findTestObject('Object Repository/xpath', ['xpath' : "//button[text()='Lanjutkan Submit']"]))
//WebUI.delay(1)
//WebUI.takeFullPageScreenshot((((baseDir + GlobalVariable.screenshotSimulasi)) + '/' + konsumen  + '/' + 'Submit Berhasil') + '.png', FailureHandling.STOP_ON_FAILURE);
//WebUI.delay(1)

